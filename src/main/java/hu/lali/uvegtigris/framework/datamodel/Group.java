package hu.lali.uvegtigris.framework.datamodel;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "group")
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String group;

    public Group() {
    }

    public Group(String role) {
        this.group = role;
    }
   
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (group != null ? group.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Group)) {
            return false;
        }
        Group other = (Group) object;
        if ((this.group == null && other.group != null) || (this.group != null && !this.group.equals(other.group))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hu.lali.uvegtigris.framework.datamodel.Role[ id=" + group + " ]";
    }
}