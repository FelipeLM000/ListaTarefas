package ifpr.pgua.eic.tads.contatos.controllers;

import ifpr.pgua.eic.tads.contatos.model.Agenda;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class AddController {
    
    private Agenda agenda;

    public AddController(Agenda agenda){
        this.agenda = agenda;
    }

    public Handler get = (Context ctx)->{
        ctx.render("templates/add.html");
    };

    public Handler post = (Context ctx)->{
        String nome = ctx.formParam("nome");
        String email = ctx.formParam("email");
        String telefone = ctx.formParam("telefone");

        String resultado = agenda.cadastrar(nome, email, telefone);
        System.out.println(agenda.listar());
        ctx.html(resultado+"<br/><a href=\"/\">Voltar</a>");
    };
}
