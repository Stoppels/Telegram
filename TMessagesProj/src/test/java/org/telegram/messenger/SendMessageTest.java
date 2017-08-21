package org.telegram.messenger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.telegram.tgnet.TLRPC;

import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class SendMessageTest {
    @Mock
    MessageObject MessObj = mock(MessageObject.class);

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    SendMessagesHelper sendMessagesHelper;

    TLRPC.Message message;
    TLRPC.User user;
    TLRPC.Chat chat;

    @Before
    public void setUp() {
        message = new TLRPC.Message();
        message.message = "Een test bericht";

        user = new TLRPC.User();
        user.id = 33973748;
        user.first_name = "First";
        user.last_name = "Last";
        user.username = "testson12";
        user.phone = "+12025550121";

        chat = new TLRPC.Chat();
        chat.id = 1345565;

        this.sendMessagesHelper = new SendMessagesHelper();
    }

    @Test
    public void testSendMessage() throws Exception {
        AbstractMap userTest = new HashMap();
        AbstractMap chatTest = new HashMap();
        userTest.put(1, user.id);
        chatTest.put(1, chat.id);

        ArrayList<MessageObject> messages = new ArrayList<>();

        MessObj = new MessageObject(message, userTest, chatTest, true);
        System.out.println(MessObj);
        messages.add(
                MessObj
        );

        SendMessagesHelper messagesHelper = new SendMessagesHelper();
        messagesHelper.sendMessage(messages, 1);
        assertEquals(messages.get(0).isSent(), true);
    }

}