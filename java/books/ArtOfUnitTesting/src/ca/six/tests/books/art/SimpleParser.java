package ca.six.tests.books.art;

import java.io.InvalidObjectException;

class SimpleParser {
    public int parseAndSum(String numbers) throws InvalidObjectException {
        if (numbers.length() == 0) {
            return 0;
        }

        if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        } else {
            throw new InvalidObjectException("can't parse this string");
        }
    }
}
