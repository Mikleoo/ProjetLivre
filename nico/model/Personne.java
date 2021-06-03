package nico.model;

public class Personne {

    protected int idPersonne;
    protected String nomPersonne;

    public Personne() {}

    public Personne(int idPersonne, String nomPersonne) {
        this.idPersonne = idPersonne;
        this.nomPersonne = nomPersonne;
    }

    public int getIdPersonne() {
        return this.idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNomPersonne() {
        return this.nomPersonne;
    }

    public void setNomPersonne(String nomPersonne) {
        this.nomPersonne = nomPersonne;
    }

    @Override
    public String toString() {
        return "{" +
            " idPersonne='" + getIdPersonne() + "'" +
            ", nomPersonne='" + getNomPersonne() + "'" +
            "}";
    }

}
