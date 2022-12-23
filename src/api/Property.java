package api;

public class Property {
    private String name,type,location,descr;

    public Property(String name,String type,String location,String descr) {
        this.name = name;
        this.type = type;
        this.location = location;
        this.descr = descr;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLocation() {
        return location;
    }

    public String getDescr() {
        return descr;
    }

}
