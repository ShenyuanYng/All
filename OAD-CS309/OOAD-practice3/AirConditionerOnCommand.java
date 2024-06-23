/**
 * ClassName: AirConditionerOnCommand
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-11-29 - 23:08
 * @Version: v1.0
 */
public class AirConditionerOnCommand implements Command{
     AirConditioner airConditioner;

    public AirConditionerOnCommand(AirConditioner airConditioner){
        super();
        this.airConditioner = airConditioner;
    }

    @Override
    public void excute() {
        airConditioner.on();
    }

    @Override
    public void undo() {
        airConditioner.off();
    }
}
