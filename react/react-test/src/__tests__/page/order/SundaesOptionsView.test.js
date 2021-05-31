import { SundaesOptionsView } from "../../../pages/order/SundaesOptionsView";
import { render, screen } from "@testing-library/react";

describe("SundaesOptionsView", () => {
  test("", async () => {
    const { debug } = render(<SundaesOptionsView type={"scoops"} />);
    const images = await screen.findAllByRole("img");
    debug();
    expect(images).toHaveLength(2);
  });
});
