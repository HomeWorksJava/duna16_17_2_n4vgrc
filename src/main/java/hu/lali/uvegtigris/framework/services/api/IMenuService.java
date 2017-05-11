package hu.lali.uvegtigris.framework.services.api;

import hu.lali.uvegtigris.framework.datamodel.MenuItem;
import java.util.List;

public interface IMenuService {
    public List<MenuItem> getByRoleName(String pRole);
    public MenuItem getById(long pID);
}