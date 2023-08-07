package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import classes.Operations;
import classes.Record;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFinance {

  DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

  @Test
  public void checkCalcBalance() throws ParseException {
    List<Record> records = new ArrayList<>();
    Record r1 = new Record(1, dateFormat.parse("10.10.2023"),
        "papa", "Food", "Pizza1", -15.00);

    Record r2 = new Record(2, dateFormat.parse("11.10.2023"),
        "papa", "Food", "Pizza2", -25.00);

    Record r3 = new Record(3, dateFormat.parse("12.10.2023"),
        "papa", "Food", "Pizza3", -27.00);

    Record r4 = new Record(4, dateFormat.parse("11.10.2023"),
        "papa", "Income", "Salary", 1200.00);
    records.add(r1);
    records.add(r2);
    records.add(r3);
    records.add(r4);

    assertEquals(1133.00, Operations.calcBalance(records,
        dateFormat.parse("09.10.2023"), dateFormat.parse("13.10.2023")));
    assertEquals(1148.00, Operations.calcBalance(records, dateFormat.parse("10.10.2023"),
        dateFormat.parse("13.10.2023")));
  }
}
