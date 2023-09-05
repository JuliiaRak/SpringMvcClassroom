package com.api.classroom.domain;

import javax.persistence.*;

@Entity
public class Query {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String comment;
    private String admin;
    private boolean checked;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User author;

    public Query() {
    }

    public Query(String comment, boolean checked, User user, String admin) {
        this.author = user;
        this.comment = comment;
        this.checked = checked;
        this.admin = admin;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}
