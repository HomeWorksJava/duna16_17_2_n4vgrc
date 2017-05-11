package hu.lali.uvegtigris.viewmodel.system;

import java.util.List;

public class PagerPOJO {
    protected long total;
    protected List rows;

    public PagerPOJO() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}