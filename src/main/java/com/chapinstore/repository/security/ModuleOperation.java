package com.chapinstore.repository.security;

import com.chapinstore.entity.security.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleOperation extends JpaRepository<Module, Long> {}
