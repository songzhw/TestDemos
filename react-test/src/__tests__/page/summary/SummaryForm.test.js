import { SummaryForm } from "../../../pages/summary/SummaryForm";
import { fireEvent, render, screen, waitFor, waitForElementToBeRemoved } from "@testing-library/react";
import userEvent from "@testing-library/user-event";

describe("SummaryFormPage", () => {
  test("init conditions", () => {
    render(<SummaryForm />);
    const checkbox = screen.getByText(/terms and conditions/i);//"i"是表示不区分大小写
    expect(checkbox).not.toBeChecked();
    const btn = screen.getByText(/confirm order/i);
    expect(btn).toBeDisabled();
  });

  test("checkbox disable button on first click", () => {
    render(<SummaryForm />);
    const checkbox = screen.getByText(/terms and conditions/i);//"i"是表示不区分大小写
    const btn = screen.getByText(/confirm order/i);
    fireEvent.click(checkbox);
    expect(btn).toBeEnabled();
  });

  test("popover starts out hidden", () => {
    render(<SummaryForm />);
    const popover = screen.queryByText(/fake/i);
    expect(popover).not.toBeInTheDocument();
  });

  test("popover appears upopn mouseover of checkbox label", async () => {
    render(<SummaryForm />);
    const link = screen.getByText(/terms and conditions/i);
    userEvent.hover(link);

    const popover = await screen.findByText(/fake/i);
    expect(popover).toBeInTheDocument();
  });

  test("popver disappears when we mouse out", async () => {
    render(<SummaryForm />);
    const link = screen.getByText(/terms and conditions/i);
    userEvent.hover(link);

    const popover = await screen.findByText(/fake/i);
    expect(popover).toBeInTheDocument();

    userEvent.unhover(link);
    // expect(popover).not.toBeInTheDocument()
    await waitForElementToBeRemoved(() =>
      screen.getByText(/fake/i)
    );

  });

});
