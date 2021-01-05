package com.order.board;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Utils {

	/**
	 * Méthode de lecture de fichiers
	 */
	public static String readFile(final String name) {
		String content ="";
		try {
			content = new String(Files.readAllBytes(Paths.get(name)));
		} catch (final IOException e) {
			e.printStackTrace();
		}
		return content;
	}
	
}
