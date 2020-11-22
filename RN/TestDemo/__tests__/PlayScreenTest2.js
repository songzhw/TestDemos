import { SoundPlayer } from "../src/unitest/mock2/SoundPlayer";
import { PlayScreen } from "../src/unitest/mock2/PlayScreen";

const mockFn = jest.fn(); //这种情况下, 这的Mock方法名一定要用mock开头!
jest.mock("../src/unitest/mock2/SoundPlayer", () => {
  return jest.fn().mockImplementation(() => {
    return { play: mockFn };
  });
});


describe("mock2B", () => {

  // 不清除的话, SoundPlayer.mock会越来越大
  afterEach(() => SoundPlayer.mockClear());

  // test("check constructor be called", () => {
  //   const page = new PlayScreen();
  //   expect(SoundPlayer).toHaveBeenCalledTimes(1);
  // });

  /*
  SoundPlayer.mock长这样:
      mock =  {
        calls: [ [] ],
        instances: [ SoundPlayer { play: [Function] } ],
        invocationCallOrder: [ 2 ],
        results: [ { type: 'return', value: undefined } ]
      }
   */
  test("check method called", () => {
    // const page = new PlayScreen();
    // page.onPlayPressed();
    //
    // expect(fn).toHaveBeenCalledWith("jazz.mp3");
    console.log(SoundPlayer.mock)
  });

});
