import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Select {
	public static void main(String[] args) {

		Connection conn= null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		
		try {
			// JDBC(Java DataBase Connect)
			// 0. jarȭ�� ���� 
			// 1. ����̹� �ε� 
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("����̹� �ε� ����");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "jspid";
			String pw = "jsppw";

			// 2. ������ ����
			conn = 
					DriverManager.getConnection(url,user,pw);

			System.out.println("���� ����");
			
			
			//3. sql�� �м�
			String sql = "select * from simple";
			ps = conn.prepareStatement(sql);
			System.out.println("�м� ����");
			
			//4. sql�� ����(select)
			rs = ps.executeQuery();
			System.out.println("���� ����");
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				System.out.println(num +":" + name + "," + addr);
			}
			

			// 5.���Ӳ���
//			rs.close();
//			ps.close();
//			conn.close();
			
			System.out.println("���� ���� ����");
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			
		} catch (SQLException e) {
			// DriverManager.getConnection
			// conn.prepareStatement
			// ps.executeQuery()
			// rs.getInt
			// rs.getString
			
			System.out.println("���� ����");
			
		} finally {
			try {
				if(rs != null)
					rs.close();
				
				if(ps != null)
					ps.close();
				
				if(conn != null)
					conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}
}



