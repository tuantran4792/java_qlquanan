package POJO_entities;
// Generated May 22, 2016 3:15:16 PM by Hibernate Tools 4.0.0.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * SystemGroupRolelist generated by hbm2java
 */
@Entity
@Table(name = "system_group_rolelist", catalog = "qlquanan")
public class SystemGroupRolelist implements java.io.Serializable {

	private Long id;
	private SystemRolelist systemRolelist;
	private SystemGroup systemGroup;
	private boolean isDeleted;

	public SystemGroupRolelist() {
	}

	public SystemGroupRolelist(SystemRolelist systemRolelist, SystemGroup systemGroup, boolean isDeleted) {
		this.systemRolelist = systemRolelist;
		this.systemGroup = systemGroup;
		this.isDeleted = isDeleted;
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
	@JoinColumn(name = "RoleListId", nullable = false)
	public SystemRolelist getSystemRolelist() {
		return this.systemRolelist;
	}

	public void setSystemRolelist(SystemRolelist systemRolelist) {
		this.systemRolelist = systemRolelist;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GroupId", nullable = false)
	public SystemGroup getSystemGroup() {
		return this.systemGroup;
	}

	public void setSystemGroup(SystemGroup systemGroup) {
		this.systemGroup = systemGroup;
	}

	@Column(name = "IsDeleted", nullable = false)
	public boolean isIsDeleted() {
		return this.isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
