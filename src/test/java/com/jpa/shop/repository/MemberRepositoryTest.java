package com.jpa.shop.repository;

import com.jpa.shop.domain.Address;
import com.jpa.shop.domain.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        Address address = Address.builder()
                .city("changwon")
                .street("wonyidaero")
                .zipcode("012345").build();

        Member member = Member.builder()
                .address(address)
                .name("test").build();
        memberRepository.save(member);
    }

    @Test
    @DisplayName("findById 테스트")
    void findByIdTest() {
       assertThatIllegalArgumentException().isThrownBy(() -> {
           memberRepository.findById(2L)
                   .orElseThrow(() -> new IllegalArgumentException("없는 id 입니다."));
       });
    }

    @Test
    @DisplayName("findByName 테스트")
    void findByNameTest() {
        Member member = memberRepository.findByName("test");
        assertThat(member).isNotNull();
    }

}