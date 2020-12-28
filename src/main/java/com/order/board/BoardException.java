package com.order.board;

import org.primefaces.json.JSONObject;

public class BoardException extends Exception {	
	
	private static final long serialVersionUID = 7221378573797080804L;
	
	private static final String SEPARATOR = ":";
	
	// ---------- Erreur Test
	private static final String ERROR_TEST = "00" + SEPARATOR;
	private static final String TEST_A = "01";
	
	private final String errorCode;
	
	public BoardException() {
		super();
		this.errorCode = "";
	}

	public BoardException(final String code) {
		super(code);
		this.errorCode = code;
	}
	
	// 00:01
	public String getErrorTest() {
		return ERROR_TEST + TEST_A;
	}
	
	public String getBoardException() {
		final JSONObject jsonException = new JSONObject();
		jsonException.put("errorCode", this.errorCode);
		return jsonException.toString();
	}
}
