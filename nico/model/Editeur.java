package nico.model;

public class Editeur {
    
    protected int id_editeur;
    protected String nom_editeur;

    public Editeur() {}

    public Editeur(int id_editeur, String nom_editeur) {
        this.id_editeur = id_editeur;
        this.nom_editeur = nom_editeur;
    }

    public int getId_editeur() {
        return this.id_editeur;
    }

    public void setId_editeur(int id_editeur) {
        this.id_editeur = id_editeur;
    }

    public String getNom_editeur() {
        return this.nom_editeur;
    }

    public void setNom_editeur(String nom_editeur) {
        this.nom_editeur = nom_editeur;
    }

    @Override
    public String toString() {
        return "{" +
            " id_editeur='" + getId_editeur() + "'" +
            ", nom_editeur='" + getNom_editeur() + "'" +
            "}";
    }
}
