import React, { useState } from "react";
import { View, ViewProps, Text, StyleSheet, TextInput } from "react-native";
import Modal from "react-native-modal";
import { Button } from "../ui/Button";

interface IProps extends ViewProps {
  isVisible: boolean;
  onAddItem: (title: string) => void;
  onCloseDialog: ()=>void;
}

export const AddTodoItemDialog = (props: IProps) => {

  const [text, setText] = useState("");

  const onButtonPress = ()=>{
    props.onAddItem(text)
    setText("")
  }

  return (
    <View>
      <Modal isVisible={props.isVisible} onBackdropPress={props.onCloseDialog}>
        <View style={styles.root}>
          <Text style={styles.title}>Add Todo Item</Text>
          <TextInput style={styles.input} onChangeText={textString => setText(textString)} value={text} placeholder={"todo item"}/>
          <Button onClick={onButtonPress} text="Add" textStyle={styles.buttonText} style={styles.button} />
        </View>
      </Modal>
    </View>
  );
};


const styles = StyleSheet.create({
  root: {alignItems: "center", justifyContent: "center", backgroundColor: "white"},
  title: {fontSize: 25, marginTop: 20},
  input: { width: 340, height: 50, borderColor: "blue", borderWidth: 1, marginVertical: 20 },
  button: { width: 200, height: 50, backgroundColor: "blue", marginBottom: 20 },
  buttonText: {fontSize: 20, color: "white"}
});

/*
1. Modal下面要有一层view, 不然children都不显示
2. Model下这层View得有bg, 不然全是半透明色
3. 做完事后(如点击完了add按钮), TextInput要手动清除, 不然就仍显示了上一次的输入
4. 默认点击dialog之外, modal是不会消失的. 要想这样, 就得加上:
 */
