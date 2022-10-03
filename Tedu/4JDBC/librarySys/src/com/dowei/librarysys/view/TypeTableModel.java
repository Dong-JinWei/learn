package com.dowei.librarysys.view;

import com.dowei.librarysys.dao.TypeDao;
import com.dowei.librarysys.entity.BookType;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class TypeTableModel extends AbstractTableModel {
    private Vector<String> columnNames;
    private Vector<Vector<String>> rowData;

    public Vector<Vector<String>> getRowData() {
        return rowData;
    }

    public TypeTableModel(){
        columnNames = new Vector<>();
        rowData = new Vector<>();
        TypeDao typeDao = new TypeDao();
        columnNames.add("类型编号");
        columnNames.add("类型名称");
        columnNames.add("该类型书目数量");
        List<BookType> allCountType = typeDao.getAllCountType();
        for (BookType type : allCountType) {
            Vector<String> row = new Vector<>();
            row.add(type.getTypeId()+"");
            row.add(type.getTypeName());
            row.add(type.getCount()+"");
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
