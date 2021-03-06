package Project;

import java.io.Serializable;
import java.time.LocalDate;

public class Personne  implements Serializable {
	private String nom;
	private String prenom;
	private LocalDate dateNaissance; 
	
	
	public Personne(String nom, String prenom, LocalDate dateNaissance) {
		this.nom=nom;
		this.prenom=prenom;
		this.dateNaissance=dateNaissance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public boolean equals(Personne person) { 
		boolean equal = nom.equals(person.getNom());
		 equal = prenom.equals(person.getPrenom())  && equal;
		 equal = dateNaissance.compareTo(person.getDateNaissance()) == 0  && equal;
		return equal;
	}
	
	
	
}
