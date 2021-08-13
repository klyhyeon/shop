package com.jpa.shop.service;

import com.jpa.shop.domain.Address;
import com.jpa.shop.domain.Member;
import com.jpa.shop.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    private Member member;

    @BeforeEach
    void setUp() {
        Address address = Address.builder()
                .city("changwon")
                .street("wonyidaero")
                .zipcode("012345").build();

        member = Member.builder()
                .address(address)
                .name("test").build();
        memberRepository.save(member);
    }

    @Test
    @DisplayName("join 테스트")
    void joinTest() {
        Member memberNew = Member.builder()
                                .address(Address.builder().city("busan").street("jagalchi").zipcode("123456").build())
                                .name("test2").build();
//        assertThatIllegalArgumentException().isThrownBy(() -> memberService.join(member));
        assertThat(memberService.join(memberNew)).isGreaterThan(18L);
    }
}