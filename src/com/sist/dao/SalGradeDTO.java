package com.sist.dao;

/**
 * Created by sist on 2016-03-03.
 *
 *  CREATE TABLE salgrade (
     GRADE NUMBER,                  int
     LOSAL NUMBER,                  int
     HISAL NUMBER                   int
     );
 */
public class SalGradeDTO {
    private int grade;
    private int local;
    private int hisal;

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public int getHisal() {
        return hisal;
    }

    public void setHisal(int hisal) {
        this.hisal = hisal;
    }
}
