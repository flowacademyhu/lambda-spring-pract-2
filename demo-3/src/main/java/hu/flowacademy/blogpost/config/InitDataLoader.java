package hu.flowacademy.blogpost.config;

import hu.flowacademy.blogpost.entity.Category;
import hu.flowacademy.blogpost.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class InitDataLoader implements CommandLineRunner {
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category c1 = new Category("Category 1");
        Category c2 = new Category("Category 2");
        categoryRepository.save(c1);
        categoryRepository.save(c2);

        categoryRepository.findAllByNameIn(List.of(
                "Category 1",
                "Category 2"
        )).forEach(category -> {
            System.out.println(category.getId());
        });
    }
}
