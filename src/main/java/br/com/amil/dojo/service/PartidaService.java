package br.com.amil.dojo.service;

import br.com.amil.dojo.model.Evento;
import br.com.amil.dojo.model.Partida;

import java.util.List;

/**
 * Created by raphael on 28/08/15.
 */
public interface PartidaService {

    List<Partida> analisarEventos(List<Evento> eventos);

}
