import React from "react";
import { OrderEntry } from "./pages/order/OrderEntry";
import { OrderContext } from "./utils/OrderContext";

function App() {
  return (
    <OrderContext.Provider value={"ctx2"}>
      <OrderEntry />
    </OrderContext.Provider>
  );
}

export default App;
