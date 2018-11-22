import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Node {
    boolean isClient;
    int number;
    Map<Node, Integer> connections;

    public boolean isClient() {
        return isClient;
    }

    public void setClient(boolean client) {
        isClient = client;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Map<Node, Integer> getConnections() {
        if(connections == null){
            connections = new HashMap<>();
        }
        return connections;
    }

    public void setConnections(Map<Node, Integer> connections) {
        this.connections = connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getNumber() == node.getNumber();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNumber());
    }
}
