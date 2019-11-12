package ca.six.tests.books.art;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogAnalyzerTest {
    @Test
    public void isValidLogFileName_invalidExtension_returnsFalse() {
        LogAnalyzer target = new LogAnalyzer();
        boolean isValid = target.isValidLogFileName(".txt");
        assertFalse(isValid);
    }
}