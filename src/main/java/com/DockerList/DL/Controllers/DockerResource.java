package com.DockerList.DL.Controllers;

import com.DockerList.DL.Service.ContainerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.ApplicationScope;

@Controller
@ApplicationScope
public class DockerResource {
    public final ContainerService containerService;

    public DockerResource(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping("/feed")
    public String feed(Model model) {
        model.addAttribute("containers", containerService.getContainers());
        return "feed";
    }
}
