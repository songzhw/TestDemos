import React from "react";
import { OrderEntry } from "./pages/order/OrderEntry";
import { FnContext, OrderContext } from "./utils/OrderContext";

function appCallback() {
  console.log(`szw appCallback`);
}

function App() {
  return (
    <FnContext.Provider value={appCallback}>
      <OrderContext.Provider value={"ctx2"}>
        <OrderEntry />
      </OrderContext.Provider>
    </FnContext.Provider>
  );
}

export default App;
