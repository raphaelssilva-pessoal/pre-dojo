package br.com.amil.dojo.service.impl;

import br.com.amil.dojo.model.Evento;
import br.com.amil.dojo.model.Log;
import br.com.amil.dojo.model.evento.EventoFactory;
import br.com.amil.dojo.repository.LogRepository;
import br.com.amil.dojo.service.EventoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by raphael on 27/08/2015.
 */
@Service
public class EventoServicoImpl implements EventoServico {

    @Autowired
    private LogRepository logRepository;

    @Override
    public List<Evento> changeEventos(InputStream stream) throws Exception {
        List<Evento> eventos = new ArrayList<Evento>();

        List<Log> logs = logRepository.getLogs(stream);

        for (Log log:logs){
            Evento evento = EventoFactory.factory(log);
            if(evento!=null){
                eventos.add(evento);
            }
        }
        return eventos;
    }
}
