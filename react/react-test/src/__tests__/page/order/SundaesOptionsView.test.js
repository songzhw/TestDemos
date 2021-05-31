import { SundaesOptionsView } from "../../../pages/order/SundaesOptionsView";
import { render } from "@testing-library/react";

describe("SundaesOptionsView", () => {
  test("", () => {
    const { debug } = render(<SundaesOptionsView type={"scoops"} />);
    debug();
  });
});
