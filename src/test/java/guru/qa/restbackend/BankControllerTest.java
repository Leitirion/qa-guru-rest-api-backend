package guru.qa.restbackend;

import guru.qa.restbackend.domain.UserInfo;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static io.restassured.RestAssured.with;

public class BankControllerTest {

    private RequestSpecification spec =
            with()
                    .baseUri("http://localhost:8080")
                    .basePath("/");

    @Test
    void bankControllerTest() {
        spec.get("user/getAll")
                .then()
                .statusCode(200)
                .extract()
                .response()
                .as(UserInfo[].class);

    }
}
