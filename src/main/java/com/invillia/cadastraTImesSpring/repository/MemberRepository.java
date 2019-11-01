package com.invillia.cadastraTImesSpring.repository;

import com.invillia.cadastraTImesSpring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByTeamId(long id);

}
