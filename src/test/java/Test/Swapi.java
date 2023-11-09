package Test;


import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Swapi {

    private String url = "https://swapi.dev/api/";
    private String endpoint = "people/2/";

    private Response response;


    @Test
    public void succesResponse(){
        response = given().get(url+endpoint);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void skinColor(){
        response = given().get(url+endpoint);
        JsonPath jsonSave = response.jsonPath();
        Assert.assertEquals(jsonSave.get("skin_color"), "gold");
    }

    @Test
    public void amountFilms(){
        response = given().get(url+endpoint);
        JsonPath jsonSave = response.jsonPath();
        Assert.assertEquals(jsonSave.getList("films").size(), 6);
    }

}
