package com.zym.controller;


import com.zym.pojo.Conference;
import com.zym.pojo.User;
import com.zym.service.ConferenceService;
import com.zym.service.Conference_requestService;
import com.zym.service.ParticipateService;
import com.zym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdministerController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @Autowired
    @Qualifier("ConferenceServiceImpl")
    private ConferenceService conferenceService;

    @Autowired
    @Qualifier("ParticipateServiceImpl")
    private ParticipateService participateService;

    @Autowired
    @Qualifier("Conference_requestServiceImpl")
    private Conference_requestService conference_requestService;

    @RequestMapping("/levelup")
    public String levelUp(Model model, @RequestParam("userId") String userId){
        int userLevel = userService.queryUserLevel(userId);
        if (userLevel<2)
            userService.updateUserLevelUP(userId);
        List<Conference>conferences = conferenceService.queryAllConference();
        model.addAttribute("conferences",conferences);
        List<User> users = userService.queryAllUser();
        model.addAttribute("users",users);
        return "administrator";
    }

    @RequestMapping("/leveldown")
    public String levelDown(Model model, @RequestParam("userId") String userId){
        int userLevel = userService.queryUserLevel(userId);
        if (userLevel>1)
            userService.updateUserLevelDown(userId);
        List<Conference>conferences = conferenceService.queryAllConference();
        model.addAttribute("conferences",conferences);
        List<User> users = userService.queryAllUser();
        model.addAttribute("users",users);
        return "administrator";
    }

    @RequestMapping("/deleteCon")
    public String deleteConferecnce(Model model, @RequestParam("conId") int conId){
        participateService.deleteParticipateInCon(conId);
        conference_requestService.deleteConRe(conId);
        conferenceService.deleteConference(conId);
        List<Conference>conferences = conferenceService.queryAllConference();
        model.addAttribute("conferences",conferences);
        List<User> users = userService.queryAllUser();
        model.addAttribute("users",users);
        return "administrator";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(Model model,@RequestParam("userId") String userId){
        userService.deleteUserInCon(userId);
        List<Conference> conferences = conferenceService.queryConferenceByUserId(userId);
        for (Conference conference : conferences) {
            participateService.deleteParticipateInCon(conference.getConId());
            conference_requestService.deleteConRe(conference.getConId());
            conferenceService.deleteConference(conference.getConId());
        }
        userService.deleteUserById(userId);
        List<Conference>conferencess = conferenceService.queryAllConference();
        model.addAttribute("conferences",conferencess);
        List<User> users = userService.queryAllUser();
        model.addAttribute("users",users);
        return "administrator";
    }
}
