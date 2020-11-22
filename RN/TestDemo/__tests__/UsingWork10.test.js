import React from "react";
import { UsingWork10Screen } from "../src/unitest/mock1/UsingWork10Screen";
import { say10, work10 } from "../src/unitest/mock1/Worker10";
import { fireEvent, render as testRender } from "react-native-testing-library";

jest.mock("../src/unitest/mock1/Worker10");

test("test exported function", () => {
  // const tree = shallow(<UsingWork10Screen/>);
  // tree.find(Button).simulate("press");
  const { getByTestId, debug } = testRender(<UsingWork10Screen />);
  const btn = getByTestId("button");
  fireEvent.press(btn);
  expect(work10).toBeCalledWith("num10");
  expect(say10).toBeCalledWith("name");
});
