package br.com.amil.dojo.model;

import br.com.amil.dojo.model.evento.Assassinato;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raphael on 27/08/2015.
 */
public class UsuarioPartida {
    String identificador;
    List<Assassinato> assassinatosEnvolvido = new ArrayList<Assassinato>();

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setAssassinatosEnvolvido(List<Assassinato> assassinatosEnvolvido) {
        this.assassinatosEnvolvido = assassinatosEnvolvido;
    }

    public List<Assassinato> getAssassinatosEnvolvido() {
        return assassinatosEnvolvido;
    }

    public  List<Assassinato> getAssassinatoComoAssassino(){
        List<Assassinato> assassinatosAssassino = new ArrayList<>();
        for (Assassinato assassinato:this.getAssassinatosEnvolvido()){
            if(assassinato.getAssassino().equals(this.getIdentificador())){
                assassinatosAssassino.add(assassinato);
            }
        }
        return assassinatosAssassino;
    }

    public  List<Assassinato> getAssassinatoComoAssassinado(){
        List<Assassinato> assassinatosAssassinado = new ArrayList<>();
        for (Assassinato assassinato:this.getAssassinatosEnvolvido()){
            if(assassinato.getAssassinado().equals(this.getIdentificador())){
                assassinatosAssassinado.add(assassinato);
            }
        }
        return assassinatosAssassinado;
    }
}
