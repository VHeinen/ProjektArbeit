package ProjektArbeit;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


	
	public static Document createTableForPDFBytableName(Document doc, String tableName) throws ClassNotFoundException, SQLException {
		
		Table table = new Table();
		Row row = new Row();
		
		int amountOfIDs = database.getAmountOfIDsByTableName(tableName);
		int amountOfColumns = database.getAmountOfColumnsByTableName(tableName);		
		
		String[] columnNames = database.getcolumnNamesByTableName(tableName);	
		
		table = adjustTableByTableName(table, tableName);
		page = setTitleForTable(page, tableName);
		setColumnNamesForTableColumns(row, table, columnNames);
				
		for (int row_count = 0; row_count < amountOfIDs; row_count++) {
			
			String query = "select * from " + tableName + " where id = " + row_count;
			
			String[] queryResult = database.getDataFromDatabase(query, amountOfColumns);
					
			row = table.getRows().add();
			
			for (int j = 0; j < queryResult.length; j++) {
				row.getCells().add(queryResult[j]);
			}
		}
		
		
		doc.getPages().get_Item(1).getParagraphs().add(table);
		
		return doc;
	}
		
	
	public static Document createTableForPDFByQuery(Document doc, String query, int length) throws ClassNotFoundException, SQLException {
		
		Table table = new Table();
		Row row = new Row();
		
		String[] queryResult = database.getDataFromDatabase(query, length);
		String[] columnNames = extractColumnNamesForTableColumns(query, length);
		String columnTitle = extractTableNameForTableTitle(page, query);
		
		table = adjustTableByColumns(table, length);
		page = setTitleForTable(page, columnTitle);
		setColumnNamesForTableColumns(row, table, columnNames);
	
		row = table.getRows().add();
		
		for (int i = 0; i < length; i++) {
			row.getCells().add(queryResult[i]);
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
			table.setLeft(200.0f);
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
	
	public static Table adjustTableByColumns(Table table, int length) {
		
		table.setBorder(new BorderInfo(BorderSide.All, .5f));
		table.setDefaultCellBorder(new BorderInfo(BorderSide.All, .5f));
		
		table.setBordersIncluded(true);
		
		if (length == 1) {
			table.setLeft(240.0f);
		}
		
		if (length == 2) {
			table.setLeft(200.0f);
		}
		
		if (length == 3) {
			table.setLeft(140.0f);
		}
		
		if (length == 4) {
			table.setLeft(90.0f);
		}

		if (length == 5) {
			table.setColumnWidths("90");
			table.setLeft(75.0f);
		}
		
		if (length == 6) {
			table.setColumnWidths("80");
			table.setLeft(55.0f);
		}
		
		if (length == 7) {
			table.setColumnWidths("70");
			table.setLeft(40.0f);
		}
		
		if (length == 8) {
			table.setColumnWidths("65");
			table.setLeft(7.0f);
		}
		
		if (length > 8) {
			table.setColumnWidths("65");
			table.setLeft(0.0f);
		}
		
		return table;
	}
	
	public static String[] extractColumnNamesForTableColumns(String query, int length) {

		String split = query.split("select")[1];
		split = split.split("from")[0];
		
		String regex = "(,)";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(split);
		
		
		if (matcher.find()) {
			String[] columnNames = split.split(",\\s*");
			return columnNames;
		}  
		else {
			String[] columnNames = {split};
			return columnNames;
		}
		
	}
	
	public static String extractTableNameForTableTitle(Page page, String query) {
		
		String split = query.split("from")[1];
		
		String regex = "((where)|(WHERE))";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(split);
		
		if (matcher.find()) {
			String tableTitle = split.split(regex)[0];
			return tableTitle;
		}  
		else {
			String tableTitle = split;
			return tableTitle;
		}
		
	}
	
	public static void setColumnNamesForTableColumns(Row row, Table table, String[] columnNames) {
		
		row = table.getRows().add();
		
		for(int i = 0; i < columnNames.length; i++) {
			row.getCells().add(columnNames[i]).setAlignment(HorizontalAlignment.Center);
		}
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
	
	
	public static void saveDocument(Document doc, String name) {
		doc.save(name);
		System.out.println("done");
	}

}
