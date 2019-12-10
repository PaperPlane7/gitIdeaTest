package com.zym.controller;

import com.zym.pojo.Conference;
import com.zym.pojo.Conference_request;
import com.zym.pojo.Participate;
import com.zym.pojo.User;
import com.zym.service.ConferenceService;
import com.zym.service.Conference_requestService;
import com.zym.service.ParticipateService;
import com.zym.service.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/conference")
public class ConferenceController {
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
    private Conference_requestService  conference_requestService;

    @RequestMapping("/createByUser")
    public String createConferenceByUser(Model model,@RequestParam("userId") String Id){
        int num = conferenceService.queryAllConferenceNum();
        int conferenceNum;
        if (num>0)
            conferenceNum =  conferenceService.getConferenceNum();
        else
            conferenceNum =0;
        model.addAttribute("conferenceNum",conferenceNum);
        model.addAttribute("userId",Id);
        return "createconference";
    }

    @RequestMapping("/create")
    public String createConference(Model model, Conference conference, @RequestParam("userinform")String[] userinform){
        System.out.println("进入create");
        //设置时间信息
        try {
            Date conCreateTime = new Date(System.currentTimeMillis());
            conference.setConCreateTime(conCreateTime);
            //数据库加入
            conferenceService.addConference(conference.getConId(),conference.getConName(),conference.getUserId(),conference.getConDescription(),conference.getConCreateTime(),conference.getConEndTime(),conference.getConTime(),conference.getConLocation(),conference.getConGuest(),conference.getConHotel());

        }catch (Exception e){
            User user = userService.queryUserById(conference.getUserId());
            String msg = user.toString();
            model.addAttribute("msg",user);
            //我创建的会议
            List<Conference> conferencesCreate = conferenceService.queryConferenceByUserId(conference.getUserId());
            model.addAttribute("conferencesCreate",conferencesCreate);
            //我参加的会议
            List<Conference> conferencesParticipate = participateService.queryParticipate(conference.getUserId());
            model.addAttribute("conferencesParticipate",conferencesParticipate);
            //传入ID
            model.addAttribute("userId",conference.getUserId());
            model.addAttribute("error","createfail");
            return "userinformation";
        }

        try {
            boolean cName=false;
            boolean cSex=false;
            boolean cIdNum=false;
            boolean cTel=false;
            boolean cCompany=false;
            boolean cRoom=false;
            for(int i=0;i<userinform.length;i++){
                System.out.println(userinform[i]);
                if (userinform[i].equals("cName"))
                    cName=true;
                if (userinform[i].equals("cSex"))
                    cSex=true;
                if (userinform[i].equals("cIdNum"))
                    cIdNum=true;
                if (userinform[i].equals("cTel"))
                    cTel=true;
                if (userinform[i].equals("cCompany"))
                    cCompany=true;
                if (userinform[i].equals("cRoom"))
                    cRoom=true;
            }
            conference_requestService.addRequest(conference.getConId(),cName,cSex,cIdNum,cTel,cCompany,cRoom);
        }catch (Exception e){
            int userLevel = userService.queryUserLevel(conference.getUserId());
            model.addAttribute("userLevel",userLevel);
            User user = userService.queryUserById(conference.getUserId());
            String msg = user.toString();
            model.addAttribute("msg",msg);
            //我创建的会议
            List<Conference> conferencesCreate = conferenceService.queryConferenceByUserId(conference.getUserId());
            model.addAttribute("conferencesCreate",conferencesCreate);
            //我参加的会议
            List<Conference> conferencesParticipate = participateService.queryParticipate(conference.getUserId());
            model.addAttribute("conferencesParticipate",conferencesParticipate);
            //传入ID
            model.addAttribute("userId",conference.getUserId());
            model.addAttribute("error","createrequestfail");
            conferenceService.deleteConference(conference.getConId());
            return "userinformation";
        }

        int userLevel = userService.queryUserLevel(conference.getUserId());
        model.addAttribute("userLevel",userLevel);
        User user = userService.queryUserById(conference.getUserId());
        String msg = user.toString();
        model.addAttribute("msg",user);
        //我创建的会议
        List<Conference> conferencesCreate = conferenceService.queryConferenceByUserId(conference.getUserId());
        model.addAttribute("conferencesCreate",conferencesCreate);
        //我参加的会议
        List<Conference> conferencesParticipate = participateService.queryParticipate(conference.getUserId());
        model.addAttribute("conferencesParticipate",conferencesParticipate);
        //传入ID
        model.addAttribute("userId",conference.getUserId());
        return "userinformation";

    }

