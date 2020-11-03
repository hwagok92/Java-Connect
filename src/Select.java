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
			// 0. jar화일 포함 
			// 1. 드라이버 로드 
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("드라이버 로딩 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String user = "jspid";
			String pw = "jsppw";

			// 2. 계정에 접속
			conn = 
					DriverManager.getConnection(url,user,pw);

			System.out.println("접속 성공");
			
			
			//3. sql문 분석
			String sql = "select * from simple";
			ps = conn.prepareStatement(sql);
			System.out.println("분석 성공");
			
			//4. sql문 실행(select)
			rs = ps.executeQuery();
			System.out.println("실행 성공");
			
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				System.out.println(num +":" + name + "," + addr);
			}
			

			// 5.접속끊기
//			rs.close();
//			ps.close();
//			conn.close();
			
			System.out.println("접속 끊기 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			
		} catch (SQLException e) {
			// DriverManager.getConnection
			// conn.prepareStatement
			// ps.executeQuery()
			// rs.getInt
			// rs.getString
			
			System.out.println("접속 실패");
			
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



