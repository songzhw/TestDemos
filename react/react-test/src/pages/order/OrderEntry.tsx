import React from "react";
import { Button } from "react-bootstrap";
import { SundaesOptionsView } from "./SundaesOptionsView";

interface IProps {
}

export const OrderEntry = (props: IProps) => {

  const onSetOrder = () => {

  };

  return (
    <div>
      <h1>Design Your Sundae!</h1>
      <SundaesOptionsView type="scoops"/>
      {/*<SundaesOptionsView type="toppings"/>*/}
      <h2> Grand total: </h2>
      <Button disabled={true} onClick={onSetOrder}>Order Sundae</Button>
    </div>
  );
};
