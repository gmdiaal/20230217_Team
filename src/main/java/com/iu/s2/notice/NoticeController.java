package com.iu.s2.notice;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s2.util.Pager;

@Controller
@RequestMapping (value = "/notice/*")
public class NoticeController {

	@Autowired NoticeService noticeService;

	@RequestMapping (value = "login", method = RequestMethod.GET)
	public String setNoticeLogin () throws Exception {

		return "/notice/login";
	}	
	@RequestMapping (value = "login", method = RequestMethod.POST)
	public ModelAndView setNoticeLogin (NoticeDTO noticeDTO, ModelAndView mv, HttpSession session) throws Exception {
		
		
		System.out.println("컨트롤러로그인전: "+noticeDTO.getPostAuthor());
		noticeDTO=noticeService.setNoticeLogin(noticeDTO);
		System.out.println("컨트롤러로그인후: "+noticeDTO.getPostAuthor());
		
		session.setAttribute("session1", noticeDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}	
	@RequestMapping (value = "logout")
	public String setNoticeLogout (HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:./list";
	}		
	
	@RequestMapping (value = "list")
	public ModelAndView getNoticeList (ModelAndView mv, Pager pager) throws Exception {
		
		mv.addObject("dto", noticeService.getNoticeList(pager));
		mv.addObject("pager", pager);
		mv.setViewName("/notice/list");
		return mv;
	}
	@RequestMapping (value = "add")
	public String setNotice () throws Exception {
		return "/notice/add";
	}
	@RequestMapping (value = "add", method = RequestMethod.POST)
	public String setNotice (NoticeDTO noticeDTO, MultipartFile multipartFile, HttpSession session) throws Exception {
		System.out.println("name: "+multipartFile.getName());
		System.out.println("orgname: "+multipartFile.getOriginalFilename());
		System.out.println("size: "+ multipartFile.getSize());
		System.out.println("session.getServletContext: " + session.getServletContext());
		
		int result = noticeService.setNotice(noticeDTO, multipartFile);
		return "redirect:./list";
	}
//	@RequestMapping(value = "detail")
//	public String getNoticeDetail()throws Exception {
//		return "/notice/detail";
//	}
	@RequestMapping(value = "detail")
	public ModelAndView getNoticeDetail(NoticeDTO noticeDTO, ModelAndView mv)throws Exception {
		
		
		
		System.out.println(noticeDTO.getPostNum());
		//parameter로 dto의 모든 정보를 받아오고 postSeen만 +1 해야댐.
		noticeDTO=noticeService.getNoticeDetail(noticeDTO);
		//noticeDTO.setPostSeen(+1L); //private라서 안먹힘.. mapper에서 하자.
		//db에 입력해야댕...
		noticeService.setNoticeUpdate(noticeDTO);
		
		mv.addObject("dto", noticeDTO);
		mv.setViewName("/notice/detail");
		return mv;
	}

//	@RequestMapping(value = "delete")
//	public String setNoticeDelete() throws Exception {
//		return "/notice/delete";
//	}	
	@RequestMapping(value = "delete")
	public String setNoticeDelete(NoticeDTO noticeDTO) throws Exception {
		noticeService.setNoticeDelete(noticeDTO);
		return "redirect:./list";
	}
	@RequestMapping(value = "update")
	public String setNoticeUpdate() throws Exception {
		return "/notice/update";
	}
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String setNoticeUpdate(NoticeDTO noticeDTO) throws Exception {
		noticeService.setNoticeUpdate(noticeDTO);
		return "redirect:./detail";
	}
	
}
