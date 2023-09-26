package com.ebank.app.ebank.web;


import com.ebank.app.ebank.payloads.GenericResponse;
import com.ebank.app.ebank.payloads.LocalClientData;
import com.ebank.app.ebank.services.LocalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/local-clients")
public class LocalClientController {

    @Autowired
    private LocalClientService service;


    @GetMapping("/get/all")
    public GenericResponse getAllLocalClients() {
        List<LocalClientData> localClientData = service.getAllLocalClients();
        return new GenericResponse("List of all local clients data: ", localClientData);
    }


    @PutMapping("/update/{localClientId}")
    public GenericResponse updateLocalClientById(@PathVariable("localClientId")Long localClientId) {
        service.updateLocalClient(localClientId);
        return new GenericResponse("Local Client has been updated successfully ", null);
    }


    @PutMapping("/update")
    public GenericResponse updateLocalClient(@RequestBody LocalClientData localClientData) {
        service.updateLocalClient(localClientData);
        return new GenericResponse("Local Client has been updated successfully ", null);
    }


    @DeleteMapping("/delete/{localClientId}")
    public GenericResponse deleteLocalClientById(@PathVariable("localClientId") Long localClientId) {
        service.deleteLocalClientById(localClientId);
        return new GenericResponse("Local Client has been deleted successfully ", null);
    }


    @PostMapping("/save")
    public GenericResponse saveLocalClient(@RequestBody LocalClientData localClientData) {
        LocalClientData data = service.saveLocalClient(localClientData);
        return new GenericResponse("Local Client has been saved successfully ", data);
    }


    @PostMapping("/research")
    public GenericResponse researchLocalClient(@RequestBody LocalClientData localClientData) {
        LocalClientData data = service.researchLocalClient(localClientData);
        return new GenericResponse("Researched local client successfully" , data);
    }
}
