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
 * SystemPrinttemplate generated by hbm2java
 */
@Entity
@Table(name = "system_printtemplate", catalog = "qlquanan")
public class SystemPrinttemplate implements java.io.Serializable {

	private Integer id;
	private String code;
	private String name;
	private int type;
	private String content;
	private boolean isSelected;
	private Date createdDate;
	private int createdUser;
	private Date updatedDate;
	private Integer updatedUser;
	private Date deletedDate;
	private Integer deletedUser;
	private int companyId;
	private boolean isDeleted;

	public SystemPrinttemplate() {
	}

	public SystemPrinttemplate(String code, String name, int type, String content, boolean isSelected, Date createdDate,
			int createdUser, int companyId, boolean isDeleted) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.content = content;
		this.isSelected = isSelected;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.companyId = companyId;
		this.isDeleted = isDeleted;
	}

	public SystemPrinttemplate(String code, String name, int type, String content, boolean isSelected, Date createdDate,
			int createdUser, Date updatedDate, Integer updatedUser, Date deletedDate, Integer deletedUser,
			int companyId, boolean isDeleted) {
		this.code = code;
		this.name = name;
		this.type = type;
		this.content = content;
		this.isSelected = isSelected;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
		this.deletedDate = deletedDate;
		this.deletedUser = deletedUser;
		this.companyId = companyId;
		this.isDeleted = isDeleted;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "Code", nullable = false, length = 20)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "Name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Type", nullable = false)
	public int getType() {
		return this.type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "Content", nullable = false)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "IsSelected", nullable = false)
	public boolean isIsSelected() {
		return this.isSelected;
	}

	public void setIsSelected(boolean isSelected) {
		this.isSelected = isSelected;
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

	@Column(name = "CompanyId", nullable = false)
	public int getCompanyId() {
		return this.companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	@Column(name = "IsDeleted", nullable = false)
	public boolean isIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
