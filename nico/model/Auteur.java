package nico.model;

public class Auteur {
    
    protected int idAuteur;
    protected String nomAuteur;

    public Auteur() {}

    public Auteur(int idAuteur, String nomAuteur) {
        this.idAuteur = idAuteur;
        this.nomAuteur = nomAuteur;
    }

    public int getIdAuteur() {
        return this.idAuteur;
    }

    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    public String getNomAuteur() {
        return this.nomAuteur;
    }

    public void setNomAuteur(String nomAuteur) {
        this.nomAuteur = nomAuteur;
    }

    @Override
    public String toString() {
        return "{" +
            " idAuteur='" + getIdAuteur() + "'" +
            ", nomAuteur='" + getNomAuteur() + "'" +
            "}";
    }

}
