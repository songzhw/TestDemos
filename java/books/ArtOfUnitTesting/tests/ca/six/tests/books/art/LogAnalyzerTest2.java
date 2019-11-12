package ca.six.tests.books.art;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LogAnalyzerTest2 {
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"c.jpg", false},
                {"d.slf", true}
        });
    }

    @Parameter(0)
    public String fileName;
    @Parameter(1)
    public boolean result;

    @Test
    public void testIsValidLogFileName() {
        System.out.println("members = " + fileName + " ; " + result);
        LogAnalyzer target = new LogAnalyzer();
        boolean isValid = target.isValidLogFileName(fileName);
        assertEquals(result, isValid);
    }


}