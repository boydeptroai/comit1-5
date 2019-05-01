package Model;
import java.sql.*;
public class DBConnection {
	Connection conn=null;// quan ly ket noi
    public DBConnection(String URL, String userName,
            String password){
        try {
            //username,password: account login SQLserver
            //URL: đường dẫn đến SQL server và database
            //goi driver
            //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        	Class.forName("com.mysql.cj.jdbc.Driver");
            //tao ket noi
            conn=DriverManager.getConnection(URL,userName, password);
            System.out.println("connected");
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        	ex.printStackTrace();
        } catch (SQLException ex) {
           // Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        	ex.printStackTrace();
        }
      }
    public DBConnection() {
        this("jdbc:mysql://localhost:3306/tttn?useUnicode=true&characterEncoding=UTF-8",
                "root","");
    }
    public Connection getConnection(){
        return conn;
    }

	public static void main(String[] args) {
		//Connection connection=getJDBCConnection();
//		if(connection!=null) {
//			System.out.println("thanhcong");
//		}else {
//			System.out.println("thatbai");
//		}
		new DBConnection();
	}
}
