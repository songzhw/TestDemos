import { jinx } from "../src/unitest/errors";

describe("jinx", () => {
  test("jinx(2) should return 2", () => {
    const result = jinx(2);
    expect(result).toBe(2);
  });
  test("jinx(4) should throw error", () => {
    expect(() => jinx(4)).toThrow(Error);
    expect(()=>jinx(4)).toThrow("4 is a bad number")
  });

});

