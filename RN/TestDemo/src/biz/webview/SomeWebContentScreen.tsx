import React, { useRef, useState } from "react";
import { View, ViewProps, Text, StyleSheet, SafeAreaView, TextInput, TouchableOpacity } from "react-native";
import WebView from "react-native-webview";
import { html } from "./LocalHtml";
import { Button } from "../../ui/Button";
import { WebViewMessageEvent } from "react-native-webview/lib/WebViewTypes";


interface IProps extends ViewProps {
}

export const SomeWebContentScreen = (props: IProps) => {
  const webviewRef = useRef<WebView>(null);

  const inject1 = () => {
    webviewRef.current?.injectJavaScript("resetText()");
  };

  const inject2 = () => {
    let text = "szw";
    webviewRef.current?.injectJavaScript(`changeText("${text}")`);
  };

  const [script, setScript] = useState("");
  const [callbackText, setCallbackText] = useState("")
  const onButtonPress = () => {
    webviewRef.current?.injectJavaScript(script);
  };

  const onMessage = (event: WebViewMessageEvent) => {
    const str = event.nativeEvent.data;
    setCallbackText(str);
  };

  return (
    <SafeAreaView style={styles.root}>
      <Button style={styles.button} onClick={inject1} text={"inject1"} textStyle={{ fontSize: 20 }} />
      <Button style={styles.button} onClick={inject2} text={"inject2"} textStyle={{ fontSize: 20 }} />

      <Text testID="inviLabel" style={styles.invisible}>{callbackText}</Text>
      <TextInput testID="inviInput" style={styles.invisible} onChangeText={setScript} value={script} />
      <TouchableOpacity testID="inviButton" style={styles.invisible} onPress={onButtonPress} />

      <WebView ref={webviewRef} source={{ html: html }} onMessage={onMessage} />
    </SafeAreaView>
  );
};


const styles = StyleSheet.create({
  root: { flex: 1 },
  button: { height: 30 },
  invisible: { height: 1 }
});
