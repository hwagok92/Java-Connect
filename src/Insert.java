import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
	public static void main(String[] args) {

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "jspid";
		String pw = "jsppw";
		Connection conn = null;
		PreparedStatement ps = null;
		int cnt;
		
		try {
			//1. ����̹� �ε�
			Class.forName(driver);
			
			
			// 2. ������ ����
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("������ ����");
			
			// 3.sql�� �м�
			int in_num = 6;
			String in_name="oh";
			String in_addr="���";
			
//			String sql = "insert into simple(num,name,addr) values(3,'choi','����')"   ;
//			String sql = "insert into simple(num,name,addr) values(" + in_num +",'"+ in_name +"','"+ in_addr +"')" ;  
			String sql = "insert into simple(num,name,addr) values(?,?,?)"   ;
			ps = conn.prepareStatement(sql);
			System.out.println("�м���");
			
			// ?(��ġȦ��) ����
			ps.setInt(1,in_num);
			ps.setString(2,in_name);
			ps.setString(3,in_addr);
			
			//4. sql�� ����
			cnt = ps.executeUpdate(); // ���������� ����� ������ ����
			System.out.println("cnt:"+cnt);
			if(cnt == 0)
				System.out.println("insert ����");
			else
				System.out.println("insert ����");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
			
		} catch (SQLException e) {
			System.out.println("SQLException");
			
		} finally {
			//5.����, �ڿ� �ݳ�
			
			if(ps != null)
				try {
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			if(conn != null)
				try {
					conn.close(); // �ڵ����� �̷������.
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}

}

