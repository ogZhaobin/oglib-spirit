package com.oglib.spirit.boot.cloud.pms.content.configuration;

import org.springframework.cloud.netflix.ribbon.RibbonClients;
import ribbonconfiguration.RibbonConfiguration;

@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
public class PmsContentRibboConfiguration {
}
