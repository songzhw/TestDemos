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
        <TextInput onChangeText={textString => setText(textString)} value={text} />
        <Button onClick={() => props.onAddItem(text)} text="Add" textStyle={{ fontSize: 20 }} />
      </Modal>
    </View>
  );
};


const styles = StyleSheet.create({
  root: {}
});
