package br.com.amil.dojo.model;

import java.util.Date;

import br.com.amil.dojo.model.evento.TypeEvento;

public abstract class Evento {
	Date dataEvento;
	
	public abstract TypeEvento geType();	
}
