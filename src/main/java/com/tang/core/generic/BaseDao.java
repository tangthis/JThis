/**
 * 
 */
package com.tang.core.generic;

/**
 * 所有自定义DAO的顶层接口
 * 封装了单表的CRUD操作
 * @author tangthis
 * <p>https://github.com/tangthis</p>
 *
 * @param <Model> POJO模型对象
 * @param <PK> 主键类型
 */
public interface BaseDao<Model,PK> {

    /**
     * 插入对象
     *
     * @param model 对象
     */
    int insertSelective(Model model);

    /**
     * 更新对象
     *
     * @param model 对象
     */
    int updateByPrimaryKeySelective(Model model);

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    int deleteByPrimaryKey(PK id);

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return
     */
    Model selectByPrimaryKey(PK id);
}
