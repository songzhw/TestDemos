describe("HomeScreen", () => {
  beforeEach(async () => {
    await device.reloadReactNative();
  });

  it("should have home screen", async () => {
    await expect(element(by.text("First Item"))).toBeVisible();
  });

  it("should show hello screen after tap", async () => {
    await element(by.text("+")).tap();
    await expect(element(by.text("Detail"))).toBeVisible();
  });

});
