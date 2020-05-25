package clientNetworking.createUser;


import clientNetworking.HTTPHandler;
import com.google.gson.Gson;
import shared.User;

public class CreateUserClient implements ICreateUserClient {
    private Gson jsonSerializer;
    private String response;
    private clientNetworking.HTTPHandler httpHandler;

    public CreateUserClient(HTTPHandler httpHandler) {
        this.httpHandler = httpHandler;
        this.jsonSerializer = new Gson();
    }

    @Override
    public String createUser(User createUserCarrier) {
        String PATH ="http://127.0.0.1:5000/api/User";
        String createEmployeeJson = jsonSerializer.toJson(createUserCarrier);
        System.out.println(createEmployeeJson);
        response = httpHandler.postToAPI(createEmployeeJson, PATH);
        System.out.println(response);
        return response;
    }

    @Override
    public String getResponse() {
        return response;
    }
}
