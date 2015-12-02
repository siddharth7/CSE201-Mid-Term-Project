package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class admincontrol {

    @FXML
    private RadioButton grad_g;

    @FXML
    private RadioButton grad_e;

    @FXML
    private RadioButton dob_after_r;

    @FXML
    private ChoiceBox<String> pgdegree;

    @FXML
    private RadioButton grad_l;

    @FXML
    private ChoiceBox<String> classx;

    @FXML
    private TextField clxii_percent;

    @FXML
    private TextField pgrad_percent;

    @FXML
    private ChoiceBox<String> pgstate;
    
    @FXML
    private RadioButton clxii_e;

    @FXML
    private RadioButton clxii_g;

    @FXML
    private TextField guni;

    @FXML
    private RadioButton clxii_l;

    @FXML
    private RadioButton phy_yes;

    @FXML
    private RadioButton gate_e;

    @FXML
    private RadioButton gate_g;

    @FXML
    private TextField enrollview;

    @FXML
    private RadioButton gate_l;

    @FXML
    private ToggleGroup clxii;

    @FXML
    private TextField grad_percent;

    @FXML
    private TextField clx_percent;

    @FXML
    private ToggleGroup clx;

    @FXML
    private RadioButton phy_no;

    @FXML
    private TextField emailview;

    @FXML
    private ToggleGroup dob;

    @FXML
    private DatePicker dateview;

    @FXML
    private DatePicker end_date;

    @FXML
    private RadioButton dob_before_r;

    @FXML
    private ChoiceBox<String> phdstream;

    @FXML
    private ChoiceBox<String> pgdepartment;

    @FXML
    private TextField pguni;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton female_radio;

    @FXML
    private ChoiceBox<String> catview;

    @FXML
    private RadioButton pgrad_e;

    @FXML
    private Button result_btn;

    @FXML
    private ToggleGroup phy_dis;

    @FXML
    private RadioButton pgrad_g;

    @FXML
    private RadioButton pgrad_l;

    @FXML
    private RadioButton male_radio;

    @FXML
    private DatePicker start_date;

    @FXML
    private ToggleGroup pgrad;

    @FXML
    private ChoiceBox<String> classxii;

    @FXML
    private RadioButton dob_on_r;

    @FXML
    private TextField gate_score;

    @FXML
    private ChoiceBox<String> gstate;

    @FXML
    private ChoiceBox<String> gdepartment;

    @FXML
    private RadioButton clx_e;

    @FXML
    private RadioButton clx_g;

    @FXML
    private TextField nameview;

    @FXML
    private ChoiceBox<String> gdegree;

    @FXML
    private RadioButton clx_l;

    @FXML
    private ToggleGroup gate;

    @FXML
    private ToggleGroup grad;
    
	static ArrayList<String> mylist = new ArrayList<String>();


    @FXML
    void pupdate(Event event) {
    	catview.getItems().addAll("All","General","ST","SC","OBC");
    	//catview.setValue("All");
    	
    }

    @FXML
    void eupdate(Event event) {
    	phdstream.getItems().addAll("All","Computer Science","Electronics and Communication","Computational Biology");
    	//phdstream.setValue("All");
    	gdegree.getItems().addAll("All","BTECH");
    	//gdegree.setValue("All");
    	pgdegree.getItems().addAll("All","MTECH");
    	//pgdegree.setValue("All");
    	classx.getItems().addAll("All","CBSE");
    	//classx.setValue("All");
    	classxii.getItems().addAll("All","CBSE");
    	//classxii.setValue("All");
    	gdepartment.getItems().addAll("All","CSE");
    	//gdepartment.setValue("All");
    	pgdepartment.getItems().addAll("All","CSE");
    	//pgdepartment.setValue("All");
    	gstate.getItems().addAll("All","Delhi");
    	//gstate.setValue("All");
    	pgstate.getItems().addAll("All","Delhi");
    	//pgstate.setValue("All");
    
    }

    @FXML
    void show_res(ActionEvent event) {
    	HashMap<Integer, String> filterdata=new HashMap<>();
    	if(emailview.getLength()!=0)
    		filterdata.put(0, emailview.getText());
    	if(nameview.getLength()!=0)
    		filterdata.put(1, nameview.getText());
    	if(enrollview.getLength()!=0)
    		filterdata.put(2, enrollview.getText());
    	if(catview.getValue()!=null)
    		{
    		if(catview.getValue()!="All")
    			filterdata.put(10, catview.getValue()); 
    		//System.out.println("yolo");
    		}
    	if(male_radio.isSelected())
    		filterdata.put(9, "Male");
    	if(female_radio.isSelected())
    		filterdata.put(9, "Female");
    	if(phy_yes.isSelected())
    		filterdata.put(11, "Yes");
    	if(phy_no.isSelected())
    		filterdata.put(11, "No");
    	if(dob_before_r.isSelected())
    		filterdata.put(13, "Before");
    	if(dob_on_r.isSelected())
    		filterdata.put(13, "On");
    	if(dob_after_r.isSelected())
    		filterdata.put(13, "After");
    	if(dateview.getValue()!=null)
    		filterdata.put(12, dateview.getValue().toString());
    	
    	if(phdstream.getValue()!=null)
		{
    		if(phdstream.getValue()!="All")
    			filterdata.put(5, phdstream.getValue()); 
		}
    	if(gdegree.getValue()!=null)
		{			
    		if(gdegree.getValue()!="All")
    			filterdata.put(24, gdegree.getValue()); 
		}
    	if(pgdegree.getValue()!=null)
		{
    		if(pgdegree.getValue()!="All")
    			filterdata.put(45, pgdegree.getValue()); 
		}
    	if(classx.getValue()!=null)
		{
    		if(classx.getValue()!="All")
    			filterdata.put(18, classx.getValue()); 
		}
    	if(classxii.getValue()!=null)
		{
    		if(classxii.getValue()!="All")
    			filterdata.put(21, classxii.getValue()); 
		}
    	if(gdepartment.getValue()!=null)
		{
    		if(gdepartment.getValue()!="All")
    			filterdata.put(25, gdepartment.getValue()); 
		}
    	if(pgdepartment.getValue()!=null)
		{
    		if(pgdepartment.getValue()!="All")
    			filterdata.put(44, pgdepartment.getValue()); 
		}
    	if(guni.getLength()!=0)
    		filterdata.put(27, guni.getText());
    	if(pguni.getLength()!=0)
    		filterdata.put(41, pguni.getText());
    	if(gstate.getValue()!=null)
		{
    		if(gstate.getValue()!="All")
    			filterdata.put(29, gstate.getValue()); 
		}
    	if(pgstate.getValue()!=null)
		{
    		if(pgstate.getValue()!="All")
    			filterdata.put(43, pgstate.getValue()); 
		}
    	if(clx_g.isSelected())
    		filterdata.put(20, "Greater");
    	else if(clx_e.isSelected())
    		filterdata.put(20, "Equal");
    	else if(clx_l.isSelected())
    		filterdata.put(20, "Less");
    	if(clx_percent.getLength()!=0)
    		filterdata.put(19, clx_percent.getText());
    	if(clxii_g.isSelected())
    		filterdata.put(23, "Greater");
    	else if(clxii_e.isSelected())
    		filterdata.put(23, "Equal");
    	else if(clxii_l.isSelected())
    		filterdata.put(23, "Less");
    	if(clxii_percent.getLength()!=0)
    		filterdata.put(22, clxii_percent.getText());
    	if(grad_g.isSelected())
    		filterdata.put(33, "Greater");
    	else if(grad_e.isSelected())
    		filterdata.put(33, "Equal");
    	else if(grad_l.isSelected())
    		filterdata.put(33, "Less");
    	if(grad_percent.getLength()!=0)
    		filterdata.put(34, grad_percent.getText());
    	if(pgrad_g.isSelected())
    		filterdata.put(50, "Greater");
    	else if(pgrad_e.isSelected())
    		filterdata.put(50, "Equal");
    	else if(pgrad_l.isSelected())
    		filterdata.put(50, "Less");
    	if(pgrad_percent.getLength()!=0)
    		filterdata.put(51, pgrad_percent.getText());
    	
    	if(gate_g.isSelected())
    	{
    		filterdata.put(61, "Greater");
    		//System.out.println("AA rha hai data");
    	}
    	
    	else if(gate_e.isSelected())
    		filterdata.put(61, "Equal");
    	else if(gate_l.isSelected())
    		filterdata.put(61, "Less");
    	if(gate_score.getLength()!=0)
    		filterdata.put(62, gate_score.getText());
   
    	readfile(filterdata);
    	
    	try
    	{
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tablev.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
          stage.setTitle("Filtered Data");
        stage.setScene(new Scene(root1));  
        stage.show();
        
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	

    }
    void readfile(HashMap<Integer, String> fdata)
    {
    	
    BufferedReader buffr = null;
	String line;
	String gate_param=fdata.get(61);
	String grad_param=fdata.get(33);
	String pgrad_param=fdata.get(50);
	int flag=0;
	try {

		buffr = new BufferedReader(new FileReader("./src/entries.txt"));
		while ((line = buffr.readLine()) != null) 
		{
			
			flag=0;
			String[] data = line.split(",");
//			for(int kk=0;kk<data.length;kk++)
//			{
//				System.out.println(kk+data[kk]);
//			}
			Iterator it = fdata.entrySet().iterator();
		    while (it.hasNext()) 
		    {
		        Map.Entry pair = (Map.Entry)it.next();
		        System.out.println(pair.getKey() + " , " + pair.getValue() +" " + data[(int)pair.getKey()] );
		        if((int)pair.getKey()==12)
		        {
		        	Date date1, date2;
		        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        	try {
						date1 = sdf.parse(data[12]);
		        		date2 = sdf.parse((String) pair.getValue());
		        	if(date1.compareTo(date2)>0 && fdata.get(13).equals("After"))
		        		{
			        		//System.out.println("Date1 is after Date2");
		        			flag=0;
		        			
			        	}
		        	else if(date1.compareTo(date2)<0 && fdata.get(13).equals("Before"))
		        		{
			        		//System.out.println("Date1 is before Date2");
		        			flag=0;
			        	}
		        	else if(date1.compareTo(date2)==0 && fdata.get(13).equals("On"))
		        		{
			        		//System.out.println("Date1 is equal to Date2");
		        		flag=0;
			        	}
		        	else
		        		flag=1;
		        	}
		        	catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		        }
		        else if((int)pair.getKey()==19)
		        {
		        	String num1=(String)pair.getValue();
		        	Double n1=Double.parseDouble(num1);
		        	String num2=(String)data[19];
		        	Double n2=Double.parseDouble(num2);
		        	System.out.println("MArks"+n1+" "+n2);
		        	if(n1>n2 && fdata.get(20).equals("Less"))
		        	{
		        		flag=0;
		        	}
		        	else if(n1==n2 && fdata.get(20).equals("Equal"))
		        	{
		        		flag=0;
		        	}
		        	else if(n1<n2 && fdata.get(20).equals("Greater"))
		        	{
		        		flag=0;
		        	}
		        	else
		        	{
		        		flag=1;
		        	}
		        }
		        else if((int)pair.getKey()==22)
		        {
		        	String num1=(String)pair.getValue();
		        	Double n1=Double.parseDouble(num1);
		        	String num2=(String)data[22];
		        	Double n2=Double.parseDouble(num2);
		        	if(n1>n2 && fdata.get(23).equals("Less"))
		        	{
		        		flag=0;
		        	}
		        	else if(n1==n2 && fdata.get(23).equals("Equal"))
		        	{
		        		flag=0;
		        	}
		        	else if(n1<n2 && fdata.get(23).equals("Greater"))
		        	{
		        		flag=0;
		        	}
		        	else
		        	{
		        		flag=1;
		        	}
		        }
		        else if((int)pair.getKey()==34)
		        {
		        	String num1=(String)pair.getValue();
		        	Double n1=Double.parseDouble(num1);
		        	String num2=(String)data[34];
		        	Double n2=Double.parseDouble(num2);
		        	if(n1>n2 && grad_param.equals("Less") && data[31].equals("Marks"))
		        	{
		        		flag=0;
		        	}
		        	else if(n1==n2 && grad_param.equals("Equal") && data[31].equals("Marks"))
		        	{
		        		flag=0;
		        	}
		        	else if(n1<n2 && grad_param.equals("Greater") && data[31].equals("Marks"))
		        	{
		        		flag=0;
		        	}
		        	else
		        	{
		        		flag=1;
		        	}
		        }
		        else if((int)pair.getKey()==51)
		        {
		        	String num1=(String)pair.getValue();
		        	Double n1=Double.parseDouble(num1);
		        	String num2=(String)data[51];
		        	Double n2=Double.parseDouble(num2);
		        	if(n1>n2 && pgrad_param.equals("Less") && data[48].equals("MARKS"))
		        	{
		        		flag=0;
		        	}
		        	else if(n1==n2 && pgrad_param.equals("Equal") && data[48].equals("MARKS"))
		        	{
		        		flag=0;
		        	}
		        	else if(n1<n2 && pgrad_param.equals("Greater") && data[48].equals("MARKS"))
		        	{
		        		flag=0;
		        	}
		        	else
		        	{
		        		flag=1;
		        	}
		        }
		        else if((int)pair.getKey()==62)
		        {
		        	String num1=(String)pair.getValue();
		        	Double n1=Double.parseDouble(num1);
		        	String num2=(String)data[62];
		        	Double n2=Double.parseDouble(num2);
		        	//System.out.println(fdata.get(48));
		        	if(n1>n2 && gate_param.equals("Less"))
		        	{
		        		flag=0;
		        	}
		        	else if(n1==n2 && gate_param.equals("Equal"))
		        	{
		        		flag=0;
		        	}
		        	if(n1<n2 && gate_param.equals("Greater"))
		        	{
		        		flag=0;
		        	}
		        	else
		        	{
		        		flag=1;
		        	}
		        }
		        
		        else if((int)pair.getKey()==20)
		        {
		        	
		        }
		        else if((int)pair.getKey()==33)
		        {
		        	
		        }
		        else if((int)pair.getKey()==13)
		        {
		        	
		        }
		        else if((int)pair.getKey()==23)
		        {
		        	
		        }
		        else if((int)pair.getKey()==50)
		        {
		        	
		        }
		        else if((int)pair.getKey()==61)
		        {
		        	//System.out.println(pair.getValue());
		        }
		        else if(data[(int) pair.getKey()].equals(pair.getValue()))
		        	flag=0;
		        else
		        	{
		        		flag=1;
		        		//System.out.println("oh bro!");
		        		break;
		        	}
		        //it.remove();
		    }
		    if(flag == 0)
		    {
		    	System.out.println(data[0]);
		    	Date date1, date2,date3;
	        	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	        	try {
					date1 = sdf.parse(start_date.getValue().toString());
	        		date2 = sdf.parse(end_date.getValue().toString());
	        		date3=sdf.parse(data[68]);
	        		System.out.println(data[68]);
	        		if(date3.compareTo(date2)<=0 && date3.compareTo(date1)>=0)
	        		{
	        			System.out.println("sfsfs");
	        			mylist.add(data[2]);
	        		}
	        	}
	        	catch(Exception e)
	        	{
	        		
	        	}
		    	
		    	
		    }
		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}

}
