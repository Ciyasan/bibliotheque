package fr.spring.bibliotheque.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class Categorie {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String nom;

  //Constructeurs

  public Categorie(Integer id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public Categorie() {}

  //Getters

  public Integer getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  //Setters

  public void setId(Integer id) {
    this.id = id;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  @Override
  public String toString() {
    return ("Zoo{" + "id = " + id + ", nom = '" + nom + '\'' + '}');
  }

  public void updateNotNull(Categorie categoriePatch) {
    if (categoriePatch.getNom() != null) {
      this.setNom(categoriePatch.getNom());
    }
  }
}
