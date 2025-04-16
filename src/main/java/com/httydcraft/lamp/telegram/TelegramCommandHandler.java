package com.httydcraft.lamp.telegram;

import com.pengrad.telegrambot.TelegramBot;

import revxrsal.commands.CommandHandler;

/**
 * Interface for handling Telegram bot commands, extending the base CommandHandler.
 * Provides access to the underlying TelegramBot instance for command execution.
 * 
 * @see com.pengrad.telegrambot.TelegramBot
 * @see revxrsal.commands.CommandHandler
 */
public interface TelegramCommandHandler extends CommandHandler {
    /**
     * Gets the Telegram bot instance associated with this command handler.
     * 
     * @return the TelegramBot instance used for command execution
     * @see com.pengrad.telegrambot.TelegramBot
     */
    TelegramBot getBot();
}
