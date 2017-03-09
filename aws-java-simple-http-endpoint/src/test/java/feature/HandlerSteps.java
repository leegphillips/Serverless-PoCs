package feature;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HandlerSteps {
    @Given("^The endpoint is there$")
    public void the_endpoint_is_there() throws Throwable {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://omctb2g1u6.execute-api.us-east-1.amazonaws.com/dev/ping")
                .build();

        Response response = client.newCall(request).execute();
        int code = response.code();
        System.out.println(code);
    }
}
