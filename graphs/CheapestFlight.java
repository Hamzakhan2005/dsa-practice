import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.sound.sampled.DataLine.Info;

public class CheapestFlight {
     static class Edge{
          int src;
          int dest;
          int wt;
          Edge(int s,int d,int w){
               src=s;
               dest=d;
               wt=w;
          }
     }
     public static void createGraph(ArrayList<Edge>[] graph,int flights[][]){
          for(int i=0;i<graph.length;i++){
               graph[i]=new ArrayList<>();
          }

          for(int i=0;i<flights.length;i++){
               Edge e=new Edge(flights[i][0],flights[i][1], flights[i][2]);
               graph[flights[i][0]].add(e);
          }

     }
     static class Info{
          int v;
          int stop;
          int cost;
          Info(int v,int s,int c){
               this.v=v;
               stop=s;
               cost=c;
          }
     }
     public static int cheapestFlight(int n,int flights[][],int src,int dest,int k){
          ArrayList<Edge>[] graph=new ArrayList[n];
          createGraph(graph, flights);

          int dist[]=new int[n];
          for(int i=0;i<n;i++){
               if(i!=src){
                    dist[i]=Integer.MAX_VALUE;
               }
          }

          Queue<Info> q=new LinkedList<>();
          q.add(new Info(src, 0, 0));

          while (!q.isEmpty()) {
               Info curr=q.remove();
               if (curr.stop>k) {
                    break;
               }

               for(int i=0;i<graph[curr.v].size();i++){
                    Edge e=graph[curr.v].get(i);
                    if( curr.cost+e.wt<dist[e.dest] && curr.stop<=k){
                         dist[e.dest]=curr.cost+e.wt;
                         q.add(new Info(e.dest, curr.stop+1, dist[e.dest]));
                    }
               }
          }
          if(dist[dest]==Integer.MAX_VALUE){
               return -1;
          }else{
               return dist[dest];
          }
     }
     public static void main(String[] args) {
          int n=4;
          int flights[][]={{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
          int src=0,dest=3,k=1;
          System.out.print(cheapestFlight(n, flights, src, dest, k));
     }
}
