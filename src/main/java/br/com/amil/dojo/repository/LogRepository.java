package br.com.amil.dojo.repository;

import java.io.File;
import java.util.List;

import br.com.amil.dojo.model.Log;

public interface LogRepository {
	List<Log> getLogs(File file) throws Exception;
}
