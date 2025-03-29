package com.DockerList.DL.Logic;

import com.DockerList.DL.Model.Container;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class ScriptRunner {
    public List<Container> getContainers(){
        Parser parser = new Parser();
        try {
            ProcessBuilder pb = new ProcessBuilder("docker", "ps", "-a");
            Process process = pb.start();
            process.waitFor();
            File outputFile = new File("src/main/java/com/DockerList/DL/Scripts/output.txt");
            return parser.parseContainersList(outputFile);

            //TODO delete output file, replace with stream
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}