package com.infy.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.infy.service com.infy.repository")
public class SpringConfig {
}
