// Digraph.java
//
// Simple class to represent a directed graph.

public class Digraph
{
    private boolean[][] edge;

    public Digraph(int numNodes)
    {
        edge = new boolean[numNodes][numNodes];

        // By default, all boolean array values are false,
        // so there are no edges in the graph.
    }

    public int getNumVertices()
    {
        return edge.length;
    }

    public int getNumEdges()
    {
        int edgesCount = 0;

        for (int row = 0; row < edge.length; row++)
        {
            for (int col = 0; col < edge[0].length; col++)
            {
                if (edge[row][col])
                    edgesCount++;
            }
        }

        return edgesCount++;

    }

    public void addEdge(int i, int j)
    {
        if (0 <= i && i < edge.length
            && 0 <= j && j < edge.length)
            edge[i][j] = true;
    }

    public void removeEdge(int i, int j)
    {
        if (0 <= i && i < edge.length
            && 0 <= j && j < edge.length)
            edge[i][j] = false;
    }

    public boolean hasEdge(int i, int j)
    {
        boolean result;
        if (0 <= i && i < edge.length
            && 0 <= j && j < edge.length)
            result = edge[i][j];
        else
            result = false;
        return result;
    }

    public int getInDegree(int vertex)
    {
        int count = 0;

        for (int row = 0; row < edge.length; row++)
        {
            if (edge[row][vertex])
                count++;
        }

        return count;
    }

    public int getOutDegree(int vertex)
    {
        int count = 0;

        for (int col = 0; col <edge[0].length; col++)
        {
            if (edge[vertex][col])
                count++;
        }

        return count;

    }

    public boolean isSource(int vertex)
    {
        boolean source = false;

        if (getInDegree(vertex) == 0)
        {
            source = true;
        }

        return source;
    }

    public boolean isSink(int vertex)
    {
        boolean sink = false;

        if (getOutDegree(vertex) == 0)
        {
            sink = true;
        }

        return sink;

    }

    public String toString()
    {
        String result = "";
        for (int i = 0; i < edge.length; i++)
        {
            for (int j = 0; j < edge[i].length; j++)
                if (edge[i][j])
                    result += "T ";
                else
                    result += "  ";
            result += "\n";
        }

        return result;
    }
}
