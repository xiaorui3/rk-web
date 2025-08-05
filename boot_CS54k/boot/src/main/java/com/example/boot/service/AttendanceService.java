package com.example.boot.service;

import com.example.boot.entity.Member;
import com.example.boot.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttendanceService {

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    @Transactional
    public void checkInMembers(List<Integer> memberIds) {
        memberRepository.updateStatusByIds(memberIds, Member.AttendanceStatus.CHECKED_IN);
    }

    @Transactional
    public void checkOutMembers(List<Integer> memberIds) {
        memberRepository.updateStatusByIds(memberIds, Member.AttendanceStatus.CHECKED_OUT);
    }

    private final MemberRepository memberRepository;

    @Autowired
    public AttendanceService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> searchMembers(String keyword) {
        return memberRepository.findByNameContainingIgnoreCaseOrPositionContainingIgnoreCase(keyword, keyword);
    }
}