package controllers;

import models.LoginValidation;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;
import views.html.*;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class HomeController extends Controller {


   private  FormFactory formFactory;


    @Inject
    public HomeController(FormFactory formFactory ){
        this.formFactory=formFactory;

    }


    public Result index() {
        return ok(main.render("Home",welcome.apply()));
    }


    public Result login() {
        String user = session("connected");
        if(user!=null) {
            return redirect("/home");
        } else {
            Form<LoginValidation> userForm = formFactory.form(LoginValidation.class);
            return ok(main.render("Home",login.apply(userForm)));
        }
    }
    
}
