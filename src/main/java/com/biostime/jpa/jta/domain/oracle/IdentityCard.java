package com.biostime.jpa.jta.domain.oracle;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Wuxi on 2016/8/11.
 */
@Entity
@Table(name = "cust_identity_card", schema = "MAMA100_CUST")
public class IdentityCard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust_identity_card_seq")
	@SequenceGenerator(name = "cust_identity_card_seq", sequenceName = "MAMA100_CUST.cust_identity_card_seq", allocationSize = 1)
    @Column(name = "id")
    private Long id;
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "id_card_name")
    private String idCardName;
    @Column(name = "id_card_no")
    private String idCardNo;
    @Column(name = "is_default")
    private Integer isDefault;
    @Column(name = "front_url")
    private String frontUrl;
    @Column(name = "back_url")
    private String backUrl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public String getIdCardName() {
		return idCardName;
	}
	public void setIdCardName(String idCardName) {
		this.idCardName = idCardName;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public String getFrontUrl() {
		return frontUrl;
	}
	public void setFrontUrl(String frontUrl) {
		this.frontUrl = frontUrl;
	}
	public String getBackUrl() {
		return backUrl;
	}
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}
	
}
