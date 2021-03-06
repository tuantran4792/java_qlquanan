package POJO_entities;
// Generated May 22, 2016 3:15:16 PM by Hibernate Tools 4.0.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BaseCategory generated by hbm2java
 */
@Entity
@Table(name = "base_category", catalog = "qlquanan")
public class BaseCategory implements java.io.Serializable {

	private Long categoryId;
	private String categoryName;
	private long parentCategoryId;
	private int level;
	private String description;
	private boolean isActived;
	private Date createdDate;
	private int createdUser;
	private Date updatedDate;
	private Integer updatedUser;
	private boolean isDeleted;
	private Date deletedDate;
	private Integer deletedUser;

	public BaseCategory() {
	}

	public BaseCategory(String categoryName, long parentCategoryId, int level, boolean isActived, Date createdDate,
			int createdUser, boolean isDeleted) {
		this.categoryName = categoryName;
		this.parentCategoryId = parentCategoryId;
		this.level = level;
		this.isActived = isActived;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.isDeleted = isDeleted;
	}

	public BaseCategory(String categoryName, long parentCategoryId, int level, String description, boolean isActived,
			Date createdDate, int createdUser, Date updatedDate, Integer updatedUser, boolean isDeleted,
			Date deletedDate, Integer deletedUser) {
		this.categoryName = categoryName;
		this.parentCategoryId = parentCategoryId;
		this.level = level;
		this.description = description;
		this.isActived = isActived;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
		this.isDeleted = isDeleted;
		this.deletedDate = deletedDate;
		this.deletedUser = deletedUser;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "CategoryID", unique = true, nullable = false)
	public Long getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	@Column(name = "CategoryName", nullable = false, length = 200)
	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Column(name = "ParentCategoryID", nullable = false)
	public long getParentCategoryId() {
		return this.parentCategoryId;
	}

	public void setParentCategoryId(long parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	@Column(name = "Level", nullable = false)
	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Column(name = "Description", length = 2000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "IsActived", nullable = false)
	public boolean isIsActived() {
		return this.isActived;
	}

	public void setIsActived(boolean isActived) {
		this.isActived = isActived;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreatedDate", nullable = false, length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CreatedUser", nullable = false)
	public int getCreatedUser() {
		return this.createdUser;
	}

	public void setCreatedUser(int createdUser) {
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

	@Column(name = "IsDeleted", nullable = false)
	public boolean isIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
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

}
