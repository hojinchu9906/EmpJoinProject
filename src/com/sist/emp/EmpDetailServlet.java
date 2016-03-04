package com.sist.emp;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by sist on 2016-03-04.
 */
public class EmpDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=EUC-KR");
        PrintWriter printWriter=resp.getWriter();

        String empno=req.getParameter("empno");         //브라우저 url에 입력되는 파라미터

        EmpDAO empDAO=EmpDAO.newInstance();             //싱클톤으로 객체 생성
        EmpDTO empDTO=empDAO.empDetail(Integer.parseInt(empno));

        printWriter.println("<html>");
        printWriter.println("<body>");
        printWriter.println("<center>");
            printWriter.println("<h3>" +empDTO.getEname()+ "님의 상세 정보입니다.</h3>");    //이부분이 null값이 안나오게 DAO에서 각 필드를 set해줘야함.

            //태아불 서습릿으로 만들기.
            printWriter.println("<table>");



            printWriter.println("</table>");

        printWriter.println("</center>");
        printWriter.println("</body>");
        printWriter.println("</html>");


    }
}





















































