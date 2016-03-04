<%--
  Created by IntelliJ IDEA.
  User: sist
  Date: 2016-03-04
  Time: 오전 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,com.sist.dao.*"%>
<%
    String strPage=request.getParameter("page");
    if(strPage==null){
        strPage="1";
    }

    int curPage=Integer.parseInt(strPage);      //웹페이지에서 get방식으로 요청한 페이지가 바뀔수 있으므로.

    EmpDAO empdao=new EmpDAO();
    ArrayList<EmpDTO> arraylist=empdao.empAllData(curPage);

    int totalPage=empdao.empTotalPage();

    out.println("<html>");
    out.println("<head>");
        out.println("<style type=text/css>");
        out.println("th,td{font-family:맑은 고딕;font-size:9pt}");
        out.println("a{text-decoration:none; color:black}");
        out.println("a:hover{text-decoration:underline; color:red}");
        out.println("</style>");
    out.println("</head>");

    out.println("<body>");
    out.println("<center>");
        out.println("<h3>사원목록</h3>");


    out.println("</center>");
    out.println("</body>");



    out.println("</html>");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>









































