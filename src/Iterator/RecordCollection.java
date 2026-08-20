package Iterator;

import java.util.List;

public class RecordCollection implements IAggregate {
    private List<String> records;

    public RecordCollection(List<String> records) {
        this.records = records;
    }

    @Override
    public IIterator createIterator() {
        return new RecordIterator(records);
    }
}