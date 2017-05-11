package hu.lali.uvegtigris.datamodel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ÁFA értékek tárolása
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SportEvent.findAll", query = "SELECT c FROM Product c"),
    @NamedQuery(name = "SportEvent.findById", query = "SELECT c FROM Product c WHERE c.id = :id")})
public class Vat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic(optional = false)
    @NotNull
    @Column(name = "rate_percent")
    protected Integer ratePercent;
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getRatePercent() {
        return ratePercent;
    }

    public void setRatePercent(Integer ratePercent) {
        this.ratePercent = ratePercent;
    }
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vat)) {
            return false;
        }
        Vat other = (Vat) object;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.lali.uvegtigris.datamodel.vat[ id=" + id + " ]";
    }
}