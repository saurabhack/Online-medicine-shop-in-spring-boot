package com.luv2code.springboot.demosecurity.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="card_details")
public class CardDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Card number is required")
    @Pattern(regexp = "^[0-9]{16}$", message = "Card number must be 16 digits")
    @Column(name = "number")
    private String number;

    @NotBlank(message = "Expiry month is required")
    @Pattern(regexp = "^(january|february|march|april|may|june|july|august|september|october|november|december)$", message = "Invalid expiry month")
    @Column(name = "month")
    private String month;

    @NotBlank(message = "CVV is required")
    @Pattern(regexp = "^[0-9]{3}$", message = "CVV must be a 3-digit number")
    @Column(name = "cvv")
    private String cvv;

    public CardDetails(){

    }
    public CardDetails(String name,String number,String month, String cvv){
        this.name=name;
        this.number=number;
        this.month=month;
        this.cvv=cvv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    @Override
    public String toString(){
        return "Address{"+
                "id="+id+
                ",name='"+name+'\''+
                ",number='"+number+'\''+
                ",month='"+month+'\''+
                ",cvv='"+cvv+'\''+
                '}';
    }
}
