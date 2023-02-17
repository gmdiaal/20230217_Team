package com.iu.s2.notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping (value = "/notice/*")
public class NoticeController {

	@Autowired NoticeService noticeService;
	
	@RequestMapping (value = "list")
	public ModelAndView getNoticeList ( ModelAndView mv ) throws Exception {
		mv.addObject("list", noticeService.getNoticeList());
		return mv;
	}
	@RequestMapping (value = "add")
	public String setNotice () throws Exception {
		return "/notice/add";
	}
	@RequestMapping (value = "add", method = RequestMethod.POST)
	public ModelAndView setNotice (NoticeDTO noticeDTO, ModelAndView mv) throws Exception {
		System.out.println("conAdd");
		int result = noticeService.setNotice(noticeDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}
	
}
