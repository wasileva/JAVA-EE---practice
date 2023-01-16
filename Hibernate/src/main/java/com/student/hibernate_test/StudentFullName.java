package com.student.hibernate_test;

import javax.persistence.Embeddable;

@Embeddable
public class StudentFullName {
    
    private String fName;
    private String mName;
    private String lName;

    public StudentFullName(String fName, String mName, String lName) {
        this.fName = fName;
        this.mName = mName;
        this.lName = lName;
    }

    public StudentFullName() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Override
    public String toString() {
        return "StudentFullName{" + "fName=" + fName + ", mName=" + mName + ", lName=" + lName + '}';
    }
    
    
}
