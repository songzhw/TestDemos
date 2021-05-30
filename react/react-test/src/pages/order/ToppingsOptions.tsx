import React from "react";
import { Col } from "react-bootstrap";

interface IProps {
  imagePath: string;
  name: string;
}

export const ToppingsOptions = ({imagePath, name}: IProps) => {

  return (
    <Col xs={6} sm={4} md={3} lg={2} style={{ textAlign: "center" }}>
      <img src={`http://localhost:3030/${imagePath}`} />
    </Col>
  );
};
