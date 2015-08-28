package br.com.amil.dojo.service;

import br.com.amil.dojo.model.Evento;
import br.com.amil.dojo.model.Log;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * Created by raphael on 27/08/2015.
 */
public interface EventoServico {
    List<Evento> changeEventos(InputStream stream) throws Exception;
}
