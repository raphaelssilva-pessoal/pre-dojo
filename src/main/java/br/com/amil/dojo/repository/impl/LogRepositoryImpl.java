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

import java.io.File;
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
    public List<Log> getLogs(File file) throws Exception {
        List<String> linhas = FileUtils.readFile(file);
        List<Log> logs = new ArrayList<Log>();

        if (linhas != null && !linhas.isEmpty()) {
            for (String linha : linhas) {
                Log log = new Log();
                log.setDataLog(this.getDate(linha));
                log.setMensagem(this.getMensagem(linha));
                logs.add(log);
            }
        }
        return logs;
    }

    private Date getDate(String linha) throws ParseException {

        Date date = null;
        Pattern r = Pattern.compile(Constants.REGEX_DATE_LOG);

        Matcher m = r.matcher(linha);

        if (!StringUtils.isEmpty(m.group(0))) {
            DateFormat dateFormat = new SimpleDateFormat();
            date = dateFormat.parse(m.group(0));
        }
        return date;
    }

    private String getMensagem(String linha) {
        String mensage = "";
        Pattern r = Pattern.compile(Constants.REGEX_DATE_LOG);
        Matcher m = r.matcher(linha);

        if (!StringUtils.isEmpty(m.group(1))) {
            mensage = m.group(1);
        }
        return mensage;
    }
}
