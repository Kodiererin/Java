package com.BlogBackend.Blog.entity;

import jakarta.persistence.*;



@Entity
@Table(name = "blogdata")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "Heading")
    private String Heading;
    @Column(name = "Body")
    private String Body;

    Blog(){}

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




    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", Heading='" + Heading + '\'' +
                ", Body='" + Body + '\'' +
                '}';
    }
}
