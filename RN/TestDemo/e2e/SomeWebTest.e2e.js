describe("SomeWebContent", () => {

  beforeEach(async () => await device.reloadReactNative());

  // test("isE2e should be true", async () => {
  //   await element(by.text("网")).tap();
  //   await expect(element(by.text("Hello World"))).toBeVisible();
  // });

  test("reset text by invisible input", async () => {
    await element(by.text("网")).tap();
    await element(by.id("inviInput")).typeText("resetText()");
    await element(by.id("inviButton")).tap();
    await expect(element(by.text("(default)"))).toBeVisible();
  });

});
