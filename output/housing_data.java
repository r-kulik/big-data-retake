// ORM class for table 'housing_data'
// WARNING: This class is AUTO-GENERATED. Modify at your own risk.
//
// Debug information:
// Generated date: Tue Oct 15 12:47:59 MSK 2024
// For connector: org.apache.sqoop.manager.PostgresqlManager
import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.lib.db.DBWritable;
import org.apache.sqoop.lib.JdbcWritableBridge;
import org.apache.sqoop.lib.DelimiterSet;
import org.apache.sqoop.lib.FieldFormatter;
import org.apache.sqoop.lib.RecordParser;
import org.apache.sqoop.lib.BooleanParser;
import org.apache.sqoop.lib.BlobRef;
import org.apache.sqoop.lib.ClobRef;
import org.apache.sqoop.lib.LargeObjectLoader;
import org.apache.sqoop.lib.SqoopRecord;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class housing_data extends SqoopRecord  implements DBWritable, Writable {
  private final int PROTOCOL_VERSION = 3;
  public int getClassFormatVersion() { return PROTOCOL_VERSION; }
  public static interface FieldSetterCommand {    void setField(Object value);  }  protected ResultSet __cur_result_set;
  private Map<String, FieldSetterCommand> setters = new HashMap<String, FieldSetterCommand>();
  private void init0() {
    setters.put("id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.id = (Integer)value;
      }
    });
    setters.put("price", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.price = (Double)value;
      }
    });
    setters.put("apartment_type_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.apartment_type_id = (Integer)value;
      }
    });
    setters.put("metro_station_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.metro_station_id = (Integer)value;
      }
    });
    setters.put("minutes_to_metro", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.minutes_to_metro = (Double)value;
      }
    });
    setters.put("region_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.region_id = (Integer)value;
      }
    });
    setters.put("number_of_rooms", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.number_of_rooms = (Double)value;
      }
    });
    setters.put("area", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.area = (Double)value;
      }
    });
    setters.put("living_area", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.living_area = (Double)value;
      }
    });
    setters.put("kitchen_area", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.kitchen_area = (Double)value;
      }
    });
    setters.put("apartment_floor", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.apartment_floor = (Double)value;
      }
    });
    setters.put("number_of_floors", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.number_of_floors = (Double)value;
      }
    });
    setters.put("renovation_id", new FieldSetterCommand() {
      @Override
      public void setField(Object value) {
        housing_data.this.renovation_id = (Integer)value;
      }
    });
  }
  public housing_data() {
    init0();
  }
  private Integer id;
  public Integer get_id() {
    return id;
  }
  public void set_id(Integer id) {
    this.id = id;
  }
  public housing_data with_id(Integer id) {
    this.id = id;
    return this;
  }
  private Double price;
  public Double get_price() {
    return price;
  }
  public void set_price(Double price) {
    this.price = price;
  }
  public housing_data with_price(Double price) {
    this.price = price;
    return this;
  }
  private Integer apartment_type_id;
  public Integer get_apartment_type_id() {
    return apartment_type_id;
  }
  public void set_apartment_type_id(Integer apartment_type_id) {
    this.apartment_type_id = apartment_type_id;
  }
  public housing_data with_apartment_type_id(Integer apartment_type_id) {
    this.apartment_type_id = apartment_type_id;
    return this;
  }
  private Integer metro_station_id;
  public Integer get_metro_station_id() {
    return metro_station_id;
  }
  public void set_metro_station_id(Integer metro_station_id) {
    this.metro_station_id = metro_station_id;
  }
  public housing_data with_metro_station_id(Integer metro_station_id) {
    this.metro_station_id = metro_station_id;
    return this;
  }
  private Double minutes_to_metro;
  public Double get_minutes_to_metro() {
    return minutes_to_metro;
  }
  public void set_minutes_to_metro(Double minutes_to_metro) {
    this.minutes_to_metro = minutes_to_metro;
  }
  public housing_data with_minutes_to_metro(Double minutes_to_metro) {
    this.minutes_to_metro = minutes_to_metro;
    return this;
  }
  private Integer region_id;
  public Integer get_region_id() {
    return region_id;
  }
  public void set_region_id(Integer region_id) {
    this.region_id = region_id;
  }
  public housing_data with_region_id(Integer region_id) {
    this.region_id = region_id;
    return this;
  }
  private Double number_of_rooms;
  public Double get_number_of_rooms() {
    return number_of_rooms;
  }
  public void set_number_of_rooms(Double number_of_rooms) {
    this.number_of_rooms = number_of_rooms;
  }
  public housing_data with_number_of_rooms(Double number_of_rooms) {
    this.number_of_rooms = number_of_rooms;
    return this;
  }
  private Double area;
  public Double get_area() {
    return area;
  }
  public void set_area(Double area) {
    this.area = area;
  }
  public housing_data with_area(Double area) {
    this.area = area;
    return this;
  }
  private Double living_area;
  public Double get_living_area() {
    return living_area;
  }
  public void set_living_area(Double living_area) {
    this.living_area = living_area;
  }
  public housing_data with_living_area(Double living_area) {
    this.living_area = living_area;
    return this;
  }
  private Double kitchen_area;
  public Double get_kitchen_area() {
    return kitchen_area;
  }
  public void set_kitchen_area(Double kitchen_area) {
    this.kitchen_area = kitchen_area;
  }
  public housing_data with_kitchen_area(Double kitchen_area) {
    this.kitchen_area = kitchen_area;
    return this;
  }
  private Double apartment_floor;
  public Double get_apartment_floor() {
    return apartment_floor;
  }
  public void set_apartment_floor(Double apartment_floor) {
    this.apartment_floor = apartment_floor;
  }
  public housing_data with_apartment_floor(Double apartment_floor) {
    this.apartment_floor = apartment_floor;
    return this;
  }
  private Double number_of_floors;
  public Double get_number_of_floors() {
    return number_of_floors;
  }
  public void set_number_of_floors(Double number_of_floors) {
    this.number_of_floors = number_of_floors;
  }
  public housing_data with_number_of_floors(Double number_of_floors) {
    this.number_of_floors = number_of_floors;
    return this;
  }
  private Integer renovation_id;
  public Integer get_renovation_id() {
    return renovation_id;
  }
  public void set_renovation_id(Integer renovation_id) {
    this.renovation_id = renovation_id;
  }
  public housing_data with_renovation_id(Integer renovation_id) {
    this.renovation_id = renovation_id;
    return this;
  }
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof housing_data)) {
      return false;
    }
    housing_data that = (housing_data) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.price == null ? that.price == null : this.price.equals(that.price));
    equal = equal && (this.apartment_type_id == null ? that.apartment_type_id == null : this.apartment_type_id.equals(that.apartment_type_id));
    equal = equal && (this.metro_station_id == null ? that.metro_station_id == null : this.metro_station_id.equals(that.metro_station_id));
    equal = equal && (this.minutes_to_metro == null ? that.minutes_to_metro == null : this.minutes_to_metro.equals(that.minutes_to_metro));
    equal = equal && (this.region_id == null ? that.region_id == null : this.region_id.equals(that.region_id));
    equal = equal && (this.number_of_rooms == null ? that.number_of_rooms == null : this.number_of_rooms.equals(that.number_of_rooms));
    equal = equal && (this.area == null ? that.area == null : this.area.equals(that.area));
    equal = equal && (this.living_area == null ? that.living_area == null : this.living_area.equals(that.living_area));
    equal = equal && (this.kitchen_area == null ? that.kitchen_area == null : this.kitchen_area.equals(that.kitchen_area));
    equal = equal && (this.apartment_floor == null ? that.apartment_floor == null : this.apartment_floor.equals(that.apartment_floor));
    equal = equal && (this.number_of_floors == null ? that.number_of_floors == null : this.number_of_floors.equals(that.number_of_floors));
    equal = equal && (this.renovation_id == null ? that.renovation_id == null : this.renovation_id.equals(that.renovation_id));
    return equal;
  }
  public boolean equals0(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof housing_data)) {
      return false;
    }
    housing_data that = (housing_data) o;
    boolean equal = true;
    equal = equal && (this.id == null ? that.id == null : this.id.equals(that.id));
    equal = equal && (this.price == null ? that.price == null : this.price.equals(that.price));
    equal = equal && (this.apartment_type_id == null ? that.apartment_type_id == null : this.apartment_type_id.equals(that.apartment_type_id));
    equal = equal && (this.metro_station_id == null ? that.metro_station_id == null : this.metro_station_id.equals(that.metro_station_id));
    equal = equal && (this.minutes_to_metro == null ? that.minutes_to_metro == null : this.minutes_to_metro.equals(that.minutes_to_metro));
    equal = equal && (this.region_id == null ? that.region_id == null : this.region_id.equals(that.region_id));
    equal = equal && (this.number_of_rooms == null ? that.number_of_rooms == null : this.number_of_rooms.equals(that.number_of_rooms));
    equal = equal && (this.area == null ? that.area == null : this.area.equals(that.area));
    equal = equal && (this.living_area == null ? that.living_area == null : this.living_area.equals(that.living_area));
    equal = equal && (this.kitchen_area == null ? that.kitchen_area == null : this.kitchen_area.equals(that.kitchen_area));
    equal = equal && (this.apartment_floor == null ? that.apartment_floor == null : this.apartment_floor.equals(that.apartment_floor));
    equal = equal && (this.number_of_floors == null ? that.number_of_floors == null : this.number_of_floors.equals(that.number_of_floors));
    equal = equal && (this.renovation_id == null ? that.renovation_id == null : this.renovation_id.equals(that.renovation_id));
    return equal;
  }
  public void readFields(ResultSet __dbResults) throws SQLException {
    this.__cur_result_set = __dbResults;
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.price = JdbcWritableBridge.readDouble(2, __dbResults);
    this.apartment_type_id = JdbcWritableBridge.readInteger(3, __dbResults);
    this.metro_station_id = JdbcWritableBridge.readInteger(4, __dbResults);
    this.minutes_to_metro = JdbcWritableBridge.readDouble(5, __dbResults);
    this.region_id = JdbcWritableBridge.readInteger(6, __dbResults);
    this.number_of_rooms = JdbcWritableBridge.readDouble(7, __dbResults);
    this.area = JdbcWritableBridge.readDouble(8, __dbResults);
    this.living_area = JdbcWritableBridge.readDouble(9, __dbResults);
    this.kitchen_area = JdbcWritableBridge.readDouble(10, __dbResults);
    this.apartment_floor = JdbcWritableBridge.readDouble(11, __dbResults);
    this.number_of_floors = JdbcWritableBridge.readDouble(12, __dbResults);
    this.renovation_id = JdbcWritableBridge.readInteger(13, __dbResults);
  }
  public void readFields0(ResultSet __dbResults) throws SQLException {
    this.id = JdbcWritableBridge.readInteger(1, __dbResults);
    this.price = JdbcWritableBridge.readDouble(2, __dbResults);
    this.apartment_type_id = JdbcWritableBridge.readInteger(3, __dbResults);
    this.metro_station_id = JdbcWritableBridge.readInteger(4, __dbResults);
    this.minutes_to_metro = JdbcWritableBridge.readDouble(5, __dbResults);
    this.region_id = JdbcWritableBridge.readInteger(6, __dbResults);
    this.number_of_rooms = JdbcWritableBridge.readDouble(7, __dbResults);
    this.area = JdbcWritableBridge.readDouble(8, __dbResults);
    this.living_area = JdbcWritableBridge.readDouble(9, __dbResults);
    this.kitchen_area = JdbcWritableBridge.readDouble(10, __dbResults);
    this.apartment_floor = JdbcWritableBridge.readDouble(11, __dbResults);
    this.number_of_floors = JdbcWritableBridge.readDouble(12, __dbResults);
    this.renovation_id = JdbcWritableBridge.readInteger(13, __dbResults);
  }
  public void loadLargeObjects(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void loadLargeObjects0(LargeObjectLoader __loader)
      throws SQLException, IOException, InterruptedException {
  }
  public void write(PreparedStatement __dbStmt) throws SQLException {
    write(__dbStmt, 0);
  }

  public int write(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(price, 2 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeInteger(apartment_type_id, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(metro_station_id, 4 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(minutes_to_metro, 5 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeInteger(region_id, 6 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(number_of_rooms, 7 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(area, 8 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(living_area, 9 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(kitchen_area, 10 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(apartment_floor, 11 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(number_of_floors, 12 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeInteger(renovation_id, 13 + __off, 4, __dbStmt);
    return 13;
  }
  public void write0(PreparedStatement __dbStmt, int __off) throws SQLException {
    JdbcWritableBridge.writeInteger(id, 1 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(price, 2 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeInteger(apartment_type_id, 3 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeInteger(metro_station_id, 4 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(minutes_to_metro, 5 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeInteger(region_id, 6 + __off, 4, __dbStmt);
    JdbcWritableBridge.writeDouble(number_of_rooms, 7 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(area, 8 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(living_area, 9 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(kitchen_area, 10 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(apartment_floor, 11 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeDouble(number_of_floors, 12 + __off, 8, __dbStmt);
    JdbcWritableBridge.writeInteger(renovation_id, 13 + __off, 4, __dbStmt);
  }
  public void readFields(DataInput __dataIn) throws IOException {
this.readFields0(__dataIn);  }
  public void readFields0(DataInput __dataIn) throws IOException {
    if (__dataIn.readBoolean()) { 
        this.id = null;
    } else {
    this.id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.price = null;
    } else {
    this.price = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.apartment_type_id = null;
    } else {
    this.apartment_type_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.metro_station_id = null;
    } else {
    this.metro_station_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.minutes_to_metro = null;
    } else {
    this.minutes_to_metro = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.region_id = null;
    } else {
    this.region_id = Integer.valueOf(__dataIn.readInt());
    }
    if (__dataIn.readBoolean()) { 
        this.number_of_rooms = null;
    } else {
    this.number_of_rooms = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.area = null;
    } else {
    this.area = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.living_area = null;
    } else {
    this.living_area = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.kitchen_area = null;
    } else {
    this.kitchen_area = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.apartment_floor = null;
    } else {
    this.apartment_floor = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.number_of_floors = null;
    } else {
    this.number_of_floors = Double.valueOf(__dataIn.readDouble());
    }
    if (__dataIn.readBoolean()) { 
        this.renovation_id = null;
    } else {
    this.renovation_id = Integer.valueOf(__dataIn.readInt());
    }
  }
  public void write(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.price) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.price);
    }
    if (null == this.apartment_type_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.apartment_type_id);
    }
    if (null == this.metro_station_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.metro_station_id);
    }
    if (null == this.minutes_to_metro) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.minutes_to_metro);
    }
    if (null == this.region_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.region_id);
    }
    if (null == this.number_of_rooms) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.number_of_rooms);
    }
    if (null == this.area) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.area);
    }
    if (null == this.living_area) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.living_area);
    }
    if (null == this.kitchen_area) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.kitchen_area);
    }
    if (null == this.apartment_floor) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.apartment_floor);
    }
    if (null == this.number_of_floors) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.number_of_floors);
    }
    if (null == this.renovation_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.renovation_id);
    }
  }
  public void write0(DataOutput __dataOut) throws IOException {
    if (null == this.id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.id);
    }
    if (null == this.price) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.price);
    }
    if (null == this.apartment_type_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.apartment_type_id);
    }
    if (null == this.metro_station_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.metro_station_id);
    }
    if (null == this.minutes_to_metro) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.minutes_to_metro);
    }
    if (null == this.region_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.region_id);
    }
    if (null == this.number_of_rooms) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.number_of_rooms);
    }
    if (null == this.area) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.area);
    }
    if (null == this.living_area) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.living_area);
    }
    if (null == this.kitchen_area) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.kitchen_area);
    }
    if (null == this.apartment_floor) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.apartment_floor);
    }
    if (null == this.number_of_floors) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeDouble(this.number_of_floors);
    }
    if (null == this.renovation_id) { 
        __dataOut.writeBoolean(true);
    } else {
        __dataOut.writeBoolean(false);
    __dataOut.writeInt(this.renovation_id);
    }
  }
  private static final DelimiterSet __outputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  public String toString() {
    return toString(__outputDelimiters, true);
  }
  public String toString(DelimiterSet delimiters) {
    return toString(delimiters, true);
  }
  public String toString(boolean useRecordDelim) {
    return toString(__outputDelimiters, useRecordDelim);
  }
  public String toString(DelimiterSet delimiters, boolean useRecordDelim) {
    StringBuilder __sb = new StringBuilder();
    char fieldDelim = delimiters.getFieldsTerminatedBy();
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(price==null?"null":"" + price, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(apartment_type_id==null?"null":"" + apartment_type_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(metro_station_id==null?"null":"" + metro_station_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(minutes_to_metro==null?"null":"" + minutes_to_metro, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(region_id==null?"null":"" + region_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(number_of_rooms==null?"null":"" + number_of_rooms, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(area==null?"null":"" + area, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(living_area==null?"null":"" + living_area, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(kitchen_area==null?"null":"" + kitchen_area, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(apartment_floor==null?"null":"" + apartment_floor, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(number_of_floors==null?"null":"" + number_of_floors, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(renovation_id==null?"null":"" + renovation_id, delimiters));
    if (useRecordDelim) {
      __sb.append(delimiters.getLinesTerminatedBy());
    }
    return __sb.toString();
  }
  public void toString0(DelimiterSet delimiters, StringBuilder __sb, char fieldDelim) {
    __sb.append(FieldFormatter.escapeAndEnclose(id==null?"null":"" + id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(price==null?"null":"" + price, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(apartment_type_id==null?"null":"" + apartment_type_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(metro_station_id==null?"null":"" + metro_station_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(minutes_to_metro==null?"null":"" + minutes_to_metro, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(region_id==null?"null":"" + region_id, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(number_of_rooms==null?"null":"" + number_of_rooms, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(area==null?"null":"" + area, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(living_area==null?"null":"" + living_area, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(kitchen_area==null?"null":"" + kitchen_area, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(apartment_floor==null?"null":"" + apartment_floor, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(number_of_floors==null?"null":"" + number_of_floors, delimiters));
    __sb.append(fieldDelim);
    __sb.append(FieldFormatter.escapeAndEnclose(renovation_id==null?"null":"" + renovation_id, delimiters));
  }
  private static final DelimiterSet __inputDelimiters = new DelimiterSet((char) 44, (char) 10, (char) 0, (char) 0, false);
  private RecordParser __parser;
  public void parse(Text __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharSequence __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(byte [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(char [] __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(ByteBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  public void parse(CharBuffer __record) throws RecordParser.ParseError {
    if (null == this.__parser) {
      this.__parser = new RecordParser(__inputDelimiters);
    }
    List<String> __fields = this.__parser.parseRecord(__record);
    __loadFromFields(__fields);
  }

  private void __loadFromFields(List<String> fields) {
    Iterator<String> __it = fields.listIterator();
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.price = null; } else {
      this.price = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.apartment_type_id = null; } else {
      this.apartment_type_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.metro_station_id = null; } else {
      this.metro_station_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.minutes_to_metro = null; } else {
      this.minutes_to_metro = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.region_id = null; } else {
      this.region_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.number_of_rooms = null; } else {
      this.number_of_rooms = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.area = null; } else {
      this.area = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.living_area = null; } else {
      this.living_area = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.kitchen_area = null; } else {
      this.kitchen_area = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.apartment_floor = null; } else {
      this.apartment_floor = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.number_of_floors = null; } else {
      this.number_of_floors = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.renovation_id = null; } else {
      this.renovation_id = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  private void __loadFromFields0(Iterator<String> __it) {
    String __cur_str = null;
    try {
    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.id = null; } else {
      this.id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.price = null; } else {
      this.price = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.apartment_type_id = null; } else {
      this.apartment_type_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.metro_station_id = null; } else {
      this.metro_station_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.minutes_to_metro = null; } else {
      this.minutes_to_metro = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.region_id = null; } else {
      this.region_id = Integer.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.number_of_rooms = null; } else {
      this.number_of_rooms = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.area = null; } else {
      this.area = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.living_area = null; } else {
      this.living_area = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.kitchen_area = null; } else {
      this.kitchen_area = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.apartment_floor = null; } else {
      this.apartment_floor = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.number_of_floors = null; } else {
      this.number_of_floors = Double.valueOf(__cur_str);
    }

    if (__it.hasNext()) {
        __cur_str = __it.next();
    } else {
        __cur_str = "null";
    }
    if (__cur_str.equals("null") || __cur_str.length() == 0) { this.renovation_id = null; } else {
      this.renovation_id = Integer.valueOf(__cur_str);
    }

    } catch (RuntimeException e) {    throw new RuntimeException("Can't parse input data: '" + __cur_str + "'", e);    }  }

  public Object clone() throws CloneNotSupportedException {
    housing_data o = (housing_data) super.clone();
    return o;
  }

  public void clone0(housing_data o) throws CloneNotSupportedException {
  }

  public Map<String, Object> getFieldMap() {
    Map<String, Object> __sqoop$field_map = new HashMap<String, Object>();
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("price", this.price);
    __sqoop$field_map.put("apartment_type_id", this.apartment_type_id);
    __sqoop$field_map.put("metro_station_id", this.metro_station_id);
    __sqoop$field_map.put("minutes_to_metro", this.minutes_to_metro);
    __sqoop$field_map.put("region_id", this.region_id);
    __sqoop$field_map.put("number_of_rooms", this.number_of_rooms);
    __sqoop$field_map.put("area", this.area);
    __sqoop$field_map.put("living_area", this.living_area);
    __sqoop$field_map.put("kitchen_area", this.kitchen_area);
    __sqoop$field_map.put("apartment_floor", this.apartment_floor);
    __sqoop$field_map.put("number_of_floors", this.number_of_floors);
    __sqoop$field_map.put("renovation_id", this.renovation_id);
    return __sqoop$field_map;
  }

  public void getFieldMap0(Map<String, Object> __sqoop$field_map) {
    __sqoop$field_map.put("id", this.id);
    __sqoop$field_map.put("price", this.price);
    __sqoop$field_map.put("apartment_type_id", this.apartment_type_id);
    __sqoop$field_map.put("metro_station_id", this.metro_station_id);
    __sqoop$field_map.put("minutes_to_metro", this.minutes_to_metro);
    __sqoop$field_map.put("region_id", this.region_id);
    __sqoop$field_map.put("number_of_rooms", this.number_of_rooms);
    __sqoop$field_map.put("area", this.area);
    __sqoop$field_map.put("living_area", this.living_area);
    __sqoop$field_map.put("kitchen_area", this.kitchen_area);
    __sqoop$field_map.put("apartment_floor", this.apartment_floor);
    __sqoop$field_map.put("number_of_floors", this.number_of_floors);
    __sqoop$field_map.put("renovation_id", this.renovation_id);
  }

  public void setField(String __fieldName, Object __fieldVal) {
    if (!setters.containsKey(__fieldName)) {
      throw new RuntimeException("No such field:"+__fieldName);
    }
    setters.get(__fieldName).setField(__fieldVal);
  }

}
