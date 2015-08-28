package br.com.amil.dojo.repository;

import br.com.amil.dojo.model.Evento;
import br.com.amil.dojo.model.Log;

import java.util.List;

/**
 * Created by raphael on 27/08/2015.
 */
public interface EventoRepository {
        List<Evento> changeEventos(List<Log> logs);
}
