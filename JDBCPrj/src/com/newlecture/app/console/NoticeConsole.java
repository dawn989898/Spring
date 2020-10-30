package com.newlecture.app.console;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.newlecture.app.entity.Notice;
import com.newlecture.app.service.NoticeService;

public class NoticeConsole {
	
	
	public void printConsole() throws ClassNotFoundException, SQLException {
		
		NoticeService service = new NoticeService();
		List<Notice> list = service.getList();
		
		
		
		System.out.printf("<공지사항> 총 %d개의 게시글\n", list.size());
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		for(Notice n : list) {
		System.out.printf("%d. %s / %s / %s\n", n.getId(), n.getContent(), n.getWrited_id(), n.getRegdate());
			
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");		
		System.out.printf("		1/3 pages\n", 12);
		System.out.println("");

	}

	public int inputmenu() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1.상세조회/ 2.이전/ 3.다음/ 4.글쓰기 > ");
		String menu_ = sc.nextLine();
		int menu = Integer.parseInt(menu_);//검사해서 바꿀수 있을때만 바꾸도록 하기
		sc.close();
		
		return menu;
	}

}
