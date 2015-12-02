/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/

package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ImportData {
	public static void main(String[] args)
	{
		String[] fieldsNamesoriginal = {"Email* ", "Name* ", "Enrollment Number* ", "Address of Correspondence* ", "Mobile* ", "PhD Stream* ", "PhD Area Preference 1* ", "PhD Area Preference 2 ", "PhD Area Preference 3 ", "Gender* ", "Category* ", "Physically Disabled* ", "Date Of Birth* ", "Children/War Widows of Defence Personnel killed/Disabled in Action* ", "Father's Name* ", "Nationality* ", "Permanent Address* ", "Pin Code ", "Xth Board* ", "Xth Marks (%)* ", "Year of Passing Xth* ", "XIIth Board* ", "XIIth Marks (%)* ", "Year of Passing XIIth* ", "Degree* ", "Department/Discipline* ", "Name of College* ", "Name of University* ", "City* ", "State* ", "Year of Graduation* ", "CGPA or MARKS ", "Graduation CGPA ", "Graduation CGPA Scale ", "Graduation Marks (%) ", "ECE PhD Subject Preference ", "Preference 1 ", "Preference 2 ", "Preference 3 ", "Preference 4 ", "Post-Graduation ", "Name of College ", "City ", "State ", "Department/Discipline ", "Degree ", "Thesis Title ", "Year of Post-Graduation ", "CGPA or MARKS? ", "Post-Graduation CGPA ", "Post-Graduation CGPA Scale ", "Post-Graduation Marks (%) ", "Other Academic Degrees ", "Exam Name ", "Subject ", "Year ", "Score ", "Rank ", "Gate ", "Area ", "Year of Graduation ", "Marks(out of 100) ", "Score ", "Rank ", "Achievements (Other information like ranks, medals etc.) ", "CV/Resume* ", "Statement of Purpose* ", "EnrollmentID ", "Enrollment Time "};

		String[] fieldsNames = {"Email", "Name", "Enrollment Number", "Address of Correspondence","Mobile", "PhD Stream", "PhD Area Preference 1", "PhD Area Preference 2", "PhD Area Preference 3", "Gender", "Category", "Physically Disabled", "DOB" ,"Children/War Widows of Defence Personnel killed/Disabled in Action", "Father's Name", "Nationality", "Permanent Address", "Pin Code", "Xth Board", "Xth Marks (%)", "Year of Passing Xth", "XIIth Board", "XIIth Marks (%)", "Year of Passing XIIth", "Graduation Degree", "Graduation Department", "Graduation College", "Graduation University", "Graduation City", "Graduationon State","Year of Graduation", "CGPA or Marks", "Graduation CGPA ", "Graduation CGPA Scale ", "Graduation Marks (%) ", "Applying for ECE PhD", "ECE PhD Subject Preference 1", "ECE PhD Subject Preference 2", "ECE PhD Subject Preference 3", "ECE PhD Subject Preference 4", "Completed Post Grad", "Post Grad Degree", "Post Grad Department", "Post Grad College", "Post Grad Thesis", "Post Grad City", "Post Grad State", "Year of Post Grad", "Post Grad CGPA or Marks", "Other Academic Degrees", "Exam Name", "Subject", "Year", "Score", "Rank", "Taken GATE Exam", "GATE Area", "Year of Graduation", "Marks(%)", "Score", "Rank", "Achievements", "CV/Resume", "Statement of Purpose", "EnrollmentID", "Enrollment Time"};

		BufferedReader br = null;
		BufferedWriter csv=null;
		try {
			br = new BufferedReader(new FileReader("./src/Data_to_Import.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			csv = new BufferedWriter(new FileWriter("/Users/siddharthsingh/Documents/workspace4/AP_project_admin/src/entries.txt", true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String line = null;
		long x = 0;
		long unixTime;
		// = System.currentTimeMillis() / 1000L;
		//String enrollmentID = "" + unixTime;
		//System.out.println(enrollmentID);
		String correspondence = null;
		String permanent = null;
		try {
			br.readLine();
			while((line = br.readLine()) != null)
			{
				String[] fieldValues = new String[69];
				unixTime = System.currentTimeMillis() / 1000L;
				String enrollmentID = "" + (unixTime + x);
				x++;
				String[] values = line.split("\"");
				
				/*System.out.println(values[1]);
				System.out.println(values[3]);*/
				correspondence = values[1].replace(",", "");
				correspondence = correspondence.replace(".", "");
				permanent = values[3].replace(",", "");
				permanent = permanent.replace(".", "");

				String[] pehleVali = values[0].split(",");
				//System.out.println("pehle - " + pehleVali.length);
				fieldValues[0] = pehleVali[0];
				fieldValues[1] = pehleVali[1];
				fieldValues[3] = correspondence;
				String[] bichVali = values[2].split(",");
				int i = 1;
				for(; i < bichVali.length; i++)
				{
					if(bichVali[i].equals(""))
						fieldValues[3+i] = "null";
					else
						fieldValues[3+i] = bichVali[i];
					//j++;
					//fieldValues[i] = bichVali[i];
					//System.out.println("ll  " + fieldValues[4+i]);
				}
				fieldValues[3+i] = permanent;
				
				//System.out.println("i - " + i);
				
				String[] akhiriVali = values[4].split(",");
				
				fieldValues[65] = fieldValues[66] = null;
				fieldValues[67] = enrollmentID;
				fieldValues[68] = ((akhiriVali[(akhiriVali.length)-2]).split(" "))[0];
				HashMap<String, String> data_to_digit= new HashMap<String, String>();
				data_to_digit.put("Jan", "01");
				data_to_digit.put("Feb", "02");
				data_to_digit.put("Mar", "03");
				data_to_digit.put("Apr", "04");
				data_to_digit.put("May", "05");
				data_to_digit.put("Jun", "06");
				data_to_digit.put("Jul", "07");
				data_to_digit.put("Aug", "08");
				data_to_digit.put("Sep", "09");
				data_to_digit.put("Oct", "10");
				data_to_digit.put("Nov", "11");
				data_to_digit.put("Dec", "12");
				String[] date_data=fieldValues[68].split("-");
				String mon=data_to_digit.get(date_data[1]);
				fieldValues[68]=date_data[0]+"-"+mon+"-"+date_data[2];
				System.out.println(fieldValues[68]);
				fieldValues[2] = akhiriVali[akhiriVali.length-1];
				i = i+3;
				i++;
				//System.out.println("ii =- "+ i);
				int j = 1;
				for(; i < 31; i++)
				{
					if(akhiriVali[j].equals(""))
						fieldValues[i] = "null";
					else
						fieldValues[i] = akhiriVali[j];
					j++;
				}
				//System.out.println("sdsds  " + j + " " + akhiriVali[j]);
				fieldValues[31] = (akhiriVali[j].split(":"))[0];
				fieldValues[32] = (fieldValues[31].equals("CGPA"))?(akhiriVali[j].split(":"))[1]:"null";
				fieldValues[33] = "10";
				fieldValues[34] = (fieldValues[31].equals("Marks"))?(akhiriVali[j].split(":"))[1]:"null";
				//System.out.println("sdsd - " + j + " " + akhiriVali[j+1]);
				j++;		
				for(i = 35; i < 40; i++)
				{
					if(akhiriVali[j].equals(""))
						fieldValues[i] = "null";
					else
						fieldValues[i] = akhiriVali[j];
					j++;
				}

				//System.out.println("ppp - " + j + " " + akhiriVali[29]);
				j++;

				fieldValues[40] = akhiriVali[21];
				//System.out.println("ss " + fieldValues[39]);
				fieldValues[41] = akhiriVali[24];
				fieldValues[42] = akhiriVali[26];
				fieldValues[43] = akhiriVali[27];
				fieldValues[44] = akhiriVali[23];
				fieldValues[45] = akhiriVali[22];
				fieldValues[46] = akhiriVali[25];
				fieldValues[47] = akhiriVali[28];
				fieldValues[48] = (akhiriVali[29].split(":"))[0];
				fieldValues[49] = (fieldValues[48].equals("CGPA"))?(akhiriVali[29].split(":"))[1]:"null";
				fieldValues[50] = "10";
				fieldValues[51] = (fieldValues[48].equals("Marks"))?(akhiriVali[29].split(":"))[1]:"null";
				j = 30;
				for(i = 52; i < 65; i++)
				{
					if(akhiriVali[j].equals(""))
						fieldValues[i] = "null";
					else
						fieldValues[i] = akhiriVali[j];
					j++;
				}
				//System.out.println("randiiiiiiiii");
				String finaldatatoput="";
				for(int k = 0; k < 69; k++){
					//System.out.print(fieldValues[k] + ",");
					finaldatatoput+=(fieldValues[k] + ",");
				}
				System.out.println(finaldatatoput);
				csv.write(finaldatatoput);
				csv.write("\n");
				System.out.println("\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}