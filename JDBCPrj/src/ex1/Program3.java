package ex1;

import java.sql.SQLException;
import java.util.Scanner;

import com.newlecture.app.console.NoticeConsole;
import com.newlecture.app.service.NoticeService;

public class Program3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 콘솔창 출력
		NoticeConsole console = new NoticeConsole();
		console.printConsole(); //한페이지에 열개의 데이터만 하도록 //rownum 사용
		int menu = console.inputmenu();
		NoticeService noticeservice = new NoticeService();
		// 메뉴 받아서 그에 맞는 정보 while문으로 돌리기

		switch (menu) {
		case 1: //조회
			break;
		case 2: //이전페이지
			break;
		case 3: //다음페이지
			break;
		case 4: //글쓰기
			break;
		case 5 : //종료
			break; //라벨 붙여서 나다디
		default:
			break;
		}

	}
	
}
