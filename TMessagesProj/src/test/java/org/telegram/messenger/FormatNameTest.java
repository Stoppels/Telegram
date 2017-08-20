package org.telegram.messenger;

import static org.junit.Assert.*;

import org.junit.Test;

public class FormatNameTest {

    @Test
    public void testFormatName() throws Exception {
        String result = ContactsController.formatName("firstName", "lastName");
        String exampleName = "firstName lastName";
        assertEquals(exampleName, result);
    }

}
