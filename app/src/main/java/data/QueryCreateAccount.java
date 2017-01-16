package data;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import model.user.User;

/**
 * Created by Klaussius on 14/12/2016.
 */

public class QueryCreateAccount extends Connection{
    private final static String PHP_QUERY_FILE = "usersQuery.php";
    private String queryURL;
    private User user;
    private int insertionId;

    public QueryCreateAccount(User user){
        this.user=user;
    }

    /**
     * Post the request to insert the user
     */
    public void createAccount() {
        queryURL=API_URL+PHP_QUERY_FILE;
        try {
            Log.i("Connect with server","Retrieving data...");
            // URL
            URL url = new URL(queryURL);
            // PARAMS POST
            Map<String, Object> params = new LinkedHashMap<>();
            params.put(REQUEST_NAME,INSERT_ITEM);
            params.put(FIELDS,"[\"name\",\"publicName\",\"password\",\"phone\",\"eMail\"]");
            params.put(VALUES,"[\""+user.getName()+"\",\""+user.getPublicName()+"\",\""+user.getPassword()+"\",\""+user.getPhone()+"\",\""+user.geteMail()+"\"]");
            byte[] postDataBytes = putParams(params); // Aux Method to make post
            //Send the data
            Reader in = connect(url, Proxy.NO_PROXY, postDataBytes);
            // Taking and analyzing the answer
            JsonArray jarray = getArrayFromJson(in, null); // Only Json Objects
            makeFromJson(jarray);

        } catch (Exception ex) {
            ex.printStackTrace();
            Log.i("Create account","Error");
        } finally {
            close();
        }
    }

    /**
     * Make the object User from Array
     */
    private void makeFromJson(JsonArray jarray){
        JsonObject jsonObject=jarray.get(0).getAsJsonObject();
        this.insertionId = jsonObject.get("insertionId").getAsInt();
    }

    /**
     * Get the insertion id
     * @return insertion id
     */
    public int getInsertionId() {
        return insertionId;
    }
}
