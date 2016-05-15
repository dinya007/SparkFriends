package fifth;

import java.io.Serializable;

public class Friends implements Serializable {

    private final Integer friend1Id;
    private final Integer friend2Id;


    public Friends(Integer friend1Id, Integer friend2Id) {
        this.friend1Id = friend1Id;
        this.friend2Id = friend2Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friends friends = (Friends) o;

        return (friend1Id.equals(friends.friend1Id) || friend1Id.equals(friends.friend2Id)) && (friend2Id.equals(friends.friend1Id) || friend2Id.equals(friends.friend2Id));
    }

    @Override
    public int hashCode() {
        return friend1Id + friend2Id;
    }

    @Override
    public String toString() {
        return "Friends{" +
                "friend1Id=" + friend1Id +
                ", friend2Id=" + friend2Id +
                '}';
    }
}
