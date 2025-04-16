package com.httydcraft.lamp.telegram.core;

import static revxrsal.commands.util.Preconditions.notNull;

import java.io.Serializable;
import java.util.function.Supplier;

// legally stolen from guava
/**
 * A thread-safe supplier that memoizes (caches) the result of its first call and returns that
 * value on subsequent calls. Inspired by Guava's memoizing supplier implementation.
 * 
 * @param <T> the type of results supplied by this supplier
 */
final class MemoizingSupplier<T> implements Supplier<T>, Serializable {

    /**
     * The delegate supplier that provides the actual value
     */
    final Supplier<T> delegate;
    
    /**
     * Volatile flag indicating whether the value has been initialized
     */
    transient volatile boolean initialized;
    
    /**
     * The memoized value (visibility ensured via the initialized flag)
     */
    transient T value;

    /**
     * Creates a new memoizing supplier that delegates to the given supplier.
     * 
     * @param delegate the delegate supplier to get the value from
     * @throws NullPointerException if delegate is null
     */
    MemoizingSupplier(Supplier<T> delegate) {
        this.delegate = notNull(delegate, "delegate");
    }

    /**
     * Gets the memoized value. On first call, delegates to the underlying supplier
     * and caches the result. Subsequent calls return the cached value.
     * 
     * @return the supplied value
     */
    @Override
    public T get() {
        // A 2-field variant of Double Checked Locking.
        if (!initialized) {
            synchronized (this) {
                if (!initialized) {
                    T t = delegate.get();
                    value = t;
                    initialized = true;
                    return t;
                }
            }
        }
        return value;
    }

    @Override
    public String toString() {
        return "Suppliers.memoize(" + delegate + ")";
    }

    private static final long serialVersionUID = 0;

    /**
     * Creates a new memoizing supplier that caches the result of the given supplier.
     * 
     * @param <T> the type of results supplied
     * @param supplier the delegate supplier
     * @return a new memoizing supplier
     * @throws NullPointerException if supplier is null
     */
    public static <T> Supplier<T> memoize(Supplier<T> supplier) {
        return new MemoizingSupplier<>(supplier);
    }
}