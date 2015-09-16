package com.tang.core.generic;


/**
 * 所有Service顶级接口，封装常用的增删改查
 * @author tangthis
 * <p>https://github.com/tangthis</p>
 *
 * @param <Model> POJO模型对象
 * @param <PK> 主键类型
 */
public interface BaseService<Model, PK> {

    /**
     * 插入对象
     *
     * @param model 对象
     */
    int insert(Model model);

    /**
     * 更新对象
     *
     * @param model 对象
     */
    int update(Model model);

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    int delete(PK id);

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return model 对象
     */
    Model selectById(PK id);

}
