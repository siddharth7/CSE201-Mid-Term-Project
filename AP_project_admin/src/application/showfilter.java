/*@author Praveen Kumar Jhanwar
 * roll no - 2014078 
 * @author Siddharth Singh
 * roll no - 2014105*/

package application;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class showfilter implements Initializable{

	@FXML
    private TableView<FilterData> tableview;
    @FXML
    private TableColumn<FilterData,String> idcol;

    @FXML
    private TableColumn<FilterData,String> namecol;
    
    @FXML
    private TableColumn<FilterData,FilterData> sopcol;
    @FXML
    private TableColumn<FilterData,FilterData> cvcol;
    @FXML
    private TableColumn<FilterData,FilterData> formcol;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		ObservableList<FilterData> filtertable=FXCollections.observableArrayList();
		//filtertable.add(new FilterData("1","2"));
        tableview.setEditable(true);
        idcol.setCellValueFactory(new PropertyValueFactory<FilterData,String>("enrollid"));
        namecol.setCellValueFactory(new PropertyValueFactory<FilterData,String>("name"));
//        formcol.setCellValueFactory(new PropertyValueFactory<FilterData,String>("form"));
//        cvcol.setCellValueFactory(new PropertyValueFactory<FilterData,String>("cv"));
//        sopcol.setCellValueFactory(new PropertyValueFactory<FilterData,String>("sop"));
        formcol.setCellValueFactory(new Callback<CellDataFeatures<FilterData, FilterData>, ObservableValue<FilterData>>() {
            @Override public ObservableValue<FilterData> call(CellDataFeatures<FilterData, FilterData> features) {
                return new ReadOnlyObjectWrapper(features.getValue());
            }
          });
        formcol.setCellFactory(new Callback<TableColumn<FilterData, FilterData>, TableCell<FilterData, FilterData>>() {
            @Override public TableCell<FilterData, FilterData> call(TableColumn<FilterData, FilterData> btnCol) {
              return new TableCell<FilterData, FilterData>() {
                final Button button = new Button(); {
                  button.setMinWidth(100);
                }
                @Override public void updateItem(final FilterData person, boolean empty) {
                  super.updateItem(person, empty);
                  if (person != null) {
                     setGraphic(button);
                     button.setText("FORM");
                    button.setOnAction(new EventHandler<ActionEvent>() {
                      @Override public void handle(ActionEvent event) {
                    	  File pdfFile = new File("./src/"+person.getEnrollid()+"_form.txt");
                    	  if(pdfFile.exists())
                    	  {
                    		  if (Desktop.isDesktopSupported())
                    		  {
                    			  try
                    		      	{
                    				  Desktop.getDesktop().open(pdfFile);
                    		      	}
                    		      catch (IOException e)
                    		      {
                    		    	  e.printStackTrace();
                    		      }
                    		  }
                    	  }
                      }
                    });
                  }
                }
              };
            }
          });
        cvcol.setCellValueFactory(new Callback<CellDataFeatures<FilterData, FilterData>, ObservableValue<FilterData>>() {
            @Override public ObservableValue<FilterData> call(CellDataFeatures<FilterData, FilterData> features) {
                return new ReadOnlyObjectWrapper(features.getValue());
            }
          });
        cvcol.setCellFactory(new Callback<TableColumn<FilterData, FilterData>, TableCell<FilterData, FilterData>>() {
            @Override public TableCell<FilterData, FilterData> call(TableColumn<FilterData, FilterData> btnCol) {
              return new TableCell<FilterData, FilterData>() {
                final Button button = new Button(); {
                  button.setMinWidth(100);
                }
                @Override public void updateItem(final FilterData person, boolean empty) {
                  super.updateItem(person, empty);
                  if (person != null) {
                     setGraphic(button);
                     button.setText("CV");
                    button.setOnAction(new EventHandler<ActionEvent>() {
                      @Override public void handle(ActionEvent event) {
                    	  File pdfFile = new File("./src/"+person.getEnrollid()+"_cv.pdf");
                    	  if(pdfFile.exists())
                    	  {
                    		  if (Desktop.isDesktopSupported())
                    		  {
                    			  try
                    		      	{
                    				  Desktop.getDesktop().open(pdfFile);
                    		      	}
                    		      catch (IOException e)
                    		      {
                    		    	  e.printStackTrace();
                    		      }
                    		  }
                    	  }
                      }
                    });
                  }
                }
              };
            }
          });
        sopcol.setCellValueFactory(new Callback<CellDataFeatures<FilterData, FilterData>, ObservableValue<FilterData>>() {
            @Override public ObservableValue<FilterData> call(CellDataFeatures<FilterData, FilterData> features) {
                return new ReadOnlyObjectWrapper(features.getValue());
            }
          });
        sopcol.setCellFactory(new Callback<TableColumn<FilterData, FilterData>, TableCell<FilterData, FilterData>>() {
            @Override public TableCell<FilterData, FilterData> call(TableColumn<FilterData, FilterData> btnCol) {
              return new TableCell<FilterData, FilterData>() {
                final Button button = new Button(); {
                  button.setMinWidth(100);
                }
                @Override public void updateItem(final FilterData person, boolean empty) {
                  super.updateItem(person, empty);
                  if (person != null) {
                     setGraphic(button);
                     button.setText("SOP");
                    button.setOnAction(new EventHandler<ActionEvent>() {
                      @Override public void handle(ActionEvent event) {
                    	  File pdfFile = new File("./src/"+person.getEnrollid()+"_sop.pdf");
                    	  if(pdfFile.exists())
                    	  {
                    		  if (Desktop.isDesktopSupported())
                    		  {
                    			  try
                    		      	{
                    				  Desktop.getDesktop().open(pdfFile);
                    		      	}
                    		      catch (IOException e)
                    		      {
                    		    	  e.printStackTrace();
                    		      }
                    		  }
                    	  }
                      }
                    });
                  }
                }
              };
            }
          });
        
            BufferedReader buffr = null;
        	String line;
        	try {
        		buffr = new BufferedReader(new FileReader("./src/entries.txt"));
        		while ((line = buffr.readLine()) != null) 
        		{
        			String[] data = line.split(",");
        			//System.out.println("asasasas");
        			{
        				
        				Iterator<String> itr = admincontrol.mylist.iterator();
        				while (itr.hasNext()) {
        				    String element = itr.next();
        				    //System.out.printf(element + " " + "%n");
        				    if(element.equals(data[2]))
        				    {
        				    	try{
        				    		filtertable.add(new FilterData(data[67],data[1],"filename1","flile2","file3"));
        				    		}
        				    	catch(Exception e){
        				    		
        				    		}
        				    }
        				}
        			}
        		}

        	} catch (FileNotFoundException e) {
        		e.printStackTrace();
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
        
		//filtertable.add(new FilterData("1","2","3"));

        tableview.setItems(filtertable);
	}

}
