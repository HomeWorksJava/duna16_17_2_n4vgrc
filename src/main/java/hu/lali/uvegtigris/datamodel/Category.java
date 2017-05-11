package hu.lali.uvegtigris.datamodel;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "shop")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Championship.findAll", query = "SELECT c FROM Shop c"),
    @NamedQuery(name = "Championship.findById", query = "SELECT c FROM Shop c WHERE c.id = :id"),
    @NamedQuery(name = "Championship.findByName", query = "SELECT c FROM Shop c WHERE c.name = :name")})
public class Category extends AbstractBasicEntity implements Serializable {
    
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shop",orphanRemoval = true, cascade = CascadeType.ALL)
    Set<Product> product = new HashSet<>();
            
    public Category() {
    }

    public Category(Integer id) {
        this.id = id;
    }

    public Category(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> event) {
        this.product = event;
    }

    public void addProduct(Product product) {
        product.setCategory(this);
        if(this.product==null) 
            this.product = new HashSet<>();
        this.product.add(product);
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.lali.uvegtigris.datamodel.Shop[ id=" + id + " ]";
    }
}