package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/PlusMinus" }, initParams = { @WebInitParam(name = "a", value = "0"),
		@WebInitParam(name = "b", value = "0") })
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CalculatorServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int number1 = 0, number2 = 0;
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setAttribute("error", "");
		request.setAttribute("result", "");
		try {
			number1 = Integer.parseInt(request.getParameter("number1"));
			number2 = Integer.parseInt(request.getParameter("number2"));
		} catch (Exception e) {
			request.setAttribute("error", "Input not correct!");
		}
		int result = 0;
		if (request.getParameter("plus") != null) {
			result = number1 + number2;
		} else if (request.getParameter("minus") != null) {
			result = number1 - number2;
		}

		request.setAttribute("result", "" + result);
		request.setAttribute("n1", "" + number1);
		request.setAttribute("n2", "" + number2);
		request.getRequestDispatcher("Calculator.jsp").forward(request, response);
		doGet(request, response);
	}

}
