package Modele;

import java.util.Date;

public class Livre {
	
	private String NomLivre;
	private String Auteur;
	private String Editeur;
	private String Lieu;
	private String date;
	private String NomPreteur;
	
	
	
	// Setters

	public void setNomLivre(String NomLivre) {
		this.NomLivre = NomLivre;
	}
	
	public void setAuteur(String Auteur) {
		this.Auteur = Auteur;
	}
	
	public void setEditeur(String Editeur) {
		this.Editeur = Editeur;
	}
	
	public void setLieu(String Lieu) {
		this.Lieu = Lieu;
	}
	
	public void setDate(String Date) {
		this.date = Date;
	}
	
	public void setNomPreteur(String NomPreteur) {
		this.NomPreteur = NomPreteur;
	}
	
	// Getters
	
	public String getNomLivre() {
		return NomLivre;
	}

	public String getDate() {
		return date;
	}

	public String getAuteur() {
		return Auteur;
	}

	public String getEditeur() {
		return Editeur;
	}

	public String getLieu() {
		return Lieu;
	}

	public String getNomPreteur() {
		return NomPreteur;
	}

}
