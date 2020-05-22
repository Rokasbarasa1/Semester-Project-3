package model.calendar;

import shared.Shift;
import shared.User;

import java.util.ArrayList;

public interface ICalendarModel {
    User getUserFromModel();
    User getUserfromDatabase(int userId);
    void getCalendar(String timeStamp);
    void getCurrentUser();
    ArrayList<Shift> getModelShifts();
}
