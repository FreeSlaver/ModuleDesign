package com.song.common.valuation.service;

import com.song.common.resume.vo.ResumeVo;

/**
 * Created by 00013708 on 2017/8/6.
 */
public interface ValuationService {

    //估值得到的是范围还是？
    void evaluate(ResumeVo resumeVo);

}
