package com.example.tourthefrance.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.util.List;
@Entity
public class Biker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private  int id;

     private String firstName;
     private String lastName;
     private double time;
     private int mountainsPoint;
     private int sprintPoints;
     private int age;
     private String country;

     @ManyToOne
     @JoinColumn(name = "team_id")
     private Team team;



    //this is returning team
    public Team getTeam() {
        return team;
    }

    public Biker() {
    }



    public Biker( String firstName, String lastName, double time, int mountainsPoint, int sprintPoints, int age, String country, Team team) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.time = time;
        this.mountainsPoint = mountainsPoint;
        this.sprintPoints = sprintPoints;
        this.age = age;
        this.country = country;
        this.team = team;
    }

    public Biker(String firstName, String lastName, double time, int mountainsPoint, int sprintPoints, int age, String country) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.time = time;
        this.mountainsPoint = mountainsPoint;
        this.sprintPoints = sprintPoints;
        this.age = age;
        this.country = country;
    }

    public int getMountainsPoint() {
        return mountainsPoint;
    }

    public void setMountainsPoint(int mountainsPoint) {
        this.mountainsPoint = mountainsPoint;
    }

    public int getSprintPoints() {
        return sprintPoints;
    }

    public void setSprintPoints(int sprintPoints) {
        this.sprintPoints = sprintPoints;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTeam(Team team){
        this.team = team;
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



    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }




}
