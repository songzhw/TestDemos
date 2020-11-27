import React, { useRef } from "react";
import { View, ViewProps, Text, StyleSheet, SafeAreaView } from "react-native";
import WebView from "react-native-webview";
import { html } from "./LocalHtml";
import { Button } from "../../ui/Button";

interface IProps extends ViewProps {
}

export const SomeWebContentScreen = (props: IProps) => {
  const webviewRef = useRef<WebView>(null);

  const inject1 = () => {
    let text = "hello"
    webviewRef.current?.injectJavaScript(`changeText(${text})`);
  };

  return (
    <SafeAreaView style={styles.root}>
      <Button style={styles.button} onClick={inject1} text={"inject1"} textStyle={{ fontSize: 20 }} />
      <WebView ref={webviewRef} source={{ html: html }} />
    </SafeAreaView>
  );
};


const styles = StyleSheet.create({
  root: { flex: 1 },
  button: { height: 30, width: 50 }
});
