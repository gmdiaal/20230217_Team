package com.iu.s2.notice;

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
	public String setNotice (NoticeDTO noticeDTO, MultipartFile multipartFile) throws Exception {
		
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
		mv.addObject("dto", noticeService.getNoticeDetail(noticeDTO));
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
