import java.util.ArrayList;

/*
 * Design pattern: Visitor
 */

public class TotalStats implements AdminAnalytics {

    private ArrayList<User> userList;
    private ArrayList<UserGroup> userGroupList;

    public TotalStats() {
        userList = new ArrayList<>();
        userGroupList = new ArrayList<>();
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void addGroup(UserGroup userGroup) {
        userGroupList.add(userGroup);
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public int getUserTotal() {
        return userList.size();
    }

    public int getGroupTotal() {
        return userGroupList.size();
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public ArrayList<UserGroup> getUserGroupList() {
        return userGroupList;
    }

    public void setUserGroupList(ArrayList<UserGroup> userGroupList) {
        this.userGroupList = userGroupList;
    }
}
