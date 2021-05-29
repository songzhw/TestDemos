// => 1.5会得到 $1.50
export function formatCurrency(num: number) {
  return new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "USD",
    minimumFractionDigits: 2
  }).format(num);
}
