package tn.esprit.indusmarket.indusmarketback.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.indusmarket.indusmarketback.Entities.Livreur;
import tn.esprit.indusmarket.indusmarketback.Services.LivreurServices;

import java.util.List;

@RestController
@RequestMapping("/livreurs")
public class LivreurController {
    @Autowired
    private LivreurServices livreurService;

    @PostMapping
    public Livreur enregistrerLivreur(@RequestBody Livreur livreur) {
        return livreurService.enregistrerLivreur(livreur);
    }

    @GetMapping
    public List<Livreur> rechercherLivreurs() {
        return livreurService.rechercherLivreurs();
    }
}
