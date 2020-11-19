export class HttpEngine {
  async request(url: string) {
    const resp = await fetch(url);
    const str = await resp.json();
    // console.log(`szw http str = `, str);
    return str;
  }
}
