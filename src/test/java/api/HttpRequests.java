package api;

import api.models.Post;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class HttpRequests {
    private static ObjectMapper objectMapper = new ObjectMapper();


    private static RequestSpecification regWithAuth(String AppId) {

        return given()
                .baseUri("https://dummyapi.io/data/api")
                .header("App-Id", AppId);
    }

    public static Post getPosts(String AppId) throws IOException {
        String responseMsg = regWithAuth(AppId)
                .get("/post")
                .then().extract().response().body()
                .asString();
        Post post = objectMapper.readValue(responseMsg, Post.class);
        return post;




    }
    public static Post getPostById (String AppId, String postId) throws IOException {

        Map<String, String> param = new HashMap<>();
        param.put("postId", postId);
        String responseMsg = regWithAuth(AppId)
                .pathParams(param)
                .get("/post/{postId}")
                .then().extract().response().body()
                .asString();
        Post post = objectMapper.readValue(responseMsg, Post.class);
        return post;

    }
    public static Post getPostByUserId (String AppId, String userId) throws IOException {

        Map<String, String> param = new HashMap<>();
        param.put("userId", userId);

        String responseMsg = regWithAuth(AppId)
                .pathParams(param)
                .get("/user/{userId}/post")
                .then().extract().response().body()
                    .asString();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        Post post = objectMapper.readValue(responseMsg, Post.class);
        return post;
    }

    public static Post getPostByTag (String AppId, String tag) throws IOException {

        Map<String, String> param = new HashMap<>();
        param.put("tag", tag);

        String responseMsg =  regWithAuth(AppId)
                .pathParams(param)
                .get("/tag/{tag}/post")
                .then().extract().response().body()
                .asString();
        Post post = objectMapper.readValue(responseMsg, Post.class);
        return post;
    }


}
