import axios from "axios";
import React, { useEffect, useState } from "react";
import { SundaeOption } from "./SundaesOption";
import { formatCurrency } from "../../utils/Utils";
import { ScoopsOptions } from "./ScoopsOptions";
import { ToppingsOptions } from "./ToppingsOptions";
import { Row } from "react-bootstrap";

interface IProps {
  type: "scoops" | "toppings";
}

export const SundaesOptionsView = ({ type }: IProps) => {
    const [items, setItems] = useState<SundaeOption[]>([]);
    const [error, setError] = useState<Error | null>(null);

    useEffect(() => {
      axios.get(`http://localhost:3030/${type}`)
        .then(raw => setItems(raw.data))
        .catch(err => setError(err));
    }, [type]);

    if (error) {
      return <h1>error</h1>;
    }

    //注意这个是组件, 所以首字母一定得大写!!!
    const ItemComponent = type === "scoops" ? ScoopsOptions : ToppingsOptions;
    const optionItems = items.map((item) => (
      <ItemComponent
        key={item.name}
        name={item.name}
        imagePath={item.imagePath}
        onUpdateCount={(itemName, newCount) => {
          console.log(``);
        }}
      />
    ));

    return (
      <>
        <h2>{type.toUpperCase()}</h2>
        <p>{formatCurrency(2)}</p>
        <Row>{optionItems}</Row>
      </>
    );
  }
;
