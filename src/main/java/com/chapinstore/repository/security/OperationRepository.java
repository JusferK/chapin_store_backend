package com.chapinstore.repository.security;

import com.chapinstore.entity.security.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation, Long> {}