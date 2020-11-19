import React, { useEffect, useLayoutEffect, useState } from "react";
import { View, ViewProps, Text, StyleSheet, SafeAreaView, FlatList, ListRenderItemInfo } from "react-native";
import { StackNavigationProp } from "@react-navigation/stack";
import { StackParamList } from "../../App";
import { Button } from "../ui/Button";
import { HttpEngine } from "../core/HttpEngine";

interface ITodoItem {
  id: string;
  title: string;
  color: string;
  isDone: boolean;
}

interface IItemProps{
  datum: ITodoItem
}
// const Item = ({ title }: { title: string }) => {
const Item = (props: IItemProps) => {
  const {datum} = props
  return (
    <View style={[styles.item, {backgroundColor: datum.color}]}>
      <Text style={[styles.title]}>{datum.title}</Text>
    </View>
  );
};

type HomeNavProp = StackNavigationProp<StackParamList, "home">

interface IProps extends ViewProps {
  navigation: HomeNavProp
}

export const HomeScreen = (props: IProps) => {
  const http = new HttpEngine();
  const [listData, setListData] = useState<ITodoItem[]>([]);

  useLayoutEffect(() => {
    props.navigation.setOptions(({
      headerRight: () => (
        <Button onClick={() => props.navigation.navigate("detail")} text="+" textStyle={styles.btnAdd}
                testID="btnAdd" />
      )
    }));
  });

  useEffect(() => {
    http.request("https://run.mocky.io/v3/499b1c1a-1002-4200-a0c5-92d959dd67a3")
      .then(resp => setListData(resp.payload));
  }, []);


  const renderItem = (item: ListRenderItemInfo<ITodoItem>) => (
    <Item datum={item.item} />
  );

  return (
    <SafeAreaView style={styles.root}>
      <FlatList
        data={listData}
        renderItem={renderItem}
        keyExtractor={item => item.id}
      />
    </SafeAreaView>
  );
};


const styles = StyleSheet.create({
  root: { flex: 1 },
  item: { padding: 10 },
  title: { fontSize: 20, color: "white" },
  btnAdd: { fontSize: 25, width: 40, textAlign: "center" }
});
