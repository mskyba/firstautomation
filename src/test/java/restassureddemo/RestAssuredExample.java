package restassureddemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.OrderDto;
import dto.PetDto;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredExample {

    private static final String BASE_URL = "https://petstore.swagger.io/v2";
    private RequestSpecification requestSpecification;
    public String petId;
    public String orderId;


    @BeforeClass
    @SneakyThrows
    public void setup() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build();

        PetDto requestPet = PetDto
                .builder()
                .status("available")
                .name("Barsik")
                .build();


        //Request creating pet
         petId = RestAssured
                .given()
                .spec(requestSpecification)
                .body(new ObjectMapper().writeValueAsString(requestPet))//from java obj to json
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getString("id");


        //Request getting pet
        JsonPath jsonResponsePet = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/pet/" + petId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        //from json to java obj
        PetDto responsePet = new ObjectMapper().readValue(jsonResponsePet.prettify(), PetDto.class);
        Assert.assertEquals(requestPet, responsePet);

    }


    @Test
    @SneakyThrows
    public void postPet() {

        OrderDto orderPet = OrderDto
                .builder()
                .quantity(10)
                .build();

        orderId = RestAssured
                .given()
                .spec(requestSpecification)
                .body(new ObjectMapper().writeValueAsString(orderPet))
                .when()
                .post("/store/order")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getString("id");
        System.out.println(orderId);
        JsonPath jsonResponseOrder = RestAssured
                .given()
                .spec(requestSpecification)
                .when()
                .get("/store/order/" + orderId)
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath();

        //from json to java obj
        OrderDto responseOrder = new ObjectMapper().readValue(jsonResponseOrder.prettify(), OrderDto.class);
        System.out.println(orderPet);
        System.out.println(responseOrder);
        Assert.assertEquals(orderPet, responseOrder);



    }

}