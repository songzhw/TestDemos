import React, { useEffect, useLayoutEffect, useState } from "react";
import { View, ViewProps, Text, StyleSheet, SafeAreaView, FlatList, ListRenderItemInfo } from "react-native";
import { StackNavigationProp } from "@react-navigation/stack";
import { StackParamList } from "../../App";
import { Button } from "../ui/Button";
import { HttpEngine } from "../core/HttpEngine";
import { ITodoItem, TodoItem } from "./TodoItem";

export type HomeNavProp = StackNavigationProp<StackParamList, "home">

interface IProps extends ViewProps {
  navigation: HomeNavProp
}

export const HomeScreen = (props: IProps) => {
  const http = new HttpEngine();
  const [listData, setListData] = useState<ITodoItem[]>([]);

  useEffect(() => {
    http.request("https://run.mocky.io/v3/0002d9dc-ddbd-4947-8306-33f6d70e17fb")
      .then(resp => setListData(resp.payload));
  }, []);

  useLayoutEffect(() => {
    props.navigation.setOptions(({
      headerRight: () => (
        <Button onClick={onAddItem} text="+" textStyle={styles.btnAdd} testID="btnAdd" />
      )
    }));
  });

  const onAddItem = ()=>{

  }


  const renderItem = (item: ListRenderItemInfo<ITodoItem>) => (
    <TodoItem datum={item.item} navigation={props.navigation} />
  );

  return (
    <SafeAreaView style={styles.root}>
      <FlatList
        testID="homeList"
        data={listData}
        renderItem={renderItem}
        keyExtractor={item => item.id}
      />
    </SafeAreaView>
  );
};


const styles = StyleSheet.create({
  root: { flex: 1 },
  btnAdd: { fontSize: 25, width: 40, textAlign: "center" }
});
