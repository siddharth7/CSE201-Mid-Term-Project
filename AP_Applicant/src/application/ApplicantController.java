/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/

package application;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;

public class ApplicantController implements Initializable{

	 //private static final CopyOption REPLACE_EXISTING = null;
	
	@FXML
    private Tab personal;
	
	@FXML
    private Tab education;
	
	@FXML
	    private CheckBox DD;

	    @FXML
	    private TextField gradCollege;

	    @FXML
	    private TextField gradMarks;

	    @FXML
	    private TextField postThesis;

	    @FXML
	    private TextField gateArea;

	    @FXML
	    private TextField otherScore;

	    @FXML
	    private TextField postDept;

	    @FXML
	    private TextField pin;

	    @FXML
	    private ChoiceBox<String> gradState;

	    @FXML
	    private ToggleGroup children;

	    @FXML
	    private Button sop;

	    @FXML
	    private TextField postDegree;

	    @FXML
	    private TextField gradCity;

	    @FXML
	    private TextField fname;

	    @FXML
	    private TextField tenBoard;

	    @FXML
	    private ChoiceBox<String> gateYear;

	    @FXML
	    private TextField gradUniversity;

	    @FXML
	    private TextField gradDegree;

	    @FXML
	    private ToggleGroup gpa2;

	    @FXML
	    private TextField postCollege;

	    @FXML
	    private Label sopname;

	    @FXML
	    private ChoiceBox<String> tenPass;

	    @FXML
	    private ChoiceBox<String> twelfthPass;

	    @FXML
	    private TextField otherExam;

	    @FXML
	    private ChoiceBox<String> nationality;

	    @FXML
	    private DatePicker dob;

	    @FXML
	    private TextField name;

	    @FXML
	    private ChoiceBox<String> postScale;

	    @FXML
	    private TextField postCity;

	    @FXML
	    private TextField gateScore;

	    @FXML
	    private Button submit;

	    @FXML
	    private TextField gradGPA;

	    @FXML
	    private ToggleGroup why;
	    
	    @FXML
	    private ToggleGroup ece;
	    
	    @FXML
	    private ToggleGroup post;
	    
	    @FXML
	    private ToggleGroup other;
	    
	    @FXML
	    private ToggleGroup gate;

	    @FXML
	    private TextField gateMarks;

	    @FXML
	    private TextField bankName;

	    @FXML
	    private ToggleGroup how;

	    @FXML
	    private ChoiceBox<String> gradScale;

	    @FXML
	    private TextField tenMarks;

	    @FXML
	    private ToggleGroup accgpa2;

	    @FXML
	    private ToggleGroup stream;

	    @FXML
	    private TextField DDnum;

	    @FXML
	    private ToggleGroup disabled;

	    @FXML
	    private TextField postMarks;

	    @FXML
	    private TextField otherSubject;

	    @FXML
	    private ChoiceBox<String> postYear;

	    @FXML
	    private Label cvname;
	    
	    @FXML
	    private Label status;

	    @FXML
	    private TextField email;

	    @FXML
	    private TextField otherRank;

	    @FXML
	    private TextField enrnum;

	    @FXML
	    private TextField twelfthMarks;

	    @FXML
	    private TextField bankBranch;

	    @FXML
	    private ToggleGroup sex;

	    @FXML
	    private TextField mobile;

	    @FXML
	    private ChoiceBox<String> postState;

	    @FXML
	    private TextField twelfthBoard;

	    @FXML
	    private TextField gateRank;

	    @FXML
	    private ChoiceBox<String> otherYear;

	    @FXML
	    private ChoiceBox<String> phd1;

	    @FXML
	    private ChoiceBox<String> phd2;

	    @FXML
	    private ChoiceBox<String> ecePref1;

	    @FXML
	    private ChoiceBox<String> phd3;

	    @FXML
	    private Button cv;

	    @FXML
	    private TextField gradDept;

	    @FXML
	    private TextArea permanent;
	    
	    @FXML
	    private TextArea correspondence;

	    @FXML
	    private TextField postGPA;

	    @FXML
	    private ChoiceBox<String> gradYear;

	    @FXML
	    private ToggleGroup category;

	    @FXML
	    private ChoiceBox<String> ecePref3;

	    @FXML
	    private ChoiceBox<String> ecePref2;

	    @FXML
	    private ChoiceBox<String> ecePref4;
	    
	    @FXML
	    private Accordion accordian;
	    
	    @FXML
	    private TitledPane accece;
	    
	    @FXML
	    private RadioButton eceNo;
	    
	    @FXML
	    private RadioButton postNo;
	    
	    @FXML
	    private RadioButton otherNo;
	    
	    @FXML
	    private RadioButton gateNo;
	    
	    @FXML
	    private TextField achieve;
    
	    private String cvPath = "null";

	    private String sopPath = "null";

