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

        printWriter.println("<table border=0 width=600>");
        printWriter.println("<tr bgcolor=#ccccff>");
        printWriter.println("<th>사원번호</th>");
        printWriter.println("<th>이름</th>");
        printWriter.println("<th>직위</th>");
        printWriter.println("<th>근무부서</th>");
        printWriter.println("<th>근무지역</th>");
        printWriter.println("<th>사원등급</th>");
        printWriter.println("</tr>");

        String color="";
        int i=0;
        for(EmpDTO empDTO:arrayList){
            if(i%2==0)
                color="white";
            else
                color="#ccffcc";
            printWriter.println("<tr bgcolor="+color+">");
            printWriter.println("<td>" +empDTO.getEmpno()+ "</td>");

            printWriter.println("<td>");
            printWriter.println("<a href=EmpDetailServlet?empno=" +empDTO.getEmpno()+">");
            printWriter.println(empDTO.getEname() +"</a>");
            printWriter.println("</td>");

            printWriter.println("<td>" +empDTO.getJob()+ "</td>");
            printWriter.println("<td>" +empDTO.getDeptDTO().getDname()+ "</td>");
            printWriter.println("<td>" +empDTO.getDeptDTO().getLoc()+ "</td>");
            printWriter.println("<td>" +empDTO.getSalGradeDTO().getGrade()+ "</td>");

            printWriter.println("</tr>");
            i++;
        }

        printWriter.println("</table>");

        //테이블 하단 선 긋기
        printWriter.println("<hr width=600>");


        //또하나의 테이블 추가하기
        printWriter.println("<table border=0 width=600>");
        //검색 및 찾기 버튼 추가.
        printWriter.println("<tr>");
        printWriter.println("<td align=left>");
        printWriter.println("검색: ");
        printWriter.println("<select>");
        printWriter.println("<option>이름</option>");
        printWriter.println("<option>부서</option>");
        printWriter.println("<option>직위</option>");
        printWriter.println("</select>");

        printWriter.println("<input type=text size=10>");
        printWriter.println("<input type=button value=찾기>");
        printWriter.println("</td>");


        //페이지 넘버 표기하기
        printWriter.println("<td align=right>");
        //여기서 파라미터 이름을 page라고 줌.
        printWriter.println("<a href=EmpServlet?page=" +(curPage>1 ? curPage-1: curPage)+ ">");
        //이미지 출력
        printWriter.println("<img src=image/prev.gif border=0>");
        printWriter.println("</a>");

        //페이지 숫자 출력
        printWriter.println("<a>");
        printWriter.println("</a>");




        printWriter.println("</td>");


        printWriter.println("</tr>");
        printWriter.println("</table>");








        printWriter.println("</center>");
        printWriter.println("</body>");
        printWriter.println("</html>");

    }
}




































