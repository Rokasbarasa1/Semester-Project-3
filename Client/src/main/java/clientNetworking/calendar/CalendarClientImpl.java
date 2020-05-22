package clientNetworking.calendar;

import clientNetworking.HTTPHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import shared.Shift;
import shared.User;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CalendarClientImpl implements CalendarClient{
    private Gson jsonSerializer;
    private String response;
    private HTTPHandler httpHandler;


    public CalendarClientImpl(HTTPHandler httpHandler){
        this.httpHandler = httpHandler;
        this.jsonSerializer = new Gson();
    }

    @Override // date format xx-xxxx
    public ArrayList<Shift> getCalendarShifts(int userID, String month) {
        Type listType = new TypeToken<ArrayList<Shift>>(){}.getType();
        String PATH ="http://127.0.0.1:5000/api/Shifts/?username=" +  userID + "&date=" + month;
        response = httpHandler.getFromAPI(PATH);
        ArrayList<Shift> shifts = jsonSerializer.fromJson(response, listType);
        return shifts;
    }

    @Override
    public String getResponse() {
        return null;
    }

    @Override
    public User getUser(String Id) {
        String PATH ="http://127.0.0.1:5000/api/Employee/" +Id;
        response = httpHandler.getFromAPI(PATH);
        User user = jsonSerializer.fromJson(response, User.class);
        return user;
    }
}
