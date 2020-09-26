package registerjdbc;

import java.util.List;
import java.util.Scanner;

public class MainMenuDao {
	static Scanner in = new Scanner(System.in);
	static MemberDao dao = new MemberDao();
	
	static void insertProcess() {
		System.out.println("---회원가입");
		System.out.print("아이디:");
		String id = in.nextLine();
		System.out.print("비밀번호:");
		String pw = in.nextLine();
		System.out.print("이름:");
		String name = in.nextLine();
		Member member = new Member(0, id, pw, name);
		dao.insertMember(member);
		System.out.println("가입되었습니다.");
	}
	
	static public void searchProcess() {
		System.out.println("---검색하기");
		System.out.print("검색할 아이디:");
		String id = in.nextLine();
		Member searchMember = dao.selectMember(id);
		System.out.println("검색결과");
		System.out.println(searchMember);
	}
	
	static public void updateProcess() {
		System.out.println("---수정하기");
		System.out.print("수정할 아이디:");
		String searchId = in.nextLine();
		Member searchMember = dao.selectMember(searchId);
		System.out.println("수정할 정보 입력");
		System.out.print("비밀번호:");
		String pw = in.nextLine();
		System.out.print("이름:");
		String name = in.nextLine();
		Member member = new Member(0, searchMember.getId(), pw, name);
		dao.updateMember(searchMember.getNum(), member);
		System.out.println("수정되었습니다.");
	}
	static public void deleteProcess() {
		System.out.println("---삭제하기");
		System.out.print("삭제할 아이디:");
		String deleteId = in.nextLine();
		Member deleteMember = dao.selectMember(deleteId);
		dao.deleteMember(deleteMember.getNum());
		System.out.println("삭제되었습니다.");
	}
	
	static public void printAll() {
		//전체목록보기
		List<Member> ret = dao.selectAll();
		for(Member tmp : ret) {
			System.out.println(tmp);
		}
	}
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("1.등록");
			System.out.println("2.검색");
			System.out.println("3.수정");
			System.out.println("4.삭제");
			System.out.println("5.목록");
			System.out.print("입력:");
			int select = Integer.parseInt(in.nextLine());
			switch(select) {
			case 1:insertProcess();break;
			case 2:searchProcess();break;
			case 3:updateProcess();break;
			case 4:deleteProcess();break;
			case 5:printAll();
			}
		}
	}
}
