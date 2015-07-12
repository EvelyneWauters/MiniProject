package ca.evelyne.repository;

import ca.evelyne.domain.person.MovieCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Flyne on 12/07/2015.
 */
@Repository
public interface MovieCharacterRepository extends JpaRepository<MovieCharacter, Integer>{
}
