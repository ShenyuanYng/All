package exer;

import java.util.ArrayList;
import java.util.List;

public class CarOwner {//车主
    private String name;//车主姓名

    private List<ParkingRecord> parkingRecords;//停车记录

    private int totalAmount;//总金额

    private int activePoints;//停车积分

    public CarOwner(String name) {
        this.name = name;
        this.parkingRecords = new ArrayList<>();
        this.activePoints = 0;
        this.totalAmount = 0;
    }

    public void addParkingRecord(ParkingRecord parkingRecord) {
        parkingRecords.add(parkingRecord);
        double hours = parkingRecord.getParkingHours();
        int price = parkingRecord.getCar().parkingPrice(hours);
        this.totalAmount += price;

        hours = parkingRecord.getParkingHours();
        int activePointsIncrement = parkingRecord.getCar().increasePoints(hours);
        this.activePoints+=activePointsIncrement;

    }

    public String toString() {
        return String.format("[%s] Parting %d times, cost %d RMB, activePoints is %d",
                this.name, this.parkingRecords.size(), this.totalAmount, this.activePoints);
    }

    public List<ParkingRecord> getParkingRecords() {
        return parkingRecords;
    }
}
