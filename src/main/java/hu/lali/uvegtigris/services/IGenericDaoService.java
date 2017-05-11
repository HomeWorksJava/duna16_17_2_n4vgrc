package hu.lali.uvegtigris.services;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;

public interface IGenericDaoService {
    public EntityManager getEM();
    public void save(Object pSort);
 
    public List getEntities(String pQuery, Map<String,Object> pParams);

    public Object getEntity(String pQuery, Map<String,Object> pParams);
}