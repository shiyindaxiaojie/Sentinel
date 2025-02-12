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
package com.alibaba.csp.sentinel.dashboard.rule.zookeeper;

import com.alibaba.csp.sentinel.dashboard.config.rule.ZookeeperRuleProperties;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.ParamFlowRuleEntity;
import com.alibaba.csp.sentinel.datasource.Converter;
import org.apache.curator.framework.CuratorFramework;

import java.util.List;

/**
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 1.8.2
 */
public class ParamFlowRuleZookeeperProvider extends ZookeeperProviderTemplate<ParamFlowRuleEntity> {

	private final ZookeeperRuleProperties zookeeperRuleProperties;

	public ParamFlowRuleZookeeperProvider(
		ZookeeperRuleProperties zookeeperRuleProperties,
		CuratorFramework zkClient,
		Converter<String, List<ParamFlowRuleEntity>> converter) {
		super(zookeeperRuleProperties, zkClient, converter);
		this.zookeeperRuleProperties = zookeeperRuleProperties;
	}

	@Override
	public String getPath(String app) {
		return ZookeeperRuleUtils.getPath(zookeeperRuleProperties.getRootPath(), app,
			zookeeperRuleProperties.getRulePath().getParamFlowRule());
	}
}
