package com.zym.controller;

import com.zym.pojo.Conference;
import com.zym.pojo.User;
import com.zym.service.ConferenceService;
import com.zym.service.Conference_requestService;
import com.zym.service.ParticipateService;
import com.zym.service.UserService;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    //调用 service层

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


    @RequestMapping("/commonuser")
    public String userPri(Model model, @RequestParam("userId") String Id,@RequestParam("userPwd") String Pwd){
        User user = userService.queryUserById(Id);
        if (user==null){
            String msg = "fail";
            model.addAttribute("error",msg);
            return "login";
        }
        if(user.getUserPwd().equals(Pwd)){


            int userLevel = userService.queryUserLevel(Id);
            if (userLevel>2){
                List<Conference>conferences = conferenceService.queryAllConference();
                model.addAttribute("conferences",conferences);
                model.addAttribute("userId",Id);
                List<User> users = userService.queryAllUser();
                model.addAttribute("users",users);

                return "administrator";
            }
            model.addAttribute("userLevel",userLevel);
            model.addAttribute("msg",user);
            //我创建的会议
            List<Conference> conferencesCreate = conferenceService.queryConferenceByUserId(Id);
            model.addAttribute("conferencesCreate",conferencesCreate);
            //我参加的会议
            List<Conference> conferencesParticipate = participateService.queryParticipate(Id);
            model.addAttribute("conferencesParticipate",conferencesParticipate);
            //传入ID
            model.addAttribute("userId",Id);
            return "userinformation";
        }
        else {
            String msg = "fail";
            model.addAttribute("error",msg);
            return "login";
        }

    }

    @RequestMapping("/register")
    public String userReg(Model model,@RequestParam("userId") String Id,@RequestParam("userPwd") String Pwd){
        try{
            userService.addUser(Id,Pwd);
            String msg = "true";
            model.addAttribute("error",msg);
            return "login";
        }catch (Exception e){
            String msg = "fail";
            model.addAttribute("error",msg);
            return "register";
        }
    }

    @RequestMapping("/deleteCon")
    public String deleteConference(Model model,@RequestParam("userId") String Id,@RequestParam("conId") int conId){

        System.out.println(conId);
        participateService.deleteParticipateInCon(conId);
        conference_requestService.deleteConRe(conId);
        conferenceService.deleteConference(conId);


        //默认转载方式
        int userLevel = userService.queryUserLevel(Id);
        model.addAttribute("userLevel",userLevel);
        User user = userService.queryUserById(Id);
        String msg = user.toString();
        model.addAttribute("msg",user);
        //我创建的会议
        List<Conference> conferencesCreate = conferenceService.queryConferenceByUserId(Id);
        model.addAttribute("conferencesCreate",conferencesCreate);
        //我参加的会议
        List<Conference> conferencesParticipate = participateService.queryParticipate(Id);

        model.addAttribute("conferencesParticipate",conferencesParticipate);
        //传入ID
        model.addAttribute("userId",Id);
        return "userinformation";
    }
}
