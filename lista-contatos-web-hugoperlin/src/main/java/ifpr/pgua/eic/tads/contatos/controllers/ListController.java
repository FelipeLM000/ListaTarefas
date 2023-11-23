package ifpr.pgua.eic.tads.contatos.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ifpr.pgua.eic.tads.contatos.model.Agenda;
import ifpr.pgua.eic.tads.contatos.model.Contato;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ListController {
    
    private Agenda agenda;

    public ListController(Agenda agenda){
        this.agenda = agenda;
    }

    public Handler get = (Context ctx)->{
        
        ArrayList<Contato> lista = agenda.getLista();
        
        String html="<html><head><meta charset=\"UTF-8\"></head><body><h1>Lista de Contatos</h1><ul>";

        for(Contato c:lista){
            html+="<li>"+c.toString()+"</li>";
        }
        
        html+="</ul><a href=\"/\">Voltar</a></body></html>";
        ctx.html(html);
    };


}
