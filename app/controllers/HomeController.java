package controllers;

import com.google.inject.Inject;
import dao.HumanDAO;
import dto.DatatableDTO;
import models.Human;
import play.Logger;
import play.libs.Json;
import play.mvc.*;

import views.html.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class HomeController extends Controller {
    private static final String DATATABLE_PARAM_DRAW = "draw";
    private static final String DATATABLE_PARAM_SEARCH = "search[value]";
    private static final String DATATABLE_PARAM_DISPLAY_LENGTH = "length";
    private static final String DATATABLE_PARAM_DISPLAY_START = "start";
    private static final String DATATABLE_PARAM_SORTING_COLUMN = "order[0][column]";
    private static final String DATATABLE_PARAM_SORTING_ORDER = "order[0][dir]";

    @Inject
    HumanDAO humanDAO;

    public Result index() {
        return ok(index.render("DataTable with Play! Framework"));
    }

    public Result humanList() {
        try {
            Map<String, String[]> parameters = request().queryString();

            Long totalNumberOfHumans = humanDAO.totalRowCount();
            String searchParam = parameters.get(DATATABLE_PARAM_SEARCH)[0];
            Integer pageSize = Integer.valueOf(parameters.get(DATATABLE_PARAM_DISPLAY_LENGTH)[0]);

            Integer page = 0;
            if (pageSize != 0) {
                page = Integer.valueOf(parameters.get(DATATABLE_PARAM_DISPLAY_START)[0]) / pageSize;
            }

            String sortBy = "id";
            String order = parameters.get(DATATABLE_PARAM_SORTING_ORDER)[0];

            Integer sortingColumnId = Integer.valueOf(parameters.get(DATATABLE_PARAM_SORTING_COLUMN)[0]);

            if (sortingColumnId != null) {
                switch (sortingColumnId) {
                    case 0:
                        sortBy = "id";
                        break;
                    case 1:
                        sortBy = "firstName";
                        break;
                    case 2:
                        sortBy = "lastName";
                        break;
                    case 3:
                        sortBy = "country";
                        break;
                    case 4:
                        sortBy = "hairColor";
                        break;
                    case 5:
                        sortBy = "occupation";
                        break;
                }
            } else {
                sortBy = "id";
            }

            DatatableDTO<Human> humanDatatableDto = new DatatableDTO<>();

            List<Human> pageOfResults = new ArrayList<>();
            Integer totalFilteredResults = new Integer(0);

            if (pageOfResults != null && totalFilteredResults != null) {
                humanDatatableDto.draw = parameters.get(DATATABLE_PARAM_DRAW)[0];
                humanDatatableDto.recordsTotal = totalNumberOfHumans;
                humanDatatableDto.data = pageOfResults;
                humanDatatableDto.recordsFiltered = totalFilteredResults;

                return ok(Json.toJson(humanDatatableDto));
            } else {
                Logger.debug("[Human Datatable] An error occured while getting data from db " +
                                "with following parameters : searchParam={} sortBy={} order={} pageSize={} page={}",
                        searchParam, sortBy, order, pageSize, page);
                return badRequest();
            }
        } catch (NumberFormatException e) {
            Logger.debug("" + e.getMessage());
            return badRequest();
        }
    }
}
