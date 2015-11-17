package com.kiblerdude.dijkstra;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Dijkstra's Shortest Path Algorithm
 *
 */
public class Dijkstra 
{
    public static void main( String[] args ) throws IOException
    {
        Files.newBufferedReader(Paths.get("dijkstraData.txt"));
    }
}
