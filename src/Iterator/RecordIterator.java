package Iterator;

import java.util.List;

public class RecordIterator implements IIterator {
    private List<String> records;
    private int position;

    public RecordIterator(List<String> records) {
        this.records = records;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < records.size();
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return records.get(position++);
        }
        return null;
    }
}