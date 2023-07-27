package fr.spring.bibliotheque.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "auteurs")
public class Auteur {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nom;
  private String prenom;

  //Constructeurs
  public Auteur(Integer id, String nom, String prenom) {
    this.id = id;
    this.nom = nom;
    this.prenom = prenom;
  }

  public Auteur() {}

  //Getters
  public Integer getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public String getPrenom() {
    return prenom;
  }

  //Setters
  public void setId(Integer id) {
    this.id = id;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  @Override
  public String toString() {
    return (
      "Zoo{" +
      "id = " +
      id +
      ", nom = '" +
      nom +
      '\'' +
      ", prenom = '" +
      prenom +
      '\'' +
      '}'
    );
  }

  public void updateNotNull(Auteur auteurPatch) {
    if (auteurPatch.getNom() != null) {
      this.setNom(auteurPatch.getNom());
    }
    if (auteurPatch.getPrenom() != null) {
      this.setPrenom(auteurPatch.getPrenom());
    }
  }
}
