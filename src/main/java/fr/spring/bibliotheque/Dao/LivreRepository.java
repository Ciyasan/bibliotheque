package fr.spring.bibliotheque.Dao;

import fr.spring.bibliotheque.Entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepository extends JpaRepository<Livre, Integer> {}
