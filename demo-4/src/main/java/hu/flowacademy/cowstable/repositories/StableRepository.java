package hu.flowacademy.cowstable.repositories;

import hu.flowacademy.cowstable.entities.Stable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StableRepository extends JpaRepository<Stable, Long> {
}
