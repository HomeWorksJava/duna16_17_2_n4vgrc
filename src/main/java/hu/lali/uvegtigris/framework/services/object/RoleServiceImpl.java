package hu.lali.uvegtigris.framework.services.object;

import hu.lali.uvegtigris.framework.datamodel.Group;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import hu.lali.uvegtigris.framework.services.api.IRoleService;

@Singleton
@Startup
public class RoleServiceImpl implements IRoleService {
    private static final String ROLE_TULAJDONOS = "tulajdonos";
    private static final String ROLE_ELADO = "elado";

    @Override
    public List<Group> getAllRoles(){
        List<Group> res = new ArrayList<>();
        res.add(new Group(ROLE_TULAJDONOS));
        res.add(new Group(ROLE_ELADO));
        return res;
    }
}