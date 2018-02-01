package dao;

import models.Human;
import play.Logger;

import java.util.List;

/**
 * Created by Lucas Declercq on 2/1/18
 */
public class HumanDAOImp implements HumanDAO{
    public void test() {
        Logger.debug("testing dao injection");
    }

    public Long totalRowCount() {
        return null;
    }

    public List<Human> getDatablepage(String searchParam, String sortBy, String order, Integer pageSize, Integer page) {
        return null;
    }

    public Long getDatatableResultsCount() {
        return null;
    }
}
