package ca.six.tests.books.art;

import org.junit.Test;

import static org.junit.Assert.*;

/* LogAnalyzerTest2 is to test true/false as a return value.
   LogAnalyzerTest  is to test other scenarios without parameterized test
 */
public class LogAnalyzerTest {
    @Test(expected = IllegalArgumentException.class)
    public void isValidLogFileName_emptyFileName_throwsException() {
        LogAnalyzer target = new LogAnalyzer();
        target.isValidLogFileName("");
    }
}