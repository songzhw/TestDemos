import React from "react";
import { View, ViewProps, Text, StyleSheet } from "react-native";
import WebView from "react-native-webview";

interface IProps extends ViewProps {
}

export const LoginScreen = (props: IProps) => {

  return (
    <WebView
      source={{uri:"https://www.google.ca"}}
    />
  );
};


const styles = StyleSheet.create({
  root: { flex: 1 }
});
