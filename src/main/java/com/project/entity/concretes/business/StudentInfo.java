package com.project.entity.concretes.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.entity.concretes.user.User;
import com.project.entity.enums.Note;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer absentee;

    private Double midtermExam;

    private Double finalExam;

    private Double examAverage;

    private String infoNote;

    @Enumerated(EnumType.STRING)
    private Note letterGrade;// AA - aa-Ab - aB - NE YAPACAĞI BELLİ DEĞİL O YÜZDEN ENUM OLUŞTURDUK
    @ManyToOne
    @JsonIgnore// sonsuz dögü olmasın
    private User teacher;

    @ManyToOne
    @JsonIgnore
    private User Student;




    @ManyToOne
    private Lesson lesson;


    @OneToOne
    private EducationTerm educationTerm;



}