    @RequestMapping("/hall")
    public String hall(Model model,@RequestParam("userId") String Id){
        model.addAttribute("userId",Id);
        //查询可参加的会议
        List<Conference> joinable = conferenceService.queryAllConferenceJoinable(Id);
        Iterator<Conference> it = joinable.iterator();
        while (it.hasNext()){
            Conference conference = it.next();
            Date date = conference.getConEndTime();
            Date today = new Date(System.currentTimeMillis());
            if (today.after(date)){
                it.remove();
            }
        }

        model.addAttribute("joinable",joinable);

        //查询会议 参加要求
        List<Conference_request> conference_requests = conference_requestService.queryAllRequest();
        model.addAttribute("conference_requests",conference_requests);

        return "conferencehall";
    }

    @RequestMapping("/join")
    public String join(Model model,@RequestParam("userId") String Id,@RequestParam("conId") int conId){

        Conference_request conference_request = conference_requestService.queryRequest(conId);
        model.addAttribute("conference_request",conference_request);
        model.addAttribute("userId",Id);
        model.addAttribute("conId",conId);
        return "conferencedetail";
        //未完工

        //默认转载方式
//        User user = userService.queryUserById(Id);
//        String msg = user.toString();
//        model.addAttribute("msg",user);
//        //我创建的会议
//        List<Conference> conferencesCreate = conferenceService.queryConferenceByUserId(Id);
//        model.addAttribute("conferencesCreate",conferencesCreate);
//        //我参加的会议
//        List<Conference> conferencesParticipate = participateService.queryParticipate(Id);
//        model.addAttribute("conferencesParticipate",conferencesParticipate);
//        //传入ID
//        model.addAttribute("userId",Id);
//        return "userinformation";
    }

    @RequestMapping("/fillInformation")
    public String fillInformation(Model model, @RequestParam("conId") int conId, Participate participate,@RequestParam("roomBool") String roomBool){
        //ID可以不要写，取不出来

        System.out.println(conId);
        System.out.println(participate);
        System.out.println(roomBool);
        if (roomBool.equals("需要")){
            participate.setRoom(true);
        }else {
            participate.setRoom(false);
        }
        participateService.addParticipate(conId,participate.getUserId());
        if (participate.getName()!=null){
            participateService.updateName(conId,participate.getUserId(),participate.getName());
        }
        if (participate.getSex()!=null){
            participateService.updateSex(conId,participate.getUserId(),participate.getSex());
        }
        if (participate.getIdNum()!=null){
            participateService.updateIdNum(conId,participate.getUserId(),participate.getIdNum());
        }
        if (participate.getTel()!=null){
            participateService.updateTel(conId,participate.getUserId(),participate.getTel());
        }
        if (participate.getCompany()!=null){
            participateService.updateCompany(conId,participate.getUserId(),participate.getTel());
        }
        if (participate.isRoom()){
            participateService.updateRoom(conId,participate.getUserId(),true);
        }else {
            participateService.updateRoom(conId,participate.getUserId(),false);
        }

        //默认转载方式
        int userLevel = userService.queryUserLevel(participate.getUserId());
        model.addAttribute("userLevel",userLevel);
        User user = userService.queryUserById(participate.getUserId());
        String msg = user.toString();
        model.addAttribute("msg",user);
        //我创建的会议
        List<Conference> conferencesCreate = conferenceService.queryConferenceByUserId(participate.getUserId());
        model.addAttribute("conferencesCreate",conferencesCreate);
        //我参加的会议
        List<Conference> conferencesParticipate = participateService.queryParticipate(participate.getUserId());
        for (Conference conference : conferencesParticipate) {
            System.out.println(conference);
        }
        model.addAttribute("conferencesParticipate",conferencesParticipate);
        //传入ID
        model.addAttribute("userId",participate.getUserId());
        return "userinformation";
    }

    @RequestMapping("/deletebyuser")
    public String deleteByUser(Model model,@RequestParam("userId") String Id, @RequestParam("conId") int conId){

        participateService.deleteParticipate(conId,Id);

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

    @RequestMapping("/conferenceIn")
    public String conference(Model model,@RequestParam("userId") String Id, @RequestParam("conId") int conId){
        Conference conference = conferenceService.queryConferenceById(conId);
        model.addAttribute("conference",conference);
        model.addAttribute("userId",Id);
        return "conference";
    }

    @RequestMapping("/conparticipate")
    public String conParticipate(Model model,@RequestParam("userId") String Id,@RequestParam("conId") int conId){
        List<Participate> participates = participateService.queryParticipateInCon(conId);
        Conference_request conference_request = conference_requestService.queryRequest(conId);

        Conference conference = conferenceService.queryConferenceById(conId);
        model.addAttribute("participates",participates);
        model.addAttribute("conference_request",conference_request);
        model.addAttribute("conference",conference);
        return "participateinformation";
    }

//    public String participateExcel(Model model,@RequestParam("userId") int Id,@RequestParam("conId") int conId){
//
//
//        return "participateinformation";
//    }

}
