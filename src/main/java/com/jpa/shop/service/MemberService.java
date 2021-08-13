package com.jpa.shop.service;

import com.jpa.shop.domain.Member;
import com.jpa.shop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        if (!Objects.isNull(memberRepository.findByName(member.getName())))
            throw new IllegalArgumentException("이미 존재하는 회원입니다.");
    }

    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        return memberRepository.findById(id)
                                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 ID 입니다."));
    }

}
