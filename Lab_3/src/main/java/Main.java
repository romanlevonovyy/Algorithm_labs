
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<Integer, Node> nodes = new HashMap<>();
    private static Map<Integer, Map<Integer, Integer>> result = new HashMap<>();

    public static void main(String[] args){
        int nodesCount = 6;
        int clients[] = {1, 2, 6};
        int connections[][] = {
                {1, 3, 10},
                {3, 4, 80},
                {4, 5, 50},
                {5, 6, 20},
                {2, 3, 40},
                {2, 4, 100}
        };

//        int nodesCount = 9;
//        int clients[] = {2, 4, 6};
//        int connections[][] = {
//                {1, 2, 20},
//                {2, 3, 20},
//                {3, 6, 20},
//                {6, 9, 20},
//                {9, 8, 20},
//                {8, 7, 20},
//                {7, 4, 20},
//                {4, 1, 20},
//                {5, 2, 10},
//                {5, 4, 10},
//                {5, 6, 10},
//                {5, 8, 10}
//        };

/*
		int nodesCount = 3;
        int clients[] = {1, 3};
        int connections[][] = {
                {1, 2, 50},
                {2, 3, 1000000000}
        };*/


        for(int i = 0; i < nodesCount; i++){
            Node node = new Node();
            node.setClient(false);
            node.setNumber(i+1);
            nodes.put(node.getNumber(), node);
        }

        for(int clientNumber: clients){
            nodes.get(clientNumber).setClient(true);
        }

        for(int connection[]: connections){
            Node start = nodes.get(connection[0]);
            Node end = nodes.get(connection[1]);
            start.getConnections().put(end, connection[2]);
            end.getConnections().put(start, connection[2]);
        }

        for(Node node: nodes.values()){
            if(!node.isClient()){
                for(Node clientNode: nodes.values()){
                    if(clientNode.isClient()){
                        findWay(clientNode.getNumber(), new HashSet<Integer>(), clientNode.getNumber(), node.getNumber(), 0);
                    }
                }
            }
        }

        int	bestServer = -1;
        int minPing = -1;
        for(int point: result.keySet()) {
            Map<Integer, Integer> clientsPings = result.get(point);
            int maxNodePing = 0;
            for (int client: clientsPings.keySet()) {
                Integer clientPing = clientsPings.get(client);
                if (clientPing > maxNodePing) {
                    maxNodePing = clientPing;
                }
            }
            if (minPing == -1 || minPing > maxNodePing) {
                bestServer = point;
                minPing = maxNodePing;
            }
        }
        System.out.println("Best node: " + bestServer);
        System.out.println("Max server ping:" + minPing);

    }

    private static void findWay(int startPoint, Set<Integer> previousPoints, int currentPoint, int endPoint, int sum) {
        Node currentNode = nodes.get(currentPoint);
        for (Node node : currentNode.getConnections().keySet()) {
            int currentSum = sum;
            if (!previousPoints.contains(node.getNumber())) {
                currentSum += currentNode.getConnections().get(node);
                if (endPoint == node.getNumber()) {
                    printResult(currentSum, startPoint, endPoint);
                    currentSum -= currentNode.getConnections().get(node);
                } else {
                    Set<Integer> newSet = new HashSet<>(previousPoints);
                    newSet.add(currentPoint);
                    findWay(startPoint, newSet, node.getNumber(), endPoint, currentSum);
                }
            }
        }
    }

    private static void printResult(int sum, int start, int end) {
        System.out.println(start + " - " + end + " " + sum);
        if (!result.containsKey(end)) {
            result.put(end, new HashMap<Integer, Integer>());
        }
        if (!result.get(end).containsKey(start) || result.get(end).get(start) > sum) {
            result.get(end).put(start, sum);
        }
    }
}
