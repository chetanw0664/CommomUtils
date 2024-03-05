package CommonUtils;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

public class ExcelUtils1 {

	public void main(String[]args) throws EncryptedDocumentException, IOException {
	ExcelUtil ex=new ExcelUtil();
	ex.getDataFromExcel("Sheet1", 0, 0);
	
	
}
}
