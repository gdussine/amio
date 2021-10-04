package fr.tncy.amio.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Entity
public class LightItem {
    @PrimaryKey
    long timestamp;
    @ColumnInfo(name = "label")
    String label;
    @ColumnInfo(name = "value")
    double value;
    @ColumnInfo(name = "mote")
    double mote;

    public LightItem() {
    }

    public long getTimestamp() {
        return timestamp;
    }

    public LocalDateTime getLocalDateTime(){
        return LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp/1000), ZoneOffset.of("+2"));
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getMote() {
        return mote;
    }

    public void setMote(double mote) {
        this.mote = mote;
    }

    @Override
    public String toString() {
        return "LightItem{" +
                "timestamp=" + timestamp +
                ", label='" + label + '\'' +
                ", value=" + value +
                ", mote=" + mote +
                '}';
    }
}
