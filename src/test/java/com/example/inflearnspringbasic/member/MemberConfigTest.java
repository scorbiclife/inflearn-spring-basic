package com.example.inflearnspringbasic.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberConfigTest {

    MemberService memberService = new MemberService(new MemoryMemberRepository());

    @Test
    void join() {
        // given
        Member member = new Member(null, "memberA", Grade.VIP);

        // when
        long id = memberService.join(member);
        Member foundMember = memberService.findMember(id);

        // then
        assertThat(foundMember).isEqualTo(member);
    }
}