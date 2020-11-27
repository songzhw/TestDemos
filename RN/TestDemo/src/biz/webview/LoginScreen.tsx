import React from "react";
import { View, ViewProps, Text, StyleSheet } from "react-native";
import WebView from "react-native-webview";

interface IProps extends ViewProps {
}

export const LoginScreen = (props: IProps) => {
  const html = `
<html>
  <h1>hello</h1>
</html>  
  `;

  return (
    <WebView
      source={{ html }}
    />
  );
};


const styles = StyleSheet.create({
  root: { flex: 1 }
});