	    private String[] fieldsNames = {"Email* ", "Name* ", "Enrollment Number* ", "Address of Correspondence* ", "Mobile* ", "PhD Stream* ", "PhD Area Preference 1* ", "PhD Area Preference 2 ", "PhD Area Preference 3 ", "Gender* ", "Category* ", "Physically Disabled* ", "Date Of Birth* ", "Children/War Widows of Defence Personnel killed/Disabled in Action* ", "Father's Name* ", "Nationality* ", "Permanent Address* ", "Pin Code ", "Xth Board* ", "Xth Marks (%)* ", "Year of Passing Xth* ", "XIIth Board* ", "XIIth Marks (%)* ", "Year of Passing XIIth* ", "Degree* ", "Department/Discipline* ", "Name of College* ", "Name of University* ", "City* ", "State* ", "Year of Graduation* ", "CGPA or MARKS ", "Graduation CGPA ", "Graduation CGPA Scale ", "Graduation Marks (%) ", "ECE PhD Subject Preference ", "Preference 1 ", "Preference 2 ", "Preference 3 ", "Preference 4 ", "Post-Graduation ", "Name of College ", "City ", "State ", "Department/Discipline ", "Degree ", "Thesis Title ", "Year of Post-Graduation ", "CGPA or MARKS? ", "Post-Graduation CGPA ", "Post-Graduation CGPA Scale ", "Post-Graduation Marks (%) ", "Other Academic Degrees ", "Exam Name ", "Subject ", "Year ", "Score ", "Rank ", "Gate ", "Area ", "Year of Graduation ", "Marks(out of 100) ", "Score ", "Rank ", "Achievements (Other information like ranks, medals etc.) ", "CV/Resume* ", "Statement of Purpose* ", "EnrollmentID ", "Enrollment Time "};

	    private ArrayList<String> fields = new ArrayList<String>();
	    
	    private String enrollmentID = "null";
	    
	    long unixTime;

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			nationality.setItems(FXCollections.observableArrayList("---------", "Afghan", "Albanian", "Algerian", "American", "Andorran", "Angolan", "Antiguans", "Argentinean", "Armenian", "Australian", "Austrian", "Azerbaijani", "Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Barbudans", "Batswana", "Belarusian", "Belgian", "Belizean", "Beninese", "Bhutanese", "Bolivian", "Bosnian", "Brazilian", "British", "Bruneian", "Bulgarian", "Burkinabe", "Burmese", "Burundian", "Cambodian", "Cameroonian", "Canadian", "Cape Verdean", "Central African", "Chadian", "Chilean", "Chinese", "Colombian", "Comoran", "Congolese", "Costa Rican", "Croatian", "Cuban", "Cypriot", "Czech", "Danish", "Djibouti", "Dominican", "Dutch", "East Timorese", "Ecuadorean", "Egyptian", "Emirian", "Equatorial Guinean", "Eritrean", "Estonian", "Ethiopian", "Fijian", "Filipino", "Finnish", "French", "Gabonese", "Gambian", "Georgian", "German", "Ghanaian", "Greek", "Grenadian", "Guatemalan", "Guinea-Bissauan", "Guinean", "Guyanese", "Haitian", "Herzegovinian", "Honduran", "Hungarian", "Icelander", "Indian", "Indonesian", "Iranian", "Iraqi", "Irish", "Israeli", "Italian", "Ivorian", "Jamaican", "Japanese", "Jordanian", "Kazakhstani", "Kenyan", "Kittian and Nevisian", "Kuwaiti", "Kyrgyz", "Laotian", "Latvian", "Lebanese", "Liberian", "Libyan", "Liechtensteiner", "Lithuanian", "Luxembourger", "Macedonian", "Malagasy", "Malawian", "Malaysian", "Maldivan", "Malian", "Maltese", "Marshallese", "Mauritanian", "Mauritian", "Mexican", "Micronesian", "Moldovan", "Monacan", "Mongolian", "Moroccan", "Mosotho", "Motswana", "Mozambican", "Namibian", "Nauruan", "Nepalese", "New Zealander", "Ni-Vanuatu", "Nicaraguan", "Nigerien", "North Korean", "Northern Irish", "Norwegian", "Omani", "Pakistani", "Palauan", "Panamanian", "Papua New Guinean", "Paraguayan", "Peruvian", "Polish", "Portuguese", "Qatari", "Romanian", "Russian", "Rwandan", "Saint Lucian", "Salvadoran", "Samoan", "San Marinese", "Sao Tomean", "Saudi", "Scottish", "Senegalese", "Serbian", "Seychellois", "Sierra Leonean", "Singaporean", "Slovakian", "Slovenian", "Solomon Islander", "Somali", "South African", "South Korean", "Spanish", "Sri Lankan", "Sudanese", "Surinamer", "Swazi", "Swedish", "Swiss", "Syrian", "Taiwanese", "Tajik", "Tanzanian", "Thai", "Togolese", "Tongan", "Trinidadian or Tobagonian", "Tunisian", "Turkish", "Tuvaluan", "Ugandan", "Ukrainian", "Uruguayan", "Uzbekistani", "Venezuelan", "Vietnamese", "Welsh", "Yemenite", "Zambian", "Zimbabwean"));
			nationality.setValue("---------");
			
