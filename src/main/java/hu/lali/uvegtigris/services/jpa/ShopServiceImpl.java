package hu.lali.uvegtigris.services.jpa;

import hu.lali.uvegtigris.datamodel.Shop;
import hu.lali.uvegtigris.datamodel.Product;
import hu.lali.uvegtigris.services.GenericDaoServiceImpl;
import java.util.HashMap;
import java.util.List;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import hu.lali.uvegtigris.services.api.IShopService;

@RequestScoped
public class ShopServiceImpl implements IShopService{
    @Inject
    GenericDaoServiceImpl dao;
    
    @Override
    public List<Shop> getAll() {
        return (List<Shop>)dao.getEntities("Shop.findAll", new HashMap<>());
    }

    @Override
    public Shop getById(Integer pID) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", pID);
        return (Shop)dao.getEntity("Shop.findById", params);
   }

    @Override
    public void save(Shop pEntity) {
        dao.save(pEntity);
    }

    @Override
    public Product getProductById(long pId) {
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", pId);
        return (Product)dao.getEntity("Product.findById", params);
    }

    @Override
    public void save(Product pEntity) {
       dao.save(pEntity);
    }
}