package br.com.amil.dojo.model.evento;

import br.com.amil.dojo.model.Evento;
import br.com.amil.dojo.model.Log;
import br.com.amil.dojo.model.TypeEvento;
import br.com.amil.dojo.utils.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Assassinato extends Evento{

	String assassino;
	String assassinado;
	String arma;
	String outraForma;

	public String getAssassino() {
		return assassino;
	}

	public void setAssassino(String assassino) {
		this.assassino = assassino;
	}

	public String getAssassinado() {
		return assassinado;
	}

	public void setAssassinado(String assassinado) {
		this.assassinado = assassinado;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getOutraForma() {
		return outraForma;
	}

	public void setOutraForma(String outraForma) {
		this.outraForma = outraForma;
	}

	@Override
	public TypeEvento geType() {
		return TypeEvento.ASSASSINATO;
	}

	@Override
	public void change(Log log) {
		Pattern r = Pattern.compile(Constants.REGEX_EVENTO_ASSASSINATO);
		Matcher m = r.matcher(log.getMensagem());

		this.setDataEvento(log.getDataLog());
		this.setAssassino(m.group(0));
		this.setAssassinado(m.group(1));
		if(m.group(2).equals("using")){
			this.setArma(m.group(2));
		}
		if(m.group(2).equals("by")){
			this.setOutraForma(m.group(2));
		}
	}

	@Override
	public boolean applies(Log log) {
		Pattern r = Pattern.compile(Constants.REGEX_EVENTO_ASSASSINATO);
		Matcher m = r.matcher(log.getMensagem());
		return m.matches();
	}
}
