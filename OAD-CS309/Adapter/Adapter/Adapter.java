package Adapter.Adapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: Adapter
 * Package: IntelliJ IDEA
 * Description:
 *
 * @Author: Eddie_Wang
 * @Create: 2023-12-12 - 20:29
 * @Version: v1.0
 */
public class Adapter implements FileOperateInterfaceV2{
    FileOperateInterfaceV1 fileOperateInterfaceV1;

    public Adapter(FileOperateInterfaceV1 fileOperateInterfaceV1){
        this.fileOperateInterfaceV1 = fileOperateInterfaceV1;
    }

    /*调用了 FileOperateInterfaceV1 的 readStaffFile() 方法，将 FileOperateInterfaceV1 的接口适配成了 FileOperateInterfaceV2。*/
    /*调用 fileOperateInterfaceV1 对应的方法，将其适配成 FileOperateInterfaceV2 接口所要求的形式*/
    @Override
    public List<StaffModel> readAllStaff() {
        return fileOperateInterfaceV1.readStaffFile();
    }

    @Override
    public void listAllStaff(List<StaffModel> list) {
        fileOperateInterfaceV1.printStaffFile(list);
    }

    @Override
    public void writeByName(List<StaffModel> list) {
        var temp = list.toArray(new StaffModel[0]);
        System.out.println(Arrays.toString(temp));
        Arrays.sort(temp, (x, y) -> x.getName().compareTo(y.getName()));
        System.out.println("************************************");
        System.out.println(Arrays.toString(temp));
        fileOperateInterfaceV1.writeStaffFile(Arrays.stream(temp).collect(Collectors.toList()));
    }
    @Override
    public void writeByRoom(List<StaffModel> list) {
        var temp = list.toArray(new StaffModel[0]);
        System.out.println(Arrays.toString(temp));
        Arrays.sort(temp, (x, y) -> x.getRoom().compareTo(y.getRoom()));
        System.out.println("************************************");
        System.out.println(Arrays.toString(temp));
        fileOperateInterfaceV1.writeStaffFile(Arrays.stream(temp).collect(Collectors.toList()));
    }
}
/*将排序后的 List<StaffModel> 传递给 FileOperateInterfaceV1，实现了对 FileOperateInterfaceV2 的适配*/