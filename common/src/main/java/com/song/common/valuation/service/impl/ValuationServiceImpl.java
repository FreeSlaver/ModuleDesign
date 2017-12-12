package com.song.common.valuation.service.impl;

import com.song.common.resume.vo.BasicInfoVo;
import com.song.common.resume.vo.ResumeVo;
import com.song.common.valuation.service.ValuationService;
import org.springframework.stereotype.Service;

/**
 * Created by 00013708 on 2017/8/6.
 */
@Service
public class ValuationServiceImpl implements ValuationService {
    @Override
    public void evaluate(ResumeVo resumeVo) {
        //刚开始不讲究什么代码优化，最快速度搞出来
        //首先得到基本信息
        BasicInfoVo basicInfoVo = resumeVo.getBasicInfoVo();
        String gender = basicInfoVo.getGender();
        double genderC = 1.00D;
        if(gender.equals("woman")){
            genderC = 0.85;
        }
        //这个age怎么算？
        int age = basicInfoVo.getAge();
        //直接按照工作年限作为直接线性相关不合理吧？一个人刚开始工作时候薪水4K，那么10年后，
        //就是4W？按照现在国家通货膨胀算的话，3年一倍，10年最少3倍，4K*3=1.2W，
        //
        //前面5年按照5倍计算，后面5年按照0.8计算？
        int  workingYears = basicInfoVo.getWorkingYears();
        double workYearsRadio = 1.00D;
        if(workingYears<=5){
            workYearsRadio = workingYears*workYearsRadio;
        }else{
            workYearsRadio = ((workingYears-5)*0.8+workingYears)*workYearsRadio;
        }

        String college = basicInfoVo.getCollege();
        double collegeRadio = 1.00D;
        //怎么个算法了？哎，真TM烦。
        // 零档1个，一档2个，二挡5个，三挡10个，四挡25个，五档50,六档125个，七档300（282）个，真是不好算哦。
        //然后了，怎么算系数？一档1.0,二挡0.95，三挡0.9，四挡0.85，五档0.8，六档0.7，七档0.6，刚刚毕业，我发现不错。
        //读取college.txt，得到所有的list，然后看这个填的大学落到那个区间，然后得到比率。

        String major = basicInfoVo.getMajor();
        //专业怎么算？

    }
}
