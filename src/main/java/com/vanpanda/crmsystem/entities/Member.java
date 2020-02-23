package com.vanpanda.crmsystem.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(columnDefinition = "CHAR(100)")
    private String lastName;

    @Column(columnDefinition = "CHAR(100)")
    private String firstName;

    @Column(columnDefinition = "CHAR(250)")
    private String email;

    @Column(columnDefinition = "INT")
    private int prepaidInCent;

    @Column(columnDefinition = "INT")
    private int points;

    @ManyToOne
    private Membership membership;

    @Column(columnDefinition = "CHAR(100)")
    private String phone;

    @Column(columnDefinition = "CHAR(1000)")
    private String address;

    @Column(columnDefinition = "DATE")
    private Date dateOfBirth;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPrepaidInCent() {
        return prepaidInCent;
    }

    public void setPrepaidInCent(int prepaidInCent) {
        this.prepaidInCent = prepaidInCent;
    }

    public void addPrepaidInCent(int amount) {
        this.prepaidInCent += amount;
    }
}
