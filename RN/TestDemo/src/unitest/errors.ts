export const jinx = (num: number) => {
  if (num % 4 === 0) {
    throw new Error("4 is a bad number");
  }
  return num;
};
