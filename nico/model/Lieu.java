package nico.model;

public class Lieu {
    
    protected int idLieu;
    protected String nomLieu;

    public Lieu() {}

    public Lieu(int idLieu, String nomLieu) {
        this.idLieu = idLieu;
        this.nomLieu = nomLieu;
    }

    public int getIdLieu() {
        return this.idLieu;
    }

    public void setIdLieu(int idLieu) {
        this.idLieu = idLieu;
    }

    public String getNomLieu() {
        return this.nomLieu;
    }

    public void setNomLieu(String nomLieu) {
        this.nomLieu = nomLieu;
    }

    @Override
    public String toString() {
        return "{" +
            " idLieu='" + getIdLieu() + "'" +
            ", nomLieu='" + getNomLieu() + "'" +
            "}";
    }

}
