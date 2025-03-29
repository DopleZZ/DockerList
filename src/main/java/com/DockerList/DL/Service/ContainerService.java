package com.DockerList.DL.Service;

import com.DockerList.DL.Logic.ScriptRunner;
import com.DockerList.DL.Model.Container;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
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

    public Container ContainerById(String id) {
        for (Container container : containers) {
            if (container.getContainer_id().equals(id)) {
                return container;
            }
        }
        return null;
    }
}
