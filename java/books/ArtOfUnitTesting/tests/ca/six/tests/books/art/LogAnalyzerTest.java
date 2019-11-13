package ca.six.tests.books.art;

import org.junit.Test;

import static org.junit.Assert.*;

// LogAnalyzerTest2.java is a more efficient version
@Deprecated
public class LogAnalyzerTest {
    @Test
    public void isValidLogFileName_invalidExtension_returnsFalse() {
        LogAnalyzer target = new LogAnalyzer();
        boolean isValid = target.isValidLogFileName("a.txt");

        assertFalse(isValid);
    }

    @Test
    public void isValidLogFileName_validExtension_returnTrue() {
        LogAnalyzer target = new LogAnalyzer();
        boolean isValid = target.isValidLogFileName("b.slf");

        assertTrue(isValid);
    }
}