package Franciscobusleiman.recipes.recipes.repositories;

import Franciscobusleiman.recipes.recipes.domain.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class CategoryRepositoryTest {
@Autowired
CategoryRepository categoryRepository;
    @Test
    void findByCategoryName() {
        Optional<Category> category = categoryRepository.findByCategoryName("mexicana");
        assertEquals("mexicana", category.get().getCategoryName());
    }
}