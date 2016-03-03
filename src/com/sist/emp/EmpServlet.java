package com.sist.emp;

import com.sist.dao.EmpDAO;
import com.sist.dao.EmpDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by sist on 2016-03-03.
 */
public class EmpServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=EUC-KR");

        PrintWriter printWriter=resp.getWriter();

        String stringCurrentPage=req.getParameter("page");
        if(stringCurrentPage==null){
            stringCurrentPage="1";
        }
        int curPage=Integer.parseInt(stringCurrentPage);

        EmpDAO empDAO=new EmpDAO();

        //조인활용한 테이블 결과 화면 리스트로 보이기.
        ArrayList<EmpDTO> arrayList=empDAO.empAllData(curPage);
        int totalPage=empDAO.empTotalPage();

        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<style type=text/css>");
        printWriter.println("th,td{font-family:맑은 고딕;font-size:9pt}");
        printWriter.println("a{text-decoration:none;color:black}");
        printWriter.println("a:hover{text-decoration:underline;color:blue}");
        printWriter.println("</style>");
        printWriter.println("</head>");

        printWriter.println("<body>");
        printWriter.println("<center>");
        printWriter.println("<h3>사원목록</h3>");


        printWriter.println("</center>");
        printWriter.println("</body>");
        printWriter.println("</html>");

    }
}



































