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
			//1. 드라이버 로드
			Class.forName(driver);
			
			
			// 2. 계정에 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("계정에 접속");
			
			// 3.sql문 분석
			int up_num = 2;
			String up_name="an";
			String up_addr="부산";
			
//			String sql = "update simple set name='moon', addr='광주' where num=1"; 
//			String sql = "update simple set name='" + up_name +"', addr='" + up_addr + "' where num= " +up_num;
			String sql = "update simple set name=?, addr=? where num=?"; 
			
			ps = conn.prepareStatement(sql);
			System.out.println("분석 끝");
			
			// ? 셋팅
			ps.setString(1,up_name);
			ps.setString(2, up_addr);
			ps.setInt(3, up_num);
			
			
			//4. sql문 실행
			cnt = ps.executeUpdate();
			System.out.println("cnt:"+cnt);
			if(cnt == 0)
				System.out.println("조건에 맞는 레코드 없음");
			else
				System.out.println("update 성공");
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			
		} catch (SQLException e) {
			System.out.println("SQLException");
			
		} finally {
			//5.끊기, 자원 반납
			
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
