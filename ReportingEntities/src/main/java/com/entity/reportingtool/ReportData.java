package com.entity.reportingtool;

// Generated 11-feb-2015 17:15:14 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.utilities.hibernate.VersionAuditor;
import com.utilities.hibernate.VersionableAdapter;

/**
 * ReportData generated by hbm2java
 */
@Entity
@Table(name = "T_REPORT_DATA")
public class ReportData implements VersionableAdapter {

	private long id;
	private ReportDataLong reportDataLong;
	private ReportField reportField;
	private ReportExecution reportExecution;
	private Date reportDataDate;
	private BigDecimal reportDataNumber;
	private String reportDataText;
	private String reportDataLock;
	private Set<ReportDataError> reportDataErrors = new HashSet(0);

	@Embedded
	private VersionAuditor versionAuditor;
	@Version
	@Column(name = "VERSION", nullable = false)
	int version;

	public ReportData() {
	}

	public ReportData(long reportDataId, ReportField reportField,
			ReportExecution reportExecution, VersionAuditor versionAuditor) {
		this.id = reportDataId;
		this.reportField = reportField;
		this.reportExecution = reportExecution;
		this.versionAuditor = versionAuditor;
	}

	public ReportData(ReportDataLong reportDataLong, ReportField reportField,
			ReportExecution reportExecution, Date reportDataDate,
			BigDecimal reportDataNumber, String reportDataText,
			String reportDataLock, Set<ReportDataError> reportDataErrors,
			VersionAuditor versionAuditor) {
		this.reportDataLong = reportDataLong;
		this.reportField = reportField;
		this.reportExecution = reportExecution;
		this.reportDataDate = reportDataDate;
		this.reportDataNumber = reportDataNumber;
		this.reportDataText = reportDataText;
		this.reportDataLock = reportDataLock;
		this.reportDataErrors = reportDataErrors;
		this.versionAuditor = versionAuditor;
	}

	@Id
	@SequenceGenerator(name = "GEN_REPORT_DATA", sequenceName = "SEQ_REPORT_DATA", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GEN_REPORT_DATA")
	@Column(name = "REPORT_DATA_ID", unique = true, nullable = false, length = 10)
	public long getId() {
		return this.id;
	}

	public void setId(long reportDataId) {
		this.id = reportDataId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REPORT_DATA_LONG_ID")
	public ReportDataLong getReportDataLong() {
		return this.reportDataLong;
	}

	public void setReportDataLong(ReportDataLong reportDataLong) {
		this.reportDataLong = reportDataLong;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REPORT_FIELD_ID", nullable = false)
	public ReportField getReportField() {
		return this.reportField;
	}

	public void setReportField(ReportField reportField) {
		this.reportField = reportField;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REPORT_EXECUTION_ID", nullable = false)
	public ReportExecution getReportExecution() {
		return this.reportExecution;
	}

	public void setReportExecution(ReportExecution reportExecution) {
		this.reportExecution = reportExecution;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "REPORT_DATA_DATE", length = 7)
	public Date getReportDataDate() {
		return this.reportDataDate;
	}

	public void setReportDataDate(Date reportDataDate) {
		this.reportDataDate = reportDataDate;
	}

	@Column(name = "REPORT_DATA_NUMBER", precision = 31, scale = 11)
	public BigDecimal getReportDataNumber() {
		return this.reportDataNumber;
	}

	public void setReportDataNumber(BigDecimal reportDataNumber) {
		this.reportDataNumber = reportDataNumber;
	}

	@Column(name = "REPORT_DATA_TEXT", length = 400)
	public String getReportDataText() {
		return this.reportDataText;
	}

	public void setReportDataText(String reportDataText) {
		this.reportDataText = reportDataText;
	}

	@Column(name = "REPORT_DATA_LOCK", length = 1)
	public String getReportDataLock() {
		return this.reportDataLock;
	}

	public void setReportDataLock(String reportDataLock) {
		this.reportDataLock = reportDataLock;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "reportData")
	public Set<ReportDataError> getReportDataErrors() {
		return this.reportDataErrors;
	}

	public void setReportDataErrors(Set<ReportDataError> reportDataErrors) {
		this.reportDataErrors = reportDataErrors;
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
