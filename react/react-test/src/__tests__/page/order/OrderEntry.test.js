import { render, screen } from "@testing-library/react";
import { OrderEntry } from "../../../pages/order/OrderEntry";

describe("OrderEntry", () => {
  test("testID", () => {
    const { debug } = render(<OrderEntry />);
    const header = screen.getByTestId("entryH1");
    expect(header).toBeInTheDocument();
    debug();
  });
});
