package com.song.common.resume.service;

import com.song.common.resume.vo.BasicInfoVo;
import com.song.common.resume.vo.ProjectExperienceVo;
import com.song.common.resume.vo.ResumeVo;
import com.song.common.technology.vo.TechVo;
import com.song.common.technology.vo.TechnologyVo;
import com.song.common.valuation.service.ValuationService;
import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by 00013708 on 2017/8/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:appContext.xml"})
public class ResumeServiceTest {

    @Autowired
    private ValuationService valuationService;
    @Test
    public void valuationTest() throws ParseException {
        BasicInfoVo basicInfoVo = generateBasicInfo();


        //技能栈
        List<TechVo> technologyStack = generateBasicInfoTechStack();

        //项目信息
        List<ProjectExperienceVo> projectExperiences = generateProjectExpriences();

        ResumeVo resumeVo = new ResumeVo(basicInfoVo,technologyStack,projectExperiences);
        //进行估值
        valuationService.evaluate(resumeVo);
    }

    private List<ProjectExperienceVo> generateProjectExpriences() {
        List<ProjectExperienceVo> projectExperiences = new ArrayList<>();
        ProjectExperienceVo csst = new ProjectExperienceVo();//这个映射关系好像也不太对。一个公司对应多个项目，我目前有8个项目。

        return projectExperiences;
    }

    private List<TechVo> generateBasicInfoTechStack() {
        List<TechnologyVo> technologyStack = new ArrayList<>();
        //我掌握了哪些技术了？这个地方的东西最后都要存数据库，然后将掌握程度结合起来。蛋疼。
        //这个数据结构不对，应该是只有5个，了解，熟悉，掌握，熟练，精通
        //前端
//        熟悉Html，Js，Css，Jquery，Ajax等
        TechnologyVo html = new TechnologyVo();
        html.setTechnologyName("html");
        html.setTechnologyCategory("frontend");

        technologyStack.add(html);

        TechnologyVo js = new TechnologyVo();
        js.setTechnologyName("js");
        js.setTechnologyCategory("frontend");

        technologyStack.add(js);

        TechnologyVo css = new TechnologyVo();
        css.setTechnologyName("css");
        css.setTechnologyCategory("frontend");

        technologyStack.add(css);

        TechnologyVo jquery = new TechnologyVo();
        jquery.setTechnologyName("html");
        jquery.setTechnologyCategory("frontend");

        technologyStack.add(jquery);

        TechnologyVo ajax = new TechnologyVo();
        ajax.setTechnologyName("ajax");
        ajax.setTechnologyCategory("frontend");

        technologyStack.add(ajax);
        //传统的ejb开发，spring，mybatis，
        TechnologyVo spring = new TechnologyVo();
        spring.setTechnologyName("spring");
        //网站后台开发
        spring.setTechnologyCategory("web");

        technologyStack.add(spring);

        TechnologyVo sparkjava = new TechnologyVo();
        sparkjava.setTechnologyName("sparkjava");
        sparkjava.setTechnologyCategory("web");

        technologyStack.add(sparkjava);

        TechnologyVo mybatis = new TechnologyVo();
        mybatis.setTechnologyName("mybatis");
        mybatis.setTechnologyCategory("orm");

        technologyStack.add(mybatis);
        //数据库mysql，oracle等
        TechnologyVo mysql = new TechnologyVo();
        mysql.setTechnologyName("mysql");
        mysql.setTechnologyCategory("database");

        technologyStack.add(mysql);

        TechnologyVo oracle = new TechnologyVo();
        oracle.setTechnologyName("oracle");
        oracle.setTechnologyCategory("database");

        technologyStack.add(oracle);
        //网络框架，netty
        TechnologyVo netty = new TechnologyVo();
        netty.setTechnologyName("netty");
        netty.setTechnologyCategory("network");

        technologyStack.add(netty);

        //中间件，activemq，kafka。。。
        TechnologyVo activemq = new TechnologyVo();
        activemq.setTechnologyName("activemq");
        activemq.setTechnologyCategory("mq");

        technologyStack.add(activemq);
        //大数据
        TechnologyVo kafka = new TechnologyVo();
        kafka.setTechnologyName("activemq");
        kafka.setTechnologyCategory("mq");

        technologyStack.add(kafka);
        //分布式，分布式追踪
        TechnologyVo zipkin = new TechnologyVo();
        zipkin.setTechnologyName("zipkin");
        zipkin.setTechnologyCategory("distribute");

        technologyStack.add(zipkin);
        //大数据
        TechnologyVo spark = new TechnologyVo();
        spark.setTechnologyName("spark");
        spark.setTechnologyCategory("distribute");

        technologyStack.add(zipkin);

        //工具类，git，maven，svn，eclipse等等，
        TechnologyVo idea = new TechnologyVo();
        idea.setTechnologyName("idea");
        idea.setTechnologyCategory("tool");

        technologyStack.add(zipkin);

        //运维，部署方面的，linux，ngnix，

        //一些高效的够geek的工具，github，stackoverflow，google，dropbox，emacs，vim等

        //我草，原来技术这么多，尼玛的。

        //这个技术分开太多了，我看，能不能归类，比如web技术，XX，但是你让别人填的时候如何填了？
        return null;
    }

    private BasicInfoVo generateBasicInfo() throws ParseException {
        BasicInfoVo basicInfoVo =  new BasicInfoVo();
        basicInfoVo.setName("宋鑫");
        basicInfoVo.setGender("man");
        basicInfoVo.setAge(27);
        DateFormatter formatter = new DateFormatter();
        Date birthday = formatter.parse("1990-10-10", Locale.CHINA);
        basicInfoVo.setBirthday(birthday);
        basicInfoVo.setCollege("长江大学");
        basicInfoVo.setMajor("计算机科学与技术");
        basicInfoVo.setGraduationDate(formatter.parse("2012-07-01", Locale.CHINA));
        basicInfoVo.setWorkExperience(6);
        basicInfoVo.setPhone("18025360608");
        basicInfoVo.setEmail("songxin@3gods.com");
        basicInfoVo.setNativePlace("湖北武汉");
        basicInfoVo.setCurrentResidence("深圳");
        return basicInfoVo;
    }
}
