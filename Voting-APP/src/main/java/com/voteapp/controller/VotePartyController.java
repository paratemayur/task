package com.voteapp.controller;

import com.voteapp.entity.User;
import com.voteapp.entity.VoteParty;
import com.voteapp.entity.request.VotePartyRequest;
import com.voteapp.iservice.IAdminService;
import com.voteapp.iservice.IUserService;
import com.voteapp.iservice.IVotePartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/v1/voteParty/")
public class VotePartyController {

    @Autowired
    private IVotePartyService iVotePartyService;

    @Autowired
    private IUserService iUserService;

    @PostMapping("/saveVote")
    public Object saveVote(@RequestBody VotePartyRequest request){
         return iVotePartyService.saveVote(request);
    }

    @GetMapping("/vote")
    public String votingForm(Model model) {
        List<VoteParty> votePartyList = iVotePartyService.getPartyList();
        model.addAttribute("votePartyList", votePartyList);
        System.out.println("knskcnk");
        return "voting-page";
    }

    @PostMapping("/vote/submit")
    public String submitVote(@RequestParam Map<String, String> paramMap, RedirectAttributes redirectAttributes) {
        String votePartyId = paramMap.get("votePartyId");
        String username = paramMap.get("username");

        if (votePartyId == null) {
            redirectAttributes.addAttribute("errorMessage", "Please select an option before voting.");
            return "redirect:/api/v1/voteParty/vote";
        }else{
            System.out.println("Voted for party with ID: " + votePartyId + " by user: " + username);
            //User user = iUserService.saveUserVote(votePartyId);
            return "redirect:/api/v1/voteParty/vote";
        }

        // Process the vote and return the appropriate view
    }

   /* @PostMapping("/vote/submit")
    public String submitVote(@RequestParam("votePartyId") Long votePartyId, @RequestParam("username") String username, RedirectAttributes redirectAttributes) {
        if (votePartyId == null) {
            redirectAttributes.addAttribute("errorMessage", "Please select an option before voting.");
            return "redirect:/api/v1/voteParty/vote";
        } else{
            System.out.println("Voted for party with ID: " + votePartyId + " by user: " + username);

            //User user = iUserService.saveUserVote(votePartyId);

            return "redirect:/api/v1/voteParty/vote";
        }

    }
*/
}
