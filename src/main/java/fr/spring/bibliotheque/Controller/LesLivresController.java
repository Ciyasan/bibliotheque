package fr.spring.bibliotheque.Controller;

import fr.spring.bibliotheque.Entity.Livre;
import fr.spring.bibliotheque.Service.LesLivres;
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
public class LesLivresController {

  @Autowired
  LesLivres livreService;

  @GetMapping("livres")
  public List<Livre> getLivres() {
    return livreService.getLivres();
  }

  @PostMapping("livres")
  public void postLivre(@RequestBody Livre newLivre) {
    System.out.println(newLivre);
    livreService.addLivre(newLivre);
  }

  @DeleteMapping("livres/{id}")
  public void deleteLivre(@PathVariable("id") Integer id) {
    livreService.deleteLivre(id);
  }

  @GetMapping("livres/{id}")
  public ResponseEntity<Livre> getLivre(@PathVariable("id") Integer id) {
    Optional<Livre> optional = livreService.getLivre(id);

    if (optional.isPresent()) {
      Livre livre = optional.get();
      return ResponseEntity.ok(livre);
    } else { //if(optional.isEmpty())
      return ResponseEntity.notFound().build();
    }
  }

  @PutMapping("livres/{id}")
  public ResponseEntity<String> updateLivre(
    @RequestBody Livre livre,
    @PathVariable("id") Integer id
  ) {
    boolean ok = livreService.updateLivre(livre, id);
    if (ok) {
      return ResponseEntity.ok("update OK");
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PatchMapping("livres/{id}")
  public void patchLivre(
    @RequestBody Livre livre,
    @PathVariable("id") Integer id
  ) {
    livreService.patchLivre(livre, id);
  }
}
