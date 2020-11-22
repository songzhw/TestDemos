import { SoundPlayer } from "../src/unitest/mock2/SouldPlayer";
import { PlayScreen } from "../src/unitest/mock2/PlayScreen";

const fn = jest.fn()
jest.mock("../src/unitest/mock2/SouldPlayer")


describe("mock2", ()=>{
  test("check constructor be called", ()=>{
    const page = new PlayScreen();
    expect(SoundPlayer).toHaveBeenCalledTimes(1)
  })



})
