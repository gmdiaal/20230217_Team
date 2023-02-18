package com.iu.s2.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s2.util.Pager;

@Controller
@RequestMapping (value = "/notice/*")
public class NoticeController {

	@Autowired NoticeService noticeService;
	
	@RequestMapping (value = "list")
	public ModelAndView getNoticeList (ModelAndView mv, Pager pager) throws Exception {
		
		mv.addObject("list", noticeService.getNoticeList(pager));
		mv.addObject("pager", pager);
		mv.setViewName("/notice/list");
		return mv;
	}
	@RequestMapping (value = "add")
	public String setNotice () throws Exception {
		return "/notice/add";
	}
	@RequestMapping (value = "add", method = RequestMethod.POST)
	public String setNotice (NoticeDTO noticeDTO) throws Exception {
		System.out.println("conAdd");
		int result = noticeService.setNotice(noticeDTO);
		return "redirect:./list";
	}
	
}
