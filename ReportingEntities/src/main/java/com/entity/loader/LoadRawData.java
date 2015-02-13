package com.entity.loader;

// Generated 11-feb-2015 16:49:54 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.utilities.hibernate.VersionAuditor;
import com.utilities.hibernate.VersionableAdapter;

/**
 * LoadRawData generated by hbm2java
 */
@Entity
@Table(name = "T_LOAD_RAW_DATA")
public class LoadRawData implements VersionableAdapter {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5530516821829715574L;
	private long id;
	private FileColum fileColum;
	private LoadRaw loadRaw;
	private String loadRawDataText;
	private String loadRawDataType;

	@Embedded
	private VersionAuditor versionAuditor;
	@Version
	@Column(name="VERSION", nullable=false)
	int version;
	
	public LoadRawData() {
	}

	public LoadRawData(long loadRawDataId, FileColum fileColum,
			LoadRaw loadRaw, String loadRawDataType) {
		this.id = loadRawDataId;
		this.fileColum = fileColum;
		this.loadRaw = loadRaw;
		this.loadRawDataType = loadRawDataType;
	}

	public LoadRawData(long loadRawDataId, FileColum fileColum,
			LoadRaw loadRaw, String loadRawDataText, String loadRawDataType) {
		this.id = loadRawDataId;
		this.fileColum = fileColum;
		this.loadRaw = loadRaw;
		this.loadRawDataText = loadRawDataText;
		this.loadRawDataType = loadRawDataType;
	}

	@Id
	@SequenceGenerator(name="GEN_LOAD_RAW_DATA", sequenceName="SEQ_LOAD_RAW_DATA", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GEN_LOAD_RAW_DATA")
	@Column(name = "LOAD_RAW_DATA_ID", unique = true, nullable = false, length = 10)
	public long getId() {
		return this.id;
	}

	public void setId(long loadRawDataId) {
		this.id = loadRawDataId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FILE_COLUM_ID", nullable = false)
	public FileColum getFileColum() {
		return this.fileColum;
	}

	public void setFileColum(FileColum fileColum) {
		this.fileColum = fileColum;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOAD_RAW_ID", nullable = false)
	public LoadRaw getLoadRaw() {
		return this.loadRaw;
	}

	public void setLoadRaw(LoadRaw loadRaw) {
		this.loadRaw = loadRaw;
	}

	@Column(name = "LOAD_RAW_DATA_TEXT", length = 400)
	public String getLoadRawDataText() {
		return this.loadRawDataText;
	}

	public void setLoadRawDataText(String loadRawDataText) {
		this.loadRawDataText = loadRawDataText;
	}

	@Column(name = "LOAD_RAW_DATA_TYPE", nullable = false, length = 40)
	public String getLoadRawDataType() {
		return this.loadRawDataType;
	}

	public void setLoadRawDataType(String loadRawDataType) {
		this.loadRawDataType = loadRawDataType;
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
