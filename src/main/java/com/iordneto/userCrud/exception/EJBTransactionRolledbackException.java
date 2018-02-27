package com.iordneto.userCrud.exception;

public class EJBTransactionRolledbackException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6328286661536343936L;

	
	public EJBTransactionRolledbackException(String message) {
		super(message);
	}
	
}
