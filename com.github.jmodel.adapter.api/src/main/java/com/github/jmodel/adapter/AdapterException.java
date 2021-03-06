package com.github.jmodel.adapter;

/**
 * 
 * Adapter exception.
 * 
 * @author jianni@hotmail.com
 *
 */
public final class AdapterException extends Exception {

	private static final long serialVersionUID = 5049750180833027559L;

	/**
	 * Constructs an {@code AdapterException} with {@code null} as its error detail
	 * message.
	 */
	public AdapterException() {
		super();
	}

	/**
	 * Constructs an {@code AdapterException} with the specified detail message.
	 *
	 * @param message
	 *            The detail message (which is saved for later retrieval by the
	 *            {@link #getMessage()} method)
	 */
	public AdapterException(String message) {
		super(message);
	}

	/**
	 * Constructs an {@code AdapterException} with the specified detail message and
	 * cause.
	 *
	 * <p>
	 * Note that the detail message associated with {@code cause} is <i>not</i>
	 * automatically incorporated into this exception's detail message.
	 *
	 * @param message
	 *            The detail message (which is saved for later retrieval by the
	 *            {@link #getMessage()} method)
	 *
	 * @param cause
	 *            The cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A null value is permitted, and
	 *            indicates that the cause is nonexistent or unknown.)
	 *
	 */
	public AdapterException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructs an {@code AdapterException} with the specified cause and a detail
	 * message of {@code (cause==null ? null : cause.toString())} (which typically
	 * contains the class and detail message of {@code cause}). This constructor is
	 * useful for Model exceptions that are little more than wrappers for other
	 * throwables.
	 *
	 * @param cause
	 *            The cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A null value is permitted, and
	 *            indicates that the cause is nonexistent or unknown.)
	 *
	 */
	public AdapterException(Throwable cause) {
		super(cause);
	}
}
