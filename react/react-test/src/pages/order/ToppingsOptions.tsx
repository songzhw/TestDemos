import React from "react";
import { Col, Form } from "react-bootstrap";

interface IProps {
  name: string;
  imagePath: string;
  onUpdateCount: (name: string, count: number) => void;
}

export const ToppingsOptions = ({ imagePath, name, onUpdateCount }: IProps) => {

  return (
    <Col xs={6} sm={4} md={3} lg={2}>
      <img src={`http://localhost:3030/${imagePath}`} style={{width: '50%'}}/>
      <Form.Group>
        <Form.Check type={"checkbox"} label={name} onChange={(e) => {
          onUpdateCount(name, e.target.checked ? 1 : 0);
        }} />

      </Form.Group>
    </Col>
  );
};
