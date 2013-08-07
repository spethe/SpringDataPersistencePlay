package controllers;

import actions.BasicAuthAction;
import actions.BasicAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import play.*;
import play.db.jpa.Transactional;
import play.mvc.*;

import play.mvc.Controller;
import views.html.*;

import static play.data.Form.form;
import models.User;
import views.html.index;

import javax.inject.Inject;


@BasicAuth
@org.springframework.stereotype.Controller

public class Application extends Controller {

    @Inject
    static BasicAuthAction basicAuthAction;

    @Inject
    static Http.Context context;


    public void setBasicAuthAction(BasicAuthAction basicAuthAction) {
        this.basicAuthAction = basicAuthAction;
    }

    public void setContext(Http.Context context) {
        this.context = context;
    }

    public static Result index() {
        return ok(index.render("Your new application is ready..."));
    }

    public static Result sayHello(){
        System.out.println("In Say Hello...");
        return ok(index.render("Hello,World"));
    }

    public static Result authenticate() throws Throwable {
        if(context == null){
            context = Http.Context.current();
        }
       return basicAuthAction.call(context);
    }

}
