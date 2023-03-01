package com.alan.pluginhost.news.joke;

import java.util.List;


public class Joke {
    /*"group":Object{...},
            "comments":Array[0],
            "type":1,
            "display_time":1469698061,
            "online_time":1469698061*/
    private JokeContent group;
    private List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public JokeContent getGroup() {
        return group;
    }

    public void setGroup(JokeContent group) {
        this.group = group;
    }
}
