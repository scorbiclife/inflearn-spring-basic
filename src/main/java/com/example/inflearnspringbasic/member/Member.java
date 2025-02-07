package com.example.inflearnspringbasic.member;

import java.util.function.Supplier;

public class Member {
    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Grade getGrade() {
        return grade;
    }
}
