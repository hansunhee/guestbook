package com.sds.icto.guestbook.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.dao.GuestBookDao;
import com.sds.icto.guestbook.vo.GuestBookVo;
import com.sds.icto.guestbook.web.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException,
			IOException {
		request.setCharacterEncoding("utf-8");
		String no=request.getParameter("no");
		String password=request.getParameter("password");
		GuestBookDao dao=new GuestBookDao();
		GuestBookVo vo=dao.selectOne(Long.parseLong(no));
		if(vo.getPassword().equals(password)){
			dao.delete(Long.parseLong(no));		
			response.sendRedirect("/guestbook");
		}else{
			request.setAttribute("msg", "비밀번호를 다시 확인해주세요!");
			request.getRequestDispatcher("/deleteform.jsp").forward(request, response);
		}
	}

}
