package ifpr.pgua.eic.tads.contatos;

import ifpr.pgua.eic.tads.contatos.controllers.AddController;
import ifpr.pgua.eic.tads.contatos.controllers.AddTarefaController;
import ifpr.pgua.eic.tads.contatos.controllers.IndexController;
import ifpr.pgua.eic.tads.contatos.controllers.ListController;
import ifpr.pgua.eic.tads.contatos.controllers.ListTarefaController;
import ifpr.pgua.eic.tads.contatos.model.Agenda;
import ifpr.pgua.eic.tads.contatos.utils.JavalinUtils;
import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Javalin app = JavalinUtils.makeApp(8080);
        
        Agenda agenda = new Agenda();
        IndexController indexController = new IndexController();
        AddController addController = new AddController(agenda);
        ListController listController = new ListController(agenda);
        AddTarefaController addTarefaController = new AddTarefaController(agenda);
        ListTarefaController listTarefaController = new ListTarefaController(agenda);

        app.get("/",indexController.get);
        app.get("/add",addController.get);
        app.post("/add",addController.post);
        app.get("/list",listController.get);
        app.get("/addTarefa",addTarefaController.get);
        app.post("/addTarefa",addTarefaController.post);
        app.get("/listTarefas",addTarefaController.get);
    }
}
