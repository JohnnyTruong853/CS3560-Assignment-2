import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


/*
 * Design Patterns: Observer, Composite
 */

public class User {

    private String tweet;
    private String username;
    private PropertyChangeSupport support;
    private SocialMediaFeed myFeed;
    private ArrayList<User> followers;
    private ArrayList<User> following;
    private ArrayList<String> tweetList;
    private long creationTime;
    private long lastUpdateTime;

    public User() {

    }

    public User(String username) {
        setUsername(username);
        tweet = "";
        support = new PropertyChangeSupport(this);
        myFeed = new SocialMediaFeed();
        myFeed.setUser(this);
        followers = new ArrayList<>();
        following = new ArrayList<>();
        tweetList = new ArrayList<>();
        addPropertyChangeListener(myFeed);

        System.out.println("Creation time:");
        creationTime = System.currentTimeMillis();
        showCreationTime(creationTime);

    }

    private void showCreationTime(long creationTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
        Date resultdate = new Date(creationTime);
        System.out.println(sdf.format(resultdate));
    }

    // Adds a property change listener
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
        showUpdateTime();
    }

    private void showUpdateTime() {
        System.out.println("Last update: ");
        lastUpdateTime = System.currentTimeMillis();
        showCreationTime(lastUpdateTime);
    }

    public void addFollowers(User newFollower) {
        followers.add(newFollower);
    }

    public void addFollowing(User newFollowing) {
        following.add(newFollowing);
        newFollowing.addFollowers(this);
    }

    // fires a property change to all listeners whenever this user posts a tweet
    public void addTweet(String tweet) {
        support.firePropertyChange("tweet", this.tweet, tweet);
        tweetList.add(tweet);
        setTweet(tweet);
        showUpdateTime();
    }

    // getters and setter

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public SocialMediaFeed getMyFeed() {
        return myFeed;
    }

    public void setMyFeed(SocialMediaFeed myFeed) {
        this.myFeed = myFeed;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<User> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<User> followers) {
        this.followers = followers;
    }

    public ArrayList<User> getFollowing() {
        return following;
    }

    public void setFollowing(ArrayList<User> following) {
        this.following = following;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
