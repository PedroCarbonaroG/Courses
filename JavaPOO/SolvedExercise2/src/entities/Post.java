package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Post {
    
    private Date moment;
    private String title;
    private String content;
    private short likes;

    private List<Comment> comments = new ArrayList<>();

    public Post() {

    }
    public Post(Date moment, String title, String content, short likes) {
        this.moment = moment;
        this.title = title;
        this.content = content;
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }
    public String getContent() {
        return content;
    }
    public short getLikes() {
        return likes;
    }
    public Date getMoment() {
        return moment;
    }
    public String getTitle() {
        return title;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public void setLikes(short likes) {
        this.likes = likes;
    }
    public void setMoment(Date moment) {
        this.moment = moment;
    }
    public void setTitle(String title) {
        this.title = title;
    }

}
