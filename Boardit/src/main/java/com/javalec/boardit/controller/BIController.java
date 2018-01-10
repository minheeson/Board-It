package com.javalec.boardit.controller;

import javax.servlet.http.HttpServletRequest;

import org.junit.runner.Request;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javalec.boardit.command.BICommand;
import com.javalec.boardit.command.BIContentCommand;
import com.javalec.boardit.command.BIDeleteCommand;
import com.javalec.boardit.command.BIListCommand;
import com.javalec.boardit.command.BIModifyCommand;
import com.javalec.boardit.command.BIReplyCommand;
import com.javalec.boardit.command.BIWriteCommand;

@Controller
public class BIController {

	BICommand command;

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("list()");
		/**
		 * 작업 부분은 command한테 시키면 됨
		 */
		command = new BIListCommand();
		command.execute(model);

		return "list";
	}

	@RequestMapping("/write_view")
	public String write_view(Model model) {

		System.out.println("write_view()");
		// 작성 화면(form)만 띄움
		return "write_view";
	}

	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		// 실제 작성
		System.out.println("write()");
		model.addAttribute("request", request);
		command = new BIWriteCommand();
		command.execute(model);

		// 작성하고 나면 다시 리스트 화면으로 이동
		return "redirect:list";
	}

	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) {
		// 컨텐츠를 클릭했을때 콘텐츠를 띄움
		System.out.println("cotent_view()");
		model.addAttribute("request", request);
		command = new BIContentCommand();
		command.execute(model); // 컨텐츠를 보이기 위해서 실제로 데이터를 가져오는건 execute() 안에 작성
		return "contet_view";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("modify()");

		model.addAttribute("reqeust", request);
		command = new BIModifyCommand();
		command.execute(model);

		// 수정 후에는 다시 리스트 화면으로 이동
		return "redirect:list";
	}

	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model) {
		System.out.println("reply_view()");
		
		model.addAttribute("request", request);
		
		// Reply 뷰 보는 리퀘스튼데, 
		// 우리꺼는 필요 없는거 같아서 일단 제외   
		//command = new BIReplyViewCommand();
		//command.execute(model);
		return "reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		
		model.addAttribute("reauest", request);
		command = new BIReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("delete()");
		
		model.addAttribute("request", request);
		command = new BIDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}

}
