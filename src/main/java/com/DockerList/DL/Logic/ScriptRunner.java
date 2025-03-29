package com.DockerList.DL.Logic;

import com.DockerList.DL.Model.Container;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ScriptRunner {
    public List<Container> getContainers(){
        Parser parser = new Parser();
        List<String> outputLines = new ArrayList<>();
        try {
            ProcessBuilder pb = new ProcessBuilder("docker", "ps", "-a");
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String line;
            while ((line = reader.readLine()) != null) {
                outputLines.add(line);
            }
            process.waitFor();
            return parser.parseContainersList(outputLines);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}