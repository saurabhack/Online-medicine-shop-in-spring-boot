package com.luv2code.springboot.demosecurity.entity;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String brand;
    private String category;
    private double price;

    @Column(columnDefinition = "TEXT")
    private String description;
    private Date createAt;
    private String imageFileName;

    @OneToMany(mappedBy = "products")
    private List<CartItem> cartItems;

    public List<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand(){
        return brand;
    }

    public void setBrand(String brand){
        this.brand=brand;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category=category;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getImageFileName(){
        return imageFileName;
    }

    public void setImageFileName(String imageFileName){
        this.imageFileName=imageFileName;
    }

    public Date getCreateAt(){
        return createAt;
    }
    public void setCreateAt(Date createAt){
        this.createAt=createAt;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price=price;
    }


    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", createAt=" + createAt +
                ", imageFileName='" + imageFileName + '\'' +
                '}';
    }


}

