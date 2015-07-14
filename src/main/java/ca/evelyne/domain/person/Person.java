package ca.evelyne.domain.person;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public class Person {

    /**
     * Field variables
     */
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    @Lob
    private String bio;
    private String imageUrl;
    private Date birthDate;
    @Enumerated (EnumType.STRING)
    private Gender gender;
    @Lob
    private byte[] image;

    /**
     * Constructors
     */
    public Person() {
    }

    public Person(String firstName, String lastName, String bio, String imageUrl, Date birthDate, Gender gender, byte[] image) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.imageUrl = imageUrl;
        this.birthDate = birthDate;
        this.gender = gender;
        this.image = image;
    }

    /**
     * Other methods & overrides
     */

    @Override
    public String toString() {
        return "Person " + this.id + " name: " + this.firstName + " " + this.lastName;
    }


    /**
     * Getters & Setters
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
