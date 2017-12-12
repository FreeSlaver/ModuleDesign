package com.song.common.technology.vo;

/**
 * Created by 00013708 on 2017/8/6.
 * 技术，比如spring，mysql等
 * 这个类用来描述，会什么技术，掌握的程度
 * 其实这个更应该映射到数据库中去，比如现行已有的各种技术，Spark，kafka等，
 * 然后这种技术所属的类别，大数据，中间件，数据库，等。
 */
public class TechnologyVo {

    //技术名称
    private String technologyName;
    //技术种类
    private String technologyCategory;


    public String getTechnologyName() {
        return technologyName;
    }

    public void setTechnologyName(String technologyName) {
        this.technologyName = technologyName;
    }

    public String getTechnologyCategory() {
        return technologyCategory;
    }

    public void setTechnologyCategory(String technologyCategory) {
        this.technologyCategory = technologyCategory;
    }


}
