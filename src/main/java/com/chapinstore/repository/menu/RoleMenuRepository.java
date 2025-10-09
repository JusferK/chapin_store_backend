package com.chapinstore.repository.menu;

import com.chapinstore.entity.menu.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleMenuRepository extends JpaRepository<RoleMenu, Long> {

    List<RoleMenu> findByMenuOperationId(Long roleId);
    List<RoleMenu> findByRoleId(Long roleId);

}