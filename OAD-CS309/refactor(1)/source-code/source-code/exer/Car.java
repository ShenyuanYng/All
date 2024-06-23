package exer;

import java.util.SplittableRandom;

public class Car {
    String carNumber;//编号
    Calculate calculate;

    public Car(String carNumber) {
        this.carNumber = carNumber;
    }

    public void setCalculate(Calculate calculate) {
        this.calculate = calculate;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public int parkingPrice(double hours){
        return calculate.calculateParkingPrice(hours);
    }
    public int increasePoints(double hours){
        return calculate.calculatePoints(hours);
    }

}
