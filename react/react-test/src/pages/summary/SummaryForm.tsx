import React, { useState } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Popover from "react-bootstrap/Popover";
import OverlayTrigger from "react-bootstrap/OverlayTrigger";

export function SummaryForm() {
  const [tcChecked, setTcChecked] = useState(false);

  const popover =
    <Popover id={"popover-terms"}>
      <Popover.Content>fake</Popover.Content>
    </Popover>;

  const checkboxLabel = (
    <span>
      i agree to
      <OverlayTrigger placement="right" overlay={popover}>
        <span style={{ color: "blue" }}> terms and conditions</span>
      </OverlayTrigger>
    </span>
  );

  return (
    <Form>
      <Form.Group controlId="terms-and-conditions">
        <Form.Check
          type="checkbox"
          checked={tcChecked}
          onChange={(e) => setTcChecked(e.target.checked)}
          label={checkboxLabel}
        />
      </Form.Group>
      <Button variant="primary" type="submit" disabled={!tcChecked}>Confirm order</Button>
    </Form>
  );
}
