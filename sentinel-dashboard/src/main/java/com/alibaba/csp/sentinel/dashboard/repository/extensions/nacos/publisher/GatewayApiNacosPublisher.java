/*
 * Copyright 1999-2018 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.csp.sentinel.dashboard.repository.extensions.nacos.publisher;

import com.alibaba.csp.sentinel.dashboard.config.rule.NacosRuleProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.ApiDefinitionEntity;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.gateway.GatewayFlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.repository.extensions.nacos.NacosRuleUtils;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.nacos.api.config.ConfigService;

import java.util.List;

/**
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 1.8.2
 */
public class GatewayApiNacosPublisher extends NacosPublisherTemplate<ApiDefinitionEntity> {

	private final NacosRuleProperties nacosRuleProperties;

	public GatewayApiNacosPublisher(
		NacosRuleProperties nacosRuleProperties,
		ConfigService configService,
		Converter<List<ApiDefinitionEntity>, String> converter) {
		super(nacosRuleProperties, configService, converter);
		this.nacosRuleProperties = nacosRuleProperties;
	}

	@Override
	public String getDataId(String app) {
		return NacosRuleUtils.getDataId(app, nacosRuleProperties.getDataIdSuffix().getGatewayApi());
	}
}
