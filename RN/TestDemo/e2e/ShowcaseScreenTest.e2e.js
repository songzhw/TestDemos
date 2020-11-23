
describe("ShowcaseScreen", () => {

  beforeEach(async () => await device.reloadReactNative());

  test("should have first page at first", async () => {
    // await element(by.text("&#8921;")).tap(); //晕, 这还找不到?!  我打印下view hierarchy, 发现text已经是"⋙"
    await element(by.text("⋙")).tap();
    await expect(element(by.text("First Page"))).toBeVisible();
  });
});
