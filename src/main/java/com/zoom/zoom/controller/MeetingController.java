package com.zoom.zoom.controller;

import com.zoom.zoom.entity.Meeting;
import com.zoom.zoom.entity.User;
import com.zoom.zoom.service.MeetingService;
import com.zoom.zoom.service.UserService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/meeting-controller")
public class MeetingController {

    MeetingService meetingService;
    UserService userService;

    @Autowired
    public MeetingController(MeetingService meetingService, UserService userService) {
        this.meetingService = meetingService;
        this.userService = userService;
    }

    @GetMapping("/scheduleMeeting")
    public String scheduleMeeting(Model model){
        Meeting meeting = new Meeting();
        model.addAttribute("meeting",meeting);
        return "schedule-meeting-form";
    }

    @PostMapping("/scheduleMeeting")
    public String scheduleMeeting(@ModelAttribute Meeting meeting,
                                  Authentication authentication){
        User currentLoggedInUser = userService.getCurrentUser();
        if(currentLoggedInUser==null){
            System.out.println("Please login first");
            return "redirect:/authentication-controller/login";
        }
        meeting.setHostId(currentLoggedInUser.getId());
        meetingService.scheduleMeeting(meeting);
        System.out.println("Meeting scheduled");
        return "redirect:/userDashboard";
    }

    @GetMapping("/startScheduledMeeting")
    public String startScheduledMeeting(@RequestParam("meetingId") Integer meetingId,
                                        Model model){
        System.out.println("Meeting id : " + meetingId);
        Meeting meeting = meetingService.findMeetingById(meetingId);
        System.out.println("MEETING IS : " + meeting);
        String sessionId = meeting.getSession();
        model.addAttribute("session" , sessionId);
        return "redirect:/newMeeting";
    }

    @GetMapping("/deleteScheduledMeeting")
    public String deleteScheduledMeeting(@RequestParam("meetingId") Integer meetingId){
        System.out.println("Meeting id : " + meetingId);
        Meeting meeting = meetingService.findMeetingById(meetingId);
        System.out.println("MEETIG IS : " + meeting);
        meetingService.delete(meeting);
        return "redirect:/userDashboard";
    }
}
