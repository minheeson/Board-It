package com.sonandhan.boardit.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sonandhan.boardit.command.BICommand;
import com.sonandhan.boardit.command.BIContentCommand;
import com.sonandhan.boardit.command.BIDeleteCommand;
import com.sonandhan.boardit.command.BIListCommand;
import com.sonandhan.boardit.command.BIModifyCommand;
import com.sonandhan.boardit.command.BIReplyCommand;
import com.sonandhan.boardit.command.BIWriteCommand;
import com.sonandhan.boardit.dto.BoardDTO;
import com.sonandhan.boardit.dto.UserDTO;
import com.sonandhan.boardit.service.BoardService;
import com.sonandhan.boardit.service.UserService;

@Controller
public class BIController {

	BICommand command;

	private static final Logger logger = LoggerFactory.getLogger(BIController.class);

	@Inject
	private UserService userService;

	@Inject
	private BoardService boardService;

	private int boardNum = 1;

	// 로그인 화면에서 로그인 버튼 클릭 후
	@RequestMapping(value = "/home")
	public String home(HttpServletRequest request) throws Exception {

		logger.info("home");

		UserDTO loginUser = userService.findByUserIdAndPassword(request.getParameter("userId"),
				request.getParameter("userPassword"));

		System.out.println(">>BIController - login(POST)");
		System.out.println(">>BIController - loginUser : " + loginUser);

		if (loginUser != null) {
			return "home";
		} else {
			return "login";
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "login";
	}

	// 회원가입 페이지 이동 후
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		System.out.println(">>BIController - signup(GET)");
		return "signup";
	}

	// 회원가입 버튼 누른 후 DB삽입
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String signup(Locale locale, Model model, HttpServletRequest request) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		UserDTO user = new UserDTO(request.getParameter("userName"), request.getParameter("userId"),
				request.getParameter("userPassword"));

		System.out.println(">>BIController - signup(POST)");
		System.out.println(">>BIController - signup(POST) user : " + user.getUserName());
		userService.signupUser(user);

		return "signup";
	}

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String profile(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "profile";
	}

	// @RequestMapping("/board")
	// public String board(Model model) {
	//
	// System.out.println("board()");
	// // 작성 화면(form)만 띄움
	// return "board";
	// }

	@RequestMapping(value = "/board", method = RequestMethod.GET)
	public String board(Model model) {

		System.out.println("boardGET()");
		// 작성 화면(form)만 띄움
		return "board";
	}

	// @RequestMapping(value="/board", method = RequestMethod.POST)
	// public String boardPOST(BoardDTO board, Model model) throws Exception {
	//
	// System.out.println("boardPOST()");
	// // 작성 화면(form)만 띄움
	//
	// boardService.registBoard(board);
	// model.addAttribute("result", "success");
	//
	// return "board";
	// }

	//
	// @RequestMapping("/pop_board")
	// public String registerGET(Model model) {
	//
	// System.out.println("pop_board()");
	// // 작성 화면(form)만 띄움
	// return "pop_board";
	// }

	@RequestMapping(value = "/pop_board", method = RequestMethod.GET)
	public String registerGET(Model model) {

		System.out.println("registerGET()");
		// 작성 화면(form)만 띄움
		return "pop_board";
	}

	@RequestMapping(value = "/pop_board", method = RequestMethod.POST)
	public String reqisterPOST(Model model, HttpServletRequest request) throws Exception {
		System.out.println("reqister()");

		BoardDTO board = new BoardDTO(boardNum++, request.getParameter("boardName"), "personal");
		boardService.registBoard(board);
		model.addAttribute("result", "success");

		return "pop_board";
	}

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
		// command = new BIReplyViewCommand();
		// command.execute(model);
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
