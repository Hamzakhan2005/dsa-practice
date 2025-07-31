import java.util.ArrayList;

public class CycleDFS {
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
          graph[0].add(new Edge(0, 3, 1));

          graph[1].add(new Edge(1, 0, 1));
          graph[1].add(new Edge(1, 2, 1));

          graph[2].add(new Edge(2, 0, 1));
          graph[2].add(new Edge(2, 1, 1));

          graph[3].add(new Edge(3, 4, 1));
          

          graph[4].add(new Edge(4,3, 1));
     }
     
     
     public static boolean cycleExist(ArrayList<Edge>[] graph){
          boolean vis[]=new boolean[graph.length];
          for(int i=0;i<graph.length;i++){
               if (!vis[i]) {
                    if(cycleUtil(graph,i,-1,vis)){
                         return true;
                    }
               }
          }
          return false;
     }
     public static boolean cycleUtil(ArrayList<Edge>[] graph,int curr,int par,boolean vis[]){
          
          vis[curr]=true;
          for(int i=0;i<graph[curr].size();i++){
               Edge e=graph[curr].get(i);
               if (!vis[e.dest]) {
                    if(cycleUtil(graph, e.dest,curr, vis))
                    return true;
               }else if(vis[e.dest]==true && par!=e.dest){
                    return true;
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
