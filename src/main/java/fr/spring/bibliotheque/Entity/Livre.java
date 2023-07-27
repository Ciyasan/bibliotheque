package fr.spring.bibliotheque.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "livres")
public class Livre {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String titre;

  @ManyToOne
  private Auteur auteur;

  @ManyToMany
  List<Categorie> categories = new ArrayList<>();

  //Constructeurs
  public Livre(Integer id, String titre) {
    this.id = id;
    this.titre = titre;
  }

  public Livre() {}

  //Getters
  public Integer getId() {
    return id;
  }

  public String getTitre() {
    return titre;
  }

  public Auteur getAuteur() {
    return auteur;
  }

  public List<Categorie> getCategories() {
    return categories;
  }

  //Setters
  public void setId(Integer id) {
    this.id = id;
  }

  public void setTitre(String titre) {
    this.titre = titre;
  }

  public void setAuteur(Auteur auteur) {
    this.auteur = auteur;
  }

  public void setCategories(List<Categorie> categories) {
    this.categories = categories;
  }

  @Override
  public String toString() {
    return ("Zoo{" + "id = " + id + ", titre = '" + titre + '\'' + '}');
  }

  public void updateNotNull(Livre livrePatch) {
    if (livrePatch.getTitre() != null) {
      this.setTitre(livrePatch.getTitre());
    }
    if (livrePatch.getAuteur() != null) {
      this.setAuteur(livrePatch.getAuteur());
    }
    if (livrePatch.getCategories() != null) {
      this.setCategories(livrePatch.getCategories());
    }
  }
}
