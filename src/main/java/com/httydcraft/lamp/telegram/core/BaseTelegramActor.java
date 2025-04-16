package com.httydcraft.lamp.telegram.core;

import java.util.UUID;
import java.util.function.Supplier;

import org.jetbrains.annotations.NotNull;

import com.httydcraft.lamp.telegram.dispatch.DispatchSource;
import com.pengrad.telegrambot.model.User;
import com.pengrad.telegrambot.request.SendMessage;
import com.httydcraft.lamp.telegram.TelegramActor;
import com.httydcraft.lamp.telegram.TelegramCommandHandler;

import revxrsal.commands.CommandHandler;

/**
 * Base implementation of the TelegramActor interface that handles Telegram command execution.
 * Provides core functionality for processing Telegram commands and sending responses.
 *
 * @see TelegramActor The interface this class implements
 * @see TelegramCommandHandler The command handler used by this actor
 * @see DispatchSource The source of Telegram messages/events
 */
public class BaseTelegramActor implements TelegramActor {

    /**
     * Memoized supplier for generating a consistent UUID based on the Telegram user ID
     */
    private final Supplier<UUID> uuidSupplier = MemoizingSupplier.memoize(() -> new UUID(0, getId()));
    
    /**
     * The Telegram command handler instance
     */
    private final TelegramCommandHandler commandHandler;
    
    /**
     * The dispatch source that triggered this command
     */
    private final DispatchSource dispatchSource;

    /**
     * Creates a new BaseTelegramActor instance.
     * 
     * @param commandHandler the Telegram command handler
     * @param dispatchSource the dispatch source that triggered this command
     */
    public BaseTelegramActor(TelegramCommandHandler commandHandler, DispatchSource dispatchSource) {
        this.commandHandler = commandHandler;
        this.dispatchSource = dispatchSource;
    }

    /**
     * Gets the user's first name as their display name.
     * 
     * @return the user's first name
     */
    @Override
    public @NotNull String getName() {
        return getUser().firstName();
    }

    /**
     * Gets a unique ID for this actor based on their Telegram user ID.
     * 
     * @return a UUID generated from the user's Telegram ID
     */
    @Override
    public @NotNull UUID getUniqueId() {
        return uuidSupplier.get();
    }

    /**
     * Sends a reply message to the user/chat that triggered this command.
     * 
     * @param message the message to send
     */
    @Override
    public void reply(@NotNull String message) {
        SendMessage sendMessage = new SendMessage(dispatchSource.getChatIdentficator().asObject(),
                commandHandler.getMessagePrefix() + message);
        commandHandler.getBot().execute(sendMessage);
    }

    /**
     * Sends an error message to the user/chat that triggered this command.
     * 
     * @param message the error message to send
     */
    @Override
    public void error(@NotNull String message) {
        reply(message);
    }

    /**
     * Gets the command handler associated with this actor.
     * 
     * @return the TelegramCommandHandler instance
     */
    @Override
    public CommandHandler getCommandHandler() {
        return commandHandler;
    }

    /**
     * Gets the Telegram User associated with this actor.
     * 
     * @return the Telegram User object
     */
    @Override
    public User getUser() {
        return dispatchSource.getAuthor();
    }

    /**
     * Gets the dispatch source that triggered this command.
     * 
     * @return the DispatchSource object
     */
    @Override
    public DispatchSource getDispatchSource() {
        return dispatchSource;
    }
}
