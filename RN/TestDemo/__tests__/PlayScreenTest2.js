import { SoundPlayer } from "../src/unitest/mock2/SoundPlayer";
import { PlayScreen } from "../src/unitest/mock2/PlayScreen";

const mockFn = jest.fn(); //这种情况下, 这的Mock方法名一定要用mock开头!
jest.mock("../src/unitest/mock2/SoundPlayer", () => {
  return {
    SoundPlayer: jest.fn().mockImplementation(() => {
      return { play: mockFn };
    })
  };
}); //官网上的做法只适用于js. 对于TS, 我们还得加上 {SoundPlayer: **}, 不然会说: "_SoundPlayer.SoundPlayer is not a constructor"


describe("mock2B", () => {

  // 不清除的话, SoundPlayer.mock会越来越大
  afterEach(() => SoundPlayer.mockClear());

  test("check constructor be called", () => {
    const page = new PlayScreen();
    expect(SoundPlayer).toHaveBeenCalledTimes(1);
  });

  test("check method called", () => {
    const page = new PlayScreen();
    page.onPlayPressed();

    expect(mockFn).toHaveBeenCalledWith("jazz.mp3");
  });

});
