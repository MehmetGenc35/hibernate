package com.hb03.bi_onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student04 {

    @Id
    private int id;

    @Column(name = "std_name")
    private String name;

    private int grade;

    @OneToOne(mappedBy = "student") // !!! sadece Diary tablosunda iliski icin kolon olusturulsun
    // iliskinin duzgun kurulabilmesi icin , setleme islemi Diary tarafindan yapilmasi lazim
    private Diary04 diary04;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Diary04 getDiary04() {
        return diary04;
    }

    public void setDiary04(Diary04 diary04) {
        this.diary04 = diary04;
    }

    @Override
    public String toString() {
        return "Student04{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +

                '}';
    }
}
