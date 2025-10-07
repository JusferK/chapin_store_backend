package com.chapinstore.service.security;

import com.chapinstore.dto.security.module.request.ModuleCreationRequestDto;
import com.chapinstore.dto.security.module.request.ModulePatchRequestDto;
import com.chapinstore.entity.security.Module;
import com.chapinstore.repository.security.ModuleRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    public Module create(ModuleCreationRequestDto request) {

        moduleRepository.findByName(request.getName())
                .ifPresent(module -> {
                    throw new EntityExistsException("Este modulo ya existe");
                });

        return moduleRepository.save(new Module(request.getName(), request.getBasePath()));
    }

    public List<Module> findAll() {
        return moduleRepository.findAll();
    }

    public Module find(Long id) {
        return moduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Este module no encontrado"));
    }

    public ModulePatchRequestDto update(ModulePatchRequestDto request) {
        Module module = moduleRepository.findByName(request.getName())
                .orElseThrow(() -> new EntityNotFoundException("Modulo no fue encontrado."));


        return mapAndUpdate(module, request);
    }

    public Map<String, Boolean> disable(Long id) {

        Module find = moduleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Modulo no fue encontrado."));

        find.setActive(false);
        moduleRepository.save(find);

        return Map.of("disabled", Boolean.TRUE);
    }

    private ModulePatchRequestDto mapAndUpdate(Module module, ModulePatchRequestDto request) {
        if (request.getBasePath() != null) module.setBasePath(request.getBasePath());
        if (request.getName() != null) module.setName(request.getName());
        if (request.getActive() != null) module.setActive(request.getActive());

        moduleRepository.save(module);
        return request;
    }


}
