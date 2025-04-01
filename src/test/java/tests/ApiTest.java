package tests;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test_data.User;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.get;

public class ApiTest {

    private static final int SUCCESS_CODE = 200;

    @Test
    @Parameters("gender")
    public void getTenUsersTest(String gender) {
        String url = "https://randomuser.me/api/";
        Response response;
        List<User> users = new ArrayList<>();
        System.out.println(">>>>>>>>>>>>>>");
        System.out.println(gender);
        System.out.println("<<<<<<<<<<<<<<");

        do {
            response = get(url);

            if (response.getStatusCode() == SUCCESS_CODE) {

                JSONObject jsonResponse = new JSONObject(response.getBody().asString());
                JSONArray results = jsonResponse.getJSONArray("results");

                JSONObject user = results.getJSONObject(0);
                String actualGender = user.getString("gender");

                if (actualGender.equals(gender)) {
                    String username = user.getJSONObject("login").getString("username");
                    String password = user.getJSONObject("login").getString("password");
                    users.add(new User(username, password));
                }

            }

        } while (users.size() < 10);

        for (User user : users) {
            System.out.println("login: " + user.getLogin() + ", password: " + user.getPassword() + ";");
        }
    }
}
