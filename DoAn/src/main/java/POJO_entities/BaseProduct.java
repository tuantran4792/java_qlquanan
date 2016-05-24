package POJO_entities;
// Generated May 22, 2016 3:15:16 PM by Hibernate Tools 4.0.0.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BaseProduct generated by hbm2java
 */
@Entity
@Table(name = "base_product", catalog = "qlquanan")
public class BaseProduct implements java.io.Serializable {

	private Long productId;
	private String barCode;
	private String productName;
	private Long categoryId;
	private boolean isActived;
	private BigDecimal retailPrice;
	private BigDecimal qtyAvailable;
	private Long imageId;
	private Date createdDate;
	private Integer createdUser;
	private Date updatedDate;
	private Integer updatedUser;
	private Date deletedDate;
	private Integer deletedUser;
	private boolean isDeleted;
	private Set<InvStockcard> invStockcards = new HashSet<InvStockcard>(0);
	private Set<SoSaleorderDetail> soSaleorderDetails = new HashSet<SoSaleorderDetail>(0);
	private Set<BaseInventory> baseInventories = new HashSet<BaseInventory>(0);

	public BaseProduct() {
	}

	public BaseProduct(String barCode, String productName, boolean isActived, BigDecimal retailPrice,
			BigDecimal qtyAvailable, boolean isDeleted) {
		this.barCode = barCode;
		this.productName = productName;
		this.isActived = isActived;
		this.retailPrice = retailPrice;
		this.qtyAvailable = qtyAvailable;
		this.isDeleted = isDeleted;
	}

	public BaseProduct(String barCode, String productName, Long categoryId, boolean isActived, BigDecimal retailPrice,
			BigDecimal qtyAvailable, Long imageId, Date createdDate, Integer createdUser, Date updatedDate,
			Integer updatedUser, Date deletedDate, Integer deletedUser, boolean isDeleted,
			Set<InvStockcard> invStockcards, Set<SoSaleorderDetail> soSaleorderDetails,
			Set<BaseInventory> baseInventories) {
		this.barCode = barCode;
		this.productName = productName;
		this.categoryId = categoryId;
		this.isActived = isActived;
		this.retailPrice = retailPrice;
		this.qtyAvailable = qtyAvailable;
		this.imageId = imageId;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
		this.deletedDate = deletedDate;
		this.deletedUser = deletedUser;
		this.isDeleted = isDeleted;
		this.invStockcards = invStockcards;
		this.soSaleorderDetails = soSaleorderDetails;
		this.baseInventories = baseInventories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ProductId", unique = true, nullable = false)
	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Column(name = "BarCode", nullable = false, length = 32)
	public String getBarCode() {
		return this.barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	@Column(name = "ProductName", nullable = false, length = 500)
	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "CategoryID")
	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "IsActived", nullable = false)
	public boolean isIsActived() {
		return this.isActived;
	}

	public void setIsActived(boolean isActived) {
		this.isActived = isActived;
	}

	@Column(name = "RetailPrice", nullable = false, scale = 4)
	public BigDecimal getRetailPrice() {
		return this.retailPrice;
	}

	public void setRetailPrice(BigDecimal retailPrice) {
		this.retailPrice = retailPrice;
	}

	@Column(name = "QtyAvailable", nullable = false, precision = 20, scale = 4)
	public BigDecimal getQtyAvailable() {
		return this.qtyAvailable;
	}

	public void setQtyAvailable(BigDecimal qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}

	@Column(name = "ImageId")
	public Long getImageId() {
		return this.imageId;
	}

	public void setImageId(Long imageId) {
		this.imageId = imageId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedDate", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CreatedUser")
	public Integer getCreatedUser() {
		return this.createdUser;
	}

	public void setCreatedUser(Integer createdUser) {
		this.createdUser = createdUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UpdatedDate", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UpdatedUser")
	public Integer getUpdatedUser() {
		return this.updatedUser;
	}

	public void setUpdatedUser(Integer updatedUser) {
		this.updatedUser = updatedUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DeletedDate", length = 19)
	public Date getDeletedDate() {
		return this.deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	@Column(name = "DeletedUser")
	public Integer getDeletedUser() {
		return this.deletedUser;
	}

	public void setDeletedUser(Integer deletedUser) {
		this.deletedUser = deletedUser;
	}

	@Column(name = "IsDeleted", nullable = false)
	public boolean isIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "baseProduct")
	public Set<InvStockcard> getInvStockcards() {
		return this.invStockcards;
	}

	public void setInvStockcards(Set<InvStockcard> invStockcards) {
		this.invStockcards = invStockcards;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "baseProduct")
	public Set<SoSaleorderDetail> getSoSaleorderDetails() {
		return this.soSaleorderDetails;
	}

	public void setSoSaleorderDetails(Set<SoSaleorderDetail> soSaleorderDetails) {
		this.soSaleorderDetails = soSaleorderDetails;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "baseProduct")
	public Set<BaseInventory> getBaseInventories() {
		return this.baseInventories;
	}

	public void setBaseInventories(Set<BaseInventory> baseInventories) {
		this.baseInventories = baseInventories;
	}

}
