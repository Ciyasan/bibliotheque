package fr.spring.bibliotheque.Controller;

import fr.spring.bibliotheque.Entity.Auteur;
import fr.spring.bibliotheque.Service.LesAuteurs;
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
public class LesAuteursController {

  @Autowired
  LesAuteurs auteurService;

  @GetMapping("auteurs")
  public List<Auteur> getAuteurs() {
    return auteurService.getAuteurs();
  }

  @PostMapping("auteurs")
  public void postAuteur(@RequestBody Auteur newAuteur) {
    System.out.println(newAuteur);
    auteurService.addAuteur(newAuteur);
  }

  @DeleteMapping("auteurs/{id}")
  public void deleteAuteur(@PathVariable("id") Integer id) {
    auteurService.deleteAuteur(id);
  }

  @GetMapping("auteurs/{id}")
  public ResponseEntity<Auteur> getAuteur(@PathVariable("id") Integer id) {
    Optional<Auteur> optional = auteurService.getAuteur(id);

    if (optional.isPresent()) {
      Auteur auteur = optional.get();
      return ResponseEntity.ok(auteur);
    } else { //if(optional.isEmpty())
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("auteurs/{id}")
  public ResponseEntity<String> updateAuteur(
    @RequestBody Auteur auteur,
    @PathVariable("id") Integer id
  ) {
    boolean ok = auteurService.updateAuteur(auteur, id);
    if (ok) {
      return ResponseEntity.ok("update OK");
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PatchMapping("auteurs/{id}")
  public void patchAuteur(
    @RequestBody Auteur auteur,
    @PathVariable("id") Integer id
  ) {
    auteurService.patchAuteur(auteur, id);
  }
}
