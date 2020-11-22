import { HttpEngine } from "../src/core/HttpEngine";

jest.mock("../src/core/HttpEngine");

describe("HomeScreen", () => {

  beforeEach(async () => await device.reloadReactNative());
  afterEach(() => HttpEngine.mockClear());

  // test("should have home screen", async () => {
  //   await expect(element(by.text("Honey"))).toBeVisible();
  // });

  test("should show detail screen after tap", async () => {
    const http = new HttpEngine();
    http.request("one")
      .then(str => console.log("szw http resp = ", str));

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
