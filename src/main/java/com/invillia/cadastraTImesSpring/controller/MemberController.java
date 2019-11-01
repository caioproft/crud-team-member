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

@Controller
public class MemberController {

    private MemberService memberService;
    private TeamService teamService;

    @Autowired
    public MemberController(MemberService memberService, TeamService teamService){
        this.memberService = memberService;
        this.teamService = teamService;
    }

    @GetMapping("/manager-members")
    public String gerenciaMembros(Model model){
        model.addAttribute("members", memberService.findAllMembers());
        return "index-members";
    }

    @GetMapping("/signup-member")
    public String signupMemberForm(Member member, Model model) {
        model.addAttribute("teams", teamService.findAllTeams());
        return "add-member";
    }

    @PostMapping("/add-member")
    public String addTeam(@Valid Member member, BindingResult result, Model model){
        if (result.hasErrors()){
            return "add-member";
        }
        memberService.addMember(member);
//        model.addAttribute("members", memberService.findAllMembers());
        return "redirect:/manager-members";
    }

    @GetMapping("edit-member/{id}")
    public String updateMemberForm(@PathVariable("id") long id, Model model){
        Member member = memberService.findByMemberId(id).orElseThrow(() -> new ActionNotPermitedException(String.valueOf(id)));
        model.addAttribute("member", member);
        model.addAttribute("teams", teamService.findAllTeams());
        return "update-member";
    }

    @PostMapping("/update-member/{id}")
    public String updateMember(@PathVariable("id") long id, @Valid Member member, BindingResult result, Model model){
        if (result.hasErrors()){
            member.setId(id);
            return "update-member";
        }
        memberService.updateMember(member);
//        model.addAttribute("members", memberService.findAllMembers());
        return "redirect:/manager-members";
    }

    @GetMapping("/delete-member/{id}")
    public String deleteMember(@PathVariable("id") long id, Model model){
        memberService.deleteMember(id);
        model.addAttribute("members", memberService.findAllMembers());
        return "index-members";
    }
}
