package controllers;

import play.mvc.*;

import views.html.*;


public class HomeController extends Controller {
    public Result index() {
        return ok(index.render("DataTable with Play! Framework"));
    }

    public Result humanList() {
        return ok();
    }

}
