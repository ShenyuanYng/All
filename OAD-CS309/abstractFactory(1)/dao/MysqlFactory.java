package abstractFactory.dao;

public class MysqlFactory implements DaoFactory {
    @Override
    public ComputerDao createComputerDao() {
        return new MysqlComputerDao();
    }

    /* 实现的具体工厂*/

    @Override
    public StaffDao createStaffDao() {
        return new MysqlStaffDao();
    }
}
