package br.com.amil.dojo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Partida {
    String numeroPartida;
    List<UsuarioPartida> usuarios = new ArrayList<UsuarioPartida>();
    Date inicio;
    Date fim;

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public String getNumeroPartida() {
        return numeroPartida;
    }

    public void setNumeroPartida(String numeroPartida) {
        this.numeroPartida = numeroPartida;
    }

    public List<UsuarioPartida> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioPartida> usuarios) {
        this.usuarios = usuarios;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }
}
