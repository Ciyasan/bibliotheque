package fr.spring.bibliotheque.Service;

import fr.spring.bibliotheque.Dao.LivreRepository;
import fr.spring.bibliotheque.Entity.Livre;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LesLivres {

  @Autowired
  LivreRepository livreRepository;

  public void addLivre(Livre livre) {
    livreRepository.save(livre);
  }

  public List<Livre> getLivres() {
    return livreRepository.findAll();
  }

  public void deleteLivre(int id) {
    livreRepository.deleteById(id);
  }

  public Optional<Livre> getLivre(Integer id) {
    return livreRepository.findById(id);
  }

  public boolean updateLivre(Livre livre, Integer id) {
    Optional<Livre> optional = livreRepository.findById(id);
    if (optional.isPresent()) {
      livreRepository.save(livre);
      return true;
    } else {
      return false;
    }
  }

  public void patchLivre(Livre livrePatch, Integer id) {
    System.out.println(livrePatch);
    System.out.println(id);

    Optional<Livre> optional = livreRepository.findById(id);
    if (optional.isPresent()) {
      Livre livre = optional.get();
      System.out.println(livre);
      livre.updateNotNull(livrePatch);

      livreRepository.save(livre);
    }
  }
}
