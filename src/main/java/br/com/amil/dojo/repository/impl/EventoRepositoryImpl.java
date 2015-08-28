package br.com.amil.dojo.repository.impl;

import br.com.amil.dojo.model.Evento;
import br.com.amil.dojo.model.Log;
import br.com.amil.dojo.model.evento.EventoFactory;
import br.com.amil.dojo.repository.EventoRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raphael on 27/08/2015.
 */
public class EventoRepositoryImpl implements EventoRepository {
    @Override
    public List<Evento> changeEventos(List<Log> logs) {
        List<Evento> eventos = new ArrayList<Evento>();

        for (Log log:logs){
            Evento evento = EventoFactory.factory(log);
            if(evento!=null){
                eventos.add(evento);
            }
        }
        return eventos;
    }
}
