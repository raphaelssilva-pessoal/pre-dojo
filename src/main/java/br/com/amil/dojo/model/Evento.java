package br.com.amil.dojo.model;

import java.util.Date;

public abstract class Evento {
	Date dataEvento;
	String numeroPartida;

	public Date getDataEvento() {
		return dataEvento;
	}

	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}

	public String getNumeroPartida() {
		return numeroPartida;
	}

	public void setNumeroPartida(String numeroPartida) {
		this.numeroPartida = numeroPartida;
	}

	public abstract TypeEvento geType();
	public abstract void change(Log log);
	public abstract boolean applies(Log log);
}
