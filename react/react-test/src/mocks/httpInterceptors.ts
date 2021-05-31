// 处理哪种api, 是rest还是graphql, 这就是"rest"引入的原因.
import { rest } from "msw";
import { setupServer } from "msw/node";

const api1 = rest.get("http://localhost:3030/scoops", (req, resp, ctx) => {
  return resp(ctx.json([
    { "name": "doujiang", "imagePath": "/images/dou.png" },
    { "name": "youtiao", "imagePath": "/images/tiao.png" }
  ]));
});
const api2 = rest.get("http://localhost:3030/toppings", (req, resp, ctx) => {
  return resp(ctx.json([
    { "name": "A", "imagePath": "/images/a.png" },
    { "name": "B", "imagePath": "/images/b.png" }
  ]));
});

export const mockServer = setupServer(api1, api2);
