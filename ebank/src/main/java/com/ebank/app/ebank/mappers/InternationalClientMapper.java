package com.ebank.app.ebank.mappers;

import com.ebank.app.ebank.entities.InternationalClient;
 import com.ebank.app.ebank.entities.User;
import com.ebank.app.ebank.enums.Status;
import com.ebank.app.ebank.enums.Type;
import com.ebank.app.ebank.payloads.InternationalClientData;


import java.util.List;
import java.util.Random;
import java.util.UUID;

public final class InternationalClientMapper {


    private InternationalClientMapper() {

    }


    public static List<InternationalClientData> mapToListOfData(List<InternationalClient> internationalClients) {
        return internationalClients
                .stream()
                .map(internationalClient -> new InternationalClientData(
                        internationalClient.getId(),
                        internationalClient.getUser().getName(),
                        internationalClient.getCodeBic(),
                        internationalClient.getIban(),
                        internationalClient.getType().toString(),
                        internationalClient.getStatus().toString(),
                        internationalClient.getBankCode(),
                        internationalClient.getAgencyCode(),
                        internationalClient.getAccountNumber(),
                        internationalClient.getKey(),
                        internationalClient.getBank()))
                .toList();
    }


    public static InternationalClient mapToEntityForUpdate(InternationalClient internationalClient) {
        internationalClient.setStatus(Status.SIGNED);
        return internationalClient;
    }


    public static InternationalClient mapToEntityForUpdate(InternationalClient internationalClient, InternationalClientData internationalClientData) {
        internationalClient.setBeneficiaryName(internationalClientData.name());
        internationalClient.setBankCode(internationalClientData.bankCode());
        internationalClient.setAgencyCode(internationalClientData.agencyCode());
        internationalClient.setAccountNumber(internationalClientData.accountNumber());
        internationalClient.setKey(internationalClientData.key());
        internationalClient.setBank(internationalClientData.bank());
        internationalClient.setStatus(Status.SAVED);
        return internationalClient;
    }


    public static InternationalClient mapToEntity(InternationalClientData data) {
        InternationalClient internationalClient = new InternationalClient();
        internationalClient.setUser(new User());
        internationalClient.getUser().setName(data.name());
        internationalClient.setCodeBic(data.codeBic());
        internationalClient.setIban(data.iban());
        internationalClient.setType(Type.AUTRES);
        internationalClient.setStatus(Status.SAVED);
        internationalClient.setBankCode(data.bankCode());
        internationalClient.setAgencyCode(data.agencyCode());
        internationalClient.setAccountNumber(data.accountNumber());
        internationalClient.setKey(data.key());
        internationalClient.setBank(data.bank());
        return internationalClient;
    }


    public static InternationalClientData mapToData(InternationalClient internationalClient) {
        return new InternationalClientData(
                internationalClient.getId(),
                internationalClient.getUser().getName(),
                internationalClient.getCodeBic(),
                internationalClient.getIban(),
                internationalClient.getType().toString(),
                internationalClient.getStatus().toString(),
                internationalClient.getBankCode(),
                internationalClient.getAgencyCode(),
                internationalClient.getAccountNumber(),
                internationalClient.getKey(),
                internationalClient.getBank()
        );
    }
}
