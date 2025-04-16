package com.httydcraft.lamp.telegram;

import com.httydcraft.lamp.telegram.core.BaseTelegramActor;
import com.httydcraft.lamp.telegram.dispatch.DispatchSource;
import com.pengrad.telegrambot.model.User;

import revxrsal.commands.command.CommandActor;

/**
 * Represents a Telegram command actor that handles command execution in Telegram bots.
 * Provides access to Telegram-specific user information and dispatch sources.
 * 
 * @see BaseTelegramActor The default implementation of this interface
 * @see TelegramCommandHandler The command handler for Telegram commands
 */
public interface TelegramActor extends CommandActor {
    /**
     * Gets the Telegram user ID associated with this actor.
     * 
     * @return the user ID as a Long
     * @see #getUser()
     */
    default Long getId() {
        return getUser().id();
    }

    /**
     * Gets the Telegram User object associated with this actor.
     * 
     * @return the Telegram User object
     * @see com.pengrad.telegrambot.model.User
     */
    default User getUser() {
        return getDispatchSource().getAuthor();
    }

    /**
     * Gets the dispatch source that triggered this command.
     * 
     * @return the DispatchSource object
     * @see DispatchSource
     */
    DispatchSource getDispatchSource();

    /**
     * Wraps a dispatch source and command handler into a TelegramActor instance.
     * 
     * @param commandHandler the Telegram command handler
     * @param dispatchSource the dispatch source
     * @return a new TelegramActor instance
     * @see BaseTelegramActor
     */
    static TelegramActor wrap(TelegramCommandHandler commandHandler, DispatchSource dispatchSource) {
        return new BaseTelegramActor(commandHandler, dispatchSource);
    }
}
