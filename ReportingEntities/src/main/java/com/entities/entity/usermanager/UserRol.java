package com.entities.entity.usermanager;

// Generated 11-feb-2015 16:49:54 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.entities.utilities.hibernate.VersionAuditor;
import com.entities.utilities.hibernate.VersionableAdapter;

/**
 * UserRol generated by hbm2java
 */
@Entity
@Table(name = "T_USER_ROL")
public class UserRol implements VersionableAdapter {

	private long id;
	private String rolName;
	private String rolDesc;
	private BigDecimal rolWeight;
	private Set<UserRolPermission> userRolPermissions = new HashSet(0);
	private Set<User> users = new HashSet(0);

	@Embedded
	private VersionAuditor versionAuditor;
	@Version
	@Column(name = "VERSION", nullable = false)
	int version;

	public UserRol() {
	}

	public UserRol(long rolId, String rolName, BigDecimal rolWeight,
			VersionAuditor versionAuditor) {
		this.id = rolId;
		this.rolName = rolName;
		this.rolWeight = rolWeight;
		this.versionAuditor = versionAuditor;
	}

	public UserRol(String rolName, String rolDesc, BigDecimal rolWeight,
			Set<UserRolPermission> userRolPermissions, Set<User> users,
			VersionAuditor versionAuditor) {
		this.rolName = rolName;
		this.rolDesc = rolDesc;
		this.rolWeight = rolWeight;
		this.userRolPermissions = userRolPermissions;
		this.users = users;
		this.versionAuditor = versionAuditor;
	}

	@Id
	@SequenceGenerator(name = "GEN_USER_ROL", sequenceName = "SEQ_USER_ROL", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_USER_ROL")
	@Column(name = "ROL_ID", unique = true, nullable = false, length = 10)
	public long getId() {
		return this.id;
	}

	public void setId(long rolId) {
		this.id = rolId;
	}

	@Column(name = "ROL_NAME", nullable = false, length = 40)
	public String getRolName() {
		return this.rolName;
	}

	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	@Column(name = "ROL_DESC")
	public String getRolDesc() {
		return this.rolDesc;
	}

	public void setRolDesc(String rolDesc) {
		this.rolDesc = rolDesc;
	}

	@Column(name = "ROL_WEIGHT", nullable = false, precision = 22, scale = 0)
	public BigDecimal getRolWeight() {
		return this.rolWeight;
	}

	public void setRolWeight(BigDecimal rolWeight) {
		this.rolWeight = rolWeight;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userRol")
	public Set<UserRolPermission> getUserRolPermissions() {
		return this.userRolPermissions;
	}

	public void setUserRolPermissions(Set<UserRolPermission> userRolPermissions) {
		this.userRolPermissions = userRolPermissions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userRol")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public VersionAuditor getAuditor() {
		return versionAuditor;
	}

	public void setAuditor(VersionAuditor _auditor) {
		this.versionAuditor = _auditor;
	}

}
