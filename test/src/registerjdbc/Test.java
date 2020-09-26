package registerjdbc;

import java.util.List;

public class Test {
	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		//dao.insertMember(new Member(0, "test@test.com", "1", "원빈"));
		List<Member> ls = dao.selectAll();
		for(Member m : ls) {
			System.out.println(m);
		}
	}
}
