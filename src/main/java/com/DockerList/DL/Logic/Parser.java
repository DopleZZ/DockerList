package com.DockerList.DL.Logic;

import com.DockerList.DL.Model.Container;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Container> parseContainersList(List<String> lines) throws FileNotFoundException {
        List<Container> containers = new ArrayList<>();
        for (int i =1; i<lines.size(); i++) {
            String line = lines.get(i).trim();
            String[] parts = line.split("\\s{2,}");
                if (parts.length != 7) {
                    containers.add(new Container(
                            parts[0],
                            parts[1],
                            parts[2],
                            parts[3],
                            parts[4],
                            "none",
                            parts[5],
                            (parts[4].contains("Up")) ? "active" : "sleeping"
                    ));
                } else {
                    containers.add(new Container(
                            parts[0],
                            parts[1],
                            parts[2],
                            parts[3],
                            parts[4],
                            parts[5],
                            parts[6],
                            (parts[4].contains("Up")) ? "active" : "sleeping"

                    ));
                    //ToDo destroy ^
                }
            }
        return containers;
    }
}
