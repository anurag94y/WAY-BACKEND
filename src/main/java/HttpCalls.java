import com.google.gson.Gson;
import db.model.UserDetail;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;



/**
 * Created by anurag.yadav on 4/13/17.
 */

public class HttpCalls {

    public static String GET(String url){
        InputStream inputStream = null;
        String result = "";
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
            inputStream = httpResponse.getEntity().getContent();
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";
        } catch (Exception e) {
            //Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    public static String putHttp(String content) {
        DefaultHttpClient client = new DefaultHttpClient();
        InputStream inputStream = null;
        String result = "";
        HttpPost post = new HttpPost("http://localhost:8080/setLocationDetail");
        try {
            post.setEntity(new StringEntity(content));
            post.setHeader("Accept", "application/json");
            post.setHeader("Content-type", "application/json");
            HttpResponse response = client.execute(post);
            inputStream = response.getEntity().getContent();
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";
        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
        return result;
    }

    // convert inputstream to String
    private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

    public static String postHttp(String content) {
        try {
            // Set up the request
            URL url = new URL("https://localhost:8080/setLocationDetail");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);

            // Build name data request params

            // Execute HTTP Post
            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            writer.write(content);
            writer.flush();
            writer.close();
            outputStream.close();
            connection.connect();

            // Read response
            int responseCode = connection.getResponseCode();
            StringBuilder response = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            if (responseCode == HttpsURLConnection.HTTP_OK) {
                return response.toString();
            }
            return "Error: " + responseCode + " " + connection.getResponseMessage();

        } catch (IOException e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public static void main(String[] args) {
        UserDetail userDetail = new UserDetail();
        userDetail.setFirstName("Paras");
        userDetail.setLastName("Meena");
        userDetail.setEmailId("paras.meena885@gmail.com");
        userDetail.setMobileNumber("9639507064");
        userDetail.setPassword("shyampur");
        userDetail.setUsername("paras885");
        //System.out.println(putHttp(new Gson().toJson(userDetail)));
        System.out.println(GET("http://localhost:8080/setLocationDetail?username=hellboy_86"));
    }

}

