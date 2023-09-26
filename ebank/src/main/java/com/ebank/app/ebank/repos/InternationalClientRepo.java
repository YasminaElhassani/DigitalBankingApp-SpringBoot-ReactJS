package com.ebank.app.ebank.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ebank.app.ebank.entities.InternationalClient;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;


@Repository
public interface InternationalClientRepo extends JpaRepository<InternationalClient, Long> {

    Optional<InternationalClient> findById(Long id);

    Optional<InternationalClient> findByBeneficiaryNameAndIbanAndStatus(String name, String iban, Enum status);


    @Override
    void deleteById(Long id);

    @Query(value = "select lc.id,lc.account_number,lc.agency_code,lc.bank,lc.bank_code,lc.beneficiary_name,lc.bank_key,lc.iban,lc.status from international_clients lc" ,nativeQuery = true)
    List<Tuple> findAllFromInternationalClientDb();
}
