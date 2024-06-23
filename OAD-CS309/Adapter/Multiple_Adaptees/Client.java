package Adapter.Multiple_Adaptees;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        List<StaffModel> list = new ArrayList<>();
        FileOperateInterfaceV1 adaptee =  new FileOperate();
        ManageStaffInterface manageStaff = new ManageStaff();
        FileOperateInterfaceV2 fileOperator = new Adapter(adaptee,manageStaff);
        Scanner input = new Scanner(System.in);
        System.out.println("Please select operation \n1.readFile \n2.listFile \n3.writeByName \n4.writeByRomm \n5.addStaff \n6.removeStaff");
        int op = 0;
        do {
            try {
                op = input.nextInt();
                switch (op) {
                    case 1:
                        list = fileOperator.readAllStaff();
                        break;
                    case 2:
                        fileOperator.listAllStaff(list);
                        break;
                    case 3:
                        fileOperator.writeByName(list);
                        break;
                    case 4:
                        fileOperator.writeByRoom(list);
                        break;
                    case 5:
                        ((Adapter) fileOperator).addNewStaff(list);
                        break;

                    case 6:
                        ((Adapter) fileOperator).removeStaffByName(list);
                        break;

                }
            } catch (InputMismatchException e) {
                System.out.println("Exception:" + e);
                input.nextLine();
            }
        } while (op != 0);
        input.close();
    }
}
