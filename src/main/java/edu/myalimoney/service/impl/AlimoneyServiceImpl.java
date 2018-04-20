package edu.myalimoney.service.impl;

import edu.myalimoney.dao.IAlimoneyDao;
import edu.myalimoney.dto.RtnResult;
import edu.myalimoney.pojo.Alimoney;
import edu.myalimoney.service.IAlimoneyService;
import edu.myalimoney.util.PageQueryUtil;
import edu.myalimoney.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理生活费相关业务的实现类
 */
@Service("iAlimoneyService")
@Transactional(propagation = Propagation.REQUIRED)
public class AlimoneyServiceImpl implements IAlimoneyService {

    //声明Dao
    @Autowired
    private IAlimoneyDao iAlimoneyDao;

    /**
     * 新增生活费
     * @param alimoney
     */
    @Override
    public RtnResult saveAlimoney(Alimoney alimoney) {
        try {
            System.out.println("==============================saveAlimoney");
            iAlimoneyDao.insert(alimoney);
            return new RtnResult(WebUtils.SUCCESS_RESULT, WebUtils.SUCCESS_STATUS, WebUtils.SUCCESS_MESSAGE);
        } catch (RuntimeException e) {
            return new RtnResult(WebUtils.ERROR_RESULT, WebUtils.ERROR_STATUS, WebUtils.ERROR_MESSAGE);
        }
    }

    /**
     * 分页带条件查询生活费
     * @param page
     * @return
     */
    @Override
    public Map<String, Object> findAlimoneyPage(PageQueryUtil page, Alimoney alimoney) {
        Map<String, Object> conditions = new HashMap<>();
        conditions.put("page", page);
        //判断条件
        /*if(alimoney!=null){
            if(alimoney.getAlimoney_title()!=null){
                conditions.put("alimoney", alimoney);
            }
        }*/
        int totalSize = iAlimoneyDao.findAlimoneyPageCount(conditions);
        //page.setCurrentPage(page.getPage());
        page.setPageSize(page.getRows());

        List<Alimoney> cList = iAlimoneyDao.findAlimoneyPage(conditions);
        Map<String, Object> result = new HashMap(){{
            put("rows", cList);
            put("total", totalSize);
        }};
        return result;
    }

    @Override
    public RtnResult deleteAlimoney(int alimoney_no) {
        try {
            iAlimoneyDao.delete(alimoney_no);
            return new RtnResult(WebUtils.SUCCESS_RESULT, WebUtils.SUCCESS_STATUS, WebUtils.SUCCESS_MESSAGE);
        } catch (RuntimeException e) {
            return new RtnResult(WebUtils.ERROR_RESULT, WebUtils.ERROR_STATUS, "删除生活费信息失败.");
        }
    }
}
