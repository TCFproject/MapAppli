package fr.eps.mapappli.obj;

public class List_Item {
    private String name;
    private String description;
    private String url;

    public List_Item(String name, String description, String url) {
        this.name = name;
        this.description = description;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
