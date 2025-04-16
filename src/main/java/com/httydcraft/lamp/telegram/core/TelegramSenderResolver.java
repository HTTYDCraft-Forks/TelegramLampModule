package com.httydcraft.lamp.telegram.core;

import org.jetbrains.annotations.NotNull;

import com.httydcraft.lamp.telegram.dispatch.DispatchSource;
import com.pengrad.telegrambot.model.User;
import com.httydcraft.lamp.telegram.TelegramActor;

import revxrsal.commands.command.CommandActor;
import revxrsal.commands.command.ExecutableCommand;
import revxrsal.commands.process.SenderResolver;

/**
 * A sender resolver implementation for Telegram commands that provides access to:
 * - Telegram User objects
 * - DispatchSource objects
 * - TelegramActor instances
 * 
 * Implemented as an enum singleton (INSTANCE).
 * 
 * @see SenderResolver
 * @see TelegramActor
 * @see DispatchSource
 * @see User
 */
public enum TelegramSenderResolver implements SenderResolver {
    /**
     * The singleton instance of this resolver
     */
    INSTANCE;

    /**
     * Checks if the given type is a custom Telegram sender type (User or DispatchSource).
     * 
     * @param type the type to check
     * @return true if the type is User or DispatchSource
     */
    @Override
    public boolean isCustomType(Class<?> type) {
        return User.class.isAssignableFrom(type) || DispatchSource.class.isAssignableFrom(type);
    }

    /**
     * Resolves and returns the appropriate sender object based on the requested type.
     * 
     * @param customSenderType the requested sender type
     * @param actor the command actor
     * @param command the executable command
     * @return the resolved sender object (User, DispatchSource, or TelegramActor)
     * @throws ClassCastException if actor is not a TelegramActor
     */
    @Override
    public @NotNull Object getSender(@NotNull Class<?> customSenderType, @NotNull CommandActor actor,
            @NotNull ExecutableCommand command) {
        TelegramActor telegramActor = (TelegramActor) actor;
        if (User.class.isAssignableFrom(customSenderType))
            return telegramActor.getUser();
        if (DispatchSource.class.isAssignableFrom(customSenderType))
            return telegramActor.getDispatchSource();
        return telegramActor;
    }
}
