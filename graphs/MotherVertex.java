import java.util.*;
public class MotherVertex {
     static class Edge{
          int src;
          int dest;
          
          public Edge(int s,int d){
               src=s;
               dest=d;
               
          }
     }
     public static void createGraph(ArrayList<Edge>[] graph){
          
          
          for(int i=0;i<graph.length;i++){
               graph[i]=new ArrayList<>();
          }
          
          graph[0].add(new Edge(0, 2));
          graph[0].add(new Edge(0, 1));

          
          

         
          

          graph[3].add(new Edge(3, 4));
          graph[3].add(new Edge(3, 0));
          
     }
     public static boolean bfs(ArrayList<Edge>[] graph,int idx){
          Queue<Integer> q=new LinkedList<>();
          boolean vis[]=new boolean[graph.length];
          q.add(idx);
          int count=0;
          while (!q.isEmpty()) {
               int curr=q.remove();
               if (!vis[curr]) {
                    vis[curr]=true;
                    count++;
                    for(int i=0;i<graph[curr].size();i++){
                         Edge e=graph[curr].get(i);
                         q.add(e.dest);
                    }
               }
          }
          return count==graph.length;
     }
     public static void main(String[] args) {
          int V=5;
          ArrayList<Edge>[] graph=new ArrayList[V];
          createGraph(graph);
          
          for(int i=0;i<V;i++){
               if(bfs(graph,i)){
                    System.out.println(i);
                    break;
               }
          }
     }
}
