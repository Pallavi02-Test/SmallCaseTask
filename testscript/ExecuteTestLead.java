package testscript;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExecuteTestLead {
	public static void main(String[] args)throws Exception {
		FileInputStream f=new FileInputStream("E:\\SmallCaseProject\\LeadSuite1.xlsx");
		ArrayList a=new ArrayList();
		Keywords key=new Keywords();
		XSSFWorkbook wbks=new XSSFWorkbook(f);
		XSSFSheet s=wbks.getSheet("TestSteps");
		
		Iterator itr=s.iterator();
		while(itr.hasNext()) {
			Row rowitr=(Row)itr.next();
			Iterator cellitr=rowitr.cellIterator();
			while(cellitr.hasNext()) {
				Cell celldata=(Cell)cellitr.next();
				
				switch(celldata.getCellType()) {
				case STRING:
					a.add(celldata.getStringCellValue());
					break;
				case NUMERIC:
					a.add(celldata.getNumericCellValue());
					break;
				case BOOLEAN:
					a.add(celldata.getBooleanCellValue());
					break;
				}
			}
		}
		
		for(int i=0;i<a.size();i++) {
			if(a.get(i).equals("openbrowser")) {
				String Keyword=(String)a.get(i);
				String Data=(String)a.get(i+1);
				String objectName=(String)a.get(i+2);
				String runmode=(String)a.get(i+3);
				System.out.println(Keyword);
				System.out.println(Data);
				System.out.println(objectName);
				System.out.println(runmode);
				if(runmode.equals("yes")) {
					key.openbrowser();
				}
				
			}
			if(a.get(i).equals("navigate")) {
				String Keyword=(String)a.get(i);
				String Data=(String)a.get(i+1);
				String objectName=(String)a.get(i+2);
				String runmode=(String)a.get(i+3);
				System.out.println(Keyword);
				System.out.println(Data);
				System.out.println(objectName);
				System.out.println(runmode);
				if(runmode.equals("yes")) {
					key.navigate(Data);
				}
				
			}
			if(a.get(i).equals("click")) {
				String Keyword=(String)a.get(i);
				String Data=(String)a.get(i+1);
				String objectName=(String)a.get(i+2);
				String runmode=(String)a.get(i+3);
				System.out.println(Keyword);
				System.out.println(Data);
				System.out.println(objectName);
				System.out.println(runmode);
				if(runmode.equals("yes")) {
					key.click(objectName);
				}
				
			}
			if(a.get(i).equals("input")) {
				String Keyword=(String)a.get(i);
				String Data=(String)a.get(i+1);
				String objectName=(String)a.get(i+2);
				String runmode=(String)a.get(i+3);
				System.out.println(Keyword);
				System.out.println(Data);
				System.out.println(objectName);
				System.out.println(runmode);
				if(runmode.equals("yes")) {
					key.input(objectName,Data);
				}
			}
				if(a.get(i).equals("switchwindow")) {
					String Keyword=(String)a.get(i);
					String Data=(String)a.get(i+1);
					String objectName=(String)a.get(i+2);
					String runmode=(String)a.get(i+3);
					System.out.println(Keyword);
					System.out.println(Data);
					System.out.println(objectName);
					System.out.println(runmode);
					if(runmode.equals("yes")) {
						key.switchwindow(objectName);
					}
				}
					if(a.get(i).equals("gettext")) {
						String Keyword=(String)a.get(i);
						String Data=(String)a.get(i+1);
						String objectName=(String)a.get(i+2);
						String runmode=(String)a.get(i+3);
						System.out.println(Keyword);
						System.out.println(Data);
						System.out.println(objectName);
						System.out.println(runmode);
						if(runmode.equals("yes")) {
							key.gettext(objectName);
						}
					}
						
						if(a.get(i).equals("navigateTo")) {
							String Keyword=(String)a.get(i);
							String Data=(String)a.get(i+1);
							String objectName=(String)a.get(i+2);
							String runmode=(String)a.get(i+3);
							System.out.println(Keyword);
							System.out.println(Data);
							System.out.println(objectName);
							System.out.println(runmode);
							if(runmode.equals("yes")) {
								key.navigateTo(Data);
							}
							
						}
						if(a.get(i).equals("comaprePrice")) {
							String Keyword=(String)a.get(i);
							String Data=(String)a.get(i+1);
							String objectName=(String)a.get(i+2);
							String runmode=(String)a.get(i+3);
							System.out.println(Keyword);
							System.out.println(Data);
							System.out.println(objectName);
							System.out.println(runmode);
							if(runmode.equals("yes")) {
								key.comparePrice();
							}
							
						}						
		}
		
	}

}
