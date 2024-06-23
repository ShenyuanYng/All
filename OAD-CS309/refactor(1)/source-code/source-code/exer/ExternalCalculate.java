package exer;

/**
 * ClassName: ExternalCalculate
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-12-20 - 17:49
 * @Version: v1.0
 */
public class ExternalCalculate extends Calculate{
    @Override
    public int calculateParkingPrice(double hours) {
        int price = 0;
        price += (int) (hours / 24) * 60;
        hours = hours % 24;
        if (hours >= 0.5 && hours < 1) {
            price += 15;
        } else if (hours >= 1) {
            price = Math.min(15 + 5 * ((int) hours - 1), 60);
        }
        return price;
    }

    @Override
    public int calculatePoints(double hours) {
        int activePointsIncrement = (int) (hours) / 24 * 2 + 1;
        return activePointsIncrement;
    }
}
