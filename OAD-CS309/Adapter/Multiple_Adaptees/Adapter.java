package Adapter.Multiple_Adaptees;

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
    ManageStaffInterface manageStaffInterface;

    public Adapter(FileOperateInterfaceV1 fileOperateInterfaceV1,ManageStaffInterface manageStaffInterface){
        this.fileOperateInterfaceV1 = fileOperateInterfaceV1;
        this.manageStaffInterface = manageStaffInterface;
    }
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
    @Override
    public void addNewStaff(List<StaffModel> list) {
        manageStaffInterface.addingStaff(list);
    }

    @Override
    public void removeStaffByName(List<StaffModel> list) {
        manageStaffInterface.removeStaff(list);
    }

}
