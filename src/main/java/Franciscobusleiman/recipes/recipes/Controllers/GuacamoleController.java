package Franciscobusleiman.recipes.recipes.Controllers;

import Franciscobusleiman.recipes.recipes.Repositories.RecipeRepository;
import Franciscobusleiman.recipes.recipes.domain.Recipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Slf4j
@Controller
public class GuacamoleController {
    private final RecipeRepository recipeRepository;

    public GuacamoleController(RecipeRepository recipeRepository){
        this.recipeRepository = recipeRepository;
    }

    @RequestMapping({"/guacamole"})
    public String getRecetas(Model model){
        log.debug("Enviando a pantalla info. de la receta de guacamola");


model.addAttribute("guacamole", recipeRepository.findByDescription("Guacamole").get());
        return "guacamole.html";

    }
}
