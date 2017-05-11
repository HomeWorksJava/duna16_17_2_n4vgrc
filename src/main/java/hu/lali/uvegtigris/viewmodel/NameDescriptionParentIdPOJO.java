package hu.lali.uvegtigris.viewmodel;

public class NameDescriptionParentIdPOJO {
    private String name,description;
    private int parentid;

    public NameDescriptionParentIdPOJO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }
}