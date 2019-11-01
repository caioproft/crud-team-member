package com.invillia.cadastraTImesSpring.controller;

import com.invillia.cadastraTImesSpring.domain.Member;
import com.invillia.cadastraTImesSpring.domain.Team;
import com.invillia.cadastraTImesSpring.excepction.ActionNotPermitedException;
import com.invillia.cadastraTImesSpring.service.MemberService;
import com.invillia.cadastraTImesSpring.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class TeamController {

    private TeamService teamService;
    private MemberService memberService;

    @Autowired
    public TeamController(TeamService teamService, MemberService memberService){
        this.teamService = teamService;
        this.memberService = memberService;
    }

    @GetMapping("/manager-teams")
    public String gerenciaTimes (Model model){
        model.addAttribute("teams", teamService.findAllTeams());
        return "index-team";
    }

    @GetMapping("/signup-team")
    public String signupTeamForm(Team team){
        return "add-team";
    }

    @PostMapping("/add-team")
    public String addTeam(@Valid Team team, BindingResult result, Model model){
        if (result.hasErrors()){
            return "add-team";
        }
        teamService.addTeam(team);
//        model.addAttribute("teams", teamService.findAllTeams());
        return "redirect:/manager-teams";
    }

    @GetMapping("/edit-team/{id}")
    public String uptadeTeamForm(@PathVariable("id") long id, Model model){
        Team team = teamService.findByTeamId(id).orElseThrow(() -> new ActionNotPermitedException(String.valueOf(id)));
        model.addAttribute("team", team);
        return "update-team";
    }

    @PostMapping("/update-team/{id}")
    public String updateTeam(@PathVariable("id") long id, @Valid Team team, BindingResult result, Model model){
        if(result.hasErrors()){
            team.setId(id);
            return  "update-team";
        }
        teamService.updateTeam(team);
        model.addAttribute("teams", teamService.findAllTeams());
        return "redirect:/manager-teams";
    }

    @GetMapping ("delete-team/{id}")
    public String deteleTeam (@PathVariable("id") long id, Model model){
        if(memberService.findByTeamId(id).isEmpty()) {
            teamService.deleteTeam(id);
            model.addAttribute("teams", teamService.findAllTeams());
            return "index-team";
        }
        return "deleteTeam-error";
    }

    @GetMapping("/team-members/{id}")
    public String showTeamMembers(@PathVariable("id") long id, Model model){
        List<Member> members = memberService.findByTeamId(id);
        model.addAttribute("members", members);
        return "team-members";
    }
}
