package com.hb04.manytoone;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Student05 {

    @Id
    private int id;

    @Column(name = "student_name",nullable = false)
    private String name;

    private int grade;

    private LocalDateTime createOn;//create edilme tarihi ve saati

    @ManyToOne //Many(Student) One(University)
    @JoinColumn(name = "university_id")
    private University university;

    @PrePersist // nesne save edildiğinde tarih setleniyor
    public void prePersist(){
        createOn=LocalDateTime.now();
    }

    //GETTER-SETTER


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

    public LocalDateTime getCreateOn() {
        return createOn;
    }

//    public void setCreateOn(LocalDateTime createOn) {
//        this.createOn = createOn;
//    }
    //TEkrar setlenebilir olursa tarih değiştirme olabilir
    //Onun yerine bu seti kapattık

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    //ToString


    @Override
    public String toString() {
        return "Student05{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                ", createOn=" + createOn +
                ", university=" + university +
                '}';
    }
}
