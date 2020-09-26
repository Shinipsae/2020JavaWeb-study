package registerjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Deprecated
//데이터베이스에 접근하는 객체
public class MemberDao {
	// 전체 목록을 가져오는 메서드
	List<Member> selectAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null; // selecr 결과 저장
		ArrayList<Member> ret = new ArrayList<>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC드라이버 로딩 완료!");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "tester", "1234");
			String sql = "select * from \"MEMBER\"";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String pw = rs.getString("PW");
				String name = rs.getString("NAME");
				Member tmp = new Member(num, id, pw, name);
				ret.add(tmp);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ret;
	}

	// 멤버 검색
	public Member selectMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC드라이버 로딩 완료!");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "tester", "1234");
			String sql = "select NUM, ID, PW, NAME from \"MEMBER\" where ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	// 데이터베이스에 Member를 등록하는 메서드 작성
	public void insertMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC드라이버 로딩 완료!");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "tester", "1234");

			String sql = "insert into \"MEMBER\" values (\"MEMBER_SEQ\".nextval, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			int ret = pstmt.executeUpdate(); // 쿼리전송 및 결과 반환
			System.out.println(ret + "행이 삽입되었습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// 데이터베이스에 Member정보를 수정하는 메서드 작성
	public void updateMember(int seq, Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC드라이버 로딩 완료!");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "tester", "1234");

			String sql = "update \"MEMBER\" set PW = ?, NAME = ? where NUM = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setInt(3, seq);
			int ret = pstmt.executeUpdate();
			System.out.println(ret + "행이 수정되었습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 데이터베이스에 Member정보를 삭제하는 메서드 작성
	public void deleteMember(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("JDBC드라이버 로딩 완료!");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "tester", "1234");
			String sql = "delete from \"MEMBER\" where NUM = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, seq);
			int ret = pstmt.executeUpdate();
			System.out.println(ret + "행이 삭제되었습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
