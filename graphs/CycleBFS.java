import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CycleBFS {
     static class Edge{
          int src;
          int dest;
          int wt;
          public Edge(int s,int d,int w){
               src=s;
               dest=d;
               wt=w;
          }
     }
     public static void createGraph(ArrayList<Edge>[] graph){
          
          
          for(int i=0;i<graph.length;i++){
               graph[i]=new ArrayList<>();
          }
          
          graph[0].add(new Edge(0, 1, 1));
          graph[0].add(new Edge(0, 2, 1));
          

          graph[1].add(new Edge(1, 0, 1));
          graph[1].add(new Edge(1, 2, 1));

          graph[2].add(new Edge(2, 0, 1));
          graph[2].add(new Edge(2, 1, 1));

     }
     public static boolean cycleExist(ArrayList<Edge>[] graph){
          boolean[] vis=new boolean[graph.length];
          for(int i=0;i<graph.length;i++){
               if (!vis[i]) {
                    if (cycleExistUtil(graph,i,vis)) {
                         return true;
                    }
               }
               
          }
          return false;
     }
     public static boolean cycleExistUtil(ArrayList<Edge>[] graph,int curr,boolean vis[]){
          Queue<Integer> q=new LinkedList<>();
          q.add(curr);
          int par[]=new int[graph.length];
          Arrays.fill(par, -1);
          while (!q.isEmpty()) {
               curr=q.remove();
               for(int i=0;i<graph[curr].size();i++){
                    Edge e=graph[curr].get(i);
                    if (!vis[e.dest]) {
                         vis[e.dest]=true;
                         par[e.dest]=curr;
                         q.add(e.dest);
                    }
                    else if(par[curr]!=e.dest){
                         return true;
                    }
               }
          }
          return false;
     }
     public static void main(String[] args) {
          int V=7;
          ArrayList<Edge>[] graph=new ArrayList[V];
          createGraph(graph);
          
          System.out.println(cycleExist(graph));
     }
}
