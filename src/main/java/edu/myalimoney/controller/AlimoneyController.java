package edu.myalimoney.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import edu.myalimoney.dto.RtnResult;
import edu.myalimoney.pojo.Alimoney;
import edu.myalimoney.service.IAlimoneyService;
import edu.myalimoney.util.PageQueryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 处理生活费请求的控制器
 */
@Controller
@RequestMapping("/alimoney")
public class AlimoneyController {

    //声明业务层
    @Autowired
    private IAlimoneyService iAlimoneyService;

    /**
     * 处理分页带条件查询
     * @param page
     * @param alimoney
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "queryList.do", produces = "text/html;charset=UTF-8")
    public String queryList(PageQueryUtil page, Alimoney alimoney){
        Map<String, Object> resultMap = iAlimoneyService.findAlimoneyPage(page, alimoney);
        return JSON.toJSONStringWithDateFormat(resultMap, "yyyy-MM-dd HH:mm:ss", SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 处理新增生活费信息
     * @param alimoney
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "save.do")
    public RtnResult saveAlimoney(Alimoney alimoney){
        System.out.println("============================ save ok 1");
        return iAlimoneyService.saveAlimoney(alimoney);
    }

    /**
     * 处理删除生活费信息
     * @param alimoney_no
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delete.do")
    public RtnResult deleteAlimoney(int alimoney_no){
        System.out.println("======================= alimoney_no: "+alimoney_no);
        return iAlimoneyService.deleteAlimoney(alimoney_no);
    }

}
