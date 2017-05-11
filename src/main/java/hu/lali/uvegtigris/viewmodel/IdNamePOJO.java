package hu.lali.uvegtigris.viewmodel;

import hu.lali.uvegtigris.datamodel.AbstractBasicEntity;

public class IdNamePOJO {
    protected Integer id;
    protected String name;
 
    public IdNamePOJO() {
    }

    public static IdNamePOJO factoryDTO(AbstractBasicEntity pValue){
        return new IdNamePOJO(pValue.getId(),pValue.getName());
    }
    
    public IdNamePOJO(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}