package abstractFactory.dao;

public interface DaoFactory {
    ComputerDao createComputerDao();

    StaffDao createStaffDao();
}
/*  定义的抽象工厂*/
