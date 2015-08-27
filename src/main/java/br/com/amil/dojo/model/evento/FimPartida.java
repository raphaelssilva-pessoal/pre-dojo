package br.com.amil.dojo.model.evento;

import br.com.amil.dojo.model.Evento;

public class FimPartida extends Evento{
	String numeroPartida;

	@Override
	public TypeEvento geType() {
		return TypeEvento.INICIOPARTIDA;
	}
}
