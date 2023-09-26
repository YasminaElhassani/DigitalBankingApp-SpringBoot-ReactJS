package com.ebank.app.ebank.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table; 
import com.ebank.app.ebank.entities.converters.StatusConverter;
import com.ebank.app.ebank.entities.converters.TypeConverter; 
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




@Entity
@Table(name = "international_clients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InternationalClient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @Column(name = "code_bic")
    private String codeBic;


    @Column(name = "iban")
    private String iban;


    @Column(name = "beneficiary_name")
    private String beneficiaryName;


    @Column(name = "bank_code")
    private String bankCode;


    @Column(name = "agency_code")
    private String agencyCode;


    @Column(name = "account_number")
    private String accountNumber;


    @Column(name = "bank_key")
    private Integer key;


    @Column(name = "bank")
    private String bank;


    @Convert(converter = TypeConverter.class)
    @Column(name = "type")
    private Enum type;


    @Convert(converter = StatusConverter.class)
    @Column(name = "status")
    private Enum status;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;
    
}
