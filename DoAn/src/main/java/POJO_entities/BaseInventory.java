package POJO_entities;
// Generated May 22, 2016 3:15:16 PM by Hibernate Tools 4.0.0.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BaseInventory generated by hbm2java
 */
@Entity
@Table(name = "base_inventory", catalog = "qlquanan")
public class BaseInventory implements java.io.Serializable {

	private Long id;
	private BaseProduct baseProduct;
	private BigDecimal qtyAvailable;
	private BigDecimal cogs;
	private Date updatedDate;
	private int updatedUser;
	private Boolean isDeleted;
	private Integer deletedUser;

	public BaseInventory() {
	}

	public BaseInventory(BaseProduct baseProduct, BigDecimal qtyAvailable, BigDecimal cogs, int updatedUser) {
		this.baseProduct = baseProduct;
		this.qtyAvailable = qtyAvailable;
		this.cogs = cogs;
		this.updatedUser = updatedUser;
	}

	public BaseInventory(BaseProduct baseProduct, BigDecimal qtyAvailable, BigDecimal cogs, Date updatedDate,
			int updatedUser, Boolean isDeleted, Integer deletedUser) {
		this.baseProduct = baseProduct;
		this.qtyAvailable = qtyAvailable;
		this.cogs = cogs;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
		this.isDeleted = isDeleted;
		this.deletedUser = deletedUser;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ID", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProductId", nullable = false)
	public BaseProduct getBaseProduct() {
		return this.baseProduct;
	}

	public void setBaseProduct(BaseProduct baseProduct) {
		this.baseProduct = baseProduct;
	}

	@Column(name = "QtyAvailable", nullable = false, precision = 20, scale = 4)
	public BigDecimal getQtyAvailable() {
		return this.qtyAvailable;
	}

	public void setQtyAvailable(BigDecimal qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}

	@Column(name = "COGS", nullable = false, scale = 4)
	public BigDecimal getCogs() {
		return this.cogs;
	}

	public void setCogs(BigDecimal cogs) {
		this.cogs = cogs;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UpdatedDate", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UpdatedUser", nullable = false)
	public int getUpdatedUser() {
		return this.updatedUser;
	}

	public void setUpdatedUser(int updatedUser) {
		this.updatedUser = updatedUser;
	}

	@Column(name = "IsDeleted")
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Column(name = "DeletedUser")
	public Integer getDeletedUser() {
		return this.deletedUser;
	}

	public void setDeletedUser(Integer deletedUser) {
		this.deletedUser = deletedUser;
	}

}
