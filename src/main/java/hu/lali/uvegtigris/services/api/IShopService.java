package hu.lali.uvegtigris.services.api;

import hu.lali.uvegtigris.datamodel.Shop;
import hu.lali.uvegtigris.datamodel.Product;
import java.util.List;

public interface IShopService {
    public List<Shop> getAll();
    public Shop getById(Integer pID);
    public void save(Shop pEntity);
    public void save(Product pEntity);
    public Product getProductById(long pId);
}