package hu.lali.uvegtigris.admin;

import com.jcabi.aspects.Loggable;
import hu.lali.uvegtigris.datamodel.Shop;
import hu.lali.uvegtigris.datamodel.Product;
import hu.lali.uvegtigris.viewmodel.IdNamePOJO;
import hu.lali.uvegtigris.viewmodel.NameDescriptionPOJO;
import hu.lali.uvegtigris.viewmodel.BasicEntitiesDTO;

import hu.lali.uvegtigris.viewmodel.product.ProductWithIDsPOJO;
import hu.lali.uvegtigris.viewmodel.shop.ShopWithIDsPOJO;
import hu.lali.uvegtigris.viewmodel.shop.ShopDTO;
import hu.lali.uvegtigris.viewmodel.system.MessagePOJO;
import io.swagger.annotations.Api;
import java.util.ArrayList;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hu.lali.uvegtigris.services.api.IShopService;


@Path("/shop")
@Api(value = "Shop administration")
public class ShopREST {
    private static final Logger log = LoggerFactory.getLogger(ShopREST.class.getSimpleName());

    @Inject
    IShopService service;
    
    @Inject
    ShopDTO dtoShop;

    public ShopREST() {
        log.info("CREATE ShopREST Instance");
    }
    
    @GET
    @Path("/entity/all") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO, prepend = true)
    public List<Shop> entityList(){
        return service.getAll();
    }

    @GET
    @Path("/idname/all") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO,  prepend = true)
    public List<IdNamePOJO> idnameList(){
        List<IdNamePOJO> res = new ArrayList<>();
        List<Shop> entities = service.getAll();
        for (Shop entity : entities) {
            res.add(IdNamePOJO.factoryDTO(entity));
        }
        return res;
    }

    @GET
    @Path("namedescription/all") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO,  prepend = true)
    public List<NameDescriptionPOJO> namedescriptionList() {
        List<NameDescriptionPOJO> res = new ArrayList<>();
        List<Shop> entities = service.getAll();
        for(Shop entity : entities) {
            // todo
        }
        return res;
    }
    
    @GET
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO,  prepend = true)
    public Shop findById(@PathParam("id") int id){
        return service.getById(id);
    }
    
    @POST
    @Path("/save")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO,  prepend = true)
    public MessagePOJO save(ShopWithIDsPOJO pData){
        service.save(dtoShop.toShop(pData, null));
        return new MessagePOJO("OK");
    }

    @POST
    @Path("/addproduct")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Loggable(value = Loggable.INFO,  prepend = true)
    public MessagePOJO addProduct(ProductWithIDsPOJO pData){
        Shop shop = service.getById(pData.getShopid());
        Product product = dtoShop.toProduct(pData);
        shop.addProduct(product);
        
        service.save(shop);
        return new MessagePOJO("OK");
    }
}