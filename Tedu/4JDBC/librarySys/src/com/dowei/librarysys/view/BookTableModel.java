package com.dowei.librarysys.view;

import com.dowei.librarysys.dao.BookDao;
import com.dowei.librarysys.entity.Book;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class BookTableModel extends AbstractTableModel {
    private Vector<String> columnNames;
    private Vector<Vector<String>> rowData;

    public Vector<Vector<String>> getRowData() {
        return rowData;
    }

    public BookTableModel(){
        columnNames = new Vector<>();
        rowData = new Vector<>();
        BookDao bookDao = new BookDao();

        columnNames.add("书籍编号");
        columnNames.add("书籍标题");
        columnNames.add("书籍作者");
        columnNames.add("书籍ISBN");
        columnNames.add("书籍类型");

        List<Book> allBook = bookDao.getAllBook();
        for (Book book : allBook) {
            Vector<String> row = new Vector<>();
            row.add(book.getBookId()+"");
            row.add(book.getBookTitle());
            row.add(book.getAuthor().getAuthorName());
            row.add(book.getBookISBN()+"");
            row.add(book.getType().getTypeName());
            rowData.add(row);
        }
    }

    @Override
    public int getRowCount() {
        return rowData.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return rowData.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }
}
