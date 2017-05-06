package com.example.luizh.cadastroaluno;

/**
 * Created by luizh on 24/03/2017.
 */

public class Aluno {

    private Long id;
    private String name;
    private String phone;
    private String link;

    public String toString(){ return "Code: " + id + "    Name: " + name +  "     Phone: " + phone ;}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public void setLink(String link) { this.link = link; }
    public String getLink() {
        return link;
    }
}