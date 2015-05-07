package com.sds.icto.guestbook.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.guestbook.action.DeleteAction;
import com.sds.icto.guestbook.action.DeleteFormAction;
import com.sds.icto.guestbook.action.IndexAction;
import com.sds.icto.guestbook.action.InsertAction;
import com.sds.icto.guestbook.web.Action;

/**
 * Servlet implementation class GuestBookServelt
 */
@WebServlet("/gb")
public class GuestBookServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestBookServelt() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			String a=request.getParameter("a");
			Action action=null;
			if("add".equals(a)){
				action=new InsertAction();
			}else if("delete".equals(a)){
				action=new DeleteAction();			
			}else if("deleteform".equals(a)){
				action=new DeleteFormAction();
			}
			if(action==null){
				action=new IndexAction();
			}
			action.execute(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
