package com.legrego.jsonplaceholder;

import com.legrego.jsonplaceholder.domain.Post;
import com.legrego.jsonplaceholder.domain.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Driver class for application.
 * Responsible for handling user input, and executing the requested commands.
 *
 * @author Larry Gregory
 */
public class Main {
    /** Class Logger */
    private static final Log LOG = LogFactory.getLog(Main.class);

    /** Format String for printing User details to the console in a tabular fashion. */
    private static final String USER_FORMAT_STRING = "%-15s%-25s%-15s\n";

    /** Reader for handling user input */
    private final BufferedReader reader;

    /** Client Proxy to the JsonPlaceholder API */
    private final JsonPlaceholderProxy proxy;

    /** Flag indicating that application is running and should accept commands */
    private boolean running;

    /**
     * Constructor.
     *
     * @param reader reader used to supply user input for completing commands.
     * @param proxy proxy to the JsonPlaceholder API.
     */
    public Main (BufferedReader reader, JsonPlaceholderProxy proxy) {
        this.reader = reader;
        this.proxy = proxy;
        this.running = true;
    }

    /**
     * Entry Point.
     * Performs initialization, and continually accepts commands from user.
     *
     * @param args command-line arguments (not required for this application)
     */
    public static void main(String[] args) {
        LOG.debug("Initializing");
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
        RegisterBuiltin.register(ResteasyProviderFactory.getInstance());
        JsonPlaceholderProxy proxy = ProxyFactory.create(JsonPlaceholderProxy.class, "http://jsonplaceholder.typicode.com");
        Main instance = new Main(stdIn, proxy);
        LOG.debug("Initialization Complete. Ready for user input.");

        while (instance.isRunning()) {
            try {
                String command = instance.getInput("> ");
                if (command == null || command.isEmpty()) {
                    continue;
                }

                instance.runCommand(command);
            }
            catch (IOException ioe) {
                LOG.error("Error retrieving user input for command", ioe);
            }
            catch (RuntimeException re) {
                // Client Proxy throws a generic RuntimeException when there's an unexpected error encountered
                LOG.error("Unexpected error handling request", re);
                System.err.println("Error processing request. See logs for details");
            }
        }
    }

    /**
     * Runs the passed command.
     *
     * @param command the command to run
     */
    private void runCommand(String command) throws IOException {
        LOG.debug("Executing command: '" + command + "'");

        switch (command) {
            case "listUsers":
                listUsers();
                break;

            case "addUser":
                addUser();
                break;

            case "listUserPosts":
                listUserPosts();
                break;

            case "addUserPost":
                addUserPost();
                break;

            case "help":
                printHelp();
                break;

            case "exit":
            case "quit":
                this.setRunning(false);
                break;

            default:
                System.err.println("unrecognized command: '" + command + "'. Type 'help' for list of available commands.");
                break;
        }
    }

    /**
     * Lists all Users.
     */
    private void listUsers() {
        List<User> users = proxy.getAllUsers();
        System.out.printf(USER_FORMAT_STRING, "User ID", "Username", "Email");
        for (User u : users) {
            System.out.printf(USER_FORMAT_STRING, u.getId(), u.getUsername(), u.getEmail());
        }
    }

    /**
     * Adds a User to the system.
     * 
     * Additional validation steps:
     *  1) Ensure that username does not already exist
     *  2) Ensure email address is valid
     *  3) Verify all fields meet minimum/maximum length requirements
     *  4) Depending on system requirements, white-list a character set, to prevent malicious input from being persisted
     *
     * @throws IOException if an error is encountered while handling user input
     */
    private void addUser() throws IOException {
        String username = getInput("\tEnter Username: ");
        String email = getInput("\tEnter Email: ");
        String name = getInput("\tEnter Name: ");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setEmail(email);
        newUser.setName(name);

        User createdUser = proxy.createUser(newUser);
        System.out.println("User created successfully:");
        System.out.printf(USER_FORMAT_STRING, "User ID", "Username", "Email");
        System.out.printf(USER_FORMAT_STRING, createdUser.getId(), createdUser.getUsername(), createdUser.getEmail());
    }

    /**
     * Retrieve all Posts for a given User.
     *
     * Additional validation steps:
     *  1) Ensure that User ID entered is a valid Integer, and corresponds to a valid User in the system
     *
     * @throws IOException if an error is encountered while handling user input
     */
    private void listUserPosts() throws IOException {
        String userId = getInput("\tEnter User ID: ");
        List<Post> usersPosts = proxy.getPostsForUser(Integer.valueOf(userId));

        if (usersPosts.isEmpty()) {
            System.out.println("No Posts found for user with ID " + userId);
            return;
        }

        System.out.println("User with ID " + userId + " has the following posts:");
        for (Post post : usersPosts) {
            printPost(post);
        }
    }

    /**
     * Adds a Post to the system.
     *
     * Additional validation steps:
     *  1) Ensure that User ID is a valid Integer, and corresponds to a valid User in the system
     *  2) Verify all fields meet minimum/maximum length requirements
     *  4) Depending on system requirements, white-list a character set, to prevent malicious input from being persisted
     *
     * @throws IOException if an error is encountered while handling user input
     */
    private void addUserPost() throws IOException {
        String userId = getInput("\tEnter User ID: ");
        String postTitle = getInput("\tEnter Post Title: ");
        String postBody = getInput("\tEnter Post Body: ");

        Post post = new Post();
        post.setUserId(Integer.valueOf(userId));
        post.setTitle(postTitle);
        post.setBody(postBody);

        Post createdPost = proxy.createPost(post);
        System.out.println("Post for user created successfully:");
        printPost(createdPost);
    }

    /**
     * Prints the post to the console.
     *
     * @param post the post to display
     */
    private void printPost(Post post) {
        System.out.println(post.getTitle());
        System.out.println("--------------------------------------");
        System.out.println(post.getBody());
        System.out.println();
    }

    /**
     * Prints help for this tool.
     */
    private void printHelp() {
        System.out.println("Available Commands: ");
        System.out.println("  listUsers: Print all users");
        System.out.println("  addUser: Add a user to the system");
        System.out.println("  addUserPost: Add a Post for a particular User");
        System.out.println("  listUserPosts: Print all posts from a particular User");
        System.out.println("  help: Print all available commands");
        System.out.println("  exit | quit: Exit the application");
    }

    /**
     * Retrieve input from the user.
     *
     * @param prompt the prompt to display
     * @return String the input from the user
     * @throws IOException if an error occurs retrieving input
     */
    private String getInput(String prompt) throws IOException{
        System.out.print(prompt);
        return this.reader.readLine();
    }

    /**
     * Getter for property 'running'.
     *
     * @return Value for property 'running'.
     */
    public boolean isRunning() {
        return this.running;
    }

    /**
     * Setter for property 'running'.
     *
     * @param running Value to set for property 'running'.
     */
    public void setRunning(boolean running) {
        this.running = running;
    }
}