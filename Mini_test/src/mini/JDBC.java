package mini;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class JDBC {
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String user = "system";
    private static String password = "bin852456";
     
	 public static Connection connect() {  
	        try {
	            // 1단계 : 오라클 드라이버를 동적으로 메모리로 로딩.
	            Class.forName(driver);

	            return DriverManager.getConnection(url, user, password);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
}
