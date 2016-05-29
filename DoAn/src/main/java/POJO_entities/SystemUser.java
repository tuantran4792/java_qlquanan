package POJO_entities;
// Generated May 22, 2016 3:15:16 PM by Hibernate Tools 4.0.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * SystemUser generated by hbm2java
 */
@Entity
@Table(name = "system_user", catalog = "qlquanan", uniqueConstraints = @UniqueConstraint(columnNames = "UserId"))
public class SystemUser implements java.io.Serializable {

	private Long id;
	private SystemUserAccount systemUserAccount;
	private String fullname;
	private Date birthday;
	private String address;
	private String phone;
	private String indentityNumber;
	private int createdUser;
	private Date createDate;
	private Integer updateUser;
	private Date updateDate;
	private Integer deletedUser;
	private Date deletedDate;
	private int isDeleted;
	private Set<SchUserWorkshift> schUserWorkshifts = new HashSet<SchUserWorkshift>(0);
	private Set<TblUserTool> tblUserTools = new HashSet<TblUserTool>(0);

	public SystemUser() {
	}

	public SystemUser(SystemUserAccount systemUserAccount, int createdUser, Date createDate, int isDeleted) {
		this.systemUserAccount = systemUserAccount;
		this.createdUser = createdUser;
		this.createDate = createDate;
		this.isDeleted = isDeleted;
	}

	public SystemUser(SystemUserAccount systemUserAccount, String fullname, Date birthday, String address, String phone,
			String indentityNumber, int createdUser, Date createDate, Integer updateUser, Date updateDate,
			Integer deletedUser, Date deletedDate, int isDeleted, Set<SchUserWorkshift> schUserWorkshifts,
			Set<TblUserTool> tblUserTools) {
		this.systemUserAccount = systemUserAccount;
		this.fullname = fullname;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.indentityNumber = indentityNumber;
		this.createdUser = createdUser;
		this.createDate = createDate;
		this.updateUser = updateUser;
		this.updateDate = updateDate;
		this.deletedUser = deletedUser;
		this.deletedDate = deletedDate;
		this.isDeleted = isDeleted;
		this.schUserWorkshifts = schUserWorkshifts;
		this.tblUserTools = tblUserTools;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "Id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UserId", unique = true, nullable = false)
	public SystemUserAccount getSystemUserAccount() {
		return this.systemUserAccount;
	}

	public void setSystemUserAccount(SystemUserAccount systemUserAccount) {
		this.systemUserAccount = systemUserAccount;
	}

	@Column(name = "Fullname", length = 200)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Birthday", length = 19)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "Address", length = 500)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "Phone", length = 20)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "IndentityNumber", length = 20)
	public String getIndentityNumber() {
		return this.indentityNumber;
	}

	public void setIndentityNumber(String indentityNumber) {
		this.indentityNumber = indentityNumber;
	}

	@Column(name = "CreatedUser", nullable = false)
	public int getCreatedUser() {
		return this.createdUser;
	}

	public void setCreatedUser(int createdUser) {
		this.createdUser = createdUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CreateDate", nullable = false, length = 19)
	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "UpdateUser")
	public Integer getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UpdateDate", length = 19)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "DeletedUser")
	public Integer getDeletedUser() {
		return this.deletedUser;
	}

	public void setDeletedUser(Integer deletedUser) {
		this.deletedUser = deletedUser;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DeletedDate", length = 19)
	public Date getDeletedDate() {
		return this.deletedDate;
	}

	public void setDeletedDate(Date deletedDate) {
		this.deletedDate = deletedDate;
	}

	@Column(name = "IsDeleted", nullable = false)
	public int getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "systemUser")
	public Set<SchUserWorkshift> getSchUserWorkshifts() {
		return this.schUserWorkshifts;
	}

	public void setSchUserWorkshifts(Set<SchUserWorkshift> schUserWorkshifts) {
		this.schUserWorkshifts = schUserWorkshifts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "systemUser")
	public Set<TblUserTool> getTblUserTools() {
		return this.tblUserTools;
	}

	public void setTblUserTools(Set<TblUserTool> tblUserTools) {
		this.tblUserTools = tblUserTools;
	}

}
