package com.tang.core.generic;
/**
 * 实现BaseService，封装了增删改查操作
 * 自己业务Service可以继承它，或者实现BaseService接口，
 * @author tangthis
 * <p>https://github.com/tangthis</p>
 *
 * @param <Model> POJO模型对象
 * @param <PK> 主键类型
 */
public abstract class BaseServiceImpl<Model, PK> implements BaseService<Model, PK> {

    /**
     * 定义成抽象方法,由子类实现,完成dao的注入
     *
     * @return BaseDao实现类
     */
    public abstract BaseDao<Model, PK> getDao();

    /**
     * 插入对象
     *
     * @param model 对象
     */
    public int insert(Model model) {
        return getDao().insertSelective(model);
    }

    /**
     * 更新对象
     *
     * @param model 对象
     */
    public int update(Model model) {
        return getDao().updateByPrimaryKeySelective(model);
    }

    /**
     * 通过主键, 删除对象
     *
     * @param id 主键
     */
    public int delete(PK id) {
        return getDao().deleteByPrimaryKey(id);
    }

    /**
     * 通过主键, 查询对象
     *
     * @param id 主键
     * @return
     */
    public Model selectById(PK id) {
        return getDao().selectByPrimaryKey(id);
    }
    
}
