import React from "react";
import { View, ViewProps, Text, StyleSheet, TouchableOpacity, StyleProp, ViewStyle, TextStyle } from "react-native";

interface IProps extends ViewProps {
  onClick: () => void;
  text: string,
  textStyle: StyleProp<TextStyle>
}

export const Button = (props: IProps) => {
  return (
    <View style={props.style}>
      <TouchableOpacity onPress={props.onClick} style={styles.fillParent}>
        <Text style={props.textStyle}>{props.text}</Text>
      </TouchableOpacity>
    </View>
  );
};


const styles = StyleSheet.create({
  fillParent: {
    flex: 1,  //这是为了让TouchableOpacity充满整个Button区域, 这样用户点击更容易
    justifyContent: "center",
    alignItems: "center" //这两条是让<Text>居于水平&垂直的中间
  }
});