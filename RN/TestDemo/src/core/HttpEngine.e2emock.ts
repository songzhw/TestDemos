export class HttpEngine {
  async request(url: string) {
    const listData = {
      succ: true,
      payload: [
        { id: "001as0d", title: "Onion", category: "grocery", isDone: false, color: "#9c27b0" }
      ]
    };
    // console.log(`szw http str = `, str);
    return listData;
  }
}
