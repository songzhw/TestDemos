package ca.six.tests.books.art;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Executable;

import static org.junit.Assert.*;

/* LogAnalyzerTest2 is to test true/false as a return value.
   LogAnalyzerTest  is to test other scenarios without parameterized test
 */
public class LogAnalyzerTest {
    @Rule public ExpectedException exceptionRule = ExpectedException.none();

    @Test(expected = IllegalArgumentException.class)
    public void isValidLogFileName_emptyFileName_throwsException() {
        LogAnalyzer target = new LogAnalyzer();
        target.isValidLogFileName("");
    }

    @Test
    public void isValidLogFileName_emptyFileName_throwsException2() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("fileName has to be provided. Now it's empty");

        LogAnalyzer target = new LogAnalyzer();
        target.isValidLogFileName(null);
    }
}