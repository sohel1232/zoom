package com.zoom.zoom.controller;

import com.zoom.zoom.entity.Meeting;
import com.zoom.zoom.entity.User;
import com.zoom.zoom.service.MeetingService;
import com.zoom.zoom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    private MeetingService meetingService;
    private UserService userService;

    @Autowired
    public HomeController(MeetingService meetingService, UserService userService) {
        this.meetingService = meetingService;
        this.userService = userService;
    }

    @GetMapping
    public String homePage(){
        System.out.println("INSIDE");
        return "home";
    }

//    @GetMapping("/newMeeting")
//    public String newMeeting(Model model){
//        User currentLoggedInUser = userService.getCurrentUser();
//        if(currentLoggedInUser==null){
//            return "redirect:/index.html";
//        }
//        model.addAttribute("username",currentLoggedInUser.getEmail());
//        return "redirect:/index.html?username=" + currentLoggedInUser.getEmail();
//    }

    @GetMapping("/signIn")
    public String signIn() {
        return "sign-in";
    }

//    @GetMapping("/userDashboard")
//    public String userDashboard(Model model){
//        User currentLoggedInUser = userService.getCurrentUser();
//        if(currentLoggedInUser==null){
//            System.out.println("Please Login first");
//            return "sign-in";
//        }
//        Integer userId = currentLoggedInUser.getId();
//        List<Meeting> scheduledMeetings = meetingService.getAllScheduledMeetingsByHostId(userId);
//        System.out.println("MEETINGS : " + scheduledMeetings);
//        model.addAttribute("scheduledMeetings", scheduledMeetings);
//        return "user-dashboard";
//    }

}
