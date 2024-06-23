import java.util.Queue;
import java.util.ArrayDeque;


/**
 * ClassName: RemoteCommandQueue
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-11-29 - 23:21
 * @Version: v1.0
 */
public class RemoteCommandQueue {
    ArrayDeque<Command> commands = new ArrayDeque<>() ;
    ArrayDeque <Command> undoCommand = new ArrayDeque<>();//record the previous command

    public RemoteCommandQueue() {
//        commands = new ArrayDeque<>();
    }

    /**
     * only add command but not execute
     *
     * @param command
     */
    public void buttonPressed(Command command) {
        undoCommand.addLast(command);
        commands.addLast(command);
    }

    /**
     * execute the command in the queue by first-in-first-out principle
     * if there is no command in the queue display "no command"
     */
    public void commandExecute() {
        if (commands.size() == 0){
            System.out.println("no execute command");
        }else {
            Command ex_command = commands.pollFirst();
            ex_command.excute();
        }
    }

    /**
     * undo the previous command
     */
    public void commandUndo() {
        if (undoCommand.size() == 0){
            System.out.println("no undo command");
        }else {
            Command ex_command = undoCommand.pollLast();
            ex_command.undo();
        }
    }
}
