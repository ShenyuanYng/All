/**
 * ClassName: AirConditioner
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-11-29 - 23:05
 * @Version: v1.0
 */
public class AirConditioner {
    private String location;
    private boolean airConditionerOn;

    public AirConditioner(String location) {
        this.location = location;
        airConditionerOn = false;
    }

    public void on() {
        airConditionerOn = true;
        System.out.println(this);
    }

    public void off() {
        airConditionerOn = false;
        System.out.println(this);
    }

    public String toString() {
        return String.format("%s: Air Conditioner is %s", location, airConditionerOn ? "On" : "Off");
    }

}

