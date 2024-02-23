package com.myapp.exception;

public class DepartmentNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public DepartmentNotFoundException() {

	}

	public DepartmentNotFoundException(String message) {
		super(message);
	}

	public DepartmentNotFoundException(Throwable cause) {
		super(cause);
	}

	public DepartmentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	protected DepartmentNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

	@Override
	public synchronized Throwable getCause() {
		return super.getCause();
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
	}

	@Override
	public synchronized Throwable initCause(Throwable cause) {
		return super.initCause(cause);
	}

}
