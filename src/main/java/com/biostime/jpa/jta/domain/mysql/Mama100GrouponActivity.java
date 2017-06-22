package com.biostime.jpa.jta.domain.mysql;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 拼团活动配置
 * @author wcj
 * @date 2017年5月22日 上午10:14:49
 */
@Entity
@Table(name = "mama100_group_on_activity")
public class Mama100GrouponActivity implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 活动配置id
	 */
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
	private Long id;
	/**
	 * 拼团活动名称，标题
	 */
	@Column(name="name")
	private String name;
	/**
	 * 平台类型，1妈妈100，2swisse
	 */
	@Column(name="platform_type")
	private Integer platformType;
	/**
	 * 拼团活动编码
	 */
	@Column(name="activity_code")
	private String activityCode;
	/**
	 * 商品sku
	 */
	private Long sku;
	/**
	 * 商品名称
	 */
	@Column(name="sku_name")
	private String skuName;
	/**
	 * 拼团价格
	 */
	private Double price;
	/**
	 * 总库存
	 */
	@Column(name="total_stock")
	private Integer totalStock;
	/**
	 * 剩余库存
	 */
	@Column(name="remain_stock")
	private Integer remainStock;
	/**
	 * 成团人数
	 */
	private Integer num;
	/**
	 * 活动开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name="start_time")
	private Date startTime;
	/**
	 * 活动结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name="end_time")
	private Date endTime;
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name="create_time")
	private Date createTime;
	/**
	 * 重要说明
	 */
	private String description;
	
	/**
	 * 优惠券id
	 */
	@Column(name="coupon_id")
	private String couponId;
	/**
	 * 优惠券客户端展示类型，1线上券2通用券3线下券
	 */
	@Column(name="coupon_type")
	private Integer couponType;
	/**
	 * 拼团有效时间
	 */
	private Integer duration;
	/**
	 * 开启状态，0待上线1已下线2已上线
	 */
	private Integer status;
	/**
	 * 创建人id
	 */
	@Column(name="create_user_id")
	private String createUserId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPlatformType() {
		return platformType;
	}

	public void setPlatformType(Integer platformType) {
		this.platformType = platformType;
	}

	public String getActivityCode() {
		return activityCode;
	}

	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public Long getSku() {
		return sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSkuName() {
		return skuName;
	}

	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}

	public Integer getTotalStock() {
		return totalStock;
	}

	public void setTotalStock(Integer totalStock) {
		this.totalStock = totalStock;
	}

	public Integer getRemainStock() {
		return remainStock;
	}

	public void setRemainStock(Integer remainStock) {
		this.remainStock = remainStock;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public Integer getCouponType() {
		return couponType;
	}

	public void setCouponType(Integer couponType) {
		this.couponType = couponType;
	}
}
