package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by andri on 11/5/2016.
 */
public class RecordBook {
    private List<Record> records;

    public RecordBook() {
        records = new ArrayList<>();
    }

    public RecordBook(List<Record> records) {
        this.records = records;
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public List<Record> getRecords() {
        return records;
    }
}
