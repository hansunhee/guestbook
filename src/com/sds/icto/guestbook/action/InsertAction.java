package com.sds.icto.guestbook.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.dao.GuestBookDao;
import com.sds.icto.guestbook.vo.GuestBookVo;
import com.sds.icto.guestbook.web.Action;


public class InsertAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException,
			IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String pw=request.getParameter("pass");
		String content=request.getParameter("content");
		GuestBookDao dao=new GuestBookDao();
		dao.add(new GuestBookVo(name, pw, content));
		response.sendRedirect("/guestbook");
	}

	
	
}
