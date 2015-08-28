package br.com.amil.dojo.repository.impl;

/**
 * Created by raphael on 27/08/2015.
 */

import br.com.amil.dojo.model.Log;
import br.com.amil.dojo.repository.LogRepository;
import br.com.amil.dojo.utils.Constants;
import br.com.amil.dojo.utils.FileUtils;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Repository
public class LogRepositoryImpl implements LogRepository {

	@Override
	public List<Log> getLogs(InputStream stream) throws Exception {
		List<String> linhas = LogRepositoryImpl.getStringListFromInputStream(stream);
		List<Log> logs = new ArrayList<Log>();

		if (linhas != null && !linhas.isEmpty()) {
			for (String linha : linhas) {
				if (validarLinha(linha)) {
					Log log = new Log();
					log.setDataLog(this.getDate(linha));
					log.setMensagem(this.getMensagem(linha));
					logs.add(log);
				}
			}
		}
		return logs;
	}

	boolean validarLinha(String linha) {
		Pattern r = Pattern.compile(Constants.REGEX_DATE_LOG);
		return r.matcher(linha).matches();
	}

	private Date getDate(String linha) throws ParseException {

		Date date = null;
		Pattern r = Pattern.compile(Constants.REGEX_DATE_LOG);
		

		Matcher m = r.matcher(linha);
		m.find();
		
		if (!StringUtils.isEmpty(m.group(1))) {
			DateFormat dateFormat = new SimpleDateFormat();
			date = dateFormat.parse(m.group(1));
		}
		return date;
	}

	private String getMensagem(String linha) {
		String mensage = "";
		Pattern r = Pattern.compile(Constants.REGEX_DATE_LOG);
		Matcher m = r.matcher(linha);
		m.find();

		if (!StringUtils.isEmpty(m.group(6))) {
			mensage = m.group(6);
		}
		return mensage;
	}

	// convert InputStream to String
	private static List<String> getStringListFromInputStream(InputStream is) {

		BufferedReader br = null;
		List<String> lines = new ArrayList<>();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return lines;

	}
}
