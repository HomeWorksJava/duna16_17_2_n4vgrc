package hu.lali.uvegtigris.viewmodel;

import hu.lali.uvegtigris.datamodel.AbstractBasicEntity;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class BasicEntitiesDTO {
    
    public NameDescriptionPOJO factory(AbstractBasicEntity pValue){
         return new NameDescriptionPOJO(pValue.getName(), pValue.getDescription());
    }
}
