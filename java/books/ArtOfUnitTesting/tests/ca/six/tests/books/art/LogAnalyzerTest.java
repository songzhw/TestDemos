package ca.six.tests.books.art;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Executable;

import static org.junit.Assert.*;

/* LogAnalyzerTest2 is to test true/false as a return value.
   LogAnalyzerTest  is to test other scenarios without parameterized test
 */
public class LogAnalyzerTest {
    @Rule public ExpectedException exceptionRule = ExpectedException.none();

    @Category(CategoryJunitTool.class)
    @Test
    public void isValidLogFileName_emptyFileName_throwsException2() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("fileName has to be provided. Now it's empty");

        LogAnalyzer target = makeAnalyzer();
        target.isValidLogFileName(null);
    }

    @Category(CategoryJunitTool.class)
    @Test(expected = IllegalArgumentException.class)
    public void isValidLogFileName_emptyFileName_throwsException1() {
        LogAnalyzer target = makeAnalyzer();
        target.isValidLogFileName("");
    }

    @Category(CategorySimple.class)
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
    @Category(CategorySimple.class)
    @Test
    public void empty() {

    }

    private LogAnalyzer makeAnalyzer() {
        return new LogAnalyzer();
    }
}

interface CategorySimple {
}

interface CategoryJunitTool {
}