package controllers;

import play.mvc.*;

import views.html.*;


public class HomeController extends Controller {
    private static final String DATATABLE_PARAM_DRAW = "draw";
    private static final String DATATABLE_PARAM_SEARCH = "search[value]";
    private static final String DATATABLE_PARAM_DISPLAY_LENGTH = "length";
    private static final String DATATABLE_PARAM_DISPLAY_START = "start";
    private static final String DATATABLE_PARAM_SORTING_COLUMN = "order[0][column]";
    private static final String DATATABLE_PARAM_SORTING_ORDER = "order[0][dir]";

    public Result index() {
        return ok(index.render("DataTable with Play! Framework"));
    }

    public Result humanList() {
        return ok();
    }

}
