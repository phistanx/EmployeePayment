import java.io.*;
import java.util.*;
/**
 * Driver containing all important methods
 * @author Tristan Vu 40028927<br>
 * COMP 249<br>
 * Assignment 4<br>
 * Due Date: 10th April
 */
public class A4Driver {
	/**
	 * finds number of records for any text file
	 * @param String a
	 * @return integer
	 * @throws IOException
	 */
public static int numRecords(String a) throws IOException{
	BufferedReader in = null;
	int numRecords = 0;
	try{
		in = new BufferedReader(new FileReader(a));
		while(in.readLine()!=null){
			numRecords++;
		}
	}
	catch(IOException e){
		
	}
	finally{
		in.close();
		}
	return numRecords;
}
/**
 * allows user to add records to part-time text file
 * @param String b
 * @throws IOException
 */
public static void addPTRecords(String b) throws IOException{
	Scanner scan = null;
	Scanner scan1 = null;
	Scanner scan2 = null;
	Scanner scan3 = null;
	BufferedReader in = null;
	BufferedReader in1 = null;
	BufferedReader in2 = null;
	BufferedReader in3 = null;
	Scanner sc = null;
	PrintWriter out = null;
		try{
			in = new BufferedReader( new FileReader(b));
			in1 = new BufferedReader( new FileReader("Full-Time-Faculty.txt"));
			in2 = new BufferedReader( new FileReader("TAs.txt"));
			in3 = new BufferedReader( new FileReader("Staff.txt"));
			ArrayList<part_time>arr = new ArrayList<part_time>();
			//scans through the selected text file
			scan = new Scanner(in);
				for(int i=0;i<numRecords(b);i++){
				part_time p = new part_time();
				p.setId(scan.nextLong());
				p.setFirstName(scan.next());
				p.setFamilyName(scan.next());
				p.setCityOfResidence(scan.next());
				p.setHireYear(scan.nextInt());
				p.setHourlyRate(scan.nextDouble());
				p.setNumHrs(scan.nextInt());
				p.setNumStudents(scan.nextInt());
				arr.add(p);
				}
				
				
				scan1 = new Scanner(in1);
				ArrayList<full_time>arr1 = new ArrayList<full_time>();
					for(int i=0;i<numRecords("Full-Time-Faculty.txt");i++){
					full_time y = new full_time();
					y.setId(scan1.nextLong());
					y.setFirstName(scan1.next());
					y.setFamilyName(scan1.next());
					y.setCityOfResidence(scan1.next());
					y.setHireYear(scan1.nextInt());
					y.setSalary(scan1.nextLong());
					arr1.add(y);
					}
					
					ArrayList<TAs>arr2 = new ArrayList<TAs>();
					scan2 = new Scanner(in2);
						for(int i=0;i<numRecords("TAs.txt");i++){
							TAs p = new TAs();
						p.setId(scan2.nextLong());
						p.setFirstName(scan2.next());
						p.setFamilyName(scan2.next());
						p.setCityOfResidence(scan2.next());
						p.setHireYear(scan2.nextInt());
						p.setClassification(scan2.next());
						p.setNumClasses(scan2.nextInt());
						p.setNumWorkHrs(scan2.nextInt());
						arr2.add(p);
						}
						
						 scan3 = new Scanner(in3);
						 	ArrayList<Staff>arr3 = new ArrayList<Staff>();
						 	 	for(int i =0;i<numRecords("Staff.txt");i++){
						 		Staff v = new Staff();
						 		v.setId(scan3.nextLong());
								v.setFirstName(scan3.next());
								v.setFamilyName(scan3.next());
								v.setCityOfResidence(scan3.next());
								v.setHireYear(scan3.nextInt());
								v.setSalary(scan3.nextDouble());
								v.setPerfCode(scan3.next().charAt(0));
								arr3.add(v);
						 	}
			//User input records
			sc=new Scanner(System.in);
			out = new PrintWriter(new FileOutputStream(b,true));
			out.println();
			boolean adding = true;
			int i = numRecords(b);
			
			System.out.println("Enter record(s): ");
	 outer: while(adding){
			part_time p = new part_time();
			String input = sc.nextLine();
			if(input.equals("-1")){
				break;
			}
			String[] tokens = null;
			long id=0;
			int hireYear=0;
			double hourlyRate=0;
			int numHrs=0;
			int numStudents=0;
			try{
			 tokens = input.split("\\s+");
			 id = Long.parseLong(tokens[0]);
			 hireYear = Integer.parseInt(tokens[4]);
			 hourlyRate = Double.parseDouble(tokens[5]);
			 numHrs = Integer.parseInt(tokens[6]);
			 numStudents = Integer.parseInt(tokens[7]);
			}
			catch(NumberFormatException e){
				System.out.println("Error, try again: ");
				continue;
			}
			p = new part_time(id,tokens[1],tokens[2],tokens[3],hireYear,hourlyRate,numHrs,numStudents);
			arr.add(p);
			for(int j=0;j<i;j++){
				if(arr.get(i).getId()==arr.get(j).getId()){
					System.out.println("ID already exist, go again:");
					arr.remove(i);
					continue outer;
				}
			}
			for(int k=0;k<numRecords("Full-Time-Faculty.txt");k++){
				if(arr.get(i).getId()==arr1.get(k).getId()){
					System.out.println("ID already exist, go again:");
					arr.remove(i);
					continue outer;
				}
			}
			for(int q=0;q<numRecords("TAs.txt");q++){
				if(arr.get(i).getId()==arr2.get(q).getId()){
					System.out.println("ID already exist, go again:");
					arr.remove(i);
					continue outer;
				}
			}
			for(int n=0;n<numRecords("Staff.txt");n++){
				if(arr.get(i).getId()==arr3.get(n).getId()){
					System.out.println("ID already exist, go again:");
					arr.remove(i);
					continue outer;
				}
			}
			out.println(arr.get(i));
			i++;
					}
			}
		catch(IOException e){
			System.out.println("error");
		}finally{
			in.close();
			in1.close();
			in2.close();
			in3.close();
			scan.close();
			scan1.close();
			scan2.close();
			scan3.close();
			out.close();
			}
	}
/**
 * allows user to add records to full-time text file
 * @param String b
 * @throws IOException
 */
public static void addFTRecords(String b) throws IOException{
	Scanner scan = null;
	Scanner scan1 = null;
	Scanner scan2 = null;
	Scanner scan3 = null;
	BufferedReader in = null;
	BufferedReader in1 = null;
	BufferedReader in2 = null;
	BufferedReader in3 = null;
	Scanner sc = null;
	PrintWriter out = null;
	try{
		in = new BufferedReader( new FileReader(b));
		in1 = new BufferedReader( new FileReader("Part-Time-Faculty.txt"));
		in2 = new BufferedReader( new FileReader("TAs.txt"));
		in3 = new BufferedReader( new FileReader("Staff.txt"));
		ArrayList<full_time>arr = new ArrayList<full_time>();
		//scans through the selected text file
		scan = new Scanner(in);
			for(int i=0;i<numRecords(b);i++){
			full_time p = new full_time();
			p.setId(scan.nextLong());
			p.setFirstName(scan.next());
			p.setFamilyName(scan.next());
			p.setCityOfResidence(scan.next());
			p.setHireYear(scan.nextInt());
			p.setSalary(scan.nextLong());
			arr.add(p);
			}
			
			scan1 = new Scanner(in1);
			ArrayList<part_time>arr1 = new ArrayList<part_time>();
				for(int i=0;i<numRecords("Part-Time-Faculty.txt");i++){
				part_time x = new part_time();
				x.setId(scan1.nextLong());
				x.setFirstName(scan1.next());
				x.setFamilyName(scan1.next());
				x.setCityOfResidence(scan1.next());
				x.setHireYear(scan1.nextInt());
				x.setHourlyRate(scan1.nextDouble());
				x.setNumHrs(scan1.nextInt());
				x.setNumStudents(scan1.nextInt());
				arr1.add(x);
				}
				
				ArrayList<TAs>arr2 = new ArrayList<TAs>();
				scan2 = new Scanner(in2);
					for(int i=0;i<numRecords("TAs.txt");i++){
						TAs p = new TAs();
					p.setId(scan2.nextLong());
					p.setFirstName(scan2.next());
					p.setFamilyName(scan2.next());
					p.setCityOfResidence(scan2.next());
					p.setHireYear(scan2.nextInt());
					p.setClassification(scan2.next());
					p.setNumClasses(scan2.nextInt());
					p.setNumWorkHrs(scan2.nextInt());
					arr2.add(p);
					}
					
					 scan3 = new Scanner(in3);
					 	ArrayList<Staff>arr3 = new ArrayList<Staff>();
					 	 	for(int i =0;i<numRecords("Staff.txt");i++){
					 		Staff v = new Staff();
					 		v.setId(scan3.nextLong());
							v.setFirstName(scan3.next());
							v.setFamilyName(scan3.next());
							v.setCityOfResidence(scan3.next());
							v.setHireYear(scan3.nextInt());
							v.setSalary(scan3.nextDouble());
							v.setPerfCode(scan3.next().charAt(0));
							arr3.add(v);
					 	}
		//User input records
		sc=new Scanner(System.in);
		out = new PrintWriter(new FileOutputStream(b,true));
		out.println();
		boolean adding = true;
		int i = numRecords(b);
		
		System.out.println("Enter record(s): ");
 outer: while(adding){
	   full_time p = new full_time();
		String input = sc.nextLine();
		if(input.equals("-1")){
			break;
		}
		String[] tokens = null;
		long id = 0;
		int hireYear=0;
		long salary=0;
		try{
		tokens = input.split("\\s+");
		id = Long.parseLong(tokens[0]);
		hireYear = Integer.parseInt(tokens[4]);
		salary = Long.parseLong(tokens[5]);
		}
		catch(NumberFormatException e){
			
		}
		p = new full_time(id,tokens[1],tokens[2],tokens[3],hireYear,salary);
		arr.add(p);
		for(int j=0;j<i;j++){
			if(arr.get(i).getId()==arr.get(j).getId()){
				System.out.println("ID already exist, go again:");
				arr.remove(i);
				continue outer;
			}
		}
		for(int k=0;k<numRecords("Part-Time-Faculty.txt");k++){
			if(arr.get(i).getId()==arr1.get(k).getId()){
				System.out.println("ID already exist, go again:");
				arr.remove(i);
				continue outer;
			}
		}
		for(int q=0;q<numRecords("TAs.txt");q++){
			if(arr.get(i).getId()==arr2.get(q).getId()){
				System.out.println("ID already exist, go again:");
				arr.remove(i);
				continue outer;
			}
		}
		for(int n=0;n<numRecords("Staff.txt");n++){
			if(arr.get(i).getId()==arr3.get(n).getId()){
				System.out.println("ID already exist, go again:");
				arr.remove(i);
				continue outer;
			}
		}
		out.println(arr.get(i));
		i++;
				}
		}
	catch(IOException e){
		System.out.println("error");
	}finally{
		in.close();
		in1.close();
		in2.close();
		in3.close();
		scan.close();
		scan1.close();
		scan2.close();
		scan3.close();
		out.close();
		}
}	
/**
 * allows user to add records to TA text file
 * @param String b
 * @throws IOException
 */
public static void addTARecords(String b) throws IOException{
	Scanner scan = null;
	Scanner scan1 = null;
	Scanner scan2 = null;
	Scanner scan3 = null;
	BufferedReader in = null;
	BufferedReader in1 = null;
	BufferedReader in2 = null;
	BufferedReader in3 = null;
	Scanner sc = null;
	PrintWriter out = null;
	try{
		in = new BufferedReader( new FileReader(b));
		in1 = new BufferedReader( new FileReader("Part-Time-Faculty.txt"));
		in2 = new BufferedReader( new FileReader("Full-Time-Faculty.txt"));
		in3 = new BufferedReader( new FileReader("Staff.txt"));
		ArrayList<TAs>arr = new ArrayList<TAs>();
		scan = new Scanner(in);
			for(int i=0;i<numRecords(b);i++){
				TAs p = new TAs();
			p.setId(scan.nextLong());
			p.setFirstName(scan.next());
			p.setFamilyName(scan.next());
			p.setCityOfResidence(scan.next());
			p.setHireYear(scan.nextInt());
			p.setClassification(scan.next());
			p.setNumClasses(scan.nextInt());
			p.setNumWorkHrs(scan.nextInt());
			arr.add(p);
			}
		
			//
		 scan1 = new Scanner(in1);
			ArrayList<part_time>arr1 = new ArrayList<part_time>();
				for(int i=0;i<numRecords("Part-Time-Faculty.txt");i++){
				part_time x = new part_time();
				x.setId(scan1.nextLong());
				x.setFirstName(scan1.next());
				x.setFamilyName(scan1.next());
				x.setCityOfResidence(scan1.next());
				x.setHireYear(scan1.nextInt());
				x.setHourlyRate(scan1.nextDouble());
				x.setNumHrs(scan1.nextInt());
				x.setNumStudents(scan1.nextInt());
				arr1.add(x);
				}
				//
			scan2 = new Scanner(in2);
				ArrayList<full_time>arr2 = new ArrayList<full_time>();
					for(int i=0;i<numRecords("Full-Time-Faculty.txt");i++){
					full_time y = new full_time();
					y.setId(scan2.nextLong());
					y.setFirstName(scan2.next());
					y.setFamilyName(scan2.next());
					y.setCityOfResidence(scan2.next());
					y.setHireYear(scan2.nextInt());
					y.setSalary(scan2.nextLong());
					arr2.add(y);
					}
					
					
					
			 scan3 = new Scanner(in3);
			 	ArrayList<Staff>arr3 = new ArrayList<Staff>();
			 	 	for(int i =0;i<numRecords("Staff.txt");i++){
			 		Staff v = new Staff();
			 		v.setId(scan3.nextLong());
					v.setFirstName(scan3.next());
					v.setFamilyName(scan3.next());
					v.setCityOfResidence(scan3.next());
					v.setHireYear(scan3.nextInt());
					v.setSalary(scan3.nextDouble());
					v.setPerfCode(scan3.next().charAt(0));
					arr3.add(v);
			 	}
			 	//
		//User input records
		sc=new Scanner(System.in);
		out = new PrintWriter(new FileOutputStream(b,true));
		out.println();
		boolean adding = true;
		int i = numRecords(b);
		
		System.out.println("Enter record(s): ");
 outer: while(adding){
	    TAs p = new TAs();
		String input = sc.nextLine();
		if(input.equals("-1")){
			break;
		}
		String[] tokens = null;
		long id=0;
		int hireYear=0;
		int numClasses=0;
		int numWorkHrs=0;
		try{
		 tokens = input.split("\\s+");
		 id = Long.parseLong(tokens[0]);
		 hireYear = Integer.parseInt(tokens[4]);
		 numClasses = Integer.parseInt(tokens[6]);
		 numWorkHrs = Integer.parseInt(tokens[7]);
		}
		catch(NumberFormatException e){
			System.out.println("Error, try again: ");
			continue;
		}
		p = new TAs(id,tokens[1],tokens[2],tokens[3],hireYear,tokens[5],numClasses,numWorkHrs);
		arr.add(p);
		
		for(int j=0;j<i;j++){
			if(arr.get(i).getId()==arr.get(j).getId()){
				System.out.println("ID already exist, go again:");
				arr.remove(i);
				continue outer;
			}
				}
		for(int k=0;k<numRecords("Part-Time-Faculty.txt");k++){
			if(arr.get(i).getId()==arr1.get(k).getId()){
				System.out.println("ID already exist, go again:");
				arr.remove(i);
				continue outer;
			}
		}
		for(int q=0;q<numRecords("Full-Time-Faculty.txt");q++){
			if(arr.get(i).getId()==arr2.get(q).getId()){
				System.out.println("ID already exist, go again:");
				arr.remove(i);
				continue outer;
			}
		for(int n=0;n<numRecords("Staff.txt");n++){
			if(arr.get(i).getId()==arr3.get(n).getId()){
				System.out.println("ID already exist, go again:");
				arr.remove(i);
				continue outer;
			}
		}
		}
		out.println(arr.get(i));
		i++;
				}
		}
	catch(IOException e){
		System.out.println("error");
	}finally{
		in.close();
		in1.close();
		in2.close();
		in3.close();
		scan.close();
		scan1.close();
		scan2.close();
		scan3.close();
		out.close();
		}
}	
/**
 * Returns the total salary of all TA and part-time employees
 * @return totalSalry
 * @throws IOException
 */
public static double findTermSalary() throws IOException{
	BufferedReader ta = null;
	BufferedReader pt = null;
	Scanner scTa = null;
	Scanner scPt = null;
	double totalSalary=0;
	try{
	 ta = new BufferedReader( new FileReader("TAs.txt"));
	 pt = new BufferedReader( new FileReader("Part-Time-Faculty.txt"));
	 LinkedList tas = new LinkedList();
	 scTa = new Scanner(ta);
	 for(int i=0;i<numRecords("TAs.txt"); i++){
		TAs a = new TAs();
		a.setId(scTa.nextLong());
		a.setFirstName(scTa.next());
		a.setFamilyName(scTa.next());
		a.setCityOfResidence(scTa.next());
		a.setHireYear(scTa.nextInt());
		a.setClassification(scTa.next());
		a.setNumClasses(scTa.nextInt());
		a.setNumWorkHrs(scTa.nextInt());
		tas.add(a);
		totalSalary+=a.getSalary();
			 }

	 LinkedList pts = new LinkedList();
	 scPt = new Scanner(pt);
	 for(int i=0;i<numRecords("Part-Time-Faculty.txt");i++){
		 	part_time b = new part_time();
			b.setId(scPt.nextLong());
			b.setFirstName(scPt.next());
			b.setFamilyName(scPt.next());
			b.setCityOfResidence(scPt.next());
			b.setHireYear(scPt.nextInt());
			b.setHourlyRate(scPt.nextDouble());
			b.setNumHrs(scPt.nextInt());
			b.setNumStudents(scPt.nextInt());
			pts.add(b);
			totalSalary+=b.getSalary();
	 }
	
	}
	catch(IOException e){
		
	}
	finally{
		ta.close();
		pt.close();
		scPt.close();
		scTa.close();
	}
	return totalSalary;
}
/**
 * finds the highest and lowest salary of full-time employees and prints it
 * @throws IOException
 */
public static void  findHighest_and_Lowest_FT_Salary() throws IOException{
	BufferedReader ft = null;	
	Scanner sc = null;
	try{
		ft = new BufferedReader( new FileReader("Full-Time-Faculty.txt"));
		LinkedList fts = new LinkedList();
		sc = new Scanner(ft);
		
		for(int i=0;i<numRecords("Full-Time-Faculty.txt");i++){
			full_time a = new full_time();
			a.setId(sc.nextInt());
			a.setFirstName(sc.next());
			a.setFamilyName(sc.next());
			a.setCityOfResidence(sc.next());
			a.setHireYear(sc.nextInt());
			a.setSalary(sc.nextLong());
			fts.add(a);
			}
		
		String [] tokens = null;
		long [] salarys = new long[numRecords("Full-Time-Faculty.txt")];
		for(int i=1;i<numRecords("Full-Time-Faculty.txt")+1;i++){
		tokens = fts.getList(i).split("\\s+");
		 salarys [i-1]= Long.parseLong(tokens[5]);
				} 
		
		long highest=salarys[0];
		for(int i=0;i<salarys.length;i++){
			if(highest<salarys[i]){
				highest=salarys[i];

			}
		}
		long lowest=salarys[0];
		for(int i=0;i<salarys.length;i++){
			if(lowest>salarys[i]){
				lowest=salarys[i];

			}
		}
		for(int i=0;i<salarys.length;i++){
			if(highest==salarys[i]){
				System.out.println(fts.getList(i+1));
			}
			else if(lowest==salarys[i]){
				System.out.println(fts.getList(i+1));
			}
		}
		}
	catch(IOException e){
		
	}
	finally{
		ft.close();
		sc.close();
	}
}
/**
 * Increases staff salary based on the performance and permanently changes the text file
 * @throws IOException
 */
public static void Increase_Staff_Salary() throws IOException{
	BufferedReader st = null;
	Scanner sc = null;
	PrintWriter out = null;
	try{
		st = new BufferedReader( new FileReader("Staff.txt"));
		sc = new Scanner(st);
		EmployList<Staff>staffs = new EmployList<Staff>();
		for(int i=0;i<numRecords("Staff.txt");i++){
			Staff a = new Staff();
			a.setId(sc.nextInt());
			a.setFirstName(sc.next());
			a.setFamilyName(sc.next());
			a.setCityOfResidence(sc.next());
			a.setHireYear(sc.nextInt());
			a.setSalary(sc.nextDouble());
			a.setPerfCode(sc.next().charAt(0));
			staffs.add(a);
		}
		out = new PrintWriter(new FileOutputStream("Staff.txt"));
			for(int i=1;i<staffs.Size()+1;i++){
			if(staffs.getList(i).getPerfCode()=='A'){
				staffs.getList(i).setSalary(staffs.getList(i).getSalary()*1.08);
				staffs.getList(i).setPerfCode('E');
			}
			else if(staffs.getList(i).getPerfCode()=='B'){
				staffs.getList(i).setSalary(staffs.getList(i).getSalary()*1.06);
				staffs.getList(i).setPerfCode('E');
			}
			else if(staffs.getList(i).getPerfCode()=='C'){
				staffs.getList(i).setSalary(staffs.getList(i).getSalary()*1.03);
				staffs.getList(i).setPerfCode('E');
			}
			else if(staffs.getList(i).getPerfCode()=='D'){
				staffs.getList(i).setSalary(staffs.getList(i).getSalary()*1.01);
				staffs.getList(i).setPerfCode('E');
			}
			out.println(staffs.getList(i));
		}
	}
	catch(IOException e){
		
	}
	finally{
		st.close();
		sc.close();
		out.close();
	}
}
public static void main(String[] args) throws IOException{
	   /* addPTRecords("Part-Time-Faculty.txt");
		addFTRecords("Full-Time-Faculty.txt");
		addTARecords("TAs.txt");
		system.out.println("total salary is " + findTermSalary());
		findHighest_and_Lowest_FT_Salary();
		Increase_Staff_Salary();*/
	}
}