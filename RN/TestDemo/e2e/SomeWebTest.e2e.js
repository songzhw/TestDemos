describe("SomeWebContent", () => {

  beforeEach(async () => await device.reloadReactNative());

  test("isE2e should be true", async () => {
    await element(by.text("网")).tap();
    await expect(element(by.text("hello"))).toBeVisible();
  });

});
