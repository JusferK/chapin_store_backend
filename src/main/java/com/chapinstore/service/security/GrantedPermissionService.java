package com.chapinstore.service.security;

import com.chapinstore.dto.security.granted_permission.GrantedPermissionWrapperDto;
import com.chapinstore.entity.security.GrantedPermission;
import com.chapinstore.entity.security.Operation;
import com.chapinstore.entity.security.Role;
import com.chapinstore.repository.security.GrantedPermissionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class GrantedPermissionService {

    @Autowired
    private GrantedPermissionRepository grantedPermissionRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private OperationService operationService;

    public List<GrantedPermission> create(GrantedPermissionWrapperDto request) {

        List<GrantedPermission> list = request.getPermissions()
                .stream()
                .map(grantedPermission -> {

                    Role findRole = roleService.find(grantedPermission.getRoleId());
                    Operation findOperation = operationService.find(grantedPermission.getOperationId());

                    return new GrantedPermission(findRole, findOperation);
                })
                .toList();

        return grantedPermissionRepository.saveAll(list);
    }

    public Map<String, Boolean> delete(Long id) {

        GrantedPermission find = grantedPermissionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la operacion"));
        grantedPermissionRepository.delete(find);

        return Map.of("deleted", Boolean.TRUE);
    }

}