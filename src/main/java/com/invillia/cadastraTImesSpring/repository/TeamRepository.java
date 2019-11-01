package com.invillia.cadastraTImesSpring.repository;

import com.invillia.cadastraTImesSpring.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
