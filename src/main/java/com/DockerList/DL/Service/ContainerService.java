package com.DockerList.DL.Service;

import com.DockerList.DL.Logic.ScriptRunner;
import com.DockerList.DL.Model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class ContainerService {
    private List<Container> containers;
    ScriptRunner sc = new ScriptRunner();

    @Autowired
    public ContainerService(List<Container> containers) {
        this.containers = containers;
    }

    public void updateContainers() {
        List<Container> newContainers = sc.getContainers();
        if (newContainers != null) {
            this.containers = newContainers;
        }
    }

    public List<Container> getContainers() {
        updateContainers();
        return containers;
    }

    public void toggleContainer(String id, String stat) {
        if (stat.equals("active")) {
            sc.stopContainer(id);
        } else if (stat.equals("sleeping")) {
            sc.startContainer(id);
        }
    }
}
