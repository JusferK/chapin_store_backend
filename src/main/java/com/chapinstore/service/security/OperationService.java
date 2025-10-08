package com.chapinstore.service.security;

import com.chapinstore.common.mapper.OperationMapper;
import com.chapinstore.dto.security.operation.request.OperationCreationWrapperDto;
import com.chapinstore.dto.security.operation.request.OperationPatchRequestDto;
import com.chapinstore.entity.security.Module;
import com.chapinstore.entity.security.Operation;
import com.chapinstore.repository.security.OperationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private ModuleService moduleService;

    @Autowired
    private OperationMapper operationMapper;

    public List<Operation> create(OperationCreationWrapperDto request) {

        Module findModule = moduleService.find(request.getModuleId());

        return request.getOperations()
                .stream()
                .map(operation -> {
                    Operation transformed = operationMapper.toOperation(operation);
                    transformed.setModule(findModule);
                    return operationRepository.save(transformed);
                })
                .toList();
    }

    public List<Operation> findAll() {
        return operationRepository.findAll();
    }

    public List<Operation> findByPublic() {
        return operationRepository.findByPermitAllIsTrue();
    }

    public Operation find(Long id) {
        return operationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontro la operacion"));
    }

    public OperationPatchRequestDto patch(OperationPatchRequestDto request) {

        Operation find = operationRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException("No se enconntro la operacion"));

        return mapAndUpdate(request, find);
    }

    public Map<String, Boolean> disable(Long id) {

        Operation find = operationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se enconntro la operacion"));

        find.setIsActive(false);
        operationRepository.save(find);

        return Map.of("disabled", Boolean.TRUE);
    }

    private OperationPatchRequestDto mapAndUpdate(OperationPatchRequestDto request, Operation operation) {

        if (request.getPermitAll() != null) operation.setPermitAll(request.getPermitAll());
        if (request.getPath() != null) operation.setPath(request.getPath());
        if (request.getName() != null) operation.setName(request.getName());
        if (request.getMethod() != null) operation.setMethod(request.getMethod());

        operationRepository.save(operation);

        return request;
    }



}
