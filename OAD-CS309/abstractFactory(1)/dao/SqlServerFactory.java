package abstractFactory.dao;

public class SqlServerFactory implements DaoFactory {
    @Override
    public ComputerDao createComputerDao() {
        return new SqlServerComputerDao();
    }

    /*实现的具体工厂*/

    @Override
    public StaffDao createStaffDao() {
        return new SqlServerStaffDao();
    }
}
