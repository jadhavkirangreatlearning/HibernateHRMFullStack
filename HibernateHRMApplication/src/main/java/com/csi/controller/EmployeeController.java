package com.csi.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import com.csi.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	EmployeeService employeeServiceImpl = new EmployeeServiceImpl();

	String SIGNUP_PAGE = "/signup.jsp";
	String SIGNIN_PAGE = "/signin.jsp";
	String EDITDATA_PAGE = "/edit.jsp";
	String SHOWDATA_PAGE = "/show.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		String redirect = "";

		String empName = request.getParameter("empname");

		String action = request.getParameter("action");

		if (empName != null & action.equals("signup")) {

			String empAddress = request.getParameter("empaddress");

			long empContactNumber = Long.valueOf(request.getParameter("empcontactnumber"));

			double empSalary = Double.valueOf(request.getParameter("empsalary"));

			String empGender = request.getParameter("empgender");

			int empAge = Integer.valueOf(request.getParameter("empage"));

			Date dobDate = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				dobDate = simpleDateFormat.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee(empName, empAddress, empContactNumber, empSalary, empGender, empAge,
					dobDate, empEmailId, empPassword);

			employeeServiceImpl.signUp(employee);

			redirect = SIGNIN_PAGE;

		} else if (action.equals("signin")) {

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			if (employeeServiceImpl.signIn(empEmailId, empPassword)) {

				request.setAttribute("empList", employeeServiceImpl.getAllData());
				redirect = SHOWDATA_PAGE;
			} else {
				request.setAttribute("message", "Oops Please try again!!!!");

				redirect = SIGNIN_PAGE;
			}

		} else if (action.equals("edit_form")) {
			redirect = EDITDATA_PAGE;
		} else if (action.equals("edit")) {

			int empId = Integer.valueOf(request.getParameter("empid"));

			String employeeName = request.getParameter("empname");

			String empAddress = request.getParameter("empaddress");

			long empContactNumber = Long.valueOf(request.getParameter("empcontactnumber"));

			double empSalary = Double.valueOf(request.getParameter("empsalary"));

			String empGender = request.getParameter("empgender");

			int empAge = Integer.valueOf(request.getParameter("empage"));

			Date dobDate = null;

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			try {
				dobDate = simpleDateFormat.parse(request.getParameter("empdob"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String empEmailId = request.getParameter("empemailid");

			String empPassword = request.getParameter("emppassword");

			Employee employee = new Employee(employeeName, empAddress, empContactNumber, empSalary, empGender, empAge,
					dobDate, empEmailId, empPassword);

			employeeServiceImpl.updateData(empId, employee);

			request.setAttribute("empList", employeeServiceImpl.getAllData());

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("deletedatabyid")) {

			int empId = Integer.valueOf(request.getParameter("empid"));

			employeeServiceImpl.deleteDataById(empId);

			request.setAttribute("empList", employeeServiceImpl.getAllData());

			redirect = SHOWDATA_PAGE;

		} else if (action.equals("deletealldata")) {

			employeeServiceImpl.deleteAllData();

			request.setAttribute("empList", employeeServiceImpl.getAllData());

			redirect = SHOWDATA_PAGE;

		}

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(redirect);
		requestDispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
