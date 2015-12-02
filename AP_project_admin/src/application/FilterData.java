package application;


import javafx.beans.property.SimpleStringProperty;

public class FilterData {

	SimpleStringProperty enrollid;
	SimpleStringProperty name;
	SimpleStringProperty cv;
	SimpleStringProperty sop;
	SimpleStringProperty form;
	

	public FilterData(String enrollid, String name, String cv,String sop, String form)
	{
		this.enrollid=new SimpleStringProperty(enrollid);
		this.name=new SimpleStringProperty(name);
		this.cv=new SimpleStringProperty(cv);
		this.sop=new SimpleStringProperty(sop);
		this.form=new SimpleStringProperty(form);
	}

	public String getEnrollid()
	{
		return enrollid.get();
	}

	public String getName()
	{
		return name.get();
	}

	public String getCv()
	{
		return cv.get();
	}
	public String getSop()
	{
		return sop.get();
	}
	public String getForm()
	{
		return form.get();
	}

	public void setEnrollid(String enrollid)
	{
		this.enrollid.set(enrollid);
	}

	public void setName(String name)
	{
		this.name.set(name);
	}

	public void setCv(String cv)
	{
		this.cv.set(cv);
	}
	public void setSop(String sop)
	{
		this.sop.set(sop);
	}
	public void setForm(String form)
	{
		this.form.set(form);
	}
}
