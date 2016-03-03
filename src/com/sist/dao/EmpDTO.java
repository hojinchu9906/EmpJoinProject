package com.sist.dao;

import java.util.Date;

/**
 * Created by sist on 2016-03-03.
 *
 * 데이터 형 :  오라클                       자바
 *          CHAR, VARCHAR2, CLOG            String
 *          NUMBER                          int
 *          DATE, TIMESTAMP                 java.util.Date
 *          BLOB, BFILE                     InputStream
 *
 *          CREATE TABLE MY_TABLE (
             EMPNO NUMBER,                  int
             ENAME VARCHAR2,                String
             JOB VARCHAR2,                  String
             MGR NUMBER,                    int
             HIREDATE DATE,                 Date
             SAL NUMBER,                    int,double
             COMM NUMBER,                   int
             DEPTNO NUMBER                  int
             );
 */
public class EmpDTO {
    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private Date hiredate;
    private int sal;
    private int comm;
    private int deptno;

    private DeptDTO deptDTO=new DeptDTO();
    private SalGradeDTO salGradeDTO=new SalGradeDTO();

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public int getComm() {
        return comm;
    }

    public void setComm(int comm) {
        this.comm = comm;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public DeptDTO getDeptDTO() {
        return deptDTO;
    }

    public void setDeptDTO(DeptDTO deptDTO) {
        this.deptDTO = deptDTO;
    }

    public SalGradeDTO getSalGradeDTO() {
        return salGradeDTO;
    }

    public void setSalGradeDTO(SalGradeDTO salGradeDTO) {
        this.salGradeDTO = salGradeDTO;
    }
}









































