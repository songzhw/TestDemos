describe("ShowcaseScreen", () => {

  beforeEach(async () => await device.reloadReactNative());

  test("should have first page at first", async () => {
    // await element(by.text("&#8921;")).tap(); //晕, 这还找不到?!  我打印下view hierarchy, 发现text已经是"⋙"
    await element(by.text("⋙")).tap();
    await expect(element(by.text("First Page"))).toBeVisible();
  });

  test("swipe test", async () => {
    await element(by.text("⋙")).tap();
    // 这里取巧了. 因为detox不支持testID在自定义view上, 所以无法使用by.id("viewpager"). 只好试一下Text, 竟然成功了!
    await element(by.text("First Page")).swipe("left"); // swipe("left")表示滑动到去看右边一页!
    await expect(element(by.text("Second Page"))).toBeVisible();
  });
});
