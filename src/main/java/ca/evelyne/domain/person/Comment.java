package ca.evelyne.domain.person;

import javax.persistence.*;
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
    private String content;
    private Date dateAdded;
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
}
