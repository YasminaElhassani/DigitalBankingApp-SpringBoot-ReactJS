package com.ebank.app.ebank.payloads;
 

import com.fasterxml.jackson.annotation.JsonProperty;



public record LocalClientData(
   @JsonProperty("id") Long id,
   @JsonProperty("name") String name,
   @JsonProperty("rib") String rib,
   @JsonProperty("status") String status,
   @JsonProperty("bankCode") String bankCode,
   @JsonProperty("agencyCode") String agencyCode,
   @JsonProperty("accountNumber") String accountNumber,
   @JsonProperty("key") Integer key,
   @JsonProperty("bank") String bank
) {
    
}
