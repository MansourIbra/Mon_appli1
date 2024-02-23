package gn.orange.mon_appli1.Controller;

import gn.orange.mon_appli1.Model.Auteur;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/page")
public class HomeController {
    
    List<Auteur> auteurs = new ArrayList<>();
    
    public HomeController(){

        Auteur auteur1 = new Auteur();
        auteur1.setId("1");
        auteur1.setNom("Camara");
        auteur1.setPrenom("Laye");
        auteur1.setNationalite("Guinéenne");
        auteur1.setAge(40);

        Auteur auteur2 = new Auteur();
        auteur2.setId("2");
        auteur2.setNom("Cesaire");
        auteur2.setPrenom("Aimer");
        auteur2.setNationalite("Camerounais");
        auteur2.setAge(46);

        Auteur auteur3 = new Auteur();
        auteur3.setId("03");
        auteur3.setNom("Ferdinand");
        auteur3.setPrenom("Oyono");
        auteur3.setNationalite("Camerounais");
        auteur3.setAge(50);

        Auteur auteur4 = new Auteur();
        auteur4.setId("4");
        auteur4.setNom("Monenembo");
        auteur4.setPrenom("Thierno");
        auteur4.setNationalite("Guinéenne");
        auteur4.setAge(65);

        Auteur auteur5 = new Auteur();
        auteur5.setId("5");
        auteur5.setNom("Ngiane");
        auteur5.setPrenom("Djibril");
        auteur5.setNationalite("Guinéenne");
        auteur5.setAge(49);

        auteurs.add(auteur1);
        auteurs.add(auteur2);
        auteurs.add(auteur3);
        auteurs.add(auteur4);
        auteurs.add(auteur5);

    }

    @GetMapping("/home")
    public String Home(Model model){
        model.addAttribute("auteurs",auteurs);
        return "home";
    }
    @GetMapping("/auteur/{id}")
    public String getAuteur(Model model, @PathVariable("id") String id){
        Optional<Auteur> auteur = auteurs.stream().filter(auteur1 -> Objects.equals(auteur1.getId(), id)).findFirst();
        if(auteur.isPresent()){
            model.addAttribute("auteur",auteur.get());
        }
        else {
            model.addAttribute("auteur", new Auteur());
        }

        return "auteur";
    }
    @GetMapping("/formulaire")
    public String formulairAuteur(Model model){
        model.addAttribute("auteur", new Auteur());
        return "formulaire";
    }

    @PostMapping("/auteur")
    public String saveAuteur( @RequestBody Auteur auteur){
        auteurs.add(auteur);
        return "redirect:/page/home";
    }


}
