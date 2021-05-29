import axios from "axios";
import React, { useEffect } from "react";

interface IProps {
  type: "scoops" | "toppings";
}

export const SundaesOptions = ({ type }: IProps) => {

  useEffect(() => {
    axios.get(`http://localhost:3030/${type}`)
      .then(raw => console.log(raw.data))
      .catch(error => console.error(error));
  }, [type]);


  return (
    <div>

    </div>
  );
};
