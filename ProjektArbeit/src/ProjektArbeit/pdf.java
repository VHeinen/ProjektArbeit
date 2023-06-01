package ProjektArbeit;

import java.sql.SQLException;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Cell;
import com.aspose.pdf.Cells;
import com.aspose.pdf.Document;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.Page;
import com.aspose.pdf.Row;
import com.aspose.pdf.Table;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.VerticalAlignment;

public class pdf {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Document document = new Document();
		Page page = document.getPages().add();
		
	
		
		
		
		page.getParagraphs().add(new TextFragment("Notenübersicht"));
		
		
		document = createTableForPdfByTablename(document, "pupil");
	
		
		saveDoc(document, "Test.pdf");

		
	
		
		
	// Idee: klasse pdf ruft methode database.getData.... auf und nimm das was aus der querrie kommt und schmeißt es in eine Tabelle und erzeugt daraus die pdf
	// die Methoden aus der pdf klasse sollen dann später im Code mittels Button aufgerufen werden können
	
	
	}
	
	public static Document createTableForPdfByTablename(Document doc, String tablename) throws ClassNotFoundException, SQLException {
		
		Table table = new Table();
		Row row = new Row();
		
		table.setBorder(new BorderInfo(BorderSide.All, .5f));
		table.setDefaultCellBorder(new BorderInfo(BorderSide.All, .5f));
		
		int amountOfIDs = database.getAmountOfIDsByTablename(tablename);
		int amountOfColumns = database.getAmountOfColumnsByTablename(tablename);
	
		for (int row_count = 0; row_count < amountOfIDs; row_count++) {
			
			String query = "select * from " + tablename + " where id = " + row_count;
			
			String test[] = database.getDataFromDatabase(query, amountOfColumns);
			
			row = table.getRows().add();
			
			for (int i = 0; i < test.length; i++) {
				row.getCells().add(test[i]).setAlignment(HorizontalAlignment.Center);
				
			}
		}
		
		doc.getPages().get_Item(1).getParagraphs().add(table);
		
		return doc;
	}
	
	
	
	
	public static void saveDoc(Document doc, String name) {
		doc.save(name);
		System.out.println("done");
	}

}
