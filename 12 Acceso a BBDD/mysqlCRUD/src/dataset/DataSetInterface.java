package dataset;

public interface DataSetInterface {
    public void importFromCSV(String file, String tableName, String[] columns) throws Exception;
    public void exportToCSV(String file, String tableName, String[] columns) throws Exception;
}
