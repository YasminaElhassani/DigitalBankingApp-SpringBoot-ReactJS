package com.ebank.app.ebank.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebank.app.ebank.entities.LocalClient;

import javax.persistence.Tuple;
import java.util.List;
import java.util.Optional;


@Repository
public interface LocalClientRepo extends JpaRepository<LocalClient,Long> {


    Optional<LocalClient> findById(Long id);
    Optional<LocalClient> findByBeneficiaryNameAndRibAndStatus(String name,String rib,Enum status);

    @Override
    void deleteById(Long id);

    @Query(value = "select lc.id,lc.account_number,lc.agency_code,lc.bank,lc.bank_code,lc.beneficiary_name,lc.bank_key,lc.rib,lc.status from local_clients lc" ,nativeQuery = true)
    List<Tuple> findAllFromLocalClientDb();
}
