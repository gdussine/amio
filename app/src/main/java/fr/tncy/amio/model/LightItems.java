package fr.tncy.amio.model;

import java.util.Comparator;
import java.util.List;

public class LightItems {

    private List<LightItem> data;

    public List<LightItem> getData() {
        return data;
    }

    public void setData(List<LightItem> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LightItems{" +
                "data=" + data +
                '}';
    }

    public LightItem getLast(){
        return data.stream().max(new Comparator<LightItem>() {
            @Override
            public int compare(LightItem o1, LightItem o2) {
                return Long.compare(o1.getTimestamp(), o2.getTimestamp());
            }
        }).orElse(null);
    }
}
