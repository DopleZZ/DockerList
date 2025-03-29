package com.DockerList.DL.Enums;

public enum CommandEnum {
    START("docker start"),
    STOP("docker stop"),
    LIST("docker ps -a");

    private final String command;

    CommandEnum(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }
}