			tenPass.setItems(FXCollections.observableArrayList("2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951"));
			tenPass.setValue("2013");
			twelfthPass.setItems(FXCollections.observableArrayList("2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951"));
			twelfthPass.setValue("2015");

			gradState.setItems(FXCollections.observableArrayList("---------", "Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh", "Chhatisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Pondicherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttaranchal", "Uttar Pradesh", "West Bengal", "Other"));
			gradState.setValue("---------");
		
			gradYear.setItems(FXCollections.observableArrayList("2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951"));
			gradYear.setValue("2015");
			gradScale.setItems(FXCollections.observableArrayList("4", "10"));
			gradScale.setValue("4");
			
			ecePref1.setItems(FXCollections.observableArrayList("---------", "Advanced Signal Processing", "Statistical Signal Processing", "Digital VLSI Design", "Analog CMOS design", "Digital Communications", "Communication Networks", "Linear systems", "Introduction to Robotics", "RF Circuit design", "Antennas and Propagation", "Embedded Systems"));
			ecePref1.setValue("---------");
			ecePref2.setItems(FXCollections.observableArrayList("---------", "Advanced Signal Processing", "Statistical Signal Processing", "Digital VLSI Design", "Analog CMOS design", "Digital Communications", "Communication Networks", "Linear systems", "Introduction to Robotics", "RF Circuit design", "Antennas and Propagation", "Embedded Systems"));
			ecePref2.setValue("---------");
			ecePref3.setItems(FXCollections.observableArrayList("---------", "Advanced Signal Processing", "Statistical Signal Processing", "Digital VLSI Design", "Analog CMOS design", "Digital Communications", "Communication Networks", "Linear systems", "Introduction to Robotics", "RF Circuit design", "Antennas and Propagation", "Embedded Systems"));
			ecePref3.setValue("---------");
			ecePref4.setItems(FXCollections.observableArrayList("---------", "Advanced Signal Processing", "Statistical Signal Processing", "Digital VLSI Design", "Analog CMOS design", "Digital Communications", "Communication Networks", "Linear systems", "Introduction to Robotics", "RF Circuit design", "Antennas and Propagation", "Embedded Systems"));
			ecePref4.setValue("---------");
			
