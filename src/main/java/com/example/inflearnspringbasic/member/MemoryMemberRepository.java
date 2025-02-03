package com.example.inflearnspringbasic.member;

import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {

    private final ConcurrentHashMap<Long, Member> memberMap = new ConcurrentHashMap<>();

    private long lastId = 0;

    @Override
    public long save(Member member) {
        memberMap.put(++lastId, member);
        return lastId;
    }

    @Override
    public Member findById(long id) {
        return memberMap.get(id);
    }
}
