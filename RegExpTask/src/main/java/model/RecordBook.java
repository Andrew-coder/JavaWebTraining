package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 11/5/2016.
 */
public class RecordBook {
    /**
     * the list of records
     */
    private List<Record> records;

    /**
     * base constructor
     */
    public RecordBook() {
        records = new ArrayList<>();
    }

    /**
     * constructor which inits the list of records
     * @param records the list of record
     */
    public RecordBook(List<Record> records) {
        this.records = records;
    }

    /**
     * the method which add new record
     * @param record the record which will be added
     */
    public void addRecord(Record record) {
        records.add(record);
    }

    public List<Record> getRecords() {
        return records;
    }
}
