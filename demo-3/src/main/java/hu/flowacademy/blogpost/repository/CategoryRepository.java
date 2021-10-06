package hu.flowacademy.blogpost.repository;

import hu.flowacademy.blogpost.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Set<Category> findAllByNameIn(List<String> names);
}
