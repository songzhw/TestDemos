package ca.six.tests.books.art;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LogAnalyzerTest2 {
    @Parameter
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"c.jpg", false},
                {"d.slf", true}
        });
    }


}