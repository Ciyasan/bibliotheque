package fr.spring.bibliotheque.Dao;

import fr.spring.bibliotheque.Entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository
  extends JpaRepository<Categorie, Integer> {}
