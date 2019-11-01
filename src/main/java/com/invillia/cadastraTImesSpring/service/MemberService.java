package com.invillia.cadastraTImesSpring.service;

import com.invillia.cadastraTImesSpring.domain.Member;
import com.invillia.cadastraTImesSpring.excepction.MemberNotFoundException;
import com.invillia.cadastraTImesSpring.repository.MemberRepository;
import com.invillia.cadastraTImesSpring.repository.TeamRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private MemberRepository memberRepository;
    private TeamRepository teamRepository;

    public MemberService(MemberRepository memberRepository, TeamRepository teamRepository) {
        this.memberRepository = memberRepository;
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void addMember(Member member){
        memberRepository.save(member);
    }
    @Transactional
    public List<Member> findAllMembers(){
        return memberRepository.findAll();
    }

    @Transactional
    public List<Member> findByTeamId(long id){
        return memberRepository.findByTeamId(id);
    }

    @Transactional
    public Optional<Member> findByMemberId(long id){
       return memberRepository.findById(id);
    }

    @Transactional
    public void updateMember(Member member){
        Member persited = memberRepository.findById(member.getId()).orElseThrow(IllegalArgumentException::new);
        persited.setTeam(member.getTeam());
        persited.setName(member.getName());
        memberRepository.save(persited);
    }

    @Transactional
    public void deleteMember(long id){
        Member member = memberRepository.findById(id).orElseThrow(() -> new MemberNotFoundException(String.valueOf(id)));
        memberRepository.delete(member);
    }

}
