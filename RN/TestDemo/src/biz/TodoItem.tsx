import React from "react";
import { HomeNavProp } from "./HomeScreen";
import { StyleSheet, View } from "react-native";
import { Button } from "../ui/Button";

export interface ITodoItem {
  id: string;
  title: string;
  color: string;
  isDone: boolean;
}

export interface IItemProps {
  datum: ITodoItem;
  navigation: HomeNavProp;
}

// const Item = ({ title }: { title: string }) => {

export const TodoItem = (props: IItemProps) => {
  const { datum } = props;
  return (
    <View style={[{ backgroundColor: datum.color }]}>
      <Button onClick={() => props.navigation.navigate("detail", { datum: datum })}
              text={datum.title} textStyle={styles.title} />
    </View>
  );
};

const styles = StyleSheet.create({
  item: {  },
  title: { fontSize: 50, color: "white", padding: 50 }
});
