package com.wallmart.exceptions;

public class WallmartProductsException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 0;

    /**
     *
     * @param message
     */
    public WallmartProductsException(String message) {
        super(message);
    }

    /**
     *
     * @param message
     * @param throwable
     */
    public WallmartProductsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}

