package Franciscobusleiman.recipes.recipes.DataLoader;

import Franciscobusleiman.recipes.recipes.repositories.CategoryRepository;
import Franciscobusleiman.recipes.recipes.repositories.RecipeRepository;
import Franciscobusleiman.recipes.recipes.repositories.UnitOfMeasureRepository;
import Franciscobusleiman.recipes.recipes.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class BootStrapData implements CommandLineRunner {
    private final CategoryRepository categoryRepository;
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public BootStrapData(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository){
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void run(String... args) throws Exception {




if(! categoryRepository.findByCategoryName("mexicana").isPresent()) {
    Category category1 = new Category();
    category1.setCategoryName("mexicana");

    Category category2 = new Category();
    category2.setCategoryName("argentina");

    Category category3 = new Category();
    category3.setCategoryName("italiana");

    Category category4 = new Category();
    category4.setCategoryName("vasca");

    UnitOfMeasure unitOfMeasure1 = new UnitOfMeasure();
    unitOfMeasure1.setUom("cucharada");

    UnitOfMeasure unitOfMeasure2 = new UnitOfMeasure();
    unitOfMeasure2.setUom("unidad");

    UnitOfMeasure unitOfMeasure3 = new UnitOfMeasure();
    unitOfMeasure3.setUom("gramo");




            log.debug("Cargando información de recetas");

            Recipe recetaGuacamole = new Recipe();
            recetaGuacamole.setDescription("Guacamole");
            recetaGuacamole.setPrepTime(20);
            recetaGuacamole.setCookTime(0);
            recetaGuacamole.setDifficulty(Difficulty.EASY);
            recetaGuacamole.setDirections("Troceamos la cebolla en trocitos pequeños, hacemos lo mismo con el tomate y el pimiento verde, reservamos.\n" +
                    "Picamos el cilantro en trocitos pequeños (no abuséis de este condimento), aproximadamente 1/2 cucharadita una vez este picado.\n" +
                    "Partimos la lima por la mitad (vamos a utilizar el jugo de media lima, la otra mitad podemos utilizarla en otra preparación). \n" +
                    "Pelamos los aguacates, retiramos el hueso (conservar el hueso), disponemos los aguacates en un plato y con un tenedor aplastamos bien. \n" +
                    "Añadimos un poquito del jugo de la lima (más o menos 1 cucharadita pequeña).\n" +
                    "Incorporamos el tomate picado,  el pimiento picado, la cebolla picada, el cilantro picado y una pizca de sal.\n" +
                    "Mezclamos todo bien, probamos y si le falta un poquito más de sal, sazonamos al gusto.");

            Notes notaGuacamole = new Notes();
            notaGuacamole.setNotes("Utilizad aguacates maduros, serán más fáciles de aplastar y tendrán un mejor sabor.\n" +
                    "Otros trucos de amigos mexicanos para que no se ponga oscuro: no salar y que cada comensal lo haga en su plato, o agregar un poco de aceite de girasol.");

            recetaGuacamole.setNotes(notaGuacamole);


            recetaGuacamole.getCategories().add(category1);
            category1.getRecipes().add(recetaGuacamole);



            recetaGuacamole.getIngredients().add(new Ingredient("aguacate", new BigDecimal(2), unitOfMeasure1, recetaGuacamole));
            recetaGuacamole.getIngredients().add(new Ingredient("tomate", new BigDecimal(1), unitOfMeasure2, recetaGuacamole));
            recetaGuacamole.getIngredients().add(new Ingredient("cebolla", new BigDecimal(30), unitOfMeasure2, recetaGuacamole));
            recetaGuacamole.getIngredients().add(new Ingredient("pimiento verde", new BigDecimal(0.25), unitOfMeasure2, recetaGuacamole));
            recetaGuacamole.getIngredients().add(new Ingredient("lima", new BigDecimal(0.5), unitOfMeasure2, recetaGuacamole));
            recetaGuacamole.getIngredients().add(new Ingredient("cilantro", new BigDecimal(1), unitOfMeasure2, recetaGuacamole));
            recetaGuacamole.getIngredients().add(new Ingredient("sal", new BigDecimal(1), unitOfMeasure2, recetaGuacamole));

            recipeRepository.save(recetaGuacamole);

            Recipe recetaTortilla = new Recipe();
            recetaTortilla.setDescription("tortilla");
            recetaTortilla.setPrepTime(30);
            recetaTortilla.setCookTime(35);
            recetaTortilla.setDifficulty(Difficulty.MODERATE);
            recetaTortilla.setDirections("Pelamos y lavamos las patatas, las cortamos en rodajas finas al igual que la cebolla. Ponemos ambas cosas en una sartén y cubrimos de aceite de oliva virgen extra, dejamos que se hagan a fuego medio-suave hasta que comiencen a dorarse. Sabréis que las patatas están hechas cuando comiencen a romperse, con la paleta. Para que la tortilla esté jugosa es importante que las patatas se hagan bien y se confiten, porque no hay nada peor que una tortilla con las patatas medio crudas.\n" +
                    "Las sacamos de la sartén y escurrimos bien. Ponemos en un cuenco grande, aparte batimos los huevos y los añadimos a las patatas y a la cebolla, añadimos un poco de sal y mezclamos. Dejamos un par de minutos que se mezclen bien. Aquí hay quien prefiere dejar las patatas enteras y quien prefiere machacarlas un poco con la paleta para que se mezclen bien con el huevo. \n" +
                    "Ponemos en la sartén un par de cucharadas de aceite de oliva virgen extra y vertemos todo. Al principio rompemos un poco, como si fuéramos a hacer un revuelto, luego vamos dándole forma  por los bordes. Cuando veamos que ya está cuajada por abajo ponemos un plato o una tapa encima de la sartén y le damos la vuelta rápidamente. Ponemos de nuevo la sartén en el fuego y deslizamos la tortilla desde el plato a la sartén. Dejamos unos minutos más (2 o 3 si te gusta más cuajada, menos si te gusta jugosa) para que se termine de hacer y ya tenemos lista nuestra tortilla de patatas.");
            Notes notaTortilla = new Notes();
            notaTortilla.setNotes("Corta las patatas de manera que las rodajas tengan un espesor similar, para que se cocinen de manera uniforme. La cebolla córtala en juliana, no muy fina, para que no se queme.");
            recetaTortilla.setNotes(notaTortilla);


            recetaTortilla.getCategories().add(category2);
            recetaTortilla.getCategories().add(category3);
            category2.getRecipes().add(recetaTortilla);
            category3.getRecipes().add(recetaTortilla);

            recetaTortilla.getIngredients().add(new Ingredient("huevo", new BigDecimal(5), unitOfMeasure1, recetaTortilla));
            recetaTortilla.getIngredients().add(new Ingredient("papa", new BigDecimal(500), unitOfMeasure3, recetaTortilla));
            recetaTortilla.getIngredients().add(new Ingredient("aceite de oliva", new BigDecimal(1), unitOfMeasure3, recetaTortilla));
            recetaTortilla.getIngredients().add(new Ingredient("cebolla", new BigDecimal(1), unitOfMeasure3, recetaTortilla));
            recetaTortilla.getIngredients().add(new Ingredient("sal", new BigDecimal(1), unitOfMeasure3, recetaTortilla));

            recipeRepository.save(recetaTortilla);
    categoryRepository.save(category1);
    categoryRepository.save(category2);
    categoryRepository.save(category3);
    categoryRepository.save(category4);
    unitOfMeasureRepository.save(unitOfMeasure1);
    unitOfMeasureRepository.save(unitOfMeasure2);
    unitOfMeasureRepository.save(unitOfMeasure3);
        }

    }
}
