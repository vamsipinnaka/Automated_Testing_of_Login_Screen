package vamsi;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class OpenBrowser {

    public String[] getTestData(int rowIndex) throws IOException 
    {
        FileInputStream fis = new FileInputStream("./testdata/vamsi.xlsx");
        Workbook w = WorkbookFactory.create(fis);
        Sheet s = w.getSheet("Sheet1");
        
        Row row = s.getRow(rowIndex); // Get the row at the given index
        String[] data = new String[row.getLastCellNum()];

        for (int i = 0; i < row.getLastCellNum(); i++) 
        {
            Cell cell = row.getCell(i);
            data[i] = cell.toString();
        }

        w.close();
        fis.close();
        return data;
    }
}
