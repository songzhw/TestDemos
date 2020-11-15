import React from "react";
import {View, ViewProps, Text, StyleSheet, SafeAreaView, FlatList, ListRenderItemInfo} from "react-native";

interface IData {
  id: string;
  title: string;
}

const DATA = [
  {
    id: 'bd7acbea-c1b1-46c2-aed5-3ad53abb28ba',
    title: 'First Item',
  },
  {
    id: '3ac68afc-c605-48d3-a4f8-fbd91aa97f63',
    title: 'Second Item',
  },
  {
    id: '58694a0f-3da1-471f-bd96-145571e29d72',
    title: 'Third Item',
  },
];

const Item = ({title}: { title: string }) => {
  return (
    <View style={styles.item}>
      <Text style={styles.title}>{title}</Text>
    </View>
  );
}

interface IProps extends ViewProps {
}

export const HomeScreen = (props: IProps) => {
  const renderItem = (item: ListRenderItemInfo<IData>) => (
    <Item title={item.item.title}/>
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
}


const styles = StyleSheet.create({
  root: {flex: 1},
  item: {},
  title: {}
});
