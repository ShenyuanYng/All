/**
 * ClassName: Command
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-11-29 - 23:06
 * @Version: v1.0
 */
public interface Command {
    //执行操作
    public void excute();
    //撤销操作
    public void undo();
}
