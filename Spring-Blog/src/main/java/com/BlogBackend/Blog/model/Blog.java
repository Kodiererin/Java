package com.BlogBackend.Blog.model;

import java.util.Arrays;

public class Blog {
    private int id;
    private String Heading;
    private String Body;
    private String [] images;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeading() {
        return Heading;
    }

    public void setHeading(String heading) {
        Heading = heading;
    }

    public String getBody() {
        return Body;
    }

    public void setBody(String body) {
        Body = body;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }


    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", Heading='" + Heading + '\'' +
                ", Body='" + Body + '\'' +
                ", images=" + Arrays.toString(images) +
                '}';
    }
}
