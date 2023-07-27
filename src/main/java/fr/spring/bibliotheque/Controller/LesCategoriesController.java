package fr.spring.bibliotheque.Controller;

import fr.spring.bibliotheque.Entity.Categorie;
import fr.spring.bibliotheque.Service.LesCategories;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class LesCategoriesController {

  @Autowired
  LesCategories categorieService;

  @GetMapping("categories")
  public List<Categorie> getCategories() {
    return categorieService.getCategories();
  }

  @PostMapping("categories")
  public void postCategorie(@RequestBody Categorie newCategorie) {
    System.out.println(newCategorie);
    categorieService.addCategorie(newCategorie);
  }

  @DeleteMapping("categories/{id}")
  public void deleteCategorie(@PathVariable("id") Integer id) {
    categorieService.deleteCategorie(id);
  }

  @GetMapping("categories/{id}")
  public ResponseEntity<Categorie> getCategorie(
    @PathVariable("id") Integer id
  ) {
    Optional<Categorie> optional = categorieService.getCategorie(id);

    if (optional.isPresent()) {
      Categorie categorie = optional.get();
      return ResponseEntity.ok(categorie);
    } else { //if(optional.isEmpty())
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("categories/{id}")
  public ResponseEntity<String> updateCategorie(
    @RequestBody Categorie categorie,
    @PathVariable("id") Integer id
  ) {
    boolean ok = categorieService.updateCategorie(categorie, id);
    if (ok) {
      return ResponseEntity.ok("update OK");
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PatchMapping("categories/{id}")
  public void patchCategorie(
    @RequestBody Categorie categorie,
    @PathVariable("id") Integer id
  ) {
    categorieService.patchCategorie(categorie, id);
  }
}
