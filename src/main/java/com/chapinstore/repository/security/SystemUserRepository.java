package com.chapinstore.repository.security;

import com.chapinstore.entity.security.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemUserRepository extends JpaRepository<SystemUser, Integer> {}