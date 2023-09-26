package com.ebank.app.ebank.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InternationalClientData(

        @JsonProperty("id") Long id,
        @JsonProperty("name") String name,
        @JsonProperty("codeBic") String codeBic,
        @JsonProperty("iban") String iban,
        @JsonProperty("type") String type,
        @JsonProperty("status") String status,
        @JsonProperty("bankCode") String bankCode,
        @JsonProperty("agencyCode") String agencyCode,
        @JsonProperty("accountNumber") String accountNumber,
        @JsonProperty("key") Integer key,
        @JsonProperty("bank") String bank
) {
}
