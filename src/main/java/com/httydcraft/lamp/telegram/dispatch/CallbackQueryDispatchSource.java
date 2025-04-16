package com.httydcraft.lamp.telegram.dispatch;

import com.httydcraft.lamp.telegram.dispatch.identificator.Identificator;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.User;

/**
 * Implementation of DispatchSource for Telegram callback queries.
 * Provides access to callback query data and metadata.
 * 
 * @see DispatchSource
 * @see CallbackQuery
 */
public class CallbackQueryDispatchSource implements DispatchSource {
    /**
     * The underlying Telegram callback query
     */
    private final CallbackQuery callbackQuery;

    /**
     * Creates a new dispatch source from a Telegram callback query.
     * 
     * @param callbackQuery the Telegram callback query
     * @throws NullPointerException if callbackQuery is null
     */
    public CallbackQueryDispatchSource(CallbackQuery callbackQuery) {
        this.callbackQuery = callbackQuery;
    }

    /**
     * Gets the callback query data as raw text.
     * 
     * @return the callback query data
     */
    @Override
    public String getText() {
        return callbackQuery.data();
    }

    /**
     * Gets the callback query data as execution text.
     * 
     * @return the callback query data
     */
    @Override
    public String getExecutionText() {
        return callbackQuery.data();
    }

    /**
     * Gets the user who triggered the callback query.
     * 
     * @return the author User object
     */
    @Override
    public User getAuthor() {
        return callbackQuery.from();
    }

    /**
     * Gets the callback query ID as the source identificator.
     * 
     * @return the callback query ID as an Identificator
     */
    @Override
    public Identificator getSourceIdentificator() {
        return Identificator.of(callbackQuery.id());
    }

    /**
     * Gets the chat ID where the callback query originated.
     * 
     * @return the chat ID as an Identificator, or null if not available
     */
    @Override
    public Identificator getChatIdentficator() {
        if (callbackQuery.message() != null)
            return Identificator.of(callbackQuery.message().chat().id());
        return null;
    }

    /**
     * Gets the underlying Telegram callback query.
     * 
     * @return the CallbackQuery object
     */
    public CallbackQuery getCallbackQuery() {
        return callbackQuery;
    }
}
