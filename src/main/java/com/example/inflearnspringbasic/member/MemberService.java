package com.example.inflearnspringbasic.member;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    long join(Member member) {
        return memberRepository.save(member);
    }

    Member findMember(long memberId) {
        return memberRepository.findById(memberId);
    }

}
