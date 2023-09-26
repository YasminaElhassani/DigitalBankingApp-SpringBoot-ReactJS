package com.ebank.app.ebank.services;

import com.ebank.app.ebank.entities.LocalClient;
import com.ebank.app.ebank.enums.Status;
import com.ebank.app.ebank.mappers.LocalClientMapper;
import com.ebank.app.ebank.payloads.LocalClientData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ebank.app.ebank.repos.LocalClientRepo;

import java.util.List;
import java.util.Optional;


@Service
public class LocalClientService {


    @Autowired
    private LocalClientRepo repo;


    public List<LocalClientData> getAllLocalClients() {
        return LocalClientMapper.mapToListOfData(repo.findAll());
    }


    public void updateLocalClient(Long localClientId) {
        LocalClient localClient = repo.findById(localClientId).get();
        localClient = LocalClientMapper.mapToEntityForUpdate(localClient);
        repo.save(localClient);
    }


    public void deleteLocalClientById(Long localClientId) {
        repo.deleteById(localClientId);
    }

    public LocalClientData saveLocalClient(LocalClientData localClientData) {
        LocalClient localClient = repo.save(LocalClientMapper.mapToEntity(localClientData));
        return LocalClientMapper.mapToData(localClient);
    }


    public void updateLocalClient(LocalClientData localClientData) {
        LocalClient localClient = repo.findById(localClientData.id()).get();
        localClient = LocalClientMapper.mapToEntityForUpdate(localClient,localClientData);
        repo.save(localClient);
    }


    public LocalClientData researchLocalClient(LocalClientData localClientData) {
        LocalClient localClient = repo.findByBeneficiaryNameAndRibAndStatus(localClientData.name(),
                localClientData.rib(), Status.getByType(localClientData.status())).get();

        return LocalClientMapper.mapToData(localClient);
    }

}
