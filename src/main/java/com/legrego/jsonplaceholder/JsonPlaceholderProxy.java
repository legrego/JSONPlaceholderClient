package com.legrego.jsonplaceholder;

import com.legrego.jsonplaceholder.domain.Post;
import com.legrego.jsonplaceholder.domain.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Client Proxy to interact with the JsonPlaceholder API.
 *
 * @author Larry Gregory
 */
@Path("/")
public interface JsonPlaceholderProxy {

    /**
     * Retrieve all users from the API.
     *
     * @return Collection of all Users.
     */
    @GET
    @Path("/users")
    @Consumes(MediaType.APPLICATION_JSON)
    List<User> getAllUsers();

    /**
     * Create the specified User.
     *
     * @param user the user to create.
     * @return The created User (with new User ID).
     */
    @POST
    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    User createUser(User user);

    /**
     * Retrieve all Posts for a given User.
     *
     * @param userId the ID of the user to retrieve posts for.
     * @return Collection of User's Posts.
     */
    @GET
    @Path("/posts")
    List<Post> getPostsForUser(@QueryParam("userId") Integer userId);

    /**
     * Create a Post for a User.
     *
     * @param post the Post to create.
     * @return The created Post (with new Post ID)
     */
    @POST
    @Path("/posts")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    Post createPost(Post post);
}
