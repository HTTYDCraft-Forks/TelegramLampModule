package com.httydcraft.lamp.telegram.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.pengrad.telegrambot.TelegramBot;
import com.httydcraft.lamp.telegram.TelegramCommandHandler;

import revxrsal.commands.core.BaseCommandHandler;
import revxrsal.commands.exception.DefaultExceptionHandler;

/**
 * The core implementation of TelegramCommandHandler that manages Telegram bot commands.
 * Handles command registration, execution, and provides access to the TelegramBot instance.
 * Maintains a synchronized list of all active handler instances.
 * 
 * @see TelegramCommandHandler
 * @see TelegramBot
 * @see TelegramSenderResolver
 */
public class TelegramHandler extends BaseCommandHandler implements TelegramCommandHandler {
    /**
     * Thread-safe list of all active TelegramHandler instances
     */
    private static final List<TelegramHandler> INSTANCES = Collections.synchronizedList(new ArrayList<>());
    
    /**
     * The TelegramBot instance associated with this handler
     */
    private final TelegramBot bot;

    /**
     * Creates a new TelegramHandler for the specified bot.
     * Initializes default exception handling and registers required dependencies.
     * 
     * @param bot the TelegramBot instance to handle commands for
     */
    public TelegramHandler(TelegramBot bot) {
        this.bot = bot;

        setExceptionHandler(new DefaultExceptionHandler());
        registerDependency(TelegramBot.class, bot);
        registerSenderResolver(TelegramSenderResolver.INSTANCE);

        INSTANCES.add(this);
    }

    /**
     * Gets the Telegram bot instance associated with this handler.
     * 
     * @return the TelegramBot instance
     */
    @Override
    public TelegramBot getBot() {
        return bot;
    }

    /**
     * Gets an unmodifiable list of all active TelegramHandler instances.
     * 
     * @return list of all active handlers
     */
    public static List<TelegramHandler> getInstances() {
        return Collections.unmodifiableList(INSTANCES);
    }
}
