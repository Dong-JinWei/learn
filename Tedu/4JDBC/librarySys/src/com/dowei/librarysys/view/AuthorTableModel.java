package com.dowei.librarysys.view;

import com.dowei.librarysys.dao.AuthorDao;
import com.dowei.librarysys.entity.Author;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class AuthorTableModel extends AbstractTableModel {
    private Vector<String> columnNames;
    private Vector<Vector<String>> rowData;

    public Vector<Vector<String>> getRowData() {
        return rowData;
    }

    public AuthorTableModel(){
        columnNames = new Vector<>();
        rowData = new Vector<>();
        AuthorDao authorDao = new AuthorDao();
        columnNames.add("作者编号");
        columnNames.add("作者名字");
        columnNames.add("作品数");

        List<Author> allCountAuthor = authorDao.getAllCountAuthor();
        for (Author author : allCountAuthor) {
            Vector<String> row = new Vector<>();
            row.add(author.getAuthorId() + "");
            row.add(author.getAuthorName());
            row.add(author.getCount()+"");
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
