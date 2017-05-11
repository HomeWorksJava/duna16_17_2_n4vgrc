package hu.lali.uvegtigris.framework.services.api;

import hu.lali.uvegtigris.framework.datamodel.Group;
import java.util.List;

public interface ICacheRoleService {
    public List<Group> getRolesByUserName(String pName);
    public void removeUserRolesFromCache(String pName);
    public void addUserRoleToCache(String pName, Group pRole);
}