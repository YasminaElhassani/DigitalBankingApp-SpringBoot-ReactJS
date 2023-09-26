package com.ebank.app.ebank.web;


import com.ebank.app.ebank.payloads.GenericResponse;
import com.ebank.app.ebank.payloads.InternationalClientData;
import com.ebank.app.ebank.payloads.LocalClientData;
import com.ebank.app.ebank.services.InternationalClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@RestController
@RequestMapping("/international-clients")
public class InternationalClientController {


    @Autowired
    private InternationalClientService service;


    @GetMapping("/get/all")
    public GenericResponse getAllInternationalClients() {
        List<InternationalClientData> internationalClientData = service.getAllInternationalClients();
        return new GenericResponse("List of all international client data: ", internationalClientData);
    }


    @PutMapping("/update/{internationalClientId}")
    public GenericResponse updateInternationalClientById(@PathVariable("internationalClientId") Long internationalClientId) {
        service.updateInternationalClient(internationalClientId);
        return new GenericResponse("International Client has been updated successfully ", null);
    }


    @PutMapping("/update")
    public GenericResponse updateInternationalClientById(@RequestBody InternationalClientData internationalClientData) {
        service.updateInternationalClient(internationalClientData);
        return new GenericResponse("International Client has been updated successfully ", null);
    }


    @DeleteMapping("/delete/{internationalClientId}")
    public GenericResponse deleteLocalClientById(@PathVariable("internationalClientId") Long internationalClientId) {
        service.deleteInternationalClientById(internationalClientId);
        return new GenericResponse("International Client has been deleted successfully ", null);
    }


    @PostMapping("/save")
    public GenericResponse saveInternationalClient(@RequestBody InternationalClientData internationalClientData) {
        InternationalClientData data = service.saveInternationalClient(internationalClientData);
        return new GenericResponse("International Client has been saved successfully ", data);
    }


    @PostMapping("/research")
    public GenericResponse researchLocalClient(@RequestBody InternationalClientData internationalClientData) {
        InternationalClientData data = service.researchInternationalClientData(internationalClientData);
        return new GenericResponse("Researched international client successfully" , data);
    }
}
