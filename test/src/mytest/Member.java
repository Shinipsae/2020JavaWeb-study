package mytest;

import java.util.Scanner;

class Member{ // Member  클래스

	static String[][] member = new String[100][5]; // 값을 저장할 member 이차원 배열선언
	static int count = 0;	// 배열 행 값으로 쓰일 변수
	
	public void input() {	// 회원정보를 입력하는 메서드	
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		int serialNum = 0;  // index 0
		String id;			// index 1
		String password;	// index 2
		String name;		// index 3
		String date;		// index 4
		String choice;		// index 5
		
		count++; // 행 값 증가
		serialNum++; // 일련번호 값 증가
		
		member[count][0] = Integer.toString(serialNum); // 일련번호 값 삽입
		
		System.out.println("\n---------- 회원정보 입력 --------");
		System.out.print("아이디를 입력하세요: ");
		id = sc.next();
		member[count][1] = id; // 아이디 값 삽입
		
		System.out.print("비밀번호를 입력하세요: ");
		password = sc.next();
		member[count][2] = password; //비밀번호 값 삽입
		
		System.out.print("이름을 입력하세요: ");
		name = sc.next();
		member[count][3] = name; // 이름 값 삽입
		
		System.out.print("가입일을 입력하세요: ");
		date = sc.next();
		member[count][4] = date; // 가입일 값 삽입
		
		while(true) {
			System.out.println("아이디: " + id + "  비밀번호: " + password + "  이름: " + name + "  가입일: " + date); // 입력한 정보 확인
			System.out.print("입력하신 정보가 맞습니까? (y/n) >> ");
			choice = sc.next();
			
			if(choice.equals("y") || choice.equals("Y")) { // 입력한 정보가 맞았을 경우
				System.out.println("입력이 완료되었습니다.  \n");
				break;
				
			} else if(choice.equals("n") || choice.equals("N")) { // 입력한 정보가 틀렸을 경우
				System.out.println("회원정보를 다시 입력해주세요.");
				input();
				break;
				
			} else { // 문자를 잘못 입력했을 경우
				System.out.println("\n잘못 입력하셨습니다. y또는 n을 입력해주세요. ");
			}
			
		}
	
	}
	
	public void search() { // 회원정보를 검색하는 메서드
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		String id;
		String password;
		boolean isExist = false;
		
		System.out.println("\n---------- 회원정보 검색 --------");
		System.out.print("아이디를 입력하세요: ");
		id = sc.next();
		System.out.print("비밀번호를 입력하세요: ");
		password = sc.next();
		
		for(int i = 1; i <= count; i++) {
			if(member[i][1].equals(id) && member[i][2].equals(password)) { // 아이디와 비밀번호가 맞는 경우
				System.out.println("\n" + member[i][3] + "님의 회원정보입니다."); // member[i][3]은 name을 대체
				System.out.println("-------------------------------");
				System.out.println("회원 일련번호: " + member[i][0]);
				System.out.println("회원 아이디: " + member[i][1]);
				System.out.println("회원 비밀번호: " + member[i][2]);
				System.out.println("회원 이름: " + member[i][3]);
				System.out.println("회원 가입일: " + member[i][4]);
				isExist = true;
			} 
			
		}
		
		if(isExist == false) {
			System.out.println("아이디와 비밀번호가 올바르지 않습니다.");
			search();
		}
		
	}
	
	public void edit() { // 회원정보를 수정하는 메서드
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		String id;
		String old_password;
		String new_password;
		String new_password2;
		boolean isExist = false;
		
		System.out.println("\n---------- 비밀번호 수정 --------");
		System.out.print("아이디를 입력하세요 : ");
		id = sc.next();
		System.out.print("기존 비밀번호를 입력하세요: ");
		old_password = sc.next();
		
		for(int i = 1; i <= count; i++) { 
			if(member[i][1].equals(id) && member[i][2].equals(old_password)) { // 아이디와 비밀번호가 맞는 경우
				System.out.print("새로운 비밀번호를 입력하세요: ");
				new_password = sc.next();
				System.out.print("비밀번호 확인: ");
				new_password2 = sc.next();
					
				if(new_password.equals(new_password2)) { // 비밀번호 확인이 맞는 경우
					member[i][2] = new_password;
					System.out.println("비밀번호가 변경되었습니다.");
					isExist = true;
					
				} else { // 비밀번호 확인이 틀린 경우
					System.out.println("비밀번호가 틀렸습니다.");
					break;
				}
					
			} 
	
		}
		
		if(isExist == false) {
			System.out.println("아이디와 비밀번호가 올바르지 않습니다.");
			edit();
		}
		
	}
	
	public void delete() { // 회원정보를 삭제하는 메서드
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		String id;
		String password;
		boolean isExist = false;
		
		System.out.println("\n---------- 회원정보 삭제 --------");
		System.out.print("아이디를 입력하세요: ");
		id = sc.next();
		System.out.print("비밀번호를 입력하세요: ");
		password = sc.next();
		
		for(int i = 1; i <= count; i++) {
			if(member[i][1].equals(id) && member[i][2].equals(password)) { // 아이디와 비밀번호가 맞는 경우
				isExist = true;
				for(int j = 0; j < 5; j++) {
					member[i][j] = null;
				}
				
			}
			
			if(isExist == false) {
				System.out.println("아이디와 비밀번호가 올바르지 않습니다.");
				delete();
			}
			
		}
		
		System.out.println("회원 정보가 삭제되었습니다.");
		
	}
	
	public void test() { // 디버깅용 메서드 (회원정보 전체 출력)
		
		for(int i = 1; i <= count; i++) {
			
			for(int j = 0; j < 5; j++) {
				System.out.print(member[i][j]);
			}
			System.out.println();
			
		}
		
	}
	
}