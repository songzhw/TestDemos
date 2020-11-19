describe("HomeScreen", () => {
  beforeEach(async () => {
    await device.reloadReactNative();
  });

  it("should have home screen", async () => {
    await expect(element(by.text("First Item"))).toBeVisible();
  });

  it("should show hello screen after tap", async () => {
    await element(by.id("btnAdd")).tap(); //这里会切到另一页, 但没事, Detox会等待另一页出现的
    await expect(element(by.text("Detail"))).toBeVisible();
  });

});
