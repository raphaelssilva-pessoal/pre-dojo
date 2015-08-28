package br.com.amil.dojo.reports;

import java.util.List;

public class RankingPartida {
	String numeroPartida;
	List<RankingJogadorPartida> jogadores;

	public String getNumeroPartida() {
		return numeroPartida;
	}

	public void setNumeroPartida(String numeroPartida) {
		this.numeroPartida = numeroPartida;
	}

	public List<RankingJogadorPartida> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<RankingJogadorPartida> jogadores) {
		this.jogadores = jogadores;
	}

}
