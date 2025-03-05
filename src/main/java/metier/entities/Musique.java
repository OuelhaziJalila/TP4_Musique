package metier.entities;

import java.io.Serializable;

public class Musique implements Serializable {
	private Long idMusique;
	private String titre;
	private double duree;

	public Musique() {
	}

	public Musique(String titre, double duree) {
		this.titre = titre;
		this.duree = duree;
	}

	public Long getIdMusique() {
		return idMusique;
	}

	public void setIdMusique(Long idMusique) {
		this.idMusique = idMusique;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public double getDuree() {
		return duree;
	}

	public void setDuree(double duree) {
		this.duree = duree;
	}

	@Override
	public String toString() {
		return "Musique [idMusique=" + idMusique + ", titre=" + titre + ", duree=" + duree + "]";
	}

}