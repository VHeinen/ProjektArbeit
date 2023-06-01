package ProjektArbeit;

import java.sql.SQLException;

import javax.swing.plaf.basic.BasicBorders.MarginBorder;

import com.aspose.pdf.BorderInfo;
import com.aspose.pdf.BorderSide;
import com.aspose.pdf.Cell;
import com.aspose.pdf.Cells;
import com.aspose.pdf.Color;
import com.aspose.pdf.Document;
import com.aspose.pdf.HorizontalAlignment;
import com.aspose.pdf.MarginInfo;
import com.aspose.pdf.Note;
import com.aspose.pdf.Page;
import com.aspose.pdf.Position;
import com.aspose.pdf.Row;
import com.aspose.pdf.Table;
import com.aspose.pdf.TextFragment;
import com.aspose.pdf.TextSegment;
import com.aspose.pdf.VerticalAlignment;

public class pdf {
	
	static Document document = new Document();
	static Page page = document.getPages().add();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		page = setTitleForPDF(page);
		document = createTableForPDFBytableName(document, "pupil");
		document = createWhitespaceForNewTables(document);
		document = createTableForPDFBytableName(document, "schoolclass");
	
		
		saveDoc(document, "Test.pdf");

		
	
		
		
	// Idee: klasse pdf ruft methode database.getData.... auf und nimm das was aus der querrie kommt und schmeißt es in eine Tabelle und erzeugt daraus die pdf
	// die Methoden aus der pdf klasse sollen dann später im Code mittels Button aufgerufen werden können
	
		// TODO: neue Methode anlegen -> createTableForPdfByQuery
		// TODO: Neue Methode anlegen -> neue Seite hinzufügen / auf neue Seite springen nach erstellung von Tabelle 
		// TODO: Neue Methode anlegen -> leerzeihen in Seite einfügen, zwischen den tabellen -> maybe durch die verwendung leerer tabellen??
		// TODO: testen was passiert wenn mehrere Tabellen angelegt 
	
	}
	
	public static Document createTableForPDFBytableName(Document doc, String tableName) throws ClassNotFoundException, SQLException {
		
		Table table = new Table();
		Row row = new Row();
		
		page = setTitleForTable(page, tableName);
		table = adjustTableByTableName(table, tableName);
		
		int amountOfIDs = database.getAmountOfIDsByTableName(tableName);
		int amountOfColumns = database.getAmountOfColumnsByTableName(tableName);		
		
		String[] columnNames = database.getcolumnNamesByTableName(tableName);
		
		row = table.getRows().add();
		
		for(int i = 0; i < columnNames.length; i++) {
			row.getCells().add(columnNames[i]).setAlignment(HorizontalAlignment.Center);
		}	
		
		
		for (int row_count = 0; row_count < amountOfIDs; row_count++) {
			
			String query = "select * from " + tableName + " where id = " + row_count;
			
			String queryResult[] = database.getDataFromDatabase(query, amountOfColumns);
					
			row = table.getRows().add();
			
			for (int j = 0; j < queryResult.length; j++) {
				row.getCells().add(queryResult[j]);
			}
		}
		
		
		doc.getPages().get_Item(1).getParagraphs().add(table);
		
		return doc;
	}
		
	
	public static Document createWhitespaceForNewTables(Document doc) {
		
		Table table = new Table();
		Row row = new Row();
		
		row = table.getRows().add();
		row.getCells().add(" ");
	
		doc.getPages().get_Item(1).getParagraphs().add(table);
		
		return doc;
	}
	
	
	
	public static Table adjustTableByTableName(Table table, String tableName) {
		
		table.setBorder(new BorderInfo(BorderSide.All, .5f));
		table.setDefaultCellBorder(new BorderInfo(BorderSide.All, .5f));
		
		table.setBordersIncluded(true);
		
		if (tableName == "teacher") {
			table.setColumnWidths("80");
			table.setLeft(55.0f);
		}		
		
		if (tableName == "grade") {
			table.setColumnWidths("65");
			table.setLeft(7.0f);
		}
		
		if (tableName == "subject") {
			table.setLeft(180.0f);
		}
		
		if (tableName == "pupil") {
			table.setLeft(90.0f);
		}
		
		if (tableName == "schoolclass") {
			table.setLeft(140.0f);
		}
		
		if (tableName == "pupilmanagement" || tableName == "teachermanagement") {
			table.setLeft(90.0f);
		}
		
		
		return table;
	}
	
	
	public static Page setTitleForPDF(Page page) {
		
		TextFragment textF = new TextFragment("Notenübersicht - von Robin Brang und Viktoria Heinen \n");
		
		textF.setHorizontalAlignment(HorizontalAlignment.Center);
		textF.setVerticalAlignment(VerticalAlignment.Top);
		
		textF.getTextState().setFontSize(12f);
		textF.getTextState().setUnderline(true);
		textF.getTextState().setForegroundColor(Color.getBlueViolet());
				
		page.getParagraphs().add(textF);
		
		return page;
	}
	
	
	public static Page setTitleForTable(Page page, String tableName) {
		
		TextFragment textF = new TextFragment(tableName + " \n");
		
		textF.setHorizontalAlignment(HorizontalAlignment.Center);
		textF.setVerticalAlignment(VerticalAlignment.Top);
		
		textF.getTextState().setFontSize(10f);
		textF.getTextState().setForegroundColor(Color.getMidnightBlue());
		
		page.getParagraphs().add(textF);
		
		return page;
	}
	
	
	public static void saveDoc(Document doc, String name) {
		doc.save(name);
		System.out.println("done");
	}

}
