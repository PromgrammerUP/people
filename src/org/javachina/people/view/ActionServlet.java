package org.javachina.people.view;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.javachina.people.dto.PeopleDto;
import org.javachina.people.service.PeopleService;

/**
 * Servlet implementation class ActionServlet
 */
//@WebServlet("/ActionServlet")
public class ActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ActionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		this.doRequest(request, response);
	}

	public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//取得申请类型
		String act = request.getParameter("act");
		
		//取得所有people
		if("listall".equals(act)){
			this.listAll(request, response);
		}else if("del".equals(act)){
			this.delete(request, response);
		}else if("getAddPage".equals(act)){
			this.getAddPage(request, response);
		}else if("adddo".equals(act)){
			this.addPeople(request, response);
		}
	}
	public void listAll(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		//1获取请求参数
		
		//2调用service完成逻辑
		PeopleService ps = new PeopleService();
		ArrayList<PeopleDto> list = ps.getAllPeople();
		request.setAttribute("list", list);
		//3页面返回
		request.getRequestDispatcher("/listall.jsp").forward(request, response);
	}
	public void delete(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		 //1
		int id = Integer.parseInt(request.getParameter("id"));
		
		//
		PeopleService ps = new PeopleService();
		boolean isOK = ps.deletePeople(id);
		//
		String msg="false";
		if(isOK){
			msg="ok";
		}
		response.getWriter().print(""
				+ "<script language='javascript'>"
				+ "alert('"+msg+"');"
				+ "window.location='"+request.getContextPath()+"/action?act=listall';"
				+ "</script>");
	}
	public void getAddPage(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		request.getRequestDispatcher("/add.jsp").forward(request, response);
	}
	public void addPeople(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		//
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		Date birth = Date.valueOf(request.getParameter("birth"));
		double salary = Double.parseDouble(request.getParameter("salary"));
		
		PeopleDto dto = new PeopleDto();
		dto.setName(name);
		dto.setAge(age);
		dto.setBirth(birth);
		dto.setSalary(salary);
		//
		PeopleService ps = new PeopleService();
		boolean isOK = ps.addPeople(dto);
		String msg = "false";
		if(isOK){
			msg="OK";
		}
		response.getWriter().print(""
				+ "<script language='javascript'>"
				+ "alert('"+msg+"');"
				+ "window.location='"+request.getContextPath()+"/action?act=listall';"
				+ "</script>");
	}	
}
