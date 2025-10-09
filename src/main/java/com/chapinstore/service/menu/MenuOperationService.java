package com.chapinstore.service.menu;

import com.chapinstore.common.mapper.MenuOperationMapper;
import com.chapinstore.dto.menu.request.MenuOperationCreationDto;
import com.chapinstore.dto.menu.request.MenuOperationPatchDto;
import com.chapinstore.entity.Administrator;
import com.chapinstore.entity.menu.MenuOperation;
import com.chapinstore.entity.menu.RoleMenu;
import com.chapinstore.repository.menu.MenuOperationRepository;
import com.chapinstore.service.AdministratorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MenuOperationService {

    @Autowired
    private MenuOperationRepository menuOperationRepository;

    @Autowired
    private MenuOperationMapper menuOperationMapper;

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private RoleMenuService roleMenuService;

    public MenuOperation create(MenuOperationCreationDto request) {

        Administrator findAdmin = getAdministrator(request.getUsername());
        MenuOperation menuOperation = menuOperationMapper.toMenuOperation(request);
        menuOperation = menuOperationRepository.save(menuOperation);
        roleMenuService.save(menuOperation.getId(), findAdmin.getRole().getId());

        return menuOperation;
    }

    public List<MenuOperation> findAll() {
        return menuOperationRepository.findAll();
    }

    public List<MenuOperation> findByRole(String username) {

        Administrator findAdmin = getAdministrator(username);
        List<RoleMenu> assignedMenus = roleMenuService.findByRole(findAdmin.getRole().getId());

        return assignedMenus.stream()
                .map(
                        relation -> menuOperationRepository
                                                .findById(relation.getMenuOperationId())
                                                .orElseThrow(() -> new EntityNotFoundException("No se encontro un menu al intentar recuperar los menus asignados"))
                )
                .filter(MenuOperation::getIsFather)
                .toList();
    }

    public MenuOperationPatchDto patch(MenuOperationPatchDto request) {

        MenuOperation find = menuOperationRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el menu."));

        mapAndUpdate(request, find);

        return request;
    }

    public Map<String, Boolean> delete(Long id) {

        MenuOperation find = menuOperationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro el menu."));

        roleMenuService.findByMenuAndDelete(find.getId());
        menuOperationRepository.delete(find);
        return Map.of("delete", Boolean.TRUE);
    }

    private void mapAndUpdate(MenuOperationPatchDto request, MenuOperation menu) {

        if (request.getLabel() != null) menu.setLabel(request.getLabel());
        if (request.getIcon() != null) menu.setIcon(request.getIcon());
        if (request.getRouterLink() != null) menu.setRouterLink(request.getRouterLink());
        if (request.getIsFather() != null) menu.setIsFather(request.getIsFather());

        menuOperationRepository.save(menu);
    }

    private Administrator getAdministrator(String username){
        return administratorService.find(username);
    }

}
