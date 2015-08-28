package br.com.amil.dojo.model;

import br.com.amil.dojo.model.evento.Assassinato;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raphael on 27/08/2015.
 */
public class UsuarioPartida {
    String identificador;
    List<Assassinato> morreu = new ArrayList<Assassinato>();
    List<Assassinato> matou = new ArrayList<Assassinato>();

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public List<Assassinato> getMorreu() {
        return morreu;
    }

    public void setMorreu(List<Assassinato> morreu) {
        this.morreu = morreu;
    }

    public List<Assassinato> getMatou() {
        return matou;
    }

    public void setMatou(List<Assassinato> matou) {
        this.matou = matou;
    }
}
