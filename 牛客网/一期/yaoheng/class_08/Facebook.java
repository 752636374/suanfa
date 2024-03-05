package 牛客网.一期.yaoheng.class_08;

import java.util.*;

/**
 * 空间复杂度： 该实现的空间复杂度为 O(n)，其中 n 是用户的数量。这是由于使用了哈希表来存储用户及其朋友列表的对应关系。
 *
 * 时间复杂度： 添加用户和朋友关系的操作的时间复杂度为 O(1)，获取用户的朋友列表的操作的时间复杂度也为 O(1)。查询共同好友的操作的时间复杂度取决于用户的朋友列表的大小，假设用户的平均朋友数量为 m，那么查询共同好友的操作的时间复杂度为 O(m)。
 *
 * 注释： 代码中有详细的注释，解释了每个方法的功能和实现细节。
 *
 * 实现原理： 该实现使用了一个哈希表来存储每个用户及其朋友列表的对应关系。通过哈希表，可以快速地获取用户的朋友列表，添加用户和朋友关系，以及查询共同好友。
 *
 * 实现逻辑： Facebook 类中的 addUser 方法用于添加用户及其朋友列表，addFriendship 方法用于添加好友关系，getFriends 方法用于获取用户的朋友列表，getCommonFriends 方法用于查询共同好友。在示例中，首先添加了一些用户和朋友关系，然后查询了 Alice 和 Charlie 的共同好友。
 *
 * 优劣势：
 *
 * 优势：该实现使用了哈希表，具有快速的查询和添加操作，时间复杂度为常数级别，适用于大规模的用户和好友关系。同时，使用哈希表存储用户和朋友关系，可以快速地获取用户的朋友列表和查询共同好友。
 * 劣势：该实现没有考虑到用户的好友关系的动态变化，如果频繁地添加和删除好友关系，可能需要更新哈希表中的数据，这可能会导致一些性能损失。此外，该实现仅仅考虑了共同好友的数量，没有考虑其他因素，如兴趣、互动等，这可能会导致推荐结果的准确性降低
 */
public class Facebook {

    private Map<String, Set<String>> friendsMap;

    public Facebook() {
        friendsMap = new HashMap<>();
    }

    // 添加用户及其朋友列表到映射关系中
    public void addUser(String user, Set<String> friends) {
        friendsMap.put(user, friends);
    }

    // 获取用户的朋友列表
    public Set<String> getFriends(String user) {
        return friendsMap.getOrDefault(user, new HashSet<>());
    }

    // 添加好友关系
    public void addFriendship(String user1, String user2) {
        friendsMap.computeIfAbsent(user1, k -> new HashSet<>()).add(user2);
        friendsMap.computeIfAbsent(user2, k -> new HashSet<>()).add(user1);
    }

    // 查询共同好友
    public Set<String> getCommonFriends(String user1, String user2) {
        Set<String> commonFriends = new HashSet<>();
        Set<String> friends1 = getFriends(user1);
        Set<String> friends2 = getFriends(user2);

        for (String friend : friends1) {
            if (friends2.contains(friend)) {
                commonFriends.add(friend);
            }
        }

        return commonFriends;
    }

    public static void main(String[] args) {
        Facebook facebook = new Facebook();

        // 添加用户及其朋友列表
        facebook.addUser("Alice", new HashSet<>(Arrays.asList("Bob", "Charlie", "David")));
        facebook.addUser("Bob", new HashSet<>(Arrays.asList("Alice", "Charlie")));
        facebook.addUser("Charlie", new HashSet<>(Arrays.asList("Alice", "Bob", "David")));
        facebook.addUser("David", new HashSet<>(Arrays.asList("Alice", "Charlie")));

        // 添加好友关系
        facebook.addFriendship("Alice", "Bob");
        facebook.addFriendship("Bob", "Charlie");
        facebook.addFriendship("Charlie", "David");

        // 查询共同好友
        Set<String> commonFriends = facebook.getCommonFriends("Alice", "Charlie");

        System.out.println("Common friends between Alice and Charlie: " + commonFriends);
    }
}
