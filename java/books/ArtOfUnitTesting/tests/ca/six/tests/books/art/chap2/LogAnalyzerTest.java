package ca.six.tests.books.art.chap2;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.lang.reflect.Executable;


import static org.junit.Assert.*;

/* LogAnalyzerTest2 is to test true/false as a return value.
   LogAnalyzerTest  is to test other scenarios without parameterized test
 */
public class LogAnalyzerTest {
    @Rule public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void isValidLogFileName_emptyFileName_throwsException2() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("fileName has to be provided. Now it's empty");

        LogAnalyzer target = makeAnalyzer();
        target.isValidLogFileName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void isValidLogFileName_emptyFileName_throwsException1() {
        LogAnalyzer target = makeAnalyzer();
        target.isValidLogFileName("");
    }

    @Test
    public void isValidLogFileName_emptyFileName_throwsException3() {
        try {
            LogAnalyzer target = makeAnalyzer();
            target.isValidLogFileName("");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "fileName has to be provided. Now it's empty");
        }
    }

    @Ignore
    @Test
    public void empty() {

    }

    private LogAnalyzer makeAnalyzer() {
        return new LogAnalyzer();
    }
}