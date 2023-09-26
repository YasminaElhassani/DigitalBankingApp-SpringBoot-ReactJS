package com.ebank.app.ebank.services;


import com.ebank.app.ebank.entities.InternationalClient;
import com.ebank.app.ebank.entities.LocalClient;
import com.ebank.app.ebank.enums.Status;
import com.ebank.app.ebank.mappers.InternationalClientMapper;
import com.ebank.app.ebank.mappers.LocalClientMapper;
import com.ebank.app.ebank.payloads.InternationalClientData;
import com.ebank.app.ebank.payloads.LocalClientData;
import com.ebank.app.ebank.repos.InternationalClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InternationalClientService {


    @Autowired
    private InternationalClientRepo repo;


    public List<InternationalClientData> getAllInternationalClients() {
        return InternationalClientMapper.mapToListOfData(repo.findAll());
    }


    public void updateInternationalClient(Long internationalClientId) {
        InternationalClient internationalClient = repo.findById(internationalClientId).get();
        internationalClient = InternationalClientMapper.mapToEntityForUpdate(internationalClient);
        repo.save(internationalClient);
    }


    public void updateInternationalClient(InternationalClientData internationalClientData) {
        InternationalClient internationalClient = repo.findById(internationalClientData.id()).get();
        internationalClient = InternationalClientMapper.mapToEntityForUpdate(internationalClient, internationalClientData);
        repo.save(internationalClient);
    }


    public void deleteInternationalClientById(Long internationalClientId) {
        repo.deleteById(internationalClientId);
    }


    public InternationalClientData saveInternationalClient(InternationalClientData internationalClientData) {
        InternationalClient internationalClient = repo.save(InternationalClientMapper.mapToEntity(internationalClientData));
        return InternationalClientMapper.mapToData(internationalClient);
    }


    public InternationalClientData researchInternationalClientData(InternationalClientData internationalClientData) {
        InternationalClient internationalClient = repo.findByBeneficiaryNameAndIbanAndStatus(internationalClientData.name(),
                internationalClientData.iban(),
                Status.getByType(internationalClientData.status())).get();

        return InternationalClientMapper.mapToData(internationalClient);
    }
}
