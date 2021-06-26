import React from "react";
import { OrderEntry } from "./pages/order/OrderEntry";
import { OrderContext } from "./utils/OrderContext";

function appCallback() {
  console.log(`szw appCallback`);
}

function App() {
  return (
    <OrderContext.Provider value={["ctx2", appCallback]}>
      <OrderEntry />
    </OrderContext.Provider>
  );
}

export default App;
