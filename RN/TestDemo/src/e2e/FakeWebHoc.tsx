import React from "react";
import { View, ViewProps, Text, StyleSheet } from "react-native";

interface IProps extends ViewProps {
}

export const FakeWebHoc = (props: IProps) => {

  return (
    <View>
      <Text>hello</Text>
    </View>
  );
};


const styles = StyleSheet.create({
  root: {}
});
