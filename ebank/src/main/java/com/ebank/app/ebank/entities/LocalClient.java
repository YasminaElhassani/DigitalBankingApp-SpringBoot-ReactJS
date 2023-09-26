package com.ebank.app.ebank.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Converter;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.mapping.List;

import com.ebank.app.ebank.entities.converters.StatusConverter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Entity
@Table(name = "local_clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LocalClient {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "rib")
    private String rib;


    @Column(name = "beneficiary_name")
    private String beneficiaryName;


    @Column(name = "bank_code")
    private String bankCode;


    @Column(name = "agency_code")
    private String agencyCode;


    @Column(name = "account_number")
    private String accountNumber;


    @Column(name = "`bank_key`")
    private Integer key;


    @Column(name = "bank")
    private String bank;


    @Convert(converter = StatusConverter.class)
    @Column(name = "status")
    private Enum status;


    @OneToOne(cascade = CascadeType.ALL) 
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

}
