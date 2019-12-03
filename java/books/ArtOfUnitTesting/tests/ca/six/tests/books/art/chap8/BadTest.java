package ca.six.tests.books.art.chap8;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class BadTest {
    @Test
    public void bad() {
        String user = "USER";
        String greeting = "GREETING";
        String actual = new MessageBuilder().build(user, greeting);
        assertEquals(user + greeting, actual);
    }

    @Test
    public void good() {
        String user = "USER";
        String greeting = "GREETING";
        String actual = new MessageBuilder().build(user, greeting);
        assertEquals("USER GREETING", actual);
    }
}
