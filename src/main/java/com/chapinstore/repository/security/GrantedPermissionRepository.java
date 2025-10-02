package com.chapinstore.repository.security;

import com.chapinstore.entity.security.GrantedPermission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrantedPermissionRepository extends JpaRepository<GrantedPermission, Long> {}