import { SoundPlayer } from "../src/unitest/mock2/SoundPlayer";
import { PlayScreen } from "../src/unitest/mock2/PlayScreen";

jest.mock("../src/unitest/mock2/SoundPlayer");

describe("mock2", () => {

  // 不清除的话, SoundPlayer.mock会越来越大
  afterEach(() => SoundPlayer.mockClear());

  test("check constructor be called", () => {
    const page = new PlayScreen();
    expect(SoundPlayer).toHaveBeenCalledTimes(1);
  });

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
    const page = new PlayScreen();
    page.onPlayPressed();

    const playerObj = SoundPlayer.mock.instances[0];
    const playFunc = playerObj.play;
    expect(playFunc).toHaveBeenCalledWith("jazz.mp3")
  });

});
