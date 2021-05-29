import React from "react";
import { Button } from "react-bootstrap";
import { SundaesOptions } from "./SundaesOptions";

interface IProps {
}

export const OrderEntry = (props: IProps) => {

  const onSetOrder = () => {

  };

  return (
    <div>
      <h1>Design Your Sundae!</h1>
      <SundaesOptions type="scoops"/>
      {/*<SundaesOptions type="toppings"/>*/}
      <h2> Grand total: </h2>
      <Button disabled={true} onClick={onSetOrder}>Order Sundae</Button>
    </div>
  );
};
