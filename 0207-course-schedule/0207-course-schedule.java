// Main Masala: Here we are using Topological Sort, and the prerequisites of Topological Sort are:
// 1) The Graph should be Directed (hence, we will connect the courses as nodes according the prerequisite constraint). Thus all the courses will be connected Linearly.
// 2) Also, the Graph should not have cycles.
// Thus in short we can say, we can apply Topological Sort only in DAGs.

// Now, the idea is: First, we will form the Graph using all the courses according the Prerequisite constraint.
// Second, we do Topological Sort of that Graph and if we see that in the sorted order there are all the courses, it means there was No Cycle. And hence, all the courses can be completed.
// And 1 extra Thing: if it was asked to return the correct order, then just return the array storing the Topological Sorting order.

// Thus note: if in any problem it is asked that "something before something" always use Topological Sort after converting the problem into Graph.


class Solution 
{
    public boolean canFinish(int numCourses, int[][] prerequisites) 
    {
        //Form the Graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i < numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;

        for(int i=0; i < m; i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int indegree[] = new int[numCourses];

        for(int i=0; i < numCourses; i++)
        {
            for(int it : adj.get(i))
            {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=0; i < numCourses; i++)
        {
            if(indegree[i] == 0)
            q.add(i);
        }

        List<Integer> topo = new ArrayList<Integer>();

        //TC: O(V+E)

        while(!q.isEmpty())
        {
            int node = q.peek();

            q.remove();
            topo.add(node);

            //Node is in your Topo Sort, hence remove it from the Indegree

            for(int it : adj.get(node))
            {
                indegree[it]--;
                if(indegree[it] == 0)
                q.add(it);
            }
        }

        if(topo.size() == numCourses)
        return true;

        return false;
    }
}