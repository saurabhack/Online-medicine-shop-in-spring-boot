package com.luv2code.springboot.demosecurity.entity;

import jakarta.persistence.*;

@Entity
@Table(name="contact")
public class contactUs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="email")
    private String email;

    @Column(name="message")
    private String message;

    public contactUs(){

    }
    public contactUs(String name, String email,String number, String message){
        this.name=name;
        this.email=email;
        this.message=message;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }


    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message=message;
    }


    @Override
    public String toString(){
        return "contactUs{"+"id="+id+",name='"+name+",email='"+email+",message='"+message+"}";
    }
}
