/**
 * ClassName: Light
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-11-29 - 23:04
 * @Version: v1.0
 */
public class Light {
    private String location;
    private boolean lightOn;

    public Light(String location) {
        this.location = location;
        lightOn = false;
    }

    public void on() {
        lightOn = true;
        System.out.println(this);
    }

    public void off() {
        lightOn = false;
        System.out.println(this);
    }

    public String toString() {
        return String.format("%s: Light is %s", location, lightOn ? "On" : "Off");
    }
}

