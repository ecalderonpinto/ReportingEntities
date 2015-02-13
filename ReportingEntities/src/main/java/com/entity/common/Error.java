package com.entity.common;

// Generated 11-feb-2015 17:15:14 by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.entity.loader.LoadError;
import com.entity.reportingtool.ReportDataError;
import com.entity.reportingtool.ReportError;
import com.utilities.hibernate.VersionAuditor;
import com.utilities.hibernate.VersionableAdapter;

/**
 * Error generated by hbm2java
 */
@Entity
@Table(name = "T_ERROR")
public class Error implements VersionableAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private long id;
	private String errorType;
	private String errorName;
	private String errorLevel;
	private String errorText;
	private String errorAction;
	private Set<ReportDataError> reportDataErrors = new HashSet<ReportDataError>(
			0);
	private Set<LoadError> loadErrors = new HashSet<LoadError>(0);
	private Set<ReportError> reportErrors = new HashSet<ReportError>(0);

	@Embedded
	private VersionAuditor versionAuditor;
	@Version
	@Column(name = "VERSION", nullable = false)
	int version;

	public Error() {
	}

	public Error(long errorId, String errorType, String errorName,
			String errorLevel, VersionAuditor versionAuditor) {
		this.id = errorId;
		this.errorType = errorType;
		this.errorName = errorName;
		this.errorLevel = errorLevel;
		this.versionAuditor = versionAuditor;
	}

	public Error(String errorType, String errorName, String errorLevel,
			String errorText, String errorAction,
			Set<ReportDataError> reportDataErrors, Set<LoadError> loadErrors,
			Set<ReportError> reportErrors, VersionAuditor versionAuditor) {
		this.errorType = errorType;
		this.errorName = errorName;
		this.errorLevel = errorLevel;
		this.errorText = errorText;
		this.errorAction = errorAction;
		this.reportDataErrors = reportDataErrors;
		this.loadErrors = loadErrors;
		this.reportErrors = reportErrors;
		this.versionAuditor = versionAuditor;
	}

	@Id
	@SequenceGenerator(name = "GEN_ERROR", sequenceName = "SEQ_ERROR", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_ERROR")
	@Column(name = "ERROR_ID", unique = true, nullable = false, length = 10)
	public long getId() {
		return this.id;
	}

	public void setId(long errorId) {
		this.id = errorId;
	}

	@Column(name = "ERROR_TYPE", nullable = false, length = 40)
	public String getErrorType() {
		return this.errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

	@Column(name = "ERROR_NAME", nullable = false)
	public String getErrorName() {
		return this.errorName;
	}

	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}

	@Column(name = "ERROR_LEVEL", nullable = false, length = 40)
	public String getErrorLevel() {
		return this.errorLevel;
	}

	public void setErrorLevel(String errorLevel) {
		this.errorLevel = errorLevel;
	}

	@Column(name = "ERROR_TEXT")
	public String getErrorText() {
		return this.errorText;
	}

	public void setErrorText(String errorText) {
		this.errorText = errorText;
	}

	@Column(name = "ERROR_ACTION")
	public String getErrorAction() {
		return this.errorAction;
	}

	public void setErrorAction(String errorAction) {
		this.errorAction = errorAction;
	}

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "REPORT_DATA_ERROR_ID")
	public Set<ReportDataError> getReportDataErrors() {
		return this.reportDataErrors;
	}

	public void setReportDataErrors(Set<ReportDataError> reportDataErrors) {
		this.reportDataErrors = reportDataErrors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "error")
	public Set<LoadError> getLoadErrors() {
		return this.loadErrors;
	}

	public void setLoadErrors(Set<LoadError> loadErrors) {
		this.loadErrors = loadErrors;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "error")
	public Set<ReportError> getReportErrors() {
		return this.reportErrors;
	}

	public void setReportErrors(Set<ReportError> reportErrors) {
		this.reportErrors = reportErrors;
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
