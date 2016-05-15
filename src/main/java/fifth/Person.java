package fifth;

import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {

    private final Integer ownerId;
    private final List<Integer> friends;

    public Person(Integer ownerId, List<Integer> friends) {
        this.ownerId = ownerId;
        this.friends = friends;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public List<Integer> getFriends() {
        return friends;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return ownerId != null ? ownerId.equals(person.ownerId) : person.ownerId == null;

    }

    @Override
    public int hashCode() {
        return ownerId != null ? ownerId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ownerId=" + ownerId +
                ", friends=" + friends +
                '}';
    }
}
