// @ts-ignore
import { IS_E2E } from "@env";
import { SomeWebContentScreen } from "../biz/webview/SomeWebContentScreen";
import { FakeWebHoc } from "../e2e/FakeWebHoc";

export const SomeWeb = IS_E2E ?
  FakeWebHoc :
  SomeWebContentScreen;
