import { HttpEngine } from "../src/core/HttpEngine";

// jest.mock("../src/core/HttpEngine"); //Detox中的mock比单元测试的mock, 要复杂鑫了, 这个不行的

describe("HomeScreen", () => {

  beforeEach(async () => await device.reloadReactNative());

  test("should have home screen", async () => {
    await expect(element(by.text("Honey"))).toBeVisible();
  });

  test("should show detail screen after tap", async () => {
    await element(by.text("Wine")).tap(); //这里会切到另一页, 但没事, Detox会等待另一页出现的
    await expect(element(by.text("#8e24aa"))).toBeVisible();
  });

  test("add button", async () => {
    await element(by.id("btnAdd")).tap();
    await expect(element(by.text("Add Todo Item"))).toBeVisible();
  });

  test("should swipe then tap", async () => {
    await waitFor(element(by.text("Bacon")))
      .toBeVisible()
      .whileElement(by.id("homeList"))
      .scroll(250, "down");
    await element(by.text("Bacon")).tap();
    await expect(element(by.text("#4a148c"))).toBeVisible();
  });

  test("should change data on search", async ()=>{
    await element(by.id("searchBar")).typeText("Honey");
    await expect(element(by.text("Cheese"))).toNotExist()
    await expect(element(by.text("Honey Crisp"))).toBeVisible()
  })

});
