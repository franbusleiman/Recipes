package Franciscobusleiman.recipes.recipes.controllers;

import Franciscobusleiman.recipes.recipes.domain.Recipe;
import Franciscobusleiman.recipes.recipes.services.ImageService;
import Franciscobusleiman.recipes.recipes.services.RecipeService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
public class ImageController {

    private final RecipeService recipeService;
    private final ImageService imageService;

    public ImageController (RecipeService recipeService, ImageService imageService){
        this.recipeService = recipeService;
        this.imageService = imageService;
    }

    @GetMapping("recipe/{id}/image")
    public String getImageService(@PathVariable String id, Model model){

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

        return "recipe/formImage";
    }

    @PostMapping("recipe/{id}/SaveImage")
    public String SaveImage(@PathVariable String id, @RequestParam("image") MultipartFile file, Model model) throws IOException {


        imageService.SaveImage(Long.valueOf(id), file);

        model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));


        return "redirect:/recipe/" + id + "/show";
    }

    @RequestMapping("recipe/{id}/recipeimage")
    public void getImage(@PathVariable String id, HttpServletResponse response) throws IOException {
        Recipe recipe = recipeService.findById(Long.valueOf(id));

        if (recipe.getImage() != null) {
            byte[] bytes = new byte[recipe.getImage().length];

            int i = 0;

            for (Byte byte1 : recipe.getImage()) {
                bytes[i++] = byte1;
            }


            response.setContentType("image/jpeg");

            InputStream is = new ByteArrayInputStream(bytes);
            IOUtils.copy(is, response.getOutputStream());
        }
    }

}
