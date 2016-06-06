package persistence;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Collection;
@Component
@Entity
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "username", nullable = false, length = 250)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 250)
    private String password;
    @Basic
    @Column(name = "name", nullable = true, length = 250)
    private String name;
    @Basic
    @Column(name = "bio", nullable = true, length = 255)
    private String bio;
    @Basic
    @Column(name = "email", nullable = false, length = 250)
    private String email;
    @Basic
    @Column(name = "phone", nullable = true, length = 250)
    private String phone;
    @Basic
    @Column(name = "gender", nullable = true, length = 250)
    private Integer gender;
    @Basic
    @Column(name = "website", nullable = true, length = 250)
    private String website;
    @Basic
    @Column(name = "image", nullable = true, length = 250)
    private String image;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "follower",
            joinColumns = {
                    @JoinColumn(name = "follower_id", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "followee_id", nullable = false, updatable = false)
            }
    )
    private Collection<User> followees;

    @ManyToMany(mappedBy = "followees")
    private Collection<User> followers;

    @OneToMany(mappedBy = "user")
    private Collection<Post> posts;

    @OneToMany(mappedBy = "user")
    private Collection<Like> likes;

    @OneToMany(mappedBy = "user")
    private Collection<Comment> comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    public Collection<User> getFollowees() {
        return followees;
    }

    public void setFollowees(Collection<User> followees) {
        this.followees = followees;
    }

    public Collection<User> getFollowers() {
        return followers;
    }

    public void setFollowers(Collection<User> followers) {
        this.followers = followers;
    }

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(Collection<Post> posts) {
        this.posts = posts;
    }

    public Collection<Like> getLikes() {
        return likes;
    }

    public void setLikes(Collection<Like> likes) {
        this.likes = likes;
    }

    public Collection<Comment> getComments() {
        return comments;
    }

    public void setComments(Collection<Comment> comments) {
        this.comments = comments;
    }
}
