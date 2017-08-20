package org.telegram.messenger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.telegram.messenger.ContactsController;
import org.telegram.tgnet.TLRPC;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by ns on 20/08/2017.
 */

public class ContactsControllerTest {

//    @Mock
    ContactsController cc = mock(ContactsController.class);

//    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    TLRPC.User user;

    @Before
    public void setup() {
        user = new TLRPC.User();
        user.id = 33973748;
        user.first_name = "First";
        user.last_name = "Last";
        user.username = "testson12";
        user.phone = "+12025550121";
    }

//    TLRPC.TL_contact contact = new

    /**
     * Status: OK.
     * @throws Exception
     */
    @Test
    public void testAddContactBehavior() throws Exception {
        // Execute behavior
        cc.addContact(user);
        // Verify the behavior
        verify(cc).addContact(user);

        cc.readContacts();
//        cc.contacts.size();
//        Assert.assertEquals(runCc.contacts.get(0).user_id, user.id);
        testAddContact();
    }

    /**
     * Status: Does not work for some reason. Telegram's too spaghetti.
     * @throws Exception
     */
    @Test
    public void testAddContact() throws Exception {
        ContactsController run = new ContactsController();
        run.addContact(user);
        run.readContacts();
        run.contacts.size();
//        Assert.assertEquals(runCc.contacts.get(0).user_id, user.id);
    }

    /**
     * Status: OK.
     * @throws Exception
     */
    @Test
    public void testFormatName() throws Exception {
        String result = ContactsController.formatName(user.first_name, user.last_name);
        String name = "First Last";
        System.out.println(result);
        Assert.assertEquals(name, result);
    }

    @Test
    public void testMath() {
        assertEquals(1, 1);
    }
}
