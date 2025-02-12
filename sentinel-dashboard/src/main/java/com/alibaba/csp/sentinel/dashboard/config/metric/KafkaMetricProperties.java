package com.alibaba.csp.sentinel.dashboard.config.metric;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Kafka 监控配置
 *
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 1.8.2
 */
@Setter
@Getter
@ConfigurationProperties(prefix = KafkaMetricProperties.PREFIX)
public class KafkaMetricProperties {

	public static final String PREFIX = "sentinel.metrics.sender.kafka";

	private String topic = "sentinel_metric";
}
