package fr.eps.mapappli.obj;

public class Item {
    private int id;
    private String titre;
    private String url;

    public Item(int id, String titre, String url){
        this.id = id;
        this.titre = titre;
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getUrl() {
        return url;
    }
}
