package com.iu.s2.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManger {

	
	
	
	//File을 HDD에 저장
	public String fileSave(MultipartFile MultipartFile, String path) throws Exception {
		//1. 저장할 위치 지정		
		//프로젝트가 배포되면 톰캣/webapp/... 프로젝트명생성됨 
		//톰캣 주소가 루트가 됨. /resources/upload/bankBook/...확장자
		
		//2. 저장관리는 운영체제가 담당
		//여기선 c:/
		File file = new File(path); //임시폴더의 정보를 갖고잇을게..
		
		//임시파일경로가 오래지나서 사라졋다면
		if(!file.exists()) {
			file.mkdirs();	//없으면 만들어 makedirectories
			//mkdirs() s없으면 중간경로 없이 최종경로 위치만 만듬.
		}
		
		//3. 파일명 생성
		//중복되지 않는 파일명 생성
//		Calendar ca = Calendar.getInstance();
//		ca.getTimeInMillis(); //현재시간은 밀리섹으로
		String name = UUID.randomUUID().toString(); //<- 절대 중복되지 않는 자바클라스
		
		//4. 확장자 추가
			//a. originalname에서 substring을 이용해서 확장자 추출 (.png)
			//b. 걍 붙이기
		name = name+"_"+MultipartFile.getOriginalFilename();
		System.out.println("filemanager: "+name);
		
		//5. 파일을 저장	//파일을 보내지 않으면 size가 0으로 만들어짐. 뒤에붙는 org이름도 없고 xx_됨.
		file = new File(file, name); //parent파일경로에 가서(원래file경로), name(겹치지않게 조작된.)이름으로 저장
		//예) sfafasfa_iu.png
		
		//1). MultipartFile 객체의 transferTo메서드 사용.
		//MultipartFile.transferTo(file);
		
		//2). Spring API FileCopyUnits 객체의 copy메서드 사용
		FileCopyUtils.copy(MultipartFile.getBytes(), file); 
		//byte in=실제 파일데이터, file out=file경로
	
	
		return name;
	
	
	}
	
}
