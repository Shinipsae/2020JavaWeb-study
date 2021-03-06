package mytest;

import java.util.InputMismatchException;
import java.util.Scanner;

// 회원정보를 입력받아 저장하는 기능: 일련번호, 아이디, 비밀번호, 이름, 가입일을 저장
// 회원정보 검색 기능: 아이디와 비밀번호를 이용하여 회원정보 반환
// 비밀번호 수정 기능: 아이디, 기존 비밀번호, 새로운 비밀번호를 이용하여 새로운 비밀번호로 변경
// 회원정보를 삭제하는 기능: 아이디와 비밀번호를 이용하여 회원정보 삭제

public class MemberDriver {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int option;
		
		while(true) {
			Member member = new Member();
			
			System.out.println("\n******** 회원관리 프로그램 ********");
			System.out.println("**** 원하시는 메뉴를 선택하세요. ****");
			System.out.println("  1. 회원정보 등록");
			System.out.println("  2. 회원정보 검색");
			System.out.println("  3. 비밀번호 수정");
			System.out.println("  4. 회원정보 삭제");
			System.out.println("  5. 프로그램 종료");
			System.out.println("------------------------------");
			System.out.print(">> ");
			
			try {
				option = sc.nextInt();
				
				if(option == 1) {	// 회원정보 등록		
					member.input();
					
				} else if(option == 2) { // 회원정보 검색		
					member.search();
					
				} else if(option == 3) { // 비밀번호 수정
					member.edit();

				} else if(option == 4) { // 회원정보 삭제		
					member.delete();

				} else if(option == 5) { // 프로그램 종료		
					System.out.println("프로그램을 종료합니다.");
					break;
					
				} else if(option == 0) { // 디버깅 테스트	
					System.out.println("테스트");
					
				} else { // 번호를 잘못 입력했을 경우
					System.out.println("번호를 잘못입력하셨습니다. 다시 입력해주세요.");
				}
				
			} catch(InputMismatchException e) { // 숫자 이외의 문자열을 입력했을 경우
				System.out.println("1~5 사이의 숫자를 입력해주세요.");
				main(args); // main() 재시작
			}
			
		}
		
	}

}
