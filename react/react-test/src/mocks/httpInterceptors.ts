// 处理哪种api, 是rest还是graphql, 这就是"rest"引入的原因.
import { setupWorker, rest } from "msw";

const api1 = rest.get("http://localhost:3030/scoops", (req, resp, ctx) => {

});
const api2 = rest.get("http://localhost:3030/toppings", (req, resp, ctx) => {

});
const interceptor = setupWorker(api1, api2);
interceptor.start();
