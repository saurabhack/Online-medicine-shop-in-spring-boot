package com.luv2code.springboot.demosecurity.entity;

import jakarta.persistence.*;

@Entity
@Table(name="feedback")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="feedbacks")
    private String feedBacks;


    public FeedBack(){

    }

    public FeedBack(String name,  String feedBacks,String rating){
        this.name=name;
        this.feedBacks=feedBacks;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }


    public String getFeedBacks(){
        return feedBacks;
    }

    public void setFeedBacks(String feedBacks){
        this.feedBacks=feedBacks;
   }

   public int getId(){
        return id;
   }

   public void setId(int id){
        this.id=id;
   }


    @Override
    public String toString() {
        return "FeedBack{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", feedBacks='" + feedBacks + '\'' +
                '}';
    }
}
