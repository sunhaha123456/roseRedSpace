package com.rose.repository;

import com.rose.common.data.base.PageList;
import com.rose.common.repository.BaseRepository;
import com.rose.data.entity.TbSysUser;

public interface SysUserRepositoryCustom extends BaseRepository {
    /**
     * 功能：用户条件分页查询
     * 备注：其中 id = 1的用户为上帝用户，不会被查询出来，也由此不会被操作
     * @param uname
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    PageList<TbSysUser> list(String uname, Integer pageNo, Integer pageSize) throws Exception;
}