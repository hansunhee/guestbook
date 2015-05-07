package com.sds.icto.guestbook.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.web.Action;
import com.sds.icto.guestbook.web.WebUtil;

public class DeleteFormAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, SQLException, ServletException,
			IOException {
		String no=request.getParameter("no");
		request.setAttribute("no", no);
		WebUtil.forward("/deleteform.jsp", request, response);	
	}

}
