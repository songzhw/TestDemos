import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  StatusBar,
} from 'react-native';

import {
  Header,
  LearnMoreLinks,
  Colors,
  DebugInstructions,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';
import {HomeScreen} from "./src/biz/HomeScreen";

declare const global: { HermesInternal: null | {} };

const App = () => {
  return (
    <>
      <HomeScreen/>
    </>
  );
};


export default App;
