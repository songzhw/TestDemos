import { SoundPlayer } from "../src/unitest/mock2/SoundPlayer";
import { PlayScreen } from "../src/unitest/mock2/PlayScreen";

jest.mock("../src/unitest/mock2/SoundPlayer");

describe("mock2C", () => {

  beforeAll(() => {
    SoundPlayer.mockImplementation(() => {
      return {
        play: () => {
          throw new Error("Test Error");
        }
      };
    });
  });

  // 不清除的话, SoundPlayer.mock会越来越大
  afterEach(() => SoundPlayer.mockClear());

  test("check method called", () => {
    const page = new PlayScreen();
    expect(() => page.onPlayPressed()).toThrow();
  });

});
