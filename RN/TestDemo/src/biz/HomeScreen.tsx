import React, { useLayoutEffect } from "react";
import { View, ViewProps, Text, StyleSheet, SafeAreaView, FlatList, ListRenderItemInfo, Button } from "react-native";
import { StackNavigationProp } from "@react-navigation/stack";
import { StackParamList } from "../../App";

interface IData {
  id: string;
  title: string;
}

const DATA = [
  {
    id: "bd7acbea-c1b1-46c2-aed5-3ad53abb28ba",
    title: "First Item"
  },
  {
    id: "3ac68afc-c605-48d3-a4f8-fbd91aa97f63",
    title: "Second Item"
  },
  {
    id: "58694a0f-3da1-471f-bd96-145571e29d72",
    title: "Third Item"
  }
];

const Item = ({ title }: { title: string }) => {
  return (
    <View style={styles.item}>
      <Text style={styles.title}>{title}</Text>
    </View>
  );
};

type HomeNavProp = StackNavigationProp<StackParamList, "home">

interface IProps extends ViewProps {
  navigation: HomeNavProp
}

export const HomeScreen = (props: IProps) => {

  useLayoutEffect(() => {
    props.navigation.setOptions(({
      headerRight: () => (
        <Button onPress={() => console.log(`szw click btn`)} title="+" />
      )
    }));
  });


  const renderItem = (item: ListRenderItemInfo<IData>) => (
    <Item title={item.item.title} />
  );

  return (
    <SafeAreaView style={styles.root}>
      <FlatList
        data={DATA}
        renderItem={renderItem}
        keyExtractor={item => item.id}
      />
    </SafeAreaView>
  );
};


const styles = StyleSheet.create({
  root: { flex: 1 },
  item: { margin: 10 },
  title: { fontSize: 20 }
});
