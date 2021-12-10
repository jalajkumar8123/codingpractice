package com.tyss.esslite.exception;

public class FileStorageException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8874686406700992344L;

	public FileStorageException(String message) {
        super(message);
    }

    public FileStorageException(String message, Throwable cause) {
        super(message, cause);
    }
}
