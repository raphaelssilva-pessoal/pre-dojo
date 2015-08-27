package br.com.amil.dojo.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	public static List<String> readFile(File file) throws Exception{
		List<String> lines = new ArrayList<String>();
		FileUtils.readFile(file, lines);		
		return lines;
	}
	
	public static void readFile(File file, List<String> lines) throws Exception{
		if (file != null && file.exists()) {
			try {
				lines.addAll(Files.readAllLines(file.toPath(), Charset.defaultCharset()));
			} catch (IOException ex) {
				throw new Exception("Não foi possivel ler o arquivo.", ex);
			}
		} else {
			throw new Exception("Arquivo informado não existe.");
		}
	}
}
