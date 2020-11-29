// import React, { ComponentType, useState } from "react";
// import { View, ViewProps, Text, StyleSheet, TextInput, TouchableOpacity } from "react-native";
//
// interface IProps extends ViewProps {
//   children: any
// }
//
// export const FakeWebHoc = (props: IProps) => {
//   const [script, setScript] = useState("");
//   const onButtonPress = () => {
//   };
//   return (
//     <View style={styles.root}>
//       {props.children}
//       <Text style={styles.invisible}></Text>
//       <TextInput style={styles.invisible} onChangeText={setScript} value={script} />
//       <TouchableOpacity style={styles.invisible} onPress={onButtonPress} />
//     </View>
//   );
// };
//
//
// const styles = StyleSheet.create({
//   root: { flex: 1 },
//   invisible: { height: 0 }
// });
//
// interface IProps2 {
// }
//
// export const buildFakeWeb: React.FC = (InputComponent: React.FC) => {
//   return (props: any) =>
//     (<FakeWebHoc>
//       <InputComponent {...props} />
//     </FakeWebHoc>);
// };
