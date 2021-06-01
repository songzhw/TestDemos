import React, { useContext } from "react";
import { Col, Form } from "react-bootstrap";
import { FnContext, OrderContext } from "../../utils/OrderContext";

interface IProps {
  name: string;
  imagePath: string;
  onUpdateCount: (name: string, count: number) => void;
}

export const ScoopsOptions = ({ imagePath, name, onUpdateCount }: IProps) => {
  const onCountChange = (event: any) => {
    const count = event.target.value;
    onUpdateCount(name, count);
  };

  const contextValue = useContext(OrderContext);
  console.log(`szw contextValue = `, contextValue);
  const contextFn = useContext(FnContext);
  // @ts-ignore (因为不认识这是个function)
  contextFn();
  console.log(`szw contextFn = `, contextFn);

  return (
    <Col xs={12} sm={6} md={4} lg={3} style={{ textAlign: "center" }}>
      <img src={`http://localhost:3030/${imagePath}`} style={{ width: "50%" }}/>
      <Form.Group style={{ width: "50%" }}>
        <Form.Label>{name}</Form.Label>
        <Form.Control type={"number"} defaultValue={0} onChange={onCountChange} />
      </Form.Group>
    </Col>
  );
};