			postState.setItems(FXCollections.observableArrayList("---------", "Andaman and Nicobar Islands", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chandigarh", "Chhatisgarh", "Dadra and Nagar Haveli", "Daman and Diu", "Delhi", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Lakshadweep", "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Pondicherry", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Tripura", "Uttaranchal", "Uttar Pradesh", "West Bengal", "Other"));
			postState.setValue("---------");
			postYear.setItems(FXCollections.observableArrayList("2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951"));
			postYear.setValue("2015");
			postScale.setItems(FXCollections.observableArrayList("4", "10"));
			postScale.setValue("4");
		
			otherYear.setItems(FXCollections.observableArrayList("2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951"));
			otherYear.setValue("2015");
			gateYear.setItems(FXCollections.observableArrayList("2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951"));
			gateYear.setValue("2015");

			phd1.setItems(FXCollections.observableArrayList("---------", "Artificial Intelligence and Robotics - CSE", "Biophysics - CB", "Compilers - CSE", "Computer Architecture and Systems Design - ECE", "Computer Architecture and Systems Design - CSE", "Computer Graphics - CSE", "Computer Vision - CSE", "Controls and Robotics - ECE", "Digital and Analog VLSI Systems Design - ECE", "Electromagnetics - ECE", "Embedded and VLSI systems design - ECE", "Embedded Systems - ECE", "Fiber-Wireless Architectures - ECE", "Image Analysis and Biometrics - CSE", "Information Management and Data Engineering - CSE", "Machine Learning - CSE", "Machine Learning - ECE", "Massively Parallel Systems - CSE", "Mobile Computing and Networking Applications - CSE", "OFDM based Optical Access Networks - ECE", "Optical Wireless Communication Systems - ECE", "Program Analysis - CSE", "RF and mixed signal electronics - ECE", "Security and Privacy - CSE", "Signal and Image Processing - ECE", "Signal and Image Processing - CSE", "Software Engineering - CSE", "Structural Biology - CB", "Systems Biology - CB", "Theoretical Computer Science - CSE", "Wireless Communication - ECE", "Wireless Networks - ECE", "Wireless Networks - CSE"));
			phd1.setValue("---------");
			phd2.setItems(FXCollections.observableArrayList("---------", "Artificial Intelligence and Robotics - CSE", "Biophysics - CB", "Compilers - CSE", "Computer Architecture and Systems Design - ECE", "Computer Architecture and Systems Design - CSE", "Computer Graphics - CSE", "Computer Vision - CSE", "Controls and Robotics - ECE", "Digital and Analog VLSI Systems Design - ECE", "Electromagnetics - ECE", "Embedded and VLSI systems design - ECE", "Embedded Systems - ECE", "Fiber-Wireless Architectures - ECE", "Image Analysis and Biometrics - CSE", "Information Management and Data Engineering - CSE", "Machine Learning - CSE", "Machine Learning - ECE", "Massively Parallel Systems - CSE", "Mobile Computing and Networking Applications - CSE", "OFDM based Optical Access Networks - ECE", "Optical Wireless Communication Systems - ECE", "Program Analysis - CSE", "RF and mixed signal electronics - ECE", "Security and Privacy - CSE", "Signal and Image Processing - ECE", "Signal and Image Processing - CSE", "Software Engineering - CSE", "Structural Biology - CB", "Systems Biology - CB", "Theoretical Computer Science - CSE", "Wireless Communication - ECE", "Wireless Networks - ECE", "Wireless Networks - CSE"));
			phd2.setValue("---------");
			phd3.setItems(FXCollections.observableArrayList("---------", "Artificial Intelligence and Robotics - CSE", "Biophysics - CB", "Compilers - CSE", "Computer Architecture and Systems Design - ECE", "Computer Architecture and Systems Design - CSE", "Computer Graphics - CSE", "Computer Vision - CSE", "Controls and Robotics - ECE", "Digital and Analog VLSI Systems Design - ECE", "Electromagnetics - ECE", "Embedded and VLSI systems design - ECE", "Embedded Systems - ECE", "Fiber-Wireless Architectures - ECE", "Image Analysis and Biometrics - CSE", "Information Management and Data Engineering - CSE", "Machine Learning - CSE", "Machine Learning - ECE", "Massively Parallel Systems - CSE", "Mobile Computing and Networking Applications - CSE", "OFDM based Optical Access Networks - ECE", "Optical Wireless Communication Systems - ECE", "Program Analysis - CSE", "RF and mixed signal electronics - ECE", "Security and Privacy - CSE", "Signal and Image Processing - ECE", "Signal and Image Processing - CSE", "Software Engineering - CSE", "Structural Biology - CB", "Systems Biology - CB", "Theoretical Computer Science - CSE", "Wireless Communication - ECE", "Wireless Networks - ECE", "Wireless Networks - CSE"));
			phd3.setValue("---------");
			
			submit.setDisable(true);
			
			accordian.setExpandedPane(accece);
			
			unixTime = System.currentTimeMillis() / 1000L;
			enrollmentID = "" + unixTime;
			
			eceNo.setSelected(true);
			postNo.setSelected(true);
			otherNo.setSelected(true);
			gateNo.setSelected(true);
			
		}
		
		
	@FXML
    public void cvChooser(ActionEvent event) {
		//System.out.println("hello");
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open File");
		File file = fileChooser.showOpenDialog(null); // you could pass a stage reference here if you wanted.
		//System.out.println(file);
		if (file == null)
		{
			// do something interesting with the file.
			//System.out.println("noo");
		} 
		else
		{
			//System.out.println("aya");
			String filePath = file.getAbsolutePath();
			String fileName = file.getName();
			//System.out.println(filePath);
			//cvPath = "/home/praveen/Documents/data/" + enrollmentID + "_cv.pdf";
			cvPath = "/Users/siddharthsingh/Documents/workspace4/AP_project_admin/src/" + enrollmentID + "_cv.pdf";
			//System.out.println(cvPath);
			cvname.setText(fileName);
			try {
				Files.copy(file.toPath(), (new File(cvPath)).toPath(), REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
	
	@FXML
    public void sopChooser(ActionEvent event) {
		//System.out.println("hello");
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open File");
		File file = fileChooser.showOpenDialog(null); // you could pass a stage reference here if you wanted.
		////System.out.println(file);
		if (file == null)
		{
			// do something interesting with the file.
			//System.out.println("noo");
		} 
		else
		{
			//System.out.println("aya");
			String filePath = file.getAbsolutePath();
			String fileName = file.getName();
			//System.out.println(filePath);
			//sopPath = "/home/praveen/Documents/data/" + enrollmentID + "_sop.pdf";
			sopPath = "/Users/siddharthsingh/Documents/workspace4/AP_project_admin/src/" + enrollmentID + "_sop.pdf";
			//System.out.println(sopPath);
			sopname.setText(fileName);
			try {
				Files.copy(file.toPath(), (new File(sopPath)).toPath(), REPLACE_EXISTING);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }
	
	int emailValidate(String email)
	{
		Pattern pattern = Pattern.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
		Matcher matcher = pattern.matcher(email.toUpperCase());
		if (matcher.matches())
		{
			//System.out.println("mail done");
			return 1;
		}
		return 0;
	}
	
	int mobileValidate(String mobile)
	{
		String regexStr = "^[0-9]{10}$";
		if(mobile.matches(regexStr))
		{
			//System.out.println("mob done");
			return 1;
		}
		//System.out.println("return");
		return 0;
	}
	
	int dobValidate(String dob)
	{
		if(dob.equals("null"))
			return 0;
		Date date1 = null, date2 = null;
		LocalDate dobTemp = LocalDate.now();
		String current = dobTemp.toString();
		
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date1 = sdf.parse(dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			date2 = sdf.parse(current);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if(date1.compareTo(date2)>0)
		{
    		////System.out.println("Date1 is after Date2");
			return 0;
			
    	}
    	else if(date1.compareTo(date2)<0)
		{
    		////System.out.println("Date1 is before Date2");
    		//System.out.println("dob done");
			return 1;
    	}
    	else if(date1.compareTo(date2)==0)
		{
    		////System.out.println("Date1 is equal to Date2");
    		return 0;
    	}
    	return 0;
	}

	int validateMarks(String marks)
	{
		try
		{
			Double m = Double.parseDouble(marks);
			if(Double.compare(m, 0)>=0 && Double.compare(m, 100)<=0)
			{
				//System.out.println("mark done" + m);
				return 1;
			}
		}
		catch(Exception e)
		{
			
		}
		return 0;
	}
	
	int validatePlace(String place)
	{
		if(place.equals("null"))
			return 0;
		else
			return 1;		
	}
	
	int validateGPA(String gpa, String gpaScale)
	{
		Double GPA = Double.parseDouble(gpa);
		int GPAScale = Integer.parseInt(gpaScale);
		if(GPAScale == 4)
		{
			if(Double.compare(GPA, 0)>=0 && Double.compare(GPA, 4)<=0)
				return 1;
			else
				return 0;
		}
		else
		{
			if(Double.compare(GPA, 0)>=0 && Double.compare(GPA, 10)<=0)
				return 1;
			else
				return 0;
		}
	}
	
	public void validate(Event event)
	{
		////System.out.println("invalidate11");
		fields.clear();
		
		//System.out.println(fieldsNames.length);
		
		String emailVal = email.getText();
		////System.out.println("ddd" + emailVal.equals(""));
		////System.out.println(emailVal.equals(""));
		fields.add((emailVal.equals(""))?"null":emailVal);
		////System.out.println("kahi to aya 1");
		String nameVal = name.getText();
		////System.out.println("kahi to aya 222 " + nameVal);
		fields.add((nameVal.equals(""))?"null":nameVal);
		////System.out.println("kahi to aya 2");
		String enrnumVal = enrnum.getText();
		fields.add((enrnumVal.equals(""))?"null":enrnumVal);
		////System.out.println("kahi to aya 3");
		String correspondenceVal = correspondence.getText();
		////System.out.println(correspondenceVal);
		////System.out.println("kahi to aya 4");
		fields.add(((correspondenceVal.equals(""))?"null":correspondenceVal).replace(",", ""));
		////System.out.println("kahi to aya 5");
		String mobileVal = mobile.getText();
		fields.add((mobileVal.equals(""))?"null":mobileVal);
		////System.out.println(stream.getSelectedToggle() == null);
		////System.out.println("kahi to aya re");
		if(stream.getSelectedToggle() == null)
		{
			fields.add("null");
		}
		else
		{
			String streamVal = ((Labeled) stream.getSelectedToggle()).getText();
			////System.out.println("kahi to aya bero");
			fields.add((streamVal.equals(""))?"null":streamVal);
		}
		
		////System.out.println("kahi to aya");
		String phd1Val = phd1.getValue();
		////System.out.println(phd1.getValue());
		////System.out.println("kahi to aya 010101 " + phd1Val);
		fields.add((phd1Val.equals("---------"))?"null":phd1Val);
		////System.out.println("kahi to aya 000000");
		String phd2Val = phd2.getValue();
		fields.add((phd2Val.equals("---------"))?"null":phd2Val);
		////System.out.println("kahi to aya 0112311410");
		String phd3Val = phd3.getValue();
		fields.add((phd3Val.equals("---------"))?"null":phd3Val);
		////System.out.println("kahi to aya 6");
		if(sex.getSelectedToggle() == null)
		{
			fields.add("null");
		}
		else
		{
			String sexVal = ((Labeled) sex.getSelectedToggle()).getText();
			////System.out.println("kahi to aya bero");
			fields.add((sexVal.equals(""))?"null":sexVal);
		}
		////System.out.println("kahi to aya 8");
		if(category.getSelectedToggle() == null)
		{
			fields.add("null");
		}
		else
		{
			String categoryVal = ((Labeled) category.getSelectedToggle()).getText();
			////System.out.println("kahi to aya bero");
			fields.add((categoryVal.equals(""))?"null":categoryVal);
		}
		////System.out.println("kahi to aya 9");

		if(disabled.getSelectedToggle() == null)
		{
			fields.add("null");
		}
		else
		{
			String disabledVal = ((Labeled) disabled.getSelectedToggle()).getText();
			////System.out.println("kahi to aya bero");
			fields.add((disabledVal.equals(""))?"null":disabledVal);
		}
		////System.out.println("kahi to aya 10");
		LocalDate dobTemp = dob.getValue();
		////System.out.println("fetete" + dobTemp.toString());
		String dobVal = null;
		if(dobTemp == null)
		{
			dobVal = "null";
		}
		else
		{
			/*int year = dobTemp.getYear();
			int month = dobTemp.getMonthValue();
			int date = dobTemp.getDayOfMonth();
			dobVal = year + "-" + month + "-" + date;*/
			dobVal = dobTemp.toString();
		}
		fields.add(dobVal);
		////System.out.println(dobVal);

		if(children.getSelectedToggle() == null)
		{
			fields.add("null");
		}
		else
		{
			String childrenVal = ((Labeled) children.getSelectedToggle()).getText();
			////System.out.println("kahi to aya bero");
			fields.add((childrenVal.equals(""))?"null":childrenVal);
		}
		////System.out.println("kahi to aya 11");

		String fnameVal = fname.getText();
		fields.add((fnameVal.equals(""))?"null":fnameVal);
		String nationalityVal = nationality.getValue();
		fields.add((nationalityVal.equals("---------"))?"null":nationalityVal);
		////System.out.println("kahi to aya kahe !");
		String permanentVal = permanent.getText();
		fields.add(((permanentVal.equals(""))?"null":permanentVal).replace(",", ""));
		String pinVal = pin.getText();
		fields.add((pinVal.equals(""))?"null":pinVal);
		//System.out.println("kahi to aya 1232332");

		String tenBoardVal = tenBoard.getText();
		fields.add((tenBoardVal.equals(""))?"null":tenBoardVal);
		String tenMarksVal = tenMarks.getText();
		fields.add((tenMarksVal.equals(""))?"null":tenMarksVal);
		////System.out.println("mr gya ab main 000000");
		String tenPassVal = tenPass.getValue();
		fields.add((tenPassVal.equals("---------"))?"null":tenPassVal);
		////System.out.println("mr gya ab main 1111111");
		String twelfthBoardVal = twelfthBoard.getText();
		fields.add((twelfthBoardVal.equals(""))?"null":twelfthBoardVal);
		String twelfthMarksVal = twelfthMarks.getText();
		fields.add((twelfthMarksVal.equals(""))?"null":twelfthMarksVal);
		String twelfthPassVal = twelfthPass.getValue();
		fields.add((twelfthPassVal.equals("---------"))?"null":twelfthPassVal);
		////System.out.println("mr gya ab main");
		String gradDegreeVal = gradDegree.getText();
		fields.add((gradDegreeVal.equals(""))?"null":gradDegreeVal);
		String gradDeptVal = gradDept.getText();
		fields.add((gradDeptVal.equals(""))?"null":gradDeptVal);
		String gradCollegeVal = gradCollege.getText();
		fields.add((gradCollegeVal.equals(""))?"null":gradCollegeVal);
		String gradUniversityVal = gradUniversity.getText();
		fields.add((gradUniversityVal.equals(""))?"null":gradUniversityVal);
		String gradCityVal = gradCity.getText();
		fields.add((gradCityVal.equals(""))?"null":gradCityVal);
		String gradStateVal = gradState.getValue();
		fields.add((gradStateVal.equals("---------"))?"null":gradStateVal);
		String gradYearVal = gradYear.getValue();
		fields.add((gradYearVal.equals(""))?"null":gradYearVal);

		////System.out.println("lalalala");
		if(gpa2.getSelectedToggle() == null)
		{
			fields.add("null");
		}
		else
		{
			String gpa2Val = ((Labeled) gpa2.getSelectedToggle()).getText();
			////System.out.println("kahi to aya bero");
			fields.add((gpa2Val.equals(""))?"null":gpa2Val);
		}

		////System.out.println("lllllll");
		String gradGPAVal = gradGPA.getText();
		fields.add((gradGPAVal.equals(""))?"null":gradGPAVal);
		String gradScaleVal = gradScale.getValue();
		fields.add((gradScaleVal.equals(""))?"null":gradScaleVal);
		String gradMarksVal = gradMarks.getText();
		fields.add((gradMarksVal.equals(""))?"null":gradMarksVal);
		if(ece.getSelectedToggle() == null)
		{
			fields.add("null");
		}
		else
		{
			String eceVal = ((Labeled) ece.getSelectedToggle()).getText();
			////System.out.println("kahi to aya bero");
			fields.add((eceVal.equals(""))?"null":eceVal);
		}
		/*String eceVal = ((Labeled) ece.getSelectedToggle()).getText();
		fields.add((eceVal.equals(""))?"null":eceVal);*/
		if(post.getSelectedToggle() == null)
		{
			fields.add("null");
		}
		else
		{
			String postVal = ((Labeled) post.getSelectedToggle()).getText();
			////System.out.println("kahi to aya bero");
			fields.add((postVal.equals(""))?"null":postVal);
		}
		/*String postVal = ((Labeled) post.getSelectedToggle()).getText();
		fields.add((postVal.equals(""))?"null":postVal);*/
		if(other.getSelectedToggle() == null)
		{
			fields.add("null");
		}
		else
		{
			String otherVal = ((Labeled) other.getSelectedToggle()).getText();
			////System.out.println("kahi to aya bero");
			fields.add((otherVal.equals(""))?"null":otherVal);
		}
		/*String otherVal = ((Labeled) other.getSelectedToggle()).getText();
		fields.add((otherVal.equals(""))?"null":otherVal);*/
		if(gate.getSelectedToggle() == null)
		{
			fields.add("null");
		}
		else
		{
			String gateVal = ((Labeled) gate.getSelectedToggle()).getText();
			////System.out.println("kahi to aya bero");
			fields.add((gateVal.equals(""))?"null":gateVal);
		}
		/*String gateVal = ((Labeled) gate.getSelectedToggle()).getText();
		fields.add((gateVal.equals(""))?"null":gateVal);*/
		String ecePref1Val = ecePref1.getValue();
		fields.add((ecePref1Val.equals("---------"))?"null":ecePref1Val);
		String ecePref2Val = ecePref2.getValue();
		fields.add((ecePref2Val.equals("---------"))?"null":ecePref2Val);
		String ecePref3Val = ecePref3.getValue();
		fields.add((ecePref3Val.equals("---------"))?"null":ecePref3Val);
		String ecePref4Val = ecePref4.getValue();
		fields.add((ecePref4Val.equals("---------"))?"null":ecePref4Val);
		String postCollegeVal = postCollege.getText();
		fields.add((postCollegeVal.equals(""))?"null":postCollegeVal);
		String postCityVal = postCity.getText();
		fields.add((postCityVal.equals(""))?"null":postCityVal);
		String postStateVal = postState.getValue();
		fields.add((postStateVal.equals("---------"))?"null":postStateVal);
		String postDeptval = postDept.getText();
		fields.add((postDeptval.equals(""))?"null":postDeptval);
		String postDegreeVal = postDegree.getText();
		fields.add((postDegreeVal.equals(""))?"null":postDegreeVal);
		String postThesisVal = postThesis.getText();
		fields.add((postThesisVal.equals(""))?"null":postThesisVal);
		String postYearVal = postYear.getValue();
		fields.add((postYearVal.equals("---------"))?"null":postYearVal);
		if(accgpa2.getSelectedToggle() == null)
		{
			fields.add("null");
		}
		else
		{
			String accgpa2Val = ((Labeled) accgpa2.getSelectedToggle()).getText();
			////System.out.println("kahi to aya bero");
			fields.add((accgpa2Val.equals(""))?"null":accgpa2Val);
		}
		/*String accgpa2Val = ((Labeled) accgpa2.getSelectedToggle()).getText();
		fields.add((accgpa2Val.equals(""))?"null":accgpa2Val);*/
		String postGPAVal = postGPA.getText();
		fields.add((postGPAVal.equals(""))?"null":postGPAVal);
		String postScaleVal = postScale.getValue();
		fields.add((postScaleVal.equals(""))?"null":postScaleVal);
		String postMarksVal = postMarks.getText();
		fields.add((postMarksVal.equals(""))?"null":postMarksVal);
		String otherExamVal = otherExam.getText();
		fields.add((otherExamVal.equals(""))?"null":otherExamVal);
		String otherSubjectVal = otherSubject.getText();
		fields.add((otherSubjectVal.equals(""))?"null":otherSubjectVal);
		String otherYearVal = otherYear.getValue();
		fields.add((otherYearVal.equals("---------"))?"null":otherYearVal);
		String otherScoreVal = otherScore.getText();
		fields.add((otherScoreVal.equals(""))?"null":otherScoreVal);
		String otherRankVal = otherRank.getText();
		fields.add((otherRankVal.equals(""))?"null":otherRankVal);
		String gateAreaVal = gateArea.getText();
		fields.add((gateAreaVal.equals(""))?"null":gateAreaVal);
		String gateYearVal = gateYear.getValue();
		fields.add((gateYearVal.equals("---------"))?"null":gateYearVal);
		String gateMarksVal = gateMarks.getText();
		fields.add((gateMarksVal.equals(""))?"null":gateMarksVal);
		String gateScoreVal = gateScore.getText();
		fields.add((gateScoreVal.equals(""))?"null":gateScoreVal);
		String gateRankVal = gateRank.getText();
		fields.add((gateRankVal.equals(""))?"null":gateRankVal);
		String achieveVal = achieve.getText();
		fields.add((achieveVal.equals(""))?"null":achieveVal);
		fields.add(cvPath);
		fields.add(sopPath);
		
		/*boolean DDtemp = DD.isSelected();
		String DDval = (DDtemp == true)?"true":"false";
		fields.add(DDval);
		String bankNameVal = bankName.getText();
		fields.add(bankNameVal);
		String bankBranchVal = bankBranch.getText();
		fields.add(bankBranchVal);
		String DDnumVal = DDnum.getText();
		fields.add(DDnumVal);
		
		String howVal = ((Labeled) how.getSelectedToggle()).getText();
		fields.add(howVal);
		String whyVal = ((Labeled) why.getSelectedToggle()).getText();
		fields.add(whyVal);*/
		
		//int c = 0;
		/*//System.out.println("hello");
		for(int i = 0; i < fields.size(); i++)
		{
			//c++;
			//System.out.println("hi " + fields.get(i));
		}*/
		////System.out.println(c);
		
		int valid = 0;
		/*//System.out.println(fields.size());
		//System.out.println(fieldsNames[13]);
		//System.out.println(fields.get(13));*/
		
		for(int i = 0; i < fieldsNames.length; i++)
		{
			////System.out.println(fieldsNames[i] + "  " + fields.get(i));
			int len = fieldsNames[i].length();
			char s = fieldsNames[i].charAt(len - 2); 
			////System.out.println("lopp  " + s);
			if((s == '*') && ((fields.get(i)).equals("null")))
			{
				////System.out.println("in if");
				valid = 1;
			}
		}
		
		//System.out.println("done");

		if(valid == 0)
		{
			status.setText("");
			submit.setDisable(false);
		}
		else
		{
			status.setText("Please enter valid values in all the fields !");
		}
		
		if(emailValidate(emailVal)==0)
		{
			//System.out.println("ayayyayaya");
			valid = 1;
			email.setText("");
		}
		if(mobileValidate(mobileVal)==0)
		{
			//System.out.println("ayayyayaya");
			mobile.setText("");
			valid = 1;
		}
		if(dobValidate(dobVal)==0)
		{
			//System.out.println("ayayyayaya");
			dob.setValue(null);
			valid = 1;
		}
		if(validatePlace(phd1Val)==0)
		{
			//System.out.println("ayayyayaya");
			phd1.setValue("---------");
			valid = 1;
		}
		if(validatePlace(nationalityVal)==0)
		{
			//System.out.println("ayayyayaya");
			nationality.setValue("---------");
			valid = 1;
		}
		if(validatePlace(gradStateVal)==0)
		{
			//System.out.println("ayayyayaya");
			gradState.setValue("---------");
			valid = 1;
		}
		if(validateMarks(tenMarksVal) == 0)
		{
			//System.out.println("ayayyayaya");
			tenMarks.setText("");
			valid = 1;
		}
		if(validateMarks(twelfthMarksVal) == 0)
		{
			//System.out.println("ayayyayaya");
			twelfthMarks.setText("");
			valid = 1;
		}
		
		if(valid == 0)
		{
			status.setText("");
			submit.setDisable(false);
		}
		else
		{
			status.setText("Please enter valid values in all the fields !");
		}
	}
	
	public void saveRecord(ActionEvent event)
	{
		
		fields.add(enrollmentID);
		fields.add(LocalDate.now().toString());
		BufferedWriter csv = null;
		try {
			//csv = new BufferedWriter(new FileWriter("/home/praveen/Documents/data/entries.txt", true));
			csv = new BufferedWriter(new FileWriter("/Users/siddharthsingh/Documents/workspace4/AP_project_admin/src/entries.txt", true));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		BufferedWriter bw = null;
		try {
			//bw = new BufferedWriter(new FileWriter("/home/praveen/Documents/data/" + fields.get(fields.size()-2) + "_form" + ".txt", true));
			bw = new BufferedWriter(new FileWriter("/Users/siddharthsingh/Documents/workspace4/AP_project_admin/src/" + fields.get(fields.size()-2) + "_form" + ".txt", true));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i =  0; i < fieldsNames.length; i++)
		{
			try {
				bw.write(fieldsNames[i] + ":" + fields.get(i));
				bw.write("\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i == fieldsNames.length - 1)
			{
				try {
					csv.write(fields.get(i));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					csv.write("\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else
			{
				try {
					csv.write(fields.get(i) + ",");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		try {
			csv.flush();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			csv.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    status.setText("Data recorded");
	    personal.setDisable(true);
	    education.setDisable(true);
	    
	}
	
}