import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;

/**
 * The script is provided by Stephane Faroult
 * Delete load.cnf by ZHU Yueming
 */
public class BeforeTriggerScript {

    private static Connection         con = null;
    private static PreparedStatement  stmt = null;
    private static boolean            verbose = false;

    private static void openDB(String host, String dbname,
                               String user, String pwd) {
        try {
            //
            Class.forName("org.postgresql.Driver");
        } catch(Exception e) {
            System.err.println("Cannot find the Postgres driver. Check CLASSPATH.");
            System.exit(1);
        }
        String url = "jdbc:postgresql://" + host + "/" + dbname;
        Properties props = new Properties();
        props.setProperty("user", user);
        props.setProperty("password", pwd);
        try {
            con = DriverManager.getConnection(url, props);
            if (verbose) {
                System.out.println("Successfully connected to the database "
                        + dbname + " as " + user);
            }
            con.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println("Database connection failed");
            System.err.println(e.getMessage());
            System.exit(1);
        }
        try {
            stmt = con.prepareStatement("insert into students(studentid,name)"
                    + " values(?,?)");
        } catch (SQLException e) {
            System.err.println("Insert statement failed");
            System.err.println(e.getMessage());
            closeDB();
            System.exit(1);
        }
    }

    private static void closeDB() {
        if (con != null) {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                con.close();
                con = null;
            } catch (Exception e) {
                // Forget about it
            }
        }
    }

    private static void loadData(String studentid, String name)
            throws SQLException {
        if (con != null) {
            stmt.setString(1, studentid);
            stmt.setString(2, name);
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        String  fileName = null;
        boolean verbose = false;

        switch (args.length) {
            case 1:
                fileName = args[0];
                break;
            case 2:
                switch (args[0]) {
                    case "-v":
                        verbose = true;
                        break;
                    default:
                        System.err.println("Usage: java [-v] BeforeTriggerScript filename");
                        System.exit(1);
                }
                fileName = args[1];
                break;
            default:
                System.err.println("Usage: java [-v] BeforeTriggerScript filename");
                System.exit(1);
        }


        Properties defprop = new Properties();
        defprop.put("host", "localhost");
        defprop.put("user", "checker");
        defprop.put("password", "123456");
        defprop.put("database", "cs307");
        Properties prop = new Properties(defprop);

        if (verbose) {
            // Display configuration
            System.out.println("host     : "+prop.getProperty("host"));
            System.out.println("database : "+prop.getProperty("database"));
            System.out.println("user     : "+prop.getProperty("user"));
            System.out.println("password : (not shown)");
        }
        openDB(prop.getProperty("host"), prop.getProperty("database"),
                prop.getProperty("user"), prop.getProperty("password"));
        try (BufferedReader infile
                     = new BufferedReader(new FileReader(fileName))) {
            if (verbose) {
                System.out.println("loading " + fileName);
            }
            String   line;
            String[] parts;
            String   studentid;
            String   name;
            int      cnt = 0;
            while ((line = infile.readLine()) != null) {
                parts = line.split("\"");
                if ((parts.length > 1) && !parts[0].startsWith("Student")) {
                    studentid = parts[0].replace(",", "");
                    name = parts[1];
                    loadData(studentid, name);
                    cnt++;
                }
            }
            con.commit();
            if (verbose) {
                System.out.println(cnt + " records successfully loaded");
            }
        } catch (SQLException se) {
            System.err.println("SQL error: " + se.getMessage());
            try {
                con.rollback();
            } catch (SQLException se2) {
                // Ignore
            }
            closeDB();
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Fatal error: " + e.getMessage());
            closeDB();
            System.exit(1);
        }
        closeDB();
    }
}

