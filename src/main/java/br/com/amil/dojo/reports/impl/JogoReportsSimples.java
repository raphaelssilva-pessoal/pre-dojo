package br.com.amil.dojo.reports.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.amil.dojo.model.Partida;
import br.com.amil.dojo.model.UsuarioPartida;
import br.com.amil.dojo.reports.JogoReports;
import br.com.amil.dojo.reports.RankingJogadorPartida;
import br.com.amil.dojo.reports.RankingPartida;

@Component
public class JogoReportsSimples implements JogoReports{

	public List<RankingPartida> gerar(List<Partida> partidas){
		List<RankingPartida> list = new ArrayList<RankingPartida>();
		
		for(Partida partida:partidas){
			RankingPartida rankingPartida = new RankingPartida();
			rankingPartida.setNumeroPartida(partida.getNumeroPartida());
			rankingPartida.setJogadores(new ArrayList<RankingJogadorPartida>());
			for(UsuarioPartida  usuarioPartida: partida.getUsuarios()){
				
				RankingJogadorPartida jogadorPartida = new RankingJogadorPartida();
				jogadorPartida.setCodigoJogador(usuarioPartida.getIdentificador());
				
				jogadorPartida.setAssassino(usuarioPartida.getAssassinatoComoAssassino().size());	
				jogadorPartida.setAssassinado(usuarioPartida.getAssassinatoComoAssassinado().size());
				
				rankingPartida.getJogadores().add(jogadorPartida);
			}
			
			list.add(rankingPartida);
		}
		
		return list;
	}
	
	
	
	
}


