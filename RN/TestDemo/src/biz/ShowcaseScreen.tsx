import React from "react";
import { View, ViewProps, Text, StyleSheet } from "react-native";
import ViewPager from "@react-native-community/viewpager";

interface IProps extends ViewProps {
}

export const ShowcaseScreen = (props: IProps) => {

  return (
    <View style={styles.root}>
      <ViewPager style={styles.viewpager}>
        <View key={"1"}>
          <Text style={{ backgroundColor: "red", flex: 1 }}>First Page</Text>
        </View>
        <View key={"2"}>
          <Text style={{ backgroundColor: "blue", flex: 1 }}>Second Page</Text>
        </View>
        <View key={"3"}>
          <Text style={{ backgroundColor: "green", flex: 1 }}>Third Page</Text>
        </View>
      </ViewPager>
    </View>
  );
};


const styles = StyleSheet.create({
  root: { flex: 1 },
  viewpager: { height: 200 },
  text: {}
});
