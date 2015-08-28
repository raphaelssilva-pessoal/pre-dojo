package br.com.amil.dojo.reports;

import java.util.List;

import br.com.amil.dojo.model.Partida;

public interface JogoReports {
	public List<RankingPartida> gerar(List<Partida> partidas);
}
