package ca.evelyne.vdab.repository;

import ca.evelyne.vdab.domain.Brand;
import ca.evelyne.vdab.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
    List<Model> findByBrand(Brand b);
}
