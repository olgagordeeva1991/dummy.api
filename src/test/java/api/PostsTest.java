package api;

import api.models.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class PostsTest {
    public String id = "6098f2c41248715c153a15bd";

    @Test(description = "Получение всех постов")
    public final void getPostsTest() throws IOException {
        Post posts = HttpRequests.getPosts(id);
        Assert.assertNotNull(posts);

    }
    @Test(description = "Получение поста по id")
    public final void getPostsByIdTest() throws IOException {
        String postId = "UWdcOFTc7DfzOhI6LpI4";
        Post post = HttpRequests.getPostById(id, postId);
        Assert.assertEquals(post.getId(), postId);
    }

    @Test(description = "Получение поста по id пользователя")
    public final void getPostByUserIdTest () throws IOException {
        String userId = "0F8JIqi4zwvb77FGz6Wt";
        String postId = "h6SMm2IrtKS2voz2tAOq";
        Post post = HttpRequests.getPostByUserId(id, userId);
        Assert.assertEquals(post.getData().getId(), postId);

    }

    @Test(description = "Получение поста по тегу")
    public final void getPostByTagTest () throws IOException {
        String tag = "grass";
        Post post = HttpRequests.getPostByTag(id, tag);
        Assert.assertEquals(post.getTags(), tag);
    }

}
