package com.example.inflearnspringbasic.member;

public class MemberConfig {
    private static final MemberService memberService = new MemberService(MemberConfig.memberRepository);
    private static final MemberRepository memberRepository = new MemoryMemberRepository();

    public static MemberService memberService() {
        return memberService;
    }

    public static MemberRepository memberRepository() {
        return memberRepository;
    }
}
