package com.httydcraft.lamp.telegram.dispatch;

import com.httydcraft.lamp.telegram.dispatch.identificator.Identificator;
import com.pengrad.telegrambot.model.User;

/**
 * Represents a source of Telegram commands/messages that can be dispatched.
 * Provides access to message content, chat/user identifiers, and author information.
 * 
 * @see Identificator
 * @see User
 */
public interface DispatchSource {
    /**
     * Gets the raw text content of the dispatch source.
     * 
     * @return the raw text content
     */
    String getText();

    /**
     * Gets the processed text that should be used for command execution.
     * 
     * @return the processed execution text
     */
    String getExecutionText();

    /**
     * Gets the chat identificator where this dispatch originated.
     * 
     * @return the chat identificator
     */
    Identificator getChatIdentficator();

    /**
     * Gets the source identificator of this dispatch.
     * 
     * @return the source identificator
     */
    Identificator getSourceIdentificator();

    /**
     * Gets the author/user who triggered this dispatch.
     * 
     * @return the author User object
     */
    User getAuthor();

    /**
     * Safely casts this dispatch source to a specific subtype.
     * 
     * @param <T> the dispatch source subtype
     * @param clazz the target class to cast to
     * @return this dispatch source cast to the target type
     * @throws ClassCastException if the cast is not possible
     */
    default <T extends DispatchSource> T as(Class<T> clazz) {
        return clazz.cast(this);
    }
}
