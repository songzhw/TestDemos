import React from "react";
import { View, ViewProps, Text, StyleSheet } from "react-native";

interface IProps extends ViewProps {
}

export const DetailScreen = (props: IProps) => {

  return (
    <View>
      <Text>Detail</Text>
    </View>
  );
};


const styles = StyleSheet.create({
  root: {}
});
