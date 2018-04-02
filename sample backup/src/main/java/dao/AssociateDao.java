package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.SessionUtil;
import beans.MemberData;
import beans.PremiumMaster;

public class PremiumCalculationDao {

	SessionFactory sessionFactory;
	PremiumMaster p = new PremiumMaster();
	
	
	String policynumber;
	String benefitcoverageamount;
	String dateofbirth;
	String drinkingsmokinghabit;
	String gender;
	String hazardousoccupation;
	String heartdiseasepatient;
	String involvedinaviation;
	String policyapplieddate;
	String policyeffectivedate;
	String premiumfrequency;
	String processdate;
	String student;
	String premiumamount;
	String currentdate;
	String premiumenddate;
	int age;
	int ageweightage;
	int genderweightage;
	int coverageweightage;
	int otherfactorsweightage;
	int totalweightage;
	Query query;
	
	
	public void premiumcalculation() throws ParseException{
		
		sessionFactory = SessionUtil.getSessionFactory();		
		Session session = sessionFactory.openSession();
		org.hibernate.Transaction transaction = session.beginTransaction();
		
		/*String hql1 = "DELETE FROM PremiumMaster";
		Query query1 = session.createQuery(hql1);*/
		
		/*query = session.createQuery(Constants.clearingpremiummaster);
		transaction.commit();*/
		/*String hql = "FROM MemberData M WHERE M.ProcessDate LIKE :crntdate AND M.PolicyStatus LIKE :status";*/
		query = session.createQuery(Constants.calculatingpremiummaster);
		/*query.setParameter("crntdate","5/24/2017");*/
		query.setParameter("currentdate", new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
		query.setParameter("status", "I");
		
		List<MemberData> datas = query.list();
		System.out.println("Inside premium calculation list");
		System.out.println(query.list());
		
		 for(MemberData m : datas){
			 policynumber = m.getPolicyNumber();
			 dateofbirth = m.getDateofBirth();
			 gender = m.getGender();
			 benefitcoverageamount = m.getBenefitCoverageAmount();
			 student = m.getStudent_Ind();
			 drinkingsmokinghabit = m.getDrinkingSmokingHabits();
			 hazardousoccupation = m.getHazardousOccupation();
			 heartdiseasepatient = m.getHeartDiseasePresent();
			 premiumfrequency = m.getPremiumFrequency();
			 policyeffectivedate = m.getPolicyEffDate();
			 policyapplieddate = m.getPolicyAppliedDate();
			 currentdate = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
				
			 /*age calculation*/
			 age = calculateage(dateofbirth,currentdate);
			 System.out.println(age);
			
			 /*age weightage calculation*/
			 ageweightage = ageweightcal(age);
			 System.out.println(ageweightage);
				
				
			System.out.println(gender);
			/*gender weightage calculation*/
			genderweightage = genderweightcal(gender);
			System.out.println(genderweightage);
				
			/*benefit coverage weightage calculation*/	
			coverageweightage = coverageweightcal(benefitcoverageamount);
			System.out.println(coverageweightage);
				
			/*other factors weightage calculation*/		
			otherfactorsweightage = otherweightcal(student,drinkingsmokinghabit,hazardousoccupation,heartdiseasepatient);
			System.out.println(otherfactorsweightage);
			
			/*total weightage calculation*/
			totalweightage = ageweightage+genderweightage+coverageweightage+otherfactorsweightage;
			System.out.println(totalweightage);
				
			/*updating policy status*/
			if(totalweightage > 25)
				m.setPolicyStatus("H");
			else if(totalweightage < 25)
				m.setPolicyStatus("A");
				
			/*premium amount calculation*/	
			int premium = calculatepremium(totalweightage,benefitcoverageamount);
			System.out.println(premiumamount);
			premiumamount = Integer.toString(premium);

			/*premium end date calculation*/
			premiumenddate = calend(policyapplieddate,premiumfrequency);
			int pfreq = Integer.parseInt(premiumfrequency);
		
			/*saving into the premium master table*/
			//int seqnum = 1;
			int i=1;
			for(int seqnum=1; seqnum<=pfreq;seqnum++)
			{
				/*p.setPolicyNumber(policynumber);
				p.setPremiumAmount(premiumamount);
				p.setSequenceNumber(Integer.toString(seqnum));
				p.setPremiumStartDate(policyeffectivedate);
				p.setLateFee("  ");
				p.setPremiumPaidDate("  ");
				p.setPremiumEndDate(premiumenddate);
				session.save(p);*/
				
				String sql = "INSERT INTO PremiumMaster VALUES(:policnumber,:sequencenumber,:premiumstrtdate,:premiumendate,:premiumpaidate,:premumamount,:latfee,:premumfrequency)";
				query = session.createSQLQuery(sql);
				query.setParameter("policnumber", policynumber);
				query.setParameter("sequencenumber", i);
				query.setParameter("premiumstrtdate", policyeffectivedate);
				query.setParameter("premiumendate", premiumenddate);
				query.setParameter("premiumpaidate", " ");
				query.setParameter("premumamount", premiumamount);
				query.setParameter("latfee", " ");
				query.setParameter("premumfrequency", premiumfrequency);
				query.executeUpdate();
				i++;
			}
				
			m.setPremiumAmount(premiumamount);
			session.save(m);
			System.out.println("Successfully saved into database!!!");
			transaction.commit();
			session.close();
			
		 }
	}
	

	private String calend(String pstrt, String prfrq) throws ParseException
	{
		int frq = Integer.parseInt(prfrq);
	String enddate = "";
	SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	Date d = sdf.parse(pstrt);
	System.out.println(d);
	Calendar cal = Calendar.getInstance();
	cal.setTime(d);
	
	
	if(frq == 1)
	cal.add(Calendar.MONTH, 12);
	else if(frq == 2)
		cal.add(Calendar.MONTH, 6);
	else if(frq == 4)
		cal.add(Calendar.MONTH, 3);
	else if(frq == 12)
		cal.add(Calendar.MONTH, 1);



	Date date = cal.getTime();
	System.out.println(enddate);
	enddate = sdf.format(date);
	
	
	
	
	return enddate;
	}

	private int calculateage(String DOB, String cdate){
		int age=0;
		if(DOB.length()==10){
			String Month1 = DOB.substring(0, 2);
			String date1 =  DOB.substring(3, 5);
			String year1 = DOB.substring(6, 10);
			String Month2 = cdate.substring(0, 2);
			String date2 = cdate.substring(3, 5);
			String year2 = cdate.substring(6, 10);
			int m1 = Integer.parseInt(Month1);
			int m2 = Integer.parseInt(Month2);
			int d1 = Integer.parseInt(date1);
			int d2 = Integer.parseInt(date2);
			int y1 = Integer.parseInt(year1);
			int y2 = Integer.parseInt(year2);
			age = y2-y1;
			
			if (m2<m1)
				age = age-1;
			
			if(m2==m1){
				if(d2<d1)
					age=age-1;
			}
		}
		
		if(DOB.length()==9){
			String Month1 = DOB.substring(0, 1);
			String date1 =  DOB.substring(2, 4);
			String year1 = DOB.substring(5, 9);
			String Month2 = cdate.substring(0, 2);
			String date2 = cdate.substring(3, 5);
			String year2 = cdate.substring(6, 10);
			int m1 = Integer.parseInt(Month1);
			int m2 = Integer.parseInt(Month2);
			int d1 = Integer.parseInt(date1);
			int d2 = Integer.parseInt(date2);
			int y1 = Integer.parseInt(year1);
			int y2 = Integer.parseInt(year2);
			age = y2-y1;
			
			if (m2<m1)
				age = age-1;
			
			if(m2==m1){
				if(d2<d1)
					age=age-1;
			}
		}
		
		return age;
	}
	
	
	private int ageweightcal(int age){
		int weight = 0;
		if(age>=1 && age<=25)
			weight=2;
		else if(age>=26 && age<=35)
			weight=4;
		else if(age>=36 && age<=45)
			weight=6;
		else if(age>=46 && age<=55)
			weight=8;
		else if(age>=56 && age<=65)
			weight=10;
		else if(age>=66 && age<=75)
			weight=12;
		else if(age>=76 && age<=85)
			weight=14;
		else if(age>86)
			weight=-1;
		
		return weight;
		
	}
	
	public int genderweightcal(String gender){
		int weight = 0;
		if(gender.equals("M"))
			weight=2;
		else if(gender.equals("F"))
			weight=3;
		else if(gender.equals("U"))
			weight=3;
		return weight;
	}
	
	public int coverageweightcal(String coverage){
		int weight = 0;
		int coverageamount = Integer.parseInt(coverage);
		System.out.println("coverage amount is:"+coverageamount);
		if(coverageamount<=50000)
			weight = 1;
		else if(coverageamount>=50001 && coverageamount<=75000)
			weight = 2;
		else if(coverageamount>=75001 && coverageamount<=100000)
			weight = 3;
		else if(coverageamount>=1000001 && coverageamount<=200000)
			weight = 4;
		else if(coverageamount>=200001 && coverageamount<=300000)
			weight = 5;
		else if(coverageamount>=300001 && coverageamount<=400000)
			weight = 6;
		else if(coverageamount>=400001 && coverageamount<=500000)
			weight = 7;
		else if(coverageamount>=500001)
			weight = -1;
		 
		return weight;
	}
	
	private int otherweightcal(String student, String drinking, String hazardous, String disease){
		int weight = 0;
		
		if(student.equals("Y"))
			weight = weight+1;
		if(drinking.equals("Y"))
			weight = weight+2;
		if(hazardous.equals("Y"))
			weight = weight+4;
		if(disease.equals("Y"))
			weight = weight+2;
		
		return weight;
	}
	
	public int calculatepremium(int totweight, String covamnt)
	{
		int premiumamount = 0;
		int coverage = Integer.parseInt(covamnt);
		if(totweight>=5 && totweight<=10)
			premiumamount = (coverage*10)/100;
		else if(totweight>=11 && totweight<=15)
			premiumamount = (coverage*20)/100;
		else if(totweight>=16 && totweight<=20)
			premiumamount = (coverage*30)/100;
		else if(totweight>=21 && totweight<=25)
			premiumamount = (coverage*40)/100;
		else if(totweight>25)
			premiumamount=-1;
		return premiumamount;
	}
}
