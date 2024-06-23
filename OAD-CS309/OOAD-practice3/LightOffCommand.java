/**
 * ClassName: LightOffCommand
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-11-29 - 23:14
 * @Version: v1.0
 */
public class LightOffCommand implements Command{
    Light light;

    public LightOffCommand(Light light){
        super();
        this.light = light;
    }

    @Override
    public void excute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
