/**
 * ClassName: LightOnCommand
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-11-29 - 23:12
 * @Version: v1.0
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light){
        super();
        this.light = light;
    }

    @Override
    public void excute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
