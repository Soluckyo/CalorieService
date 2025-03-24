package org.lib.calorieservice.entity;

public class CalculateDailyCalories {
    public double calculateDailyCalories(double height, double weight, Gender gender, int age, KFA kfa, Purpose purpose) {
        double bm;
        double dailyCalories;
        if(gender == Gender.MALE) {
            bm = (13.397*(weight)) + (4.799*(height)) - (5.677*(age)) + 88.362;
        }else if(gender == Gender.FEMALE) {
            bm = (9.247*(weight)) + (3.098*(height)) - (4.33*(age)) + 447.593;
        }else throw new IllegalArgumentException("Invalid gender");

        dailyCalories = calculateActivity(kfa, bm);
        return calculatePurpose(purpose, dailyCalories);
    }
    public double calculateActivity(KFA kfa, double bm) {
        double dailyCalories = 0;
        if(kfa == KFA.ONE){
            dailyCalories = bm * 1.2;
        }else if(kfa == KFA.TWO){
            dailyCalories = bm * 1.3;
        }else if(kfa == KFA.THREE){
            dailyCalories = bm * 1.6;
        }else if(kfa == KFA.FOUR){
            dailyCalories = bm * 1.7;
        }else if(kfa == KFA.FIVE){
            dailyCalories = bm * 1.9;
        }
        return dailyCalories;
    }

    public double calculatePurpose(Purpose purpose, double dailyCalories) {
        if(purpose == Purpose.GAIN) {
            dailyCalories = dailyCalories * 1.1;
        }else if(purpose == Purpose.LOSS) {
            dailyCalories = dailyCalories * 0.9;
        }
        return dailyCalories;
    }

}
