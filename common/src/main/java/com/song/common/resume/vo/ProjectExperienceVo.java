package com.song.common.resume.vo;

import com.song.common.technology.vo.TechnologyVo;

import java.util.Date;
import java.util.List;

/**
 * Created by 00013708 on 2017/8/6.
 */
public class ProjectExperienceVo {

    private String projectName;

    private String companyName;
    //在项目中担当的岗位，初级，中级，高级，架构，pm/项目经理，技术总监，
    private String position;
    //简历上的起止时间，也未必有项目开始的起止时间
    //应聘者此项目参与的周期
    private Date starTime;
    //项目结束时间
    private Date endTime;

    private List<TechnologyVo> technologies;
    //项目整体周期
    private int overallCycle;
    //参与人数
    private int participantNumber;

    //项目用户数
    private long projectUserNumber;
    //项目描述
    private String projectDesc;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getStarTime() {
        return starTime;
    }

    public void setStarTime(Date starTime) {
        this.starTime = starTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public List<TechnologyVo> getTechnologies() {
        return technologies;
    }

    public void setTechnologies(List<TechnologyVo> technologies) {
        this.technologies = technologies;
    }

    public int getOverallCycle() {
        return overallCycle;
    }

    public void setOverallCycle(int overallCycle) {
        this.overallCycle = overallCycle;
    }

    public int getParticipantNumber() {
        return participantNumber;
    }

    public void setParticipantNumber(int participantNumber) {
        this.participantNumber = participantNumber;
    }

    public long getProjectUserNumber() {
        return projectUserNumber;
    }

    public void setProjectUserNumber(long projectUserNumber) {
        this.projectUserNumber = projectUserNumber;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }
}
