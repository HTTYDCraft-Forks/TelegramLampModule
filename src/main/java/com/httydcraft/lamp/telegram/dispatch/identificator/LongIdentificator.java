package com.httydcraft.lamp.telegram.dispatch.identificator;

/**
 * Implementation of Identificator that represents a long-based identifier.
 * Used for numeric identifiers like chat IDs and user IDs in Telegram.
 * 
 * @see Identificator
 */
public class LongIdentificator implements Identificator {
    /**
     * The underlying long value
     */
    private final long identificator;

    /**
     * Creates a new long-based identificator.
     * 
     * @param identificator the long value
     */
    public LongIdentificator(long identificator) {
        this.identificator = identificator;
    }

    /**
     * Gets the identificator value as a long.
     * 
     * @return the long value
     */
    @Override
    public long asLong() {
        return identificator;
    }

    /**
     * Indicates this is a long-based identificator.
     * 
     * @return true
     */
    @Override
    public boolean isLong() {
        return true;
    }
}
