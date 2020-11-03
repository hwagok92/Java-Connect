import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
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
			int up_num = 2;
			String up_name="an";
			String up_addr="�λ�";
			
//			String sql = "update simple set name='moon', addr='����' where num=1"; 
//			String sql = "update simple set name='" + up_name +"', addr='" + up_addr + "' where num= " +up_num;
			String sql = "update simple set name=?, addr=? where num=?"; 
			
			ps = conn.prepareStatement(sql);
			System.out.println("�м� ��");
			
			// ? ����
			ps.setString(1,up_name);
			ps.setString(2, up_addr);
			ps.setInt(3, up_num);
			
			
			//4. sql�� ����
			cnt = ps.executeUpdate();
			System.out.println("cnt:"+cnt);
			if(cnt == 0)
				System.out.println("���ǿ� �´� ���ڵ� ����");
			else
				System.out.println("update ����");
			
			
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
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
	}

}
