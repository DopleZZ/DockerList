package com.DockerList.DL.Model;

public class Container {
    private String container_id;
    private String image;
    private String command;
    private String created;
    private String status;
    private String ports;
    private String names;
    private String stat;

    public Container(String container_id, String image, String command, String created, String status, String ports, String names, String stat) {
        this.container_id = container_id;
        this.image = image;
        this.command = command;
        this.created = created;
        this.status = status;
        this.ports = ports;
        this.names = names;
        this.stat = stat;
    }

    public String getContainer_id() { return container_id; }
    public String getImage() { return image; }
    public String getCommand() { return command; }
    public String getCreated() { return created; }
    public String getStatus() { return status; }
    public String getPorts() { return ports; }
    public String getNames() { return names; }
    public String getStat() { return stat; }

    public void setContainer_id(String container_id) { this.container_id = container_id; }
    public void setImage(String image) { this.image = image; }
    public void setCommand(String command) { this.command = command; }
    public void setCreated(String created) { this.created = created; }
    public void setStatus(String status) { this.status = status; }
    public void setPorts(String ports) { this.ports = ports; }
    public void setNames(String names) { this.names = names; }
    public void setStat(String stat) { this.stat = stat; }

    @Override
    public String toString() {
        return String.format(
                "{\"container_id\":\"%s\", \"image\":\"%s\", \"command\":\"%s\", \"created\":\"%s\", \"status\":\"%s\", \"ports\":\"%s\", \"names\":\"%s\"}",
                container_id, image, command, created, status, ports, names);
    }
}