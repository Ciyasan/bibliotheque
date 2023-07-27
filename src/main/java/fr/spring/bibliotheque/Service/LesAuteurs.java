package fr.spring.bibliotheque.Service;

import fr.spring.bibliotheque.Dao.AuteurRepository;
import fr.spring.bibliotheque.Entity.Auteur;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LesAuteurs {

  @Autowired
  AuteurRepository auteurRepository;

  public void addAuteur(Auteur auteur) {
    auteurRepository.save(auteur);
  }

  public List<Auteur> getAuteurs() {
    return auteurRepository.findAll();
  }

  public void deleteAuteur(int id) {
    auteurRepository.deleteById(id);
  }

  public Optional<Auteur> getAuteur(Integer id) {
    return auteurRepository.findById(id);
  }

  public boolean updateAuteur(Auteur auteur, Integer id) {
    Optional<Auteur> optional = auteurRepository.findById(id);
    if (optional.isPresent()) {
      auteurRepository.save(auteur);
      return true;
    } else {
      return false;
    }
  }

  public void patchAuteur(Auteur auteurPatch, Integer id) {
    System.out.println(auteurPatch);
    System.out.println(id);

    Optional<Auteur> optional = auteurRepository.findById(id);
    if (optional.isPresent()) {
      Auteur auteur = optional.get();
      System.out.println(auteur);
      auteur.updateNotNull(auteurPatch);

      auteurRepository.save(auteur);
    }
  }
}
