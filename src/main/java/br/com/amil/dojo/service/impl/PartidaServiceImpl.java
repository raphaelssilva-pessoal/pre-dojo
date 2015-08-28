package br.com.amil.dojo.service.impl;

import br.com.amil.dojo.model.Evento;
import br.com.amil.dojo.model.Partida;
import br.com.amil.dojo.model.TypeEvento;
import br.com.amil.dojo.model.UsuarioPartida;
import br.com.amil.dojo.model.evento.Assassinato;
import br.com.amil.dojo.model.evento.FimPartida;
import br.com.amil.dojo.model.evento.InicioPartida;
import br.com.amil.dojo.service.PartidaService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by raphael on 28/08/15.
 */
@Service
public class PartidaServiceImpl implements PartidaService {

    @Override
    public List<Partida> analisarEventos(List<Evento> eventos) {
        List<Partida> partidas = new ArrayList<Partida>();
        ordenarEventosPorData(eventos);

        Partida partida = null;

        for(Evento evento:eventos){
            if(evento.geType().equals(TypeEvento.INICIOPARTIDA)){
                InicioPartida inicioPartida = (InicioPartida) evento;
                partida = new Partida();
                partida.setInicio(inicioPartida.getDataEvento());
                partida.setNumeroPartida(inicioPartida.getNumeroPartida());
            }else if(evento.geType().equals(TypeEvento.FIMPARTIDA)){
                FimPartida fimPartida = (FimPartida) evento;
                if(partida!=null){
                    partida.setFim(fimPartida.getDataEvento());
                    partidas.add(partida);
                    partida = null;
                }
            }else if(evento.geType().equals(TypeEvento.ASSASSINATO)) {
                Assassinato assassinato = (Assassinato) evento;
                if(partida!=null) {
                    if (validarAssassinato(assassinato)) {
                        if (validarAssassino(assassinato)) {
                            this.setUsuario(partida, assassinato.getAssassino(), assassinato);
                        }

                        if (validarAssassinado(assassinato)) {
                            this.setUsuario(partida, assassinato.getAssassinado(), assassinato);
                        }
                    }
                }
            }
        }

        return partidas;
    }

    private boolean validarAssassinato(Assassinato assassinato){
        return !assassinato.getAssassinado().equals("<WORLD>");
    }

    private boolean validarAssassino(Assassinato assassinato){
        return !assassinato.getAssassino().equals("<WORLD>");
    }

    private boolean validarAssassinado(Assassinato assassinato){
        return !assassinato.getAssassinado().equals("<WORLD>");
    }

    private void setUsuario(Partida partida, String codigoUsuario, Assassinato assassinato){
        UsuarioPartida usuarioPartida = this.getUsuario(partida, codigoUsuario);

        if(usuarioPartida==null){
            usuarioPartida = new UsuarioPartida();
            usuarioPartida.setIdentificador(codigoUsuario);
            partida.getUsuarios().add(usuarioPartida);
        }

        usuarioPartida.getAssassinatosEnvolvido().add(assassinato);
    }

    private UsuarioPartida getUsuario(Partida partida, String codigoUsuario){
        UsuarioPartida up = null;
        for(UsuarioPartida usuarioPartida:partida.getUsuarios()){
            if(usuarioPartida.getIdentificador().equals(codigoUsuario)){
                up = usuarioPartida;
                break;
            }
        }
        return up;
    }


    void ordenarEventosPorData(List<Evento> eventos){
        Collections.sort(eventos, new Comparator<Evento>() {
            @Override
            public int compare(Evento evento, Evento evento2) {
                return evento.getDataEvento().compareTo(evento2.getDataEvento());
            }
        });
    }
}
