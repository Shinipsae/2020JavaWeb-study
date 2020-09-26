package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.model.persistence.JdbcTemplate;
import member.model.persistence.Member;

//데이터베이스에 접근하는 객체
public class MemberDao {
	
	private static MemberDao instance = new MemberDao();
	
	private MemberDao() {}
	public static MemberDao getInstance() {
		return instance;
	}
	private JdbcTemplate jdbcTemplate = JdbcTemplate.getInstance();
	//전체 목록을 가져오는 메서드
	public List<Member> selectAll(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;	//selecr 결과 저장
		ArrayList<Member> ret = new ArrayList<>();
		try {
			conn = jdbcTemplate.getConnection();
			String sql = "select NUM, ID, PW, NAME from \"MEMBER\"";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String pw = rs.getString("PW");
				String name = rs.getString("NAME");
				Member tmp = new Member(num, id, pw, name);
				ret.add(tmp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		jdbcTemplate.close(stmt);
		jdbcTemplate.close(conn);
		
		return ret;
	}
	
	//멤버 검색
	public Member selectMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member member = null;
		try {
			conn = jdbcTemplate.getConnection();
			String sql = "select NUM, ID, PW, NAME from \"MEMBER\" where ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new Member(
						rs.getInt(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		jdbcTemplate.close(rs);
		jdbcTemplate.close(pstmt);
		jdbcTemplate.close(conn);
		
		return member;
	}
	
	//데이터베이스에 Member를 등록하는 메서드 작성
	public void insertMember(Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = jdbcTemplate.getConnection();
			
			String sql = 
					"insert into \"MEMBER\" values (\"MEMBER_SEQ\".nextval, ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			int ret = pstmt.executeUpdate();	//쿼리전송 및 결과 반환
			System.out.println(ret + "행이 삽입되었습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		jdbcTemplate.close(pstmt);
		jdbcTemplate.close(conn);
	}

	//데이터베이스에 Member정보를 수정하는 메서드 작성
	public void updateMember(int seq, Member member) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = jdbcTemplate.getConnection();
			String sql = "update \"MEMBER\" set PW = ?, NAME = ? where NUM = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setInt(3, seq);
			int ret = pstmt.executeUpdate();
			System.out.println(ret + "행이 수정되었습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		jdbcTemplate.close(pstmt);
		jdbcTemplate.close(conn);
	}
	
	//데이터베이스에 Member정보를 삭제하는 메서드 작성
	public void deleteMember(int seq) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = jdbcTemplate.getConnection();
			String sql = "delete from \"MEMBER\" where NUM = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setInt(1, seq);
			int ret = pstmt.executeUpdate();
			System.out.println(ret + "행이 삭제되었습니다.");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		jdbcTemplate.close(pstmt);
		jdbcTemplate.close(conn);
	}
}




