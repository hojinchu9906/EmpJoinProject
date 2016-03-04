package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Created by sist on 2016-03-03.
 */
public class EmpDAO {
    //오라클 연결    ==> Socket
    private Connection connection;

    //SQL 문장 전송 ==> BufferedReader, OutputStream
    private PreparedStatement preparedStatement;

    //URL 주소
    private final String URL="jdbc:oracle:thin:@211.238.142.20:1521:ORCL";

    //싱글턴
    private static EmpDAO empDAO;

    //생성자- 오라클 연결을 위한 드라이버 설치
    public EmpDAO(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    //연결 객체 생성
    public void getConnection(){
        try{
            connection=DriverManager.getConnection(URL,"scott","tiger");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //연결 해제
    public void disConnection(){
        try{
            if(preparedStatement !=null)
                preparedStatement.close();
            if(connection !=null)
                connection.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    //싱글톤으로 객체는 한번만 생성하게함.
    public static EmpDAO newInstance(){
        if(empDAO==null)
            empDAO=new EmpDAO();
        return empDAO;
    }

    //DAO 기능 추가
    //1. 전체 디비 목록 가져오기
    public ArrayList<EmpDTO> empAllData(int page){
        ArrayList<EmpDTO> arrayList=new ArrayList<EmpDTO>();

        try{
            //연결
            this.getConnection();
            /*
                private int empno;
                private String ename;
                private String job;
                private int mgr;
                private Date hiredate;
                private int sal;
                private int comm;
                private int deptno;

                    private int deptno;
                    private String dname;
                    private String loc;

                        private int grade;
                        private int local;
                        private int hisal;
             */
            String sql="SELECT empno,ename,job,dname,loc,grade "
                        +"FROM emp,dept,salgrade "
                        +"WHERE emp.deptno=dept.deptno "
                        +"AND sal BETWEEN losal AND hisal";

            preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();

            int i=0;
            int j=0;
            int pageStartNum=(page*5)-5;
            /*
                    1p  2p
                    0   5
                    ~   ~
                    4   9
             */
            while(resultSet.next()){
                if(i<5 && j>=pageStartNum){
                    EmpDTO empDTO=new EmpDTO();
                    empDTO.setEmpno(resultSet.getInt(1));
                    empDTO.setEname(resultSet.getString(2));
                    empDTO.setJob(resultSet.getString(3));
                    empDTO.getDeptDTO().setDname(resultSet.getString(4));
                    empDTO.getDeptDTO().setLoc(resultSet.getString(5));
                    empDTO.getSalGradeDTO().setGrade(resultSet.getInt(6));

                    arrayList.add(empDTO);
                    i++;
                }
                j++;
            }

            resultSet.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            disConnection();
        }
     return arrayList;
    }

    //2. emp 전체 페이지수 구하기
    public int empTotalPage(){
        int total=0;
        try{
            this.getConnection();
            //쿼리 작성 (COUNT)
            String sql="SELECT CEIL(COUNT(*)/5) FROM emp";
            //쿼리 실행
            preparedStatement=connection.prepareStatement(sql);
            ResultSet resultSet=preparedStatement.executeQuery();

            //결과 변수에 값 할당.
            resultSet.next();
            total=resultSet.getInt(1);

            resultSet.close();

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            this.disConnection();
        }
        return total;
    }

    //3.상세보기 (조인 사용)
    public EmpDTO empDetail(int empno){
        EmpDTO empDTO=new EmpDTO();
        try{
            this.getConnection();
            String sql="SELECT empno,ename,job,mgr,TO_CHAR(hiredate,'YYYY-MM-DD'),TO_CHAR(sal,'$99,999'),NVL(comm,0), "
                        +"emp.deptno,dname,loc,grade "
                        +"FROM emp,dept,salgrade "
                        +"WHERE emp.deptno=dept.deptno "
                        +"AND sal BETWEEN losal AND hisal "
                        +"AND empno=?";

            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setInt(1, empno);

            ResultSet resultSet=preparedStatement.executeQuery();
            resultSet.next();

            empDTO.setEmpno(resultSet.getInt(1));
            //여기서 set을 해줘야 함.
            empDTO.setEname(resultSet.getString(2));

            resultSet.close();

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }finally {
            this.disConnection();
        }
        return empDTO;
    }
}







































