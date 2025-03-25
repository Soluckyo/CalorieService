package org.lib.calorieservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int age;

    private double height;

    private double weight;

    @Enumerated(EnumType.STRING)
    private Purpose purpose;

    private double dailyCalorie;

    @Enumerated(EnumType.STRING)
    private KFA kfa;

    @ManyToOne(fetch = FetchType.LAZY)
    private Meal meal;

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
