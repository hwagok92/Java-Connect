import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connect {

	public static void main(String[] args) {

		try {
			// 0. jarȭ�� ���Խ�Ű��
			// 1. ����̹� �ε� 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("����̹� �ε� ����");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "jspid";
			String pw = "jsppw";
			
			// 2. ������ ����
			Connection conn = 
					DriverManager.getConnection(url,user,pw);
			
			System.out.println("���� ����");
			
			
//			insert
//			select
//			
			
			
			
			// 5.���Ӳ���
			conn.close();
			System.out.println("���� ���� ����");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			
		} catch (SQLException e) {
			System.out.println("���� ����");
		}
	}

}

