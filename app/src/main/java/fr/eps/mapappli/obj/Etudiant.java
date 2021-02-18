package fr.eps.mapappli.obj;

public class Etudiant {
    private String nom;
    private String prenom;
    private String email;
    private int groupe;

    public Etudiant(String nom, String prenom, String email, int groupe){
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.groupe = groupe;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public int getGroupe() {
        return groupe;
    }
}
