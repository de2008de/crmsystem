package com.vanpanda.crmsystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "Memberships")
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "CHAR(250)")
    private String name;
    
    @Column(columnDefinition = "CHAR(500)")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
