package Franciscobusleiman.recipes.recipes.services;

import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.exceptions.NotFoundException;
import Franciscobusleiman.recipes.recipes.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageServiceImpl implements ImageService{

    private final RecipeService recipeService;
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(RecipeService recipeService, RecipeRepository recipeRepository){
        this.recipeService = recipeService;
        this.recipeRepository = recipeRepository;
    }
    @Override
    public void SaveImage(Long id, MultipartFile file) throws IOException {

Optional<Recipe> recipeOptional = recipeRepository.findById(id);

if(! recipeOptional.isPresent()){
    throw new NotFoundException("El recipe con ID: " + id + " no fue encontrado");
}

        Recipe recipe = recipeService.findById(id);

        Byte[] bytes = new Byte[file.getBytes().length];

        int i = 0;

        for(byte byte1 : file.getBytes()){
            bytes[i++] = byte1;
        }

        recipe.setImage(bytes);
       recipeRepository.save(recipe);

    }
}
