package ca.evelyne.domain.movie;

import ca.evelyne.domain.person.User;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.sql.Date;


@Entity
public class Comment {
    /**
     * Class fields
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Lob
    @NotBlank
    private String content;

    private Date dateAdded;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private User user;



    /**
     * Constructors
     */
    public Comment() {
    }


    public Comment(String content, User user) {
        this.content = content;
        this.user = user;
    }

    /**
     * other methods
     */


    /**
     * Getters & Setters
     */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

}
