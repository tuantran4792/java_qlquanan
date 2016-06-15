package Model;

import javax.swing.table.AbstractTableModel;

public class CommonTableModel extends AbstractTableModel {

    private String[] columnNames;
    private Object[][] data;

    public CommonTableModel(String[] columnNames, Object[][] data) {
        this.columnNames = columnNames;
        this.data = data;
    }


    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return data.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return data[row][col];
    }
}