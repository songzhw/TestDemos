import React, { useState } from "react";
import { View, ViewProps, Text, StyleSheet, TextInput } from "react-native";
import Modal from "react-native-modal";
import { Button } from "../ui/Button";

interface IProps extends ViewProps {
  isVisible: boolean;
  onAddItem: (title: string) => void;
}

export const AddTodoItemDialog = (props: IProps) => {

  const [text, setText] = useState("");

  return (
    <View>
      <Modal isVisible={props.isVisible}>
        <View style={styles.root}>
          <TextInput style={styles.input} onChangeText={textString => setText(textString)} value={text} placeholder={"todo item"}/>
          <Button onClick={() => props.onAddItem(text)} text="Add" textStyle={styles.buttonText} style={styles.button} />
        </View>
      </Modal>
    </View>
  );
};


const styles = StyleSheet.create({
  root: {alignItems: "center", justifyContent: "center", backgroundColor: "white"},
  input: { width: 200, height: 50, borderColor: "blue", borderWidth: 1 },
  button: { width: 200, height: 50, backgroundColor: "blue" },
  buttonText: {fontSize: 20, color: "white"}
});

/*
1. Modal下面要有一层view, 不然children都不显示
2. Model下这层View得有bg, 不然全是半透明色
 */
