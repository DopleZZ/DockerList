package com.DockerList.DL.Controllers;

import com.DockerList.DL.Model.Request;
import com.DockerList.DL.Service.ContainerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.ApplicationScope;
import java.util.Map;

@ApplicationScope
@RestController
public class ManageContoller {
    public final ContainerService containerService;

    public ManageContoller(ContainerService containerService) {
        this.containerService = containerService;
    }

    @PostMapping("/toggle")
    public Map<String, Boolean> toggle(@RequestBody Request request) {
        String id = request.getContainer_id();
        String stat = request.getStat();
        containerService.toggleContainer(id, stat);
        return Map.of("success", true);
    }
}
