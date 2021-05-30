import React from "react";
import { Col, Form } from "react-bootstrap";

interface IProps {
  imagePath: string;
  name: string;
  onUpdateCount: (name: string, count: number) => void;
}

export const ToppingsOptions = ({ imagePath, name, onUpdateCount }: IProps) => {

  return (
    <Col xs={6} sm={4} md={3} lg={2} style={{ textAlign: "center" }}>
      <img src={`http://localhost:3030/${imagePath}`} />
      <Form.Group>
        <Form.Check type={"checkbox"} onChange={(e) => {
          onUpdateCount(name, e.target.checked ? 1 : 0);
        }} />

      </Form.Group>
    </Col>
  );
};
