package com.entity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.ApplicationContext;

import com.dao.reportingtool.CompanyDAO;
import com.dao.reportingtool.DepartmentDAO;
import com.dao.reportingtool.FundDAO;
import com.dao.reportingtool.FundGroupDAO;
import com.dao.reportingtool.ReportCatalogDAO;
import com.dao.reportingtool.ReportExecutionDAO;
import com.dao.reportingtool.ReportFieldDAO;
import com.dao.reportingtool.ReportFieldListDAO;
import com.entity.reportingtool.Company;
import com.entity.reportingtool.Department;
import com.entity.reportingtool.Fund;
import com.entity.reportingtool.FundGroup;
import com.entity.reportingtool.ReportCatalog;
import com.entity.reportingtool.ReportExecution;
import com.entity.reportingtool.ReportField;
import com.entity.reportingtool.ReportFieldList;
import com.utilities.hibernate.VersionAuditor;

public class InstallEntities {

	public InstallEntities() {

	}

	public void installEntitiesFull(ApplicationContext aplicationContext) {

		//
		// FileConfig fileConfig = new FileConfig("AIFMD", "AIFMD2014", new
		// VersionAuditor("admin"));
		// fileConfig.setFileSeparator("|");
		// FileConfigDAO fileConfigDAO =
		// (FileConfigDAO)aplicationContext.getBean("fileConfigDao");
		// fileConfigDAO.create(fileConfig);

		// FileColum fileColum = new FileColum(fileConfig, "", new
		// VersionAuditor("admin"));
		// FileColumDAO fileColumDAO =
		// (FileColumDAO)aplicationContext.getBean("fileColumDao");
		// fileColumDAO.create(fileColum);
		try {

			VersionAuditor versionAdmin = new VersionAuditor("admin");

			Company company = new Company("Santander Asset Manager", "Spain",
					"SAM", "", null, null, null, null, new VersionAuditor(
							"admin"));
			Department department = new Department(company, "Risk department",
					"RISK", "", "Spain", null, null, null, new VersionAuditor(
							"admin"));
			Fund fund = new Fund(company, "SAM fund 1", "ES000001", "FUND1",
					"", null, null, null, versionAdmin);
			FundGroup fundGroup = new FundGroup(fund, department, "RISK FUNDS",
					"", versionAdmin);

			ReportCatalog reportCatalog = new ReportCatalog("1.2", "COMPANY",
					"AIFMD 2014", "", null, null, null, new VersionAuditor(
							"admin"));

			String str1 = "2014-01-01";
			String str2 = "2014-12-31";
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = format.parse(str1);
			Date date2 = format.parse(str2);

			ReportExecution reportExecution = new ReportExecution(
					reportCatalog, company, fund, "Q1", "2014", date2, date1,
					"CREATION", null, null, null, null, null, null, null, null,
					null, null, null, null, versionAdmin);

			ReportField reportField1 = new ReportField(reportCatalog, "A",
					"ReportingMemberState", ".{2}", "", "", "COUNTRY", "1.2",
					null, null, null, versionAdmin);
			ReportField reportField2 = new ReportField(reportCatalog, "A",
					"Version", "([0-9])+\\.([0-9])+", "", "", "VERSION", "1.2",
					null, null, null, versionAdmin);
			ReportField reportField3 = new ReportField(reportCatalog, "D",
					"CreationDateAndTime",
					"[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}",
					"", "", "DATETIME", "1.2", null, null, null, versionAdmin);
			ReportField reportField4 = new ReportField(reportCatalog, "A",
					"FilingType", ".{4}", "", "", "FILLING", "1.2", null, null,
					null, versionAdmin);
			ReportField reportField5 = new ReportField(reportCatalog, "N",
					"AIFMContentType", "[0-9]{1}", "", "", "AIFM_TYPE", "1.2",
					null, null, null, versionAdmin);
			ReportField reportField6 = new ReportField(reportCatalog, "D",
					"ReportingPeriodStartDate", "[0-9]{4}-[0-9]{2}-[0-9]{2}",
					"", "", "DATE", "1.2", null, null, null, versionAdmin);
			ReportField reportField7 = new ReportField(reportCatalog, "D",
					"ReportingPeriodEndDate", "[0-9]{4}-[0-9]{2}-[0-9]{2}", "",
					"", "DATE", "1.2", null, null, null, versionAdmin);
			ReportField reportField8 = new ReportField(reportCatalog, "A",
					"ReportingPeriodType", ".{2}", "", "", "PERIOD", "1.2",
					null, null, null, versionAdmin);
			ReportField reportField9 = new ReportField(reportCatalog, "N",
					"ReportingPeriodYear", "[0-9]{4}", "", "", "YEAR", "1.2",
					null, null, null, versionAdmin);
			ReportField reportField10 = new ReportField(reportCatalog, "A",
					"AIFMReportingObligationChangeFrequencyCode", ".{2}", "",
					"", "AIFM_CHANGE_FREQ", "1.2", null, null, null,
					versionAdmin);
			ReportField reportField11 = new ReportField(reportCatalog, "N",
					"AIFMReportingObligationChangeContentsCode", "[0-9]{1}",
					"", "", "AIFM_CHANGE_CONTENT", "1.2", null, null, null,
					versionAdmin);
			ReportField reportField12 = new ReportField(reportCatalog, "A",
					"AIFMReportingObligationChangeQuarter", ".{2}", "", "",
					"QUARTER", "1.2", null, null, null, versionAdmin);
			ReportField reportField13 = new ReportField(reportCatalog, "B",
					"LastReportingFlag", "true|false", "", "", "BOOLEAN",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField14 = new ReportField(reportCatalog, "N",
					"QuestionNumber", "[0-9]{0,3}", "", "", "QUESTION", "1.2",
					null, null, null, versionAdmin);
			ReportField reportField15 = new ReportField(reportCatalog, "Z",
					"AssumptionDescription", ".{0,300}", "", "", "DESCRIPTION",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField16 = new ReportField(reportCatalog, "A",
					"AIFMReportingCode", ".{1}", "", "", "REPORT_CODE", "1.2",
					null, null, null, versionAdmin);
			ReportField reportField17 = new ReportField(reportCatalog, "A",
					"AIFMJurisdiction", ".{2}", "", "", "COUNTRY", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField18 = new ReportField(reportCatalog, "Z",
					"AIFMNationalCode", ".{0,30}", "", "", "NATIONAL", "1.2",
					null, null, null, versionAdmin);
			ReportField reportField19 = new ReportField(reportCatalog, "Z",
					"AIFMName", ".{0,300}", "", "", "AIFM_NAME", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField20 = new ReportField(reportCatalog, "B",
					"AIFMEEAFlag", "true|false", "", "", "BOOLEAN", "1.2",
					null, null, null, versionAdmin);
			ReportField reportField21 = new ReportField(reportCatalog, "B",
					"AIFMNoReportingFlag", "true|false", "", "", "BOOLEAN",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField22 = new ReportField(reportCatalog, "A",
					"AIFMIdentifierLEI", ".{20}", "", "", "LEI", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField23 = new ReportField(reportCatalog, "A",
					"AIFMIdentifierBIC", ".{11}", "", "", "BIC", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField24 = new ReportField(reportCatalog, "A",
					"ReportingMemberState1", ".{2}", "", "", "COUNTRY", "1.2",
					null, null, null, versionAdmin);
			ReportField reportField25 = new ReportField(reportCatalog, "Z",
					"AIFMNationalCode1", ".{0,30}", "", "", "", "1.2", null,
					null, null, versionAdmin);

			ReportField reportField26 = new ReportField(reportCatalog, "N",
					"AIFMFivePrincipalMarket1", "[0-9]{1}", "", "", "RANKING",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField27 = new ReportField(reportCatalog, "A",
					"MarketCodeType1", ".{4}", "", "", "MARKET", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField28 = new ReportField(reportCatalog, "A",
					"MarketCode1", ".{4}", "", "", "MIC", "1.2", null, null,
					null, versionAdmin);
			ReportField reportField29 = new ReportField(reportCatalog, "N",
					"MarketAggregatedValueAmount1", "[0-9]{0,15}?", "", "",
					"NUMBER", "1.2", null, null, null, versionAdmin);
			ReportField reportField30 = new ReportField(reportCatalog, "N",
					"AIFMFivePrincipalMarket2", "[0-9]{1}", "", "", "RANKING",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField31 = new ReportField(reportCatalog, "A",
					"MarketCodeType2", ".{4}", "", "", "MARKET", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField32 = new ReportField(reportCatalog, "A",
					"MarketCode2", ".{4}", "", "", "MIC", "1.2", null, null,
					null, versionAdmin);
			ReportField reportField33 = new ReportField(reportCatalog, "N",
					"MarketAggregatedValueAmount2", "[0-9]{0,15}?", "", "",
					"NUMBER", "1.2", null, null, null, versionAdmin);
			ReportField reportField34 = new ReportField(reportCatalog, "N",
					"AIFMFivePrincipalMarket3", "[0-9]{1}", "", "", "RANKING",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField35 = new ReportField(reportCatalog, "A",
					"MarketCodeType3", ".{4}", "", "", "MARKET", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField36 = new ReportField(reportCatalog, "A",
					"MarketCode3", ".{4}", "", "", "MIC", "1.2", null, null,
					null, versionAdmin);
			ReportField reportField37 = new ReportField(reportCatalog, "N",
					"MarketAggregatedValueAmount3", "[0-9]{0,15}?", "", "",
					"NUMBER", "1.2", null, null, null, versionAdmin);
			ReportField reportField38 = new ReportField(reportCatalog, "N",
					"AIFMFivePrincipalMarket4", "[0-9]{1}", "", "", "RANKING",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField39 = new ReportField(reportCatalog, "A",
					"MarketCodeType4", ".{4}", "", "", "MARKET", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField40 = new ReportField(reportCatalog, "A",
					"MarketCode4", ".{4}", "", "", "MIC", "1.2", null, null,
					null, versionAdmin);
			ReportField reportField41 = new ReportField(reportCatalog, "N",
					"MarketAggregatedValueAmount4", "[0-9]{0,15}?", "", "",
					"NUMBER", "1.2", null, null, null, versionAdmin);
			ReportField reportField42 = new ReportField(reportCatalog, "N",
					"AIFMFivePrincipalMarket5", "[0-9]{1}", "", "", "RANKING",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField43 = new ReportField(reportCatalog, "A",
					"MarketCodeType5", ".{4}", "", "", "MARKET", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField44 = new ReportField(reportCatalog, "A",
					"MarketCode5", ".{4}", "", "", "MIC", "1.2", null, null,
					null, versionAdmin);
			ReportField reportField45 = new ReportField(reportCatalog, "N",
					"MarketAggregatedValueAmount5", "[0-9]{0,15}?", "", "",
					"NUMBER", "1.2", null, null, null, versionAdmin);

			ReportField reportField46 = new ReportField(reportCatalog, "N",
					"AIFMPrincipalInstrument1", "[0-9]{1}", "", "", "RANKING",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField47 = new ReportField(reportCatalog, "A",
					"SubAssetType1", ".{11}", "", "", "SUB_ASSET", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField48 = new ReportField(reportCatalog, "N",
					"InstrumentAggregatedValueAmount1", "[0-9]{0,15}?", "", "",
					"NUMBER", "1.2", null, null, null, versionAdmin);
			ReportField reportField49 = new ReportField(reportCatalog, "N",
					"AIFMPrincipalInstrument2", "[0-9]{1}", "", "", "RANKING",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField50 = new ReportField(reportCatalog, "A",
					"SubAssetType2", ".{11}", "", "", "SUB_ASSET", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField51 = new ReportField(reportCatalog, "N",
					"InstrumentAggregatedValueAmount2", "[0-9]{0,15}?", "", "",
					"NUMBER", "1.2", null, null, null, versionAdmin);
			ReportField reportField52 = new ReportField(reportCatalog, "N",
					"AIFMPrincipalInstrument3", "[0-9]{1}", "", "", "RANKING",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField53 = new ReportField(reportCatalog, "A",
					"SubAssetType3", ".{11}", "", "", "SUB_ASSET", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField54 = new ReportField(reportCatalog, "N",
					"InstrumentAggregatedValueAmount3", "[0-9]{0,15}?", "", "",
					"NUMBER", "1.2", null, null, null, versionAdmin);
			ReportField reportField55 = new ReportField(reportCatalog, "type",
					"AIFMPrincipalInstrument4", "[0-9]{1}", "", "", "RANKING",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField56 = new ReportField(reportCatalog, "A",
					"SubAssetType4", ".{11}", "", "", "SUB_ASSET", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField57 = new ReportField(reportCatalog, "N",
					"InstrumentAggregatedValueAmount4", "[0-9]{0,15}?", "", "",
					"NUMBER", "1.2", null, null, null, versionAdmin);
			ReportField reportField58 = new ReportField(reportCatalog, "N",
					"AIFMPrincipalInstrument5", "[0-9]{1}", "", "", "RANKING",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField59 = new ReportField(reportCatalog, "A",
					"SubAssetType5", ".{11}", "", "", "SUB_ASSET", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField60 = new ReportField(reportCatalog, "N",
					"InstrumentAggregatedValueAmount5", "[0-9]{0,15}?", "", "",
					"NUMBER", "1.2", null, null, null, versionAdmin);

			ReportField reportField61 = new ReportField(reportCatalog, "N",
					"AUMAmountInEuro", "[0-9]{0,15}?", "", "", "NUMBER", "1.2",
					null, null, null, versionAdmin);
			ReportField reportField62 = new ReportField(reportCatalog, "N",
					"AUMAmountInBaseCurrency", "[0-9]{0,15}?", "", "",
					"NUMBER", "1.2", null, null, null, versionAdmin);
			ReportField reportField63 = new ReportField(reportCatalog, "A",
					"BaseCurrency", ".{3}", "", "", "CURRENCY", "1.2", null,
					null, null, versionAdmin);
			ReportField reportField64 = new ReportField(reportCatalog, "A",
					"FXEURReferenceRateType", ".{3}", "", "", "FXRATE", "1.2",
					null, null, null, versionAdmin);
			ReportField reportField65 = new ReportField(reportCatalog, "N",
					"FXEURRate", "[0-9]{1,15}\\.[0-9]{1,4}", "", "", "DECIMAL",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField66 = new ReportField(reportCatalog, "Z",
					"FXEUROtherReferenceRateDescription", ".{0,300}", "", "",
					"DESCRIPTION", "1.2", null, null, null, versionAdmin);
			ReportField reportField67 = new ReportField(reportCatalog, "Z",
					"CancelledAIFMNationalCode", ".{0,30}", "", "", "NATIONAL",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField68 = new ReportField(reportCatalog, "A",
					"CancelledReportingPeriodType", ".{2}", "", "", "PERIOD",
					"1.2", null, null, null, versionAdmin);
			ReportField reportField69 = new ReportField(reportCatalog, "D",
					"CancelledReportingPeriodYear", "[0-9]{4}?", "", "",
					"YEAR", "1.2", null, null, null, versionAdmin);
			ReportField reportField70 = new ReportField(reportCatalog, "A",
					"CancelledRecordFlag", ".{1}", "", "", "FLAG", "1.2", null,
					null, null, versionAdmin);
			
			
			ReportFieldList reportFieldList1 = new ReportFieldList("FILLING", "AMND", "2", versionAdmin);
			ReportFieldList reportFieldList2 = new ReportFieldList("FILLING", "INIT", "2", versionAdmin);
			ReportFieldList reportFieldList3 = new ReportFieldList("PERIOD", "Q1", "2", versionAdmin);
			ReportFieldList reportFieldList4 = new ReportFieldList("PERIOD", "Q2", "2", versionAdmin);
			ReportFieldList reportFieldList5 = new ReportFieldList("PERIOD", "Q3", "2", versionAdmin);
			ReportFieldList reportFieldList6 = new ReportFieldList("PERIOD", "Q4", "2", versionAdmin);
			ReportFieldList reportFieldList7 = new ReportFieldList("PERIOD", "H1", "2", versionAdmin);
			ReportFieldList reportFieldList8 = new ReportFieldList("PERIOD", "H2", "2", versionAdmin);
			ReportFieldList reportFieldList9 = new ReportFieldList("PERIOD", "X1", "2", versionAdmin);
			ReportFieldList reportFieldList10 = new ReportFieldList("PERIOD", "X2", "2", versionAdmin);
			ReportFieldList reportFieldList11 = new ReportFieldList("PERIOD", "Y1", "2", versionAdmin);
			ReportFieldList reportFieldList12 = new ReportFieldList("QUARTER", "Q1", "2", versionAdmin);
			ReportFieldList reportFieldList13 = new ReportFieldList("QUARTER", "Q2", "2", versionAdmin);
			ReportFieldList reportFieldList14 = new ReportFieldList("QUARTER", "Q3", "2", versionAdmin);
			ReportFieldList reportFieldList15 = new ReportFieldList("QUARTER", "Q4", "2", versionAdmin);
			ReportFieldList reportFieldList16 = new ReportFieldList("MARKET", "MIC", "2", versionAdmin);
			ReportFieldList reportFieldList17 = new ReportFieldList("MARKET", "OTC", "2", versionAdmin);
			ReportFieldList reportFieldList18 = new ReportFieldList("MARKET", "XXX", "2", versionAdmin);
			ReportFieldList reportFieldList19 = new ReportFieldList("MARKET", "NOT", "2", versionAdmin);
			ReportFieldList reportFieldList20 = new ReportFieldList("FXRATE", "ECB", "2", versionAdmin);
			ReportFieldList reportFieldList21 = new ReportFieldList("FXRATE", "OTH", "2", versionAdmin);
			ReportFieldList reportFieldList22 = new ReportFieldList("RANKING", "1", "2", versionAdmin);
			ReportFieldList reportFieldList23 = new ReportFieldList("RANKING", "2", "2", versionAdmin);
			ReportFieldList reportFieldList24 = new ReportFieldList("RANKING", "3", "2", versionAdmin);
			ReportFieldList reportFieldList25 = new ReportFieldList("RANKING", "4", "2", versionAdmin);
			ReportFieldList reportFieldList26 = new ReportFieldList("RANKING", "5", "2", versionAdmin);
			ReportFieldList reportFieldList27 = new ReportFieldList("AIFMTYPE", "1", "2", versionAdmin);
			ReportFieldList reportFieldList28 = new ReportFieldList("AIFMTYPE", "2", "2", versionAdmin);
			ReportFieldList reportFieldList29 = new ReportFieldList("AIFMTYPE", "3", "2", versionAdmin);

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			CompanyDAO companyDAO = (CompanyDAO)aplicationContext.getBean("companyDAO");
			companyDAO.create(company);
			
			DepartmentDAO departmentDAO = (DepartmentDAO)aplicationContext.getBean("departmentDAO");
			departmentDAO.create(department);
			
			FundDAO fundDAO = (FundDAO)aplicationContext.getBean("fundDAO");
			fundDAO.create(fund);
			
			FundGroupDAO fundGroupDAO = (FundGroupDAO)aplicationContext.getBean("fundGroupDAO");
			fundGroupDAO.create(fundGroup);
			
			ReportCatalogDAO reportCatalogDAO = (ReportCatalogDAO)aplicationContext.getBean("reportCatalogDAO");
			reportCatalogDAO.create(reportCatalog);
			
			ReportExecutionDAO reportExecutionDAO = (ReportExecutionDAO)aplicationContext.getBean("reportExecutionDAO");
			reportExecutionDAO.create(reportExecution);
			
			
			ReportFieldDAO reportFieldDAO = (ReportFieldDAO)aplicationContext.getBean("reportFieldDAO");
			reportFieldDAO.create(reportField1);
			reportFieldDAO.create(reportField2);
			reportFieldDAO.create(reportField3);
			reportFieldDAO.create(reportField4);
			reportFieldDAO.create(reportField5);
			reportFieldDAO.create(reportField6);
			reportFieldDAO.create(reportField7);
			reportFieldDAO.create(reportField8);
			reportFieldDAO.create(reportField9);
			reportFieldDAO.create(reportField10);
			reportFieldDAO.create(reportField11);
			reportFieldDAO.create(reportField12);
			reportFieldDAO.create(reportField13);
			reportFieldDAO.create(reportField14);
			reportFieldDAO.create(reportField15);
			reportFieldDAO.create(reportField16);
			reportFieldDAO.create(reportField17);
			reportFieldDAO.create(reportField18);
			reportFieldDAO.create(reportField19);
			reportFieldDAO.create(reportField20);
			reportFieldDAO.create(reportField21);
			reportFieldDAO.create(reportField22);
			reportFieldDAO.create(reportField23);
			reportFieldDAO.create(reportField24);
			reportFieldDAO.create(reportField25);
			reportFieldDAO.create(reportField26);
			reportFieldDAO.create(reportField27);
			reportFieldDAO.create(reportField28);
			reportFieldDAO.create(reportField29);
			reportFieldDAO.create(reportField30);
			reportFieldDAO.create(reportField31);
			reportFieldDAO.create(reportField32);
			reportFieldDAO.create(reportField33);
			reportFieldDAO.create(reportField34);
			reportFieldDAO.create(reportField35);
			reportFieldDAO.create(reportField36);
			reportFieldDAO.create(reportField37);
			reportFieldDAO.create(reportField38);
			reportFieldDAO.create(reportField39);
			reportFieldDAO.create(reportField40);
			reportFieldDAO.create(reportField41);
			reportFieldDAO.create(reportField42);
			reportFieldDAO.create(reportField43);
			reportFieldDAO.create(reportField44);
			reportFieldDAO.create(reportField45);
			reportFieldDAO.create(reportField46);
			reportFieldDAO.create(reportField47);
			reportFieldDAO.create(reportField48);
			reportFieldDAO.create(reportField49);
			reportFieldDAO.create(reportField50);
			reportFieldDAO.create(reportField51);
			reportFieldDAO.create(reportField52);
			reportFieldDAO.create(reportField53);
			reportFieldDAO.create(reportField54);
			reportFieldDAO.create(reportField55);
			reportFieldDAO.create(reportField56);
			reportFieldDAO.create(reportField57);
			reportFieldDAO.create(reportField58);
			reportFieldDAO.create(reportField59);
			reportFieldDAO.create(reportField60);
			reportFieldDAO.create(reportField61);
			reportFieldDAO.create(reportField62);
			reportFieldDAO.create(reportField63);
			reportFieldDAO.create(reportField64);
			reportFieldDAO.create(reportField65);
			reportFieldDAO.create(reportField66);
			reportFieldDAO.create(reportField67);
			reportFieldDAO.create(reportField68);
			reportFieldDAO.create(reportField69);
			reportFieldDAO.create(reportField70);
			
			
			ReportFieldListDAO reportFieldListDAO = (ReportFieldListDAO)aplicationContext.getBean("reportFieldListDAO");
			reportFieldListDAO.create(reportFieldList1);
			reportFieldListDAO.create(reportFieldList2);
			reportFieldListDAO.create(reportFieldList3);
			reportFieldListDAO.create(reportFieldList4);
			reportFieldListDAO.create(reportFieldList5);
			reportFieldListDAO.create(reportFieldList6);
			reportFieldListDAO.create(reportFieldList7);
			reportFieldListDAO.create(reportFieldList8);
			reportFieldListDAO.create(reportFieldList9);
			reportFieldListDAO.create(reportFieldList10);
			reportFieldListDAO.create(reportFieldList11);
			reportFieldListDAO.create(reportFieldList12);
			reportFieldListDAO.create(reportFieldList13);
			reportFieldListDAO.create(reportFieldList14);
			reportFieldListDAO.create(reportFieldList15);
			reportFieldListDAO.create(reportFieldList16);
			reportFieldListDAO.create(reportFieldList17);
			reportFieldListDAO.create(reportFieldList18);
			reportFieldListDAO.create(reportFieldList19);
			reportFieldListDAO.create(reportFieldList20);
			reportFieldListDAO.create(reportFieldList21);
			reportFieldListDAO.create(reportFieldList22);
			reportFieldListDAO.create(reportFieldList23);
			reportFieldListDAO.create(reportFieldList24);
			reportFieldListDAO.create(reportFieldList25);
			reportFieldListDAO.create(reportFieldList26);
			reportFieldListDAO.create(reportFieldList27);
			reportFieldListDAO.create(reportFieldList28);
			reportFieldListDAO.create(reportFieldList29);
			
			
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
