package com.rose.controler;

import com.rose.data.entity.TbMenu;
import com.rose.data.entity.TbRoleGroup;
import com.rose.data.to.request.MenuEditRequest;
import com.rose.service.MenuService;
import com.rose.service.RoleGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

/**
 * 功能：角色管理 controller
 * @author sunpeng
 * @date 2018
 */
@Slf4j
@RestController
@RequestMapping("/user/roleManage")
public class RoleManageControler {

    @Inject
    private RoleGroupService roleGroupService;
    @Inject
    private MenuService menuService;

    /**
     * 功能：权限分组列表
     * @param roleState 0：正常 1：冻结 2：查询全部
     * @return
     * @throws Exception
     */
    @GetMapping(value= "/list")
    public List<TbRoleGroup> list(@RequestParam Integer roleState) throws Exception {
        return roleGroupService.list(roleState);
    }

    /**
     * 功能：权限分组列表
     * @param roleName
     * @return
     * @throws Exception
     */
    @GetMapping(value= "/add")
    public void add(@RequestParam String roleName, @RequestParam(required = false) String roleRemark) throws Exception {
        roleGroupService.add(roleName, roleRemark);
    }

    /**
     * 功能：权限分组列表
     * @param id
     * @param roleName
     * @param roleRemark
     * @throws Exception
     */
    @GetMapping(value= "/update")
    public void update(@RequestParam Long id, @RequestParam String roleName, @RequestParam(required = false) String roleRemark) throws Exception {
        roleGroupService.update(id, roleName, roleRemark);
    }

    @GetMapping(value= "/opert")
    public void opert(@RequestParam Long id, @RequestParam Integer state) throws Exception {
        roleGroupService.opert(id, state);
    }

    @GetMapping(value= "/getDetail")
    public TbRoleGroup getDetail(@RequestParam Long id) throws Exception {
        return roleGroupService.getDetail(id);
    }

    /**
     * 功能：获取某角色下的选中菜单
     * 备注：返回全部非冻结菜单列表，其中关联到该角色上的菜单会标记为选中
     * @param id 角色组id
     * @return
     */
    @GetMapping(value = "/getMenuTreeByRoleId")
    public List<TbMenu> getMenuTreeByRoleId(@RequestParam Long id) {
        return menuService.getMenuTreeByRoleId(id);
    }

    /**
     * 功能：保存角色菜单
     * @param param
     */
    @PostMapping(value = "/menuSave")
    public void menuSave(@RequestBody @Validated(MenuEditRequest.BaseInfo.class) MenuEditRequest param) {
        menuService.saveRoleMenus(param.getRoleGroupId(), param.getMenuIds());
    }
}