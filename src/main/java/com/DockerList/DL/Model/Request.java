package com.DockerList.DL.Model;

public class Request {
    private String container_id;
    private String stat;

    public String getContainer_id() { return container_id; }
    public String getStat() { return stat; }

    public void setContainer_id(String container_id) { this.container_id = container_id; }
    public void setStat(String stat) { this.stat = stat; }
}
