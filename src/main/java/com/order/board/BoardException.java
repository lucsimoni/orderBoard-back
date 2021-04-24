package com.order.board;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BoardException extends RuntimeException {	
	
	private static final long serialVersionUID = 7221378573797080804L;
	
	private static final String SEPARATOR = "_";
	
	// ---------- Erreur Test
	private static final String ERROR_TEST = "00" + SEPARATOR;
	private static final String TEST_A = "01";
		
    public BoardException() {
        super();
    }
    public BoardException(String message, Throwable cause) {
        super(message, cause);
    }
    public BoardException(String message) {
        super(message);
    }
    public BoardException(Throwable cause) {
        super(cause);
    }
	
	// 00_01
	public String getErrorTest() {
		return ERROR_TEST + TEST_A;
	}

	
}
