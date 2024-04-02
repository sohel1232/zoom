package com.zoom.zoom.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "meetings")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer hostId;
    private String title;
    private LocalDateTime dateTime;
    private Integer duration;
    private String invitees;
    private String session;

    public Meeting() {
    }

    public Meeting(Integer hostId, String title, LocalDateTime dateTime, Integer duration, String invitees, String session) {
        this.hostId = hostId;
        this.title = title;
        this.dateTime = dateTime;
        this.duration = duration;
        this.invitees = invitees;
        this.session = session;
    }

    public List<String> getInviteesAsList() {
        return List.of(invitees.split(","));
    }

    public void setInvitees(String invitees) {
        this.invitees = invitees;
    }

    public Integer getHostId() {
        return hostId;
    }

    public void setHostId(Integer hostId) {
        this.hostId = hostId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getInvitees() {
        return invitees;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
