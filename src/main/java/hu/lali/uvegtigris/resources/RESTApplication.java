package hu.lali.uvegtigris.resources;

import io.swagger.jaxrs.config.BeanConfig;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class RESTApplication extends Application{

    public RESTApplication() {
        super();
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("2.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8182/uvegtigris");
        beanConfig.setBasePath("/rest");
        beanConfig.setResourcePackage("hu.lali.uvegtigris.resources");      
        beanConfig.setScan(true);
        beanConfig.setPrettyPrint(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet();
        resources.add(hu.lali.uvegtigris.admin.ShopREST.class);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        resources.add(org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature.class);
        return resources;
    }    
}