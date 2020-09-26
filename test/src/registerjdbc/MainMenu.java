package registerjdbc;

import java.util.List;
import java.util.Scanner;

public class MainMenu {
	static Scanner in = new Scanner(System.in);
	static MemberDao dao = new MemberDao();
	
	static void insertProcess() {
		System.out.println("---ȸ������");
		System.out.print("���̵�:");
		String id = in.nextLine();
		System.out.print("��й�ȣ:");
		String pw = in.nextLine();
		System.out.print("�̸�:");
		String name = in.nextLine();
		Member member = new Member(0, id, pw, name);
		dao.insertMember(member);
		System.out.println("���ԵǾ����ϴ�.");
	}
	
	static public void searchProcess() {
		System.out.println("---�˻��ϱ�");
		System.out.print("�˻��� ���̵�:");
		String id = in.nextLine();
		Member searchMember = dao.selectMember(id);
		System.out.println("�˻����");
		System.out.println(searchMember);
	}
	
	static public void updateProcess() {
		System.out.println("---�����ϱ�");
		System.out.print("������ ���̵�:");
		String searchId = in.nextLine();
		Member searchMember = dao.selectMember(searchId);
		System.out.println("������ ���� �Է�");
		System.out.print("��й�ȣ:");
		String pw = in.nextLine();
		System.out.print("�̸�:");
		String name = in.nextLine();
		Member member = new Member(0, searchMember.getId(), pw, name);
		dao.updateMember(searchMember.getNum(), member);
		System.out.println("�����Ǿ����ϴ�.");
	}
	static public void deleteProcess() {
		System.out.println("---�����ϱ�");
		System.out.print("������ ���̵�:");
		String deleteId = in.nextLine();
		Member deleteMember = dao.selectMember(deleteId);
		dao.deleteMember(deleteMember.getNum());
		System.out.println("�����Ǿ����ϴ�.");
	}
	
	static public void printAll() {
		//��ü��Ϻ���
		List<Member> ret = dao.selectAll();
		for(Member tmp : ret) {
			System.out.println(tmp);
		}
	}
	public static void main(String[] args) {
		
		while(true) {
			System.out.println("1.���");
			System.out.println("2.�˻�");
			System.out.println("3.����");
			System.out.println("4.����");
			System.out.println("5.���");
			System.out.print("�Է�:");
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