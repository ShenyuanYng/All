package exer;

/**
 * ClassName: InternalCalculate
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-12-20 - 17:50
 * @Version: v1.0
 */
public class InternalCalculate extends Calculate{
    @Override
    public int calculateParkingPrice(double hours) {
        int price = 0;
        price += (int) hours / 24 * 60;
        hours = hours % 24;
        if (hours >= 2 && hours <= 24) {
            price += Math.min(5 * (int) (hours - 2), 60);
        }
        return price;
    }

    @Override
    public int calculatePoints(double hours) {
        int activePointsIncrement = (int) (hours) / 24 * 2 + 1;
        return activePointsIncrement;
    }
}
