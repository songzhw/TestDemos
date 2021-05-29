import axios from "axios";
import React, { useEffect, useState } from "react";
import { SundaeOption } from "./SundaesOption";

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

  return (
    <div>

    </div>
  );
}
;
