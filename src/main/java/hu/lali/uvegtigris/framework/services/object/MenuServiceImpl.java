package hu.lali.uvegtigris.framework.services.object;

import hu.lali.uvegtigris.framework.datamodel.MenuItem;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hu.lali.uvegtigris.framework.services.api.IMenuService;

@Singleton
@Startup
public class MenuServiceImpl implements IMenuService {    
    private static final String ROLE_TULAJDONOS = "tulajdonos";
    private static final String ROLE_ELADO = "elado";
    
    private Logger log = LoggerFactory.getLogger(MenuServiceImpl.class.getSimpleName());

    public MenuServiceImpl() {
        log.debug("Create instance");
    }

    @Override
    public List<MenuItem> getByRoleName(String pRole) {
        List<MenuItem> res = new ArrayList<>();
        if(ROLE_TULAJDONOS.equals(pRole)){
            res.add(new MenuItem("Termékek", "/html/products.jsp"));
            //res.add(new MenuItem("Kategóriák", "/html/categories.jsp"));
            //res.add(new MenuItem("Kimutatások", "/html/stats.jsp"));
        }
        if(ROLE_ELADO.equals(pRole)){
            res.add(new MenuItem("Termékek", "/html/products.jsp"));
        }
        return res;
    }

    @Override
    public MenuItem getById(long pID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}