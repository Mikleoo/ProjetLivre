package nico.model;

import java.util.Date;

public class Livre {
    
    protected int idIsbn;
    protected String nomLivre;
    protected Date dateDeFin;
    protected boolean estSupprime;
    protected int idAuteur;
    protected int idEditeur;
    protected int idPersonne;
    protected int idLieu;

    public Livre() {}

    public Livre(int idIsbn, String nomLivre, Date dateDeFin, boolean estSupprime, int idAuteur, int idEditeur, int idPersonne, int idLieu) {
        this.idIsbn = idIsbn;
        this.nomLivre = nomLivre;
        this.dateDeFin = dateDeFin;
        this.estSupprime = estSupprime;
        this.idAuteur = idAuteur;
        this.idEditeur = idEditeur;
        this.idPersonne = idPersonne;
        this.idLieu = idLieu;
    }

    public int getIdIsbn() {
        return this.idIsbn;
    }

    public void setIdIsbn(int idIsbn) {
        this.idIsbn = idIsbn;
    }

    public String getNomLivre() {
        return this.nomLivre;
    }

    public void setNomLivre(String nomLivre) {
        this.nomLivre = nomLivre;
    }

    public Date getDateDeFin() {
        return this.dateDeFin;
    }

    public void setDateDeFin(Date dateDeFin) {
        this.dateDeFin = dateDeFin;
    }

    public boolean isEstSupprime() {
        return this.estSupprime;
    }

    public boolean getEstSupprime() {
        return this.estSupprime;
    }

    public void setEstSupprime(boolean estSupprime) {
        this.estSupprime = estSupprime;
    }

    public int getIdAuteur() {
        return this.idAuteur;
    }

    public void setIdAuteur(int idAuteur) {
        this.idAuteur = idAuteur;
    }

    public int getIdEditeur() {
        return this.idEditeur;
    }

    public void setIdEditeur(int idEditeur) {
        this.idEditeur = idEditeur;
    }

    public int getIdPersonne() {
        return this.idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public int getIdLieu() {
        return this.idLieu;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    @Override
    public String toString() {
        return "{" +
            " idIsbn='" + getIdIsbn() + "'" +
            ", nomLivre='" + getNomLivre() + "'" +
            ", dateDeFin='" + getDateDeFin() + "'" +
            ", estSupprime='" + isEstSupprime() + "'" +
            ", idAuteur='" + getIdAuteur() + "'" +
            ", idEditeur='" + getIdEditeur() + "'" +
            ", idPersonne='" + getIdPersonne() + "'" +
            ", idLieu='" + getIdLieu() + "'" +
            "}";
    }

}
