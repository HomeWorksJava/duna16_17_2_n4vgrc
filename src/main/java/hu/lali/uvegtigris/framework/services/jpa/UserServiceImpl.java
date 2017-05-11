package hu.lali.uvegtigris.framework.services.jpa;

import hu.lali.uvegtigris.services.GenericDaoServiceImpl;
import hu.lali.uvegtigris.framework.datamodel.Users;
import java.util.HashMap;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import hu.lali.uvegtigris.framework.services.api.IUserService;

@RequestScoped
public class UserServiceImpl implements IUserService{
    @Inject
    GenericDaoServiceImpl dao;
    
    @Override
    public Users getById(String pName) {
        HashMap<String,Object> params = new HashMap<String, Object>();
        params.put("username", pName);
        return (Users)dao.getEntity("Users.findByUsername", params);
    }
}