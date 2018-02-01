package dao;

import com.google.inject.ImplementedBy;
import models.Human;
import play.Logger;

import java.util.List;

/**
 * Created by Lucas Declercq on 2/1/18
 */
@ImplementedBy(HumanDAOImp.class)
public interface HumanDAO {
    public void test();

    public Long totalRowCount();

    public List<Human> getDatablepage(String searchParam, String sortBy, String order, Integer pageSize, Integer page);

    public Long getDatatableResultsCount();
}
