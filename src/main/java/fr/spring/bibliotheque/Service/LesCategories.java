package fr.spring.bibliotheque.Service;

import fr.spring.bibliotheque.Dao.CategorieRepository;
import fr.spring.bibliotheque.Entity.Categorie;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LesCategories {

  @Autowired
  CategorieRepository categorieRepository;

  public void addCategorie(Categorie categorie) {
    categorieRepository.save(categorie);
  }

  public List<Categorie> getCategories() {
    return categorieRepository.findAll();
  }

  public void deleteCategorie(int id) {
    categorieRepository.deleteById(id);
  }

  public Optional<Categorie> getCategorie(Integer id) {
    return categorieRepository.findById(id);
  }

  public boolean updateCategorie(Categorie categorie, Integer id) {
    Optional<Categorie> optional = categorieRepository.findById(id);
    if (optional.isPresent()) {
      categorieRepository.save(categorie);
      return true;
    } else {
      return false;
    }
  }

  public void patchCategorie(Categorie categoriePatch, Integer id) {
    System.out.println(categoriePatch);
    System.out.println(id);

    Optional<Categorie> optional = categorieRepository.findById(id);
    if (optional.isPresent()) {
      Categorie categorie = optional.get();
      System.out.println(categorie);
      categorie.updateNotNull(categoriePatch);

      categorieRepository.save(categorie);
    }
  }
}
