import { SundaesOptionsView } from "../../../pages/order/SundaesOptionsView";
import { render, screen } from "@testing-library/react";

describe("SundaesOptionsView", () => {
  test("", () => {
    const { debug } = render(<SundaesOptionsView type={"scoops"} />);
    debug();

    const images = screen.getAllByRole("img");
    expect(images).toHaveLength(2);
  });
});
