package hu.flowacademy.cowstable.repositories;

import hu.flowacademy.cowstable.entities.Cow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CowRepository extends JpaRepository<Cow, Long> {
}
