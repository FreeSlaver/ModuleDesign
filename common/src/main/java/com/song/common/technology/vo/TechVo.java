package com.song.common.technology.vo;

import java.util.List;

/**
 * Created by 00013708 on 2017/8/6.
 * 这个对象在前段的实现就是：在精通，熟练掌握，等等下面，让用户选择。
 * 比如，可以在了解里面填入spark和css。
 */
public class TechVo {

    private String masterDegree;

    private List<TechnologyVo> technologyVoList;

    public String getMasterDegree() {
        return masterDegree;
    }

    public void setMasterDegree(String masterDegree) {
        this.masterDegree = masterDegree;
    }

    public List<TechnologyVo> getTechnologyVoList() {
        return technologyVoList;
    }

    public void setTechnologyVoList(List<TechnologyVo> technologyVoList) {
        this.technologyVoList = technologyVoList;
    }
}
