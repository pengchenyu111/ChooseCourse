package test;
import test.LoginFrame;
public class Main {
	public static void main(String[] args) {
		
		String DBDriver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String DBURL="jdbc:sqlserver://localhost:1433;DatabaseName = class_system";
		String DBUser="root";
		String DBPass="PCY90321";
		MyDBConnection myDB=new MyDBConnection(DBDriver,DBURL,DBUser,DBPass);
		LoginFrame logf = new LoginFrame(myDB);
	}

}
