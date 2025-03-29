package com.DockerList.DL.Logic;

import com.DockerList.DL.Model.Container;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<Container> parseContainersList(File file) throws FileNotFoundException {
        List<Container> containers = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String header = reader.readLine();
            if (header == null || header.isEmpty()) return containers;
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.trim().split("\\s{2,}");
                if (parts.length != 7) {
                    containers.add(new Container(
                            parts[0],
                            parts[1],
                            parts[2],
                            parts[3],
                            parts[4],
                            "none",
                            parts[5]
                    ));
                } else {
                    containers.add(new Container(
                            parts[0],
                            parts[1],
                            parts[2],
                            parts[3],
                            parts[4],
                            parts[5],
                            parts[6]
                    ));
                    //ToDo destroy ^
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return containers;
    }
}
