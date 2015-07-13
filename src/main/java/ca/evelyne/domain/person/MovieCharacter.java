package ca.evelyne.domain.person;

import ca.evelyne.domain.film.Movie;

import javax.persistence.*;


@Entity
public class MovieCharacter {
    /**
     * Class fields
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    //TODO: bidirectioneel implementeren:
//    @ManyToOne
//    private Movie movie;

    @ManyToOne
    private Actor actor;

    /**
     * Constructors
     */
    public MovieCharacter() {
    }



    /**
     * setters & getters
     */
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
