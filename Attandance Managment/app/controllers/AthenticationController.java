package controllers;

import models.LoginValidation;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.Homepage;
import views.html.login;
import views.html.main;


import javax.inject.Inject;

public class AthenticationController extends Controller {


    private FormFactory formFactory;


    @Inject
    public AthenticationController(FormFactory formFactory){
        this.formFactory=formFactory;

    }

    @Transactional
    public Result login() {
        Form<LoginValidation> userForm = formFactory.form(LoginValidation.class).bindFromRequest();
        if (userForm.hasErrors()) {
            flash().put("error","invalid credintials");
            return badRequest(main.render("Home",login.apply(userForm)));
        }
        else {

               return badRequest(main.render("Home",login.apply(userForm)));

        }

    }

    public Result home(){
        Form<LoginValidation> userForm = formFactory.form(LoginValidation.class).bindFromRequest();
        String user = session("connected");
        if(user != null) {
            return ok(Homepage.render());
        } else {
            return badRequest(main.render("Home",login.apply(userForm)));
        }

    }

    public Result Logout() {
        session().clear();
        return redirect("/login");
    }


}
