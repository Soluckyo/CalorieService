package org.lib.calorieservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private Gender gender;

    private int age;

    private double height;

    private double weight;

    private Purpose purpose;

    private double dailyCalorie;

    private KFA kfa;

    public User(double height, double weight, Gender gender, int age, Purpose purpose, KFA kfa) {
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.age = age;
        this.purpose = purpose;
        this.kfa = kfa;
        calculateDailyCalories();
    }

    public User() {}

    private void calculateDailyCalories() {
        CalculateDailyCalories calculateDailyCalories = new CalculateDailyCalories();
        this.dailyCalorie = calculateDailyCalories.calculateDailyCalories(height, weight, gender, age, kfa, purpose);
    }

    @Override
    public String toString() {
        return "user: {" + "height=" + height +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", dailyCalories=" + dailyCalorie +
                ", purpose='" + purpose + '\'' +
                ", kfa=" + kfa +
                '}';
    }
}
