package br.com.amil.dojo.model.evento;

import br.com.amil.dojo.model.Evento;
import br.com.amil.dojo.model.Log;
import br.com.amil.dojo.model.TypeEvento;
import br.com.amil.dojo.utils.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FimPartida extends Evento{

	@Override
	public TypeEvento geType() {
		return TypeEvento.FIMPARTIDA;
	}

	@Override
	public void change(Log log) {
		Pattern r = Pattern.compile(Constants.REGEX_EVENTO_FIM_PARTIDA);
		Matcher m = r.matcher(log.getMensagem());
		this.setDataEvento(log.getDataLog());
		this.setNumeroPartida(m.group(0));
	}

	@Override
	public boolean applies(Log log) {
		Pattern r = Pattern.compile(Constants.REGEX_EVENTO_FIM_PARTIDA);
		Matcher m = r.matcher(log.getMensagem());
		return m.matches();
	}
}
