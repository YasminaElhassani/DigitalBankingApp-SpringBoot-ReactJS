package com.ebank.app.ebank.mappers;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.ebank.app.ebank.entities.User;
import com.ebank.app.ebank.enums.Status;
import com.ebank.app.ebank.payloads.LocalClientData;
import com.ebank.app.ebank.entities.LocalClient;


public final class LocalClientMapper {


    private LocalClientMapper() {

    }


    public static List<LocalClientData> mapToListOfData(List<LocalClient> localClients) {
        return localClients
                .stream()
                .map(localClient -> new LocalClientData(
                        localClient.getId(),
                        localClient.getBeneficiaryName(),
                        localClient.getRib(),
                        localClient.getStatus().toString(),
                        localClient.getBankCode(),
                        localClient.getAgencyCode(),
                        localClient.getAccountNumber(),
                        localClient.getKey(),
                        localClient.getBank()))
                .toList();
    }


    public static LocalClient mapToEntityForUpdate(LocalClient localClient) {
        localClient.setStatus(Status.SIGNED);
        return localClient;
    }


    public static LocalClient mapToEntityForUpdate(LocalClient localClient,LocalClientData localClientData) {
        localClient.setBeneficiaryName(localClientData.name());
        localClient.setBankCode(localClientData.bankCode());
        localClient.setAgencyCode(localClientData.agencyCode());
        localClient.setAccountNumber(localClientData.accountNumber());
        localClient.setKey(localClientData.key());
        localClient.setBank(localClientData.bank());
        localClient.setStatus(Status.SAVED);
        return localClient;
    }


    public static LocalClient mapToEntity(LocalClientData data) {
        LocalClient localClient = new LocalClient();
        localClient.setUser(new User());
        localClient.setBeneficiaryName(data.name());
        localClient.setRib(data.bankCode() + data.agencyCode() + data.accountNumber() + data.key());
        localClient.setBankCode(data.bankCode());
        localClient.setAgencyCode(data.agencyCode());
        localClient.setAccountNumber(data.accountNumber());
        localClient.setKey(data.key());
        localClient.setBank(data.bank());
        localClient.setStatus(Status.SAVED);
        return localClient;
    }


    public static LocalClientData mapToData(LocalClient localClient) {
        return new LocalClientData(
                localClient.getId(),
                localClient.getBeneficiaryName(),
                localClient.getRib(),
                localClient.getStatus().toString(),
                localClient.getBankCode(),
                localClient.getAgencyCode(),
                localClient.getAccountNumber(),
                localClient.getKey(),
                localClient.getBank()
        );
    }

}
