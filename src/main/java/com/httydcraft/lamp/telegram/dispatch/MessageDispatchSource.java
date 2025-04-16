package com.httydcraft.lamp.telegram.dispatch;

import com.httydcraft.lamp.telegram.dispatch.identificator.Identificator;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.User;

/**
 * Implementation of DispatchSource for Telegram messages.
 * Handles both regular text messages and media messages with captions.
 * 
 * @see DispatchSource
 * @see Message
 */
public class MessageDispatchSource implements DispatchSource {
    /**
     * The underlying Telegram message
     */
    private final Message message;
    
    /**
     * The processed message text (either text content or caption)
     */
    private String messageText;

    /**
     * Creates a new dispatch source from a Telegram message.
     * 
     * @param message the Telegram message
     * @throws NullPointerException if message is null
     */
    public MessageDispatchSource(Message message) {
        this.message = message;
        if(message.text()!=null)
            messageText = message.text();
        if(message.caption()!=null)
            messageText = message.caption();
    }

    /**
     * Gets the message text or caption.
     * 
     * @return the message content
     */
    @Override
    public String getText() {
        return messageText;
    }

    /**
     * Gets the message text to be used for command execution.
     * 
     * @return the execution text
     */
    @Override
    public String getExecutionText() {
        return getText();
    }

    /**
     * Gets the author of the message.
     * 
     * @return the author User object
     */
    @Override
    public User getAuthor() {
        return message.from();
    }

    /**
     * Gets the message ID as the source identificator.
     * 
     * @return the message ID as an Identificator
     */
    @Override
    public Identificator getSourceIdentificator() {
        return Identificator.of(message.messageId());
    }

    /**
     * Gets the chat ID where the message was sent.
     * 
     * @return the chat ID as an Identificator
     */
    @Override
    public Identificator getChatIdentficator() {
        return Identificator.of(message.chat().id());
    }

    /**
     * Gets the underlying Telegram message.
     * 
     * @return the Message object
     */
    public Message getMessage() {
        return message;
    }
}
