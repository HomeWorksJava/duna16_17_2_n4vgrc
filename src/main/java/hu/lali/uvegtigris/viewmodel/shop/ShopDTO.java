package hu.lali.uvegtigris.viewmodel.shop;

import hu.lali.uvegtigris.datamodel.Shop;
import hu.lali.uvegtigris.datamodel.Product;
import hu.lali.uvegtigris.viewmodel.product.ProductWithIDsPOJO;
import javax.enterprise.context.ApplicationScoped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ShopDTO {
    private static final Logger log = LoggerFactory.getLogger(ShopDTO.class.getSimpleName());
    
    public ShopDTO() {
    }

    public ShopWithIDsPOJO factory(Shop pModel){
        ShopWithIDsPOJO res = new ShopWithIDsPOJO();
        res.setName(pModel.getName());
        res.setDescription(pModel.getDescription());
        return res;
    }
    
    public Shop toShop(ShopWithIDsPOJO pModel, Shop res){
        if(res == null)
            res = new Shop();
        res.setName(pModel.getName());
        res.setDescription(pModel.getDescription());
        return res;
    }

    public Product toProduct(ProductWithIDsPOJO pModel){
        Product product;
        product = new Product();
        product.setCnt(pModel.getCnt());
        product.setNetPrice(pModel.getNet_price());
        product.setGrossPrice(pModel.getGross_price());

        return product;
    }
}   