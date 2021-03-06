import React from "react";
import { HomeScreen } from "./src/biz/HomeScreen";
import { createStackNavigator } from "@react-navigation/stack";
import { NavigationContainer } from "@react-navigation/native";
import { DetailScreen } from "./src/biz/DetailScreen";
import { ShowcaseScreen } from "./src/biz/ShowcaseScreen";
import { ITodoItem } from "./src/biz/TodoItem";
import { SomeWeb } from "./src/core/ScreenInjector";

export type StackParamList = {
  home: undefined;
  detail: { datum: ITodoItem };
  showcase: undefined;
  someweb: undefined;
}

const Stack = createStackNavigator();

const App = () => {
  return (
    <NavigationContainer>
      <Stack.Navigator>
        <Stack.Screen name="home" component={HomeScreen} />
        <Stack.Screen name="detail" component={DetailScreen} />
        <Stack.Screen name="showcase" component={ShowcaseScreen} />
        <Stack.Screen name="someweb" component={SomeWeb} />
      </Stack.Navigator>
    </NavigationContainer>
  );
};


export default App;
