package com.song.common.resume.vo;

import com.song.common.technology.vo.TechVo;

import java.util.List;

/**
 * Created by 00013708 on 2017/8/6.
 */
public class ResumeVo {

    //基本信息
    private BasicInfoVo basicInfoVo;
    //技能栈
//    private List<TechnologyVo> technologyStack;
    private List<TechVo> technologyStack;
    //公司，项目，岗位经验
    private List<ProjectExperienceVo> projectExperiences;

    public ResumeVo() {
    }

    public ResumeVo(BasicInfoVo basicInfoVo, List<TechVo> technologyStack, List<ProjectExperienceVo> projectExperiences) {
        this.basicInfoVo = basicInfoVo;
        this.technologyStack = technologyStack;
        this.projectExperiences = projectExperiences;
    }

    public BasicInfoVo getBasicInfoVo() {
        return basicInfoVo;
    }

    public void setBasicInfoVo(BasicInfoVo basicInfoVo) {
        this.basicInfoVo = basicInfoVo;
    }

    public List<TechVo> getTechnologyStack() {
        return technologyStack;
    }

    public void setTechnologyStack(List<TechVo> technologyStack) {
        this.technologyStack = technologyStack;
    }

    public List<ProjectExperienceVo> getProjectExperiences() {
        return projectExperiences;
    }

    public void setProjectExperiences(List<ProjectExperienceVo> projectExperiences) {
        this.projectExperiences = projectExperiences;
    }

//其他,期望薪水，目前薪水，

}
