package exer;

/**
 * ClassName: VIPCalculate
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-12-20 - 17:48
 * @Version: v1.0
 */
public class VIPCalculate extends Calculate{
    @Override
    public int calculateParkingPrice(double hours) {
        int price = 0;
        price += (int) hours / 24 * 100;
        hours = hours % 24;
        if (hours >= 0.5 && hours <= 24) {
            price += Math.min(15 * (int) hours, 100);
        }
        return price;
    }

    @Override
    public int calculatePoints(double hours) {
        int activePointsIncrement = (int) (hours) / 24 * 2 + 1;
        activePointsIncrement*=2;
        return activePointsIncrement;
    }
}
