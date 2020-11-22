import { HttpEngine } from "../src/core/HttpEngine";

jest.mock("../src/core/HttpEngine");

describe("HomeScreen", () => {

  beforeAll(() => {
    const listData = {
      succ: true,
      payload: [
        { id: "001as0d", title: "Onion", category: "grocery", isDone: false, color: "#9c27b0" }
      ]
    };
    HttpEngine.mockImplementation(() => {
      return {
        request: () => listData
      };
    });
  });

  beforeEach(async () => await device.reloadReactNative());

  afterEach(() => HttpEngine.mockClear());

  // test("should have home screen", async () => {
  //   await expect(element(by.text("Honey"))).toBeVisible();
  // });

  test("should show detail screen after tap", async () => {
    await element(by.text("Onion")).tap(); //这里会切到另一页, 但没事, Detox会等待另一页出现的
    await expect(element(by.text("#9c27b0"))).toBeVisible();
  });

  // test("should swipe then tap", async () => {
  //   await waitFor(element(by.text("Bacon")))
  //     .toBeVisible()
  //     .whileElement(by.id("homeList"))
  //     .scroll(250, "down");
  //   await element(by.text("Bacon")).tap();
  //   await expect(element(by.text("#4a148c"))).toBeVisible();
  // });
  //
  // test("add button", async () => {
  //   await element(by.id("btnAdd")).tap();
  //   await expect(element(by.text("Add Todo Item"))).toBeVisible();
  // });

});
