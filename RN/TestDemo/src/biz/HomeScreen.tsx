import React, { useEffect, useLayoutEffect, useRef, useState } from "react";
import { View, ViewProps, Text, StyleSheet, SafeAreaView, FlatList, ListRenderItemInfo, TextInput } from "react-native";
import { StackNavigationProp } from "@react-navigation/stack";
import { StackParamList } from "../../App";
import { Button } from "../ui/Button";
import { HttpEngine } from "../core/HttpEngine";
import { ITodoItem, TodoItem } from "./TodoItem";
import { AddTodoItemDialog } from "./AddTodoItemDialog";

export type HomeNavProp = StackNavigationProp<StackParamList, "home">

interface IProps extends ViewProps {
  navigation: HomeNavProp
}

export const HomeScreen = (props: IProps) => {
  const http = new HttpEngine();
  const fullDataRef = useRef<ITodoItem[]>([]);
  const [listData, setListData] = useState<ITodoItem[]>([]);
  const [dialogVisible, setDialogVisible] = useState(false);
  const [searchValue, setSearchValue] = useState("");

  useEffect(() => {
    http.request("https://run.mocky.io/v3/0002d9dc-ddbd-4947-8306-33f6d70e17fb")
      .then(resp => {
        setListData(resp.payload);
        fullDataRef.current = resp.payload;
      });
  }, []);

  useLayoutEffect(() => {
    props.navigation.setOptions(({
      headerRight: () => (
        <Button onClick={onAddItemButtonPressed} text="+" textStyle={styles.btnAdd} testID="btnAdd" />
      )
    }));
  });

  const onAddItemButtonPressed = () => {
    setDialogVisible(true);
  };

  const onAddItem = (text: string) => {
    const newItem: ITodoItem = {
      id: "tbd",
      title: text,
      color: "blue",
      isDone: false
    };

    listData.push(newItem);
    setListData(listData);
    fullDataRef.current = listData;
    setDialogVisible(false);
  };

  const onCloseDialog = () => {
    setDialogVisible(false);
  };

  const onChangeText = (text: string) => {
    setSearchValue(text);

    if (text !== "") {
      const newListData = fullDataRef.current.filter(item => item.title.toLowerCase().includes(text.toLowerCase()));
      setListData(newListData);
    } else {
      setListData(fullDataRef.current);
    }
  };

  const renderItem = (item: ListRenderItemInfo<ITodoItem>) => (
    <TodoItem datum={item.item} navigation={props.navigation} />
  );

  return (
    <SafeAreaView style={styles.root}>
      <TextInput style={styles.search} placeholder="search" value={searchValue}
                 onChangeText={onChangeText} autoCapitalize="none" testID="searchBar"/>
      <FlatList
        testID="homeList"
        data={listData}
        renderItem={renderItem}
        keyExtractor={item => item.id}
      />

      <AddTodoItemDialog isVisible={dialogVisible} onAddItem={onAddItem} onCloseDialog={onCloseDialog} />
    </SafeAreaView>
  );
};


const styles = StyleSheet.create({
  root: { flex: 1 },
  search: { height: 40, backgroundColor: "white", fontSize: 22 },
  btnAdd: { fontSize: 25, width: 40, textAlign: "center" }
});
