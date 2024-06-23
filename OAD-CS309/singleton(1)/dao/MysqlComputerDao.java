package singleton.dao;

import singleton.bean.Computer;

public class MysqlComputerDao extends Singleton implements ComputerDao {
    // way 4: double checked locking
    /*双重检查锁定（Double-Checked Locking）的方式。
首先检查 singleton 是否为 null，如果为 null，则进入同步块。
在同步块中，再次检查 singleton 是否为 null，这是为了避免多个线程同时通过了第一个 null 检查，然后都进入同步块创建实例。
如果 singleton 仍然为 null，则通过反射方式创建一个实例，并将其赋值给 singleton。最后，返回 singleton。*/
    private volatile static MysqlComputerDao singleton;

    private MysqlComputerDao() {
    }

    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (MysqlComputerDao.class) {
                if (singleton == null) {
                    try {
                        singleton = MysqlComputerDao.class.getDeclaredConstructor().newInstance();
                    } catch (Exception e) {

                    }
                }
            }
        }
        return singleton;
    }

    @Override
    public int insertComputer(Computer computer) {
        if (computer == null) {
            System.out.println("computer is null");
            return 0;
        } else {
            System.out.println("insert computer into Mysql database successfully");
            return 1;
        }
    }

    @Override
    public int updateComputer(int id) {
        System.out.println("update computer in Mysql database successfully");
        return 1;
    }

    @Override
    public int deleteComputer(int id) {
        System.out.println("delete computer in Mysql database successfully");
        return 1;
    }
}
