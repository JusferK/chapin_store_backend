package com.chapinstore.service.menu;

import com.chapinstore.entity.menu.RoleMenu;
import com.chapinstore.repository.menu.RoleMenuRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleMenuService {

    @Autowired
    private RoleMenuRepository roleMenuRepository;

    public void save(Long menuOperationId, Long roleId) {
        roleMenuRepository.save(new RoleMenu(menuOperationId, roleId));
    }

    public Map<String, Boolean> delete(Long id) {

        RoleMenu roleMenu = roleMenuRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro relacion"));

        roleMenuRepository.delete(roleMenu);

        return Map.of("deleted", Boolean.TRUE);
    }

    public void findByMenuAndDelete(Long menuId) {
        List<RoleMenu> list = roleMenuRepository.findByMenuOperationId(menuId);
        roleMenuRepository.deleteAll(list);
    }

    public List<RoleMenu> findByRole(Long roleId) {
        return roleMenuRepository.findByRoleId(roleId);
    }

}
