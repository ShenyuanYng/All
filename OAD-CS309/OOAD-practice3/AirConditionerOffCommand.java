/**
 * ClassName: AirConditionerOffCommand
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-11-29 - 23:11
 * @Version: v1.0
 */
public class AirConditionerOffCommand implements Command {

    AirConditioner airConditioner;
    public AirConditionerOffCommand(AirConditioner airConditioner){
        super();
        this.airConditioner = airConditioner;
    }

    @Override
    public void excute() {
        airConditioner.off();
    }

    @Override
    public void undo() {
        airConditioner.on();
    }
}
