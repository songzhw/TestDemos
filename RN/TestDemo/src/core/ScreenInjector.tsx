import React from "react";
// @ts-ignore
import { IS_E2E } from "@env";
import { SomeWebContentScreen } from "../biz/webview/SomeWebContentScreen";
import { buildFakeWeb, FakeWebHoc } from "../e2e/FakeWebHoc";

const web = <SomeWebContentScreen />;

export const SomeWeb = IS_E2E ?
  <FakeWebHoc> {web} </FakeWebHoc> :
  web;
