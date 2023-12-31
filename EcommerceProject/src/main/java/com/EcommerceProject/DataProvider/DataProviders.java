/**
 * 
 */
package com.EcommerceProject.DataProvider;

import org.testng.annotations.DataProvider;

import com.EcommerceProject.Utility.NewExcelLibrary;

/**
 * @author OSOS
 *
 */
/**
*/
public class DataProviders {
	
	NewExcelLibrary obj=new NewExcelLibrary();
	
	@DataProvider(name = "crendentials")
	public Object[][] getCredentials() {
		// Totals rows count
		int rows = obj.getRowCount("Credentials");
		// Total Columns
		int column = obj.getColumnCount("Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}
		System.out.println(data);
		return data;
		
	}
	@DataProvider(name = "AssignClaim")
	  public Object[][] getClaimData(){
		  int rows=obj.getRowCount("AssignClaim");
		  int columns=obj.getColumnCount("AssignClaim");
		  int actRows=rows-1;
		  
		  Object[][] data=new Object[actRows][columns];
		  
		  for (int i=0;i<actRows;i++) {
			  for (int j=0; j<columns;j++) {
				  data[i][j]=obj.getCellData("AssignClaim", j, i+2);
				  
			  }
			  
		  }
		  return data;
	  }

}
