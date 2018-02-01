package dto;

import java.util.List;

/**
 * Created by Lucas Declercq on 2/1/18
 */
public class DatatableDTO<T> {
    public String draw;
    public Long recordsTotal;
    public Integer recordsFiltered;
    public List<T> data;
}
