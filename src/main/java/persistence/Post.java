package persistence;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "description", nullable = true, length = 250)
    private String description;
    @Basic
    @Column(name = "image", nullable = false, length = 250)
    private String image;
    @Basic
    @Column(name = "created_date", nullable = false, length = 250)
    private Timestamp createdDate;
    @OneToMany(mappedBy = "post")
    private Collection<Comment> comments;
    @OneToMany(mappedBy = "post")
    private Collection<Like> likes;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }

    public Collection<Like> getLikes() {
        return likes;
    }

    public void setLikes(Collection<Like> likes) {
        this.likes = likes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
