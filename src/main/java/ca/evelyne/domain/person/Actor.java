package ca.evelyne.domain.person;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Actor extends Person {

    /**
     * class fields
     */
//    @OneToMany
//    private List<MovieCharacter> characterList;
    private String cityBornIn;
    private String countryBornIn;

    /**
     * Constructors
     */
    public Actor() {
    }

    public Actor(String firstName, String lastName, String bio, String imageURL, Date birthDate, Gender gender, byte[] image, String cityBornIn, String countryBornIn) {
        super(firstName, lastName, bio, imageURL, birthDate, gender, image);
        this.cityBornIn = cityBornIn;
        this.countryBornIn = countryBornIn;
    }

    /**
     * getters & setters
     */
    public String getCityBornIn() {
        return cityBornIn;
    }

    public void setCityBornIn(String cityBornIn) {
        this.cityBornIn = cityBornIn;
    }

    public String getCountryBornIn() {
        return countryBornIn;
    }

    public void setCountryBornIn(String countryBornIn) {
        this.countryBornIn = countryBornIn;
    }

    //    public List<MovieCharacter> getCharacterList() {
//        return characterList;
//    }
//
//    public void setCharacterList(List<MovieCharacter> characterList) {
//        this.characterList = characterList;
//    }
}
