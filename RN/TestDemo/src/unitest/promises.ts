export const tryDoIt = (num: number) => {
  return new Promise((resolve, reject) => {
    if (num % 2 == 0) {
      setTimeout(() => resolve(num * 2), 2000);
    } else {
      setTimeout(() => reject("only even"), 1000);
    }
  });
};
