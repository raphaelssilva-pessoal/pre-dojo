package br.com.amil.dojo.model.evento;

import br.com.amil.dojo.model.Evento;
import br.com.amil.dojo.model.Log;
import br.com.amil.dojo.model.TypeEvento;
import br.com.amil.dojo.model.TypeEvento.*;
/**
 * Created by raphael on 27/08/2015.
 */
public class EventoFactory {
    public static Evento factory(TypeEvento typeEvento){
        Evento evento = null;
        switch (typeEvento){
            case INICIOPARTIDA:
                evento = new InicioPartida();
                break;
            case ASSASSINATO:
                evento = new Assassinato();
                break;
            case FIMPARTIDA:
                evento = new FimPartida();
                break;
        }
        return evento;
    }


    public static Evento factory(Log log){
        Evento evento = null;
        for (TypeEvento typeEvento:TypeEvento.values()){
            Evento evento1 = EventoFactory.factory(typeEvento);
            if(evento1.applies(log)){
                evento1.change(log);
                evento = evento1;
                break;
            }
        }
        return evento;
    }
}
