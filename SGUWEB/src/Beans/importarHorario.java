
package Beans;

import ENTIDAD.registrotmC;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.primefaces.model.UploadedFile;


@ManagedBean(name = "importarHorarioB")
public class importarHorario {

    private List<registrotmC> registrotmL;
    private UploadedFile file=null;
    
    public void  readNote() throws IOException{
    	//String archivo= new Scanner(file.getInputStream()).useDelimiter("\\A").next();
    	String cadena;
    	 BufferedReader reader = null;
    	 reader = new BufferedReader(new InputStreamReader(file.getInputstream(), "UTF-8"));
    	 
    	 while((cadena = reader.readLine())!=null) {
             System.out.println(cadena);
         }
    	 
    	
    }
    
    
    
    
    
    
    
    
    
    
    public void readExcelFile() throws IOException {
    	
    	
    	
    	
       // String fileName = "D:\\importar.xls";
        /**
         * Create a new instance for cellDataList
         */
        List<List<HSSFCell>> cellDataList = new ArrayList<List<HSSFCell>>();
        try {
            /**
             * Create a new instance for FileInputStream class
             */
       //     FileInputStream fileInputStream = new FileInputStream(fileName);
            /**
             * Create a new instance for POIFSFileSystem class
             */
      //      POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
            /*
             * Create a new instance for HSSFWorkBook Class
             */
            
            
            
            
            
            InputStream input = file.getInputstream();
        	HSSFWorkbook workBook = new HSSFWorkbook(input);
            
            
            
            
      //      HSSFWorkbook workBook = new HSSFWorkbook(fsFileSystem);
            HSSFSheet hssfSheet = workBook.getSheetAt(0);
            /**
             * Iterate the rows and cells of the spreadsheet to get all the
             * datas.
             */
            Iterator<?> rowIterator = hssfSheet.rowIterator();
            while (rowIterator.hasNext()) {
                HSSFRow hssfRow = (HSSFRow) rowIterator.next();
                Iterator<?> iterator = hssfRow.cellIterator();
                List<HSSFCell> cellTempList = new ArrayList<HSSFCell>();
                while (iterator.hasNext()) {
                    HSSFCell hssfCell = (HSSFCell) iterator.next();
                    cellTempList.add(hssfCell);
                }
                cellDataList.add(cellTempList);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        printToConsole(cellDataList);
    }

    private void printToConsole(List<List<HSSFCell>> cellDataList) {
        registrotmL = new ArrayList<registrotmC>();
        registrotmC registrotm = null;
        for (int i = 0; i < cellDataList.size(); i++) {
            List<?> cellTempList = (List<?>) cellDataList.get(i);
            registrotm = new registrotmC();
            for (int j = 0; j < cellTempList.size(); j++) {
                HSSFCell hssfCell = (HSSFCell) cellTempList.get(j);
                String stringCellValue = hssfCell.toString();

                switch (j) {
                    case 0:
                        registrotm.setCpersonal(stringCellValue);
                        break;
                    case 1:
                        registrotm.setCarrera(stringCellValue);
                        break;

                }

                System.out.print(stringCellValue + "\t");
            }
            registrotmL.add(registrotm);
            System.out.println();
        }
    }

   
    public List<registrotmC> getRegistrotmL() {
        return registrotmL;
    }
    public void setRegistrotmL(List<registrotmC> registrotmL) {
        this.registrotmL = registrotmL;
    }

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

}
