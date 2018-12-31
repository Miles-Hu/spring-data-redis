package com.miles.springdataredis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Miles Hoo
 * @version v1.0.0
 * @since 18-12-31 下午5:06
 */
@Component
@ConfigurationProperties(prefix="spring.redis.cluster")
public class RedisClusterConfigProperties {
    /**
     * master nodes
     */
    //@Value("${spring.redis.cluster.nodes}")
    private List<String> nodes;

    /**
     * max redirects
     */
    //@Value("${spring.redis.cluster.max-redirects}")
    private String maxRedirects;

    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public String getMaxRedirects() {
        return maxRedirects;
    }

    public void setMaxRedirects(String maxRedirects) {
        this.maxRedirects = maxRedirects;
    }
}
