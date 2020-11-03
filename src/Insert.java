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
			//1. 드라이버 로드
			Class.forName(driver);
			
			
			// 2. 계정에 접속
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("계정에 접속");
			
			// 3.sql문 분석
			int in_num = 6;
			String in_name="oh";
			String in_addr="경기";
			
//			String sql = "insert into simple(num,name,addr) values(3,'choi','제주')"   ;
//			String sql = "insert into simple(num,name,addr) values(" + in_num +",'"+ in_name +"','"+ in_addr +"')" ;  
			String sql = "insert into simple(num,name,addr) values(?,?,?)"   ;
			ps = conn.prepareStatement(sql);
			System.out.println("분석끝");
			
			// ?(위치홀더) 셋팅
			ps.setInt(1,in_num);
			ps.setString(2,in_name);
			ps.setString(3,in_addr);
			
			//4. sql문 실행
			cnt = ps.executeUpdate(); // 성공적으로 실행된 갯수가 리턴
			System.out.println("cnt:"+cnt);
			if(cnt == 0)
				System.out.println("insert 실패");
			else
				System.out.println("insert 성공");
			
			
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
					conn.close(); // 자동으로 이루어진다.
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	}

}

