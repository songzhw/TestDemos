import { tryDoIt } from "../src/unitest/promises";

describe("promise test", () => {

  test("promise 1", (done) => {
    tryDoIt(2)
      .then(num => {
        expect(num).toBe(4);
        done();
      });
  });

  test("promise2", () => {
    return expect(tryDoIt(4)).resolves.toBe(8);
  });

  test("promise3", () => {
    return expect(tryDoIt(3)).rejects.toMatch("only even");
  });

});
