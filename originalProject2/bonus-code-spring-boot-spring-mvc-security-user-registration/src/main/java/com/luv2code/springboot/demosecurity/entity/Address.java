package com.luv2code.springboot.demosecurity.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotBlank(message = "First name cannot be empty")
    @Column(name="firstname")
    private String firstName;

    @NotBlank(message = "Last name cannot be empty")
    @Column(name="lastName")
    private String lastName;
    @NotBlank(message = "Address cannot be empty")
    @Column(name="address")
    private String address;

    @NotBlank(message = "State cannot be empty")
    @Column(name="state")
    private String state;

    @NotBlank(message = "Zip code cannot be empty")
    @Column(name="zip")
    private String zip;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @Column(name="phone")
    private String phone;

    @NotBlank(message = "City cannot be empty")
    @Column(name="city")
    private String city;
    public Address(){

    }
    public Address(String firstName,String lastName,String address,String city,String phone, String zip,String state){
        this.firstName=firstName;
        this.lastName=lastName;
        this.city=city;
        this.address=address;
        this.phone=phone;
        this.state=state;
        this.zip=zip;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString(){
        return "Address{"+
                "id="+id+
                ",firstname='"+firstName+'\''+
                ",lastName='"+lastName+'\''+
                ",state='"+state+'\''+
                ",city='"+city+'\''+
                ",address='"+address+'\''+
                ",phone='"+phone+'\''+
                ",zip='"+zip+'\''+
                '}';
    }
}

