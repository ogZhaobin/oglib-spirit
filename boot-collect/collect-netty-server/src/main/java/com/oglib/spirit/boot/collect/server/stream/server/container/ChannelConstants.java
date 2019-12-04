package com.oglib.spirit.boot.collect.server.stream.server.container;

public class ChannelConstants {

    public enum ChannelOption{
        PUT("put"),
        GET("get"),
        REMOVE("remove");
        ChannelOption(String option){
            this.option = option;
        }
        private String option;

        public String getOption() {
            return option;
        }
    }

}
