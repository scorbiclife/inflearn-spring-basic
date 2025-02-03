package com.example.inflearnspringbasic.member;

public interface MemberRepository {
    long save(Member member);
    Member findById(long id);
}
