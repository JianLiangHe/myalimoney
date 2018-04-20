package edu.myalimoney.service;

import edu.myalimoney.dto.RtnResult;
import edu.myalimoney.pojo.Alimoney;
import edu.myalimoney.util.PageQueryUtil;

import java.util.Map;

/**
 * 定义生活费相关业务的接口
 */
public interface IAlimoneyService {

    /**
     * 新增生活费信息
     * @param alimoney 生活费对象
     * @return
     */
    RtnResult saveAlimoney(Alimoney alimoney);

    /**
     * 分页带条件查询生活费列表
     * @param page  分页对象
     * @param alimoney 生活费对象
     * @return
     */
    Map<String, Object> findAlimoneyPage(PageQueryUtil page, Alimoney alimoney);

    /**
     * 删除生活费信息
     * @param alimoney_no
     * @return
     */
    RtnResult deleteAlimoney(int alimoney_no);
}
