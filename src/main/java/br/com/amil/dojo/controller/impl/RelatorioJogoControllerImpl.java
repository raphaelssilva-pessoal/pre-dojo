package br.com.amil.dojo.controller.impl;

import br.com.amil.dojo.controller.RelatorioJogoController;
import br.com.amil.dojo.model.Evento;
import br.com.amil.dojo.model.Log;
import br.com.amil.dojo.model.Partida;
import br.com.amil.dojo.reports.JogoReports;
import br.com.amil.dojo.repository.LogRepository;
import br.com.amil.dojo.service.EventoServico;
import br.com.amil.dojo.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by raphael on 28/08/15.
 */
@RestController
public class RelatorioJogoControllerImpl implements RelatorioJogoController {

    @Autowired
    EventoServico eventoServico;

    @Autowired
    PartidaService partidaService;
    
    @Autowired
    JogoReports jogoReports;
    
    public void setEventoServico(EventoServico eventoServico) {
        this.eventoServico = eventoServico;
    }

    public void setPartidaService(PartidaService partidaService) {
        this.partidaService = partidaService;
    }
    
    public void setJogoReports(JogoReports jogoReports) {
		this.jogoReports = jogoReports;
	}

    @Override
    @RequestMapping("/jogo/reports")
    public Object gerarRelatorio() {
        InputStream inputStream = getInputStream();
        List<Evento> eventos = new ArrayList<>();
        List<Partida> partidas = new ArrayList<>();
        try {
        	if (inputStream != null) {
                eventos.addAll(eventoServico.changeEventos(inputStream));
                if(!eventos.isEmpty()){
                    partidas.addAll(partidaService.analisarEventos(eventos));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jogoReports.gerar(partidas);
    }

    private InputStream getInputStream() {
        InputStream inputStream;
        String texto = "23/04/2013 15:34:22 - New match 11348965 has started\n" +
                "23/04/2013 15:36:04 - Roman killed Nick using M16\n" +
                "23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN\n" +
                "23/04/2013 15:39:22 - Match 11348965 has ended";

        inputStream = new ByteArrayInputStream(texto.getBytes());

        return inputStream;

    }
}
