package edu.myalimoney.dao;

import edu.myalimoney.pojo.Alimoney;

import java.util.List;
import java.util.Map;

/**
 * 定义生活费相关数据操作的Dao
 */
public interface IAlimoneyDao {

    /**
     * 分页查询生活费
     * @param map
     * @return
     */
    List<Alimoney> findAlimoneyPage(Map<String, Object> map);

    /**
     * 查询生活费数据条数
     * @param map
     * @return
     */
    int findAlimoneyPageCount(Map<String, Object> map);

    /**
     * 新增生活费信息
     * @param alimoney
     */
    void insert(Alimoney alimoney);

    /**
     * 根据id删除生活费信息
     * @param alimoney_no
     */
    void delete(int alimoney_no);
}
