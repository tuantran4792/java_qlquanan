package POJO_entities;
// Generated May 22, 2016 3:15:16 PM by Hibernate Tools 4.0.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SchWorkshift generated by hbm2java
 */
@Entity
@Table(name = "sch_workshift", catalog = "qlquanan")
public class SchWorkshift implements java.io.Serializable {

	private long id;
	private String scheduleName;
	private Date startDate;
	private Date toDate;
	private boolean isActived;
	private Boolean isDeleted;
	private Date createdDate;
	private int createdUser;
	private Date updatedDate;
	private Integer updatedUser;
	private Date deletedDate;
	private Integer deletedUser;
	private Set<SchUserWorkshift> schUserWorkshifts = new HashSet<SchUserWorkshift>(0);
	private Set<SystemSalary> systemSalaries = new HashSet<SystemSalary>(0);

	public SchWorkshift() {
	}

	public SchWorkshift(long id, Date startDate, Date toDate, boolean isActived, Date createdDate, int createdUser) {
		this.id = id;
		this.startDate = startDate;
		this.toDate = toDate;
		this.isActived = isActived;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
	}

	public SchWorkshift(long id, String scheduleName, Date startDate, Date toDate, boolean isActived, Boolean isDeleted,
			Date createdDate, int createdUser, Date updatedDate, Integer updatedUser, Date deletedDate,
			Integer deletedUser, Set<SchUserWorkshift> schUserWorkshifts, Set<SystemSalary> systemSalaries) {
		this.id = id;
		this.scheduleName = scheduleName;
		this.startDate = startDate;
		this.toDate = toDate;
		this.isActived = isActived;
		this.isDeleted = isDeleted;
		this.createdDate = createdDate;
		this.createdUser = createdUser;
		this.updatedDate = updatedDate;
		this.updatedUser = updatedUser;
		this.deletedDate = deletedDate;
		this.deletedUser = deletedUser;
		this.schUserWorkshifts = schUserWorkshifts;
		this.systemSalaries = systemSalaries;
	}

	@Id

	@Column(name = "Id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "ScheduleName", length = 511)
	public String getScheduleName() {
		return this.scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "StartDate", nullable = false, length = 19)
	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ToDate", nullable = false, length = 19)
	public Date getToDate() {
		return this.toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	@Column(name = "IsActived", nullable = false)
	public boolean isIsActived() {
		return this.isActived;
	}

	public void setIsActived(boolean isActived) {
		this.isActived = isActived;
	}

	@Column(name = "IsDeleted")
	public Boolean getIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "schWorkshift")
	public Set<SchUserWorkshift> getSchUserWorkshifts() {
		return this.schUserWorkshifts;
	}

	public void setSchUserWorkshifts(Set<SchUserWorkshift> schUserWorkshifts) {
		this.schUserWorkshifts = schUserWorkshifts;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "schWorkshift")
	public Set<SystemSalary> getSystemSalaries() {
		return this.systemSalaries;
	}

	public void setSystemSalaries(Set<SystemSalary> systemSalaries) {
		this.systemSalaries = systemSalaries;
	}

}
