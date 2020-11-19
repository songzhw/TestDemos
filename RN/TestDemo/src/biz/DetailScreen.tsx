import React from "react";
import { View, ViewProps, Text, StyleSheet } from "react-native";
import { ITodoItem } from "./HomeScreen";
import { RouteProp } from "@react-navigation/native";
import { StackParamList } from "../../App";

export type DetailRouteProp = RouteProp<StackParamList, "detail">;

interface IProps extends ViewProps {
  route: DetailRouteProp;
}

export const DetailScreen = (props: IProps) => {
  const { datum } = props.route.params;
  return (
    <View>
      <Text>{datum.title}</Text>
      <Text>{datum.color}</Text>
    </View>
  );
};


const styles = StyleSheet.create({
  root: {}
});
