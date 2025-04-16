package com.httydcraft.lamp.telegram.dispatch.identificator;

/**
 * Represents a polymorphic identifier that can be either a Long or String value.
 * Provides conversion methods between different representations and factory methods
 * for creating appropriate implementations.
 * 
 * @see LongIdentificator
 * @see StringIdentificator
 */
public interface Identificator {
    /**
     * Checks if this identificator represents a string value.
     * 
     * @return true if this is a string identificator
     */
    default boolean isString() {
        return false;
    }

    /**
     * Checks if this identificator represents a long value.
     * 
     * @return true if this is a long identificator
     */
    default boolean isLong() {
        return false;
    }

    /**
     * Gets the identificator value as a long.
     * 
     * @return the long value
     * @throws UnsupportedOperationException if this is not a long identificator
     */
    default long asLong() {
        throw new UnsupportedOperationException("Cannot represent identificator as long");
    }

    /**
     * Gets the identificator value as a string.
     * 
     * @return the string value
     * @throws UnsupportedOperationException if this is not a string identificator
     */
    default String asString() {
        throw new UnsupportedOperationException("Cannot represent identificator as string");
    }

    /**
     * Gets the identificator value as an Object (either Long or String).
     * 
     * @return the value as Object, or null if not a supported type
     */
    default Object asObject() {
        if (isLong())
            return asLong();
        if (isString())
            return asString();
        return null;
    }

    /**
     * Creates an Identificator from an Object (Long, Integer or String).
     * 
     * @param object the object to convert
     * @return an appropriate Identificator implementation, or null if unsupported type
     */
    static Identificator fromObject(Object object) {
        if (object instanceof Long)
            return new LongIdentificator((Long) object);
        if (object instanceof Integer)
            return new LongIdentificator((Integer) object);
        if (object instanceof String)
            return new StringIdentificator((String) object);
        return null;
    }

    /**
     * Creates a long-based identificator.
     * 
     * @param id the long value
     * @return a LongIdentificator instance
     */
    static Identificator of(long id) {
        return new LongIdentificator(id);
    }

    /**
     * Creates a string-based identificator.
     * 
     * @param id the string value
     * @return a StringIdentificator instance
     */
    static Identificator of(String id) {
        return new StringIdentificator(id);
    }
}
