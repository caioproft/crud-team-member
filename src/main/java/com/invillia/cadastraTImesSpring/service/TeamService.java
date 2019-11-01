package com.invillia.cadastraTImesSpring.service;

import com.invillia.cadastraTImesSpring.domain.Team;
import com.invillia.cadastraTImesSpring.excepction.TeamNotFoundException;
import com.invillia.cadastraTImesSpring.repository.TeamRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    @Transactional
    public void addTeam(Team team){
        teamRepository.save(team);
    }

    @Transactional
    public List<Team> findAllTeams(){
        return teamRepository.findAll();
    }

    @Transactional
    public Optional<Team> findByTeamId(long id){
        return teamRepository.findById(id);
    }

    @Transactional
    public void updateTeam(Team team){
        Team persisted = teamRepository.findById(team.getId()).orElseThrow(IllegalArgumentException::new);
        persisted.setName(team.getName());
        teamRepository.save(persisted);
    }

    @Transactional
    public void deleteTeam (Long id){
        Team team =  teamRepository.findById(id).orElseThrow(() -> new TeamNotFoundException(String.valueOf(id)));
        teamRepository.delete(team);
    }

}
