package tests;

import classes.Operations;
import classes.Record;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDateOperations {

  DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

  @Test
  public void GetMinDateFromList() throws ParseException {
    List<Record> records = new ArrayList<>();
    Record r1 = new Record(1, dateFormat.parse("10.10.2023"),
        "papa", "Food", "Pizza1", -15.00);
    Record r2 = new Record(2, dateFormat.parse("11.10.2023"),
        "papa", "Food", "Pizza2", -25.00);
    Record r3 = new Record(3, dateFormat.parse("12.10.2023"),
        "papa", "Food", "Pizza3", -27.00);
    records.add(r1);
    records.add(r2);
    records.add(r3);
    Assertions.assertEquals(dateFormat.parse("09.10.2023"), Operations.getMinDate(records));
  }


}
