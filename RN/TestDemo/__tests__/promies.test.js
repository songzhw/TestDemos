import { tryDoIt } from "../src/unitest/promises";

test("promise", () => {
  tryDoIt(2)
    .then(num => expect(num).toBe(5));
});
