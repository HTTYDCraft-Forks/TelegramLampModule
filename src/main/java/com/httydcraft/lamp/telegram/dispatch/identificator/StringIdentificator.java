package com.httydcraft.lamp.telegram.dispatch.identificator;

/**
 * Implementation of Identificator that represents a string-based identifier.
 * Used for string identifiers like callback query IDs in Telegram.
 * 
 * @see Identificator
 */
public class StringIdentificator implements Identificator {
    /**
     * The underlying string value
     */
    private final String identificator;

    /**
     * Creates a new string-based identificator.
     * 
     * @param identificator the string value
     * @throws NullPointerException if identificator is null
     */
    public StringIdentificator(String identificator) {
        this.identificator = identificator;
    }

    /**
     * Gets the identificator value as a string.
     * 
     * @return the string value
     */
    @Override
    public String asString() {
        return identificator;
    }

    /**
     * Indicates this is a string-based identificator.
     * 
     * @return true
     */
    @Override
    public boolean isString() {
        return true;
    }
}
