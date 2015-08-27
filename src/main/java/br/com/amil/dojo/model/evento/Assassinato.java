package br.com.amil.dojo.model.evento;

import br.com.amil.dojo.model.Evento;

public class Assassinato extends Evento{

	String assassino;
	String assassinado;
	String arma;
	String outraForma;
	
	@Override
	public TypeEvento geType() {
		return TypeEvento.ASSASSINATO;
	}
}
