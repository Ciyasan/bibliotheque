package fr.spring.bibliotheque.Dao;

import fr.spring.bibliotheque.Entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuteurRepository extends JpaRepository<Auteur, Integer> {}
