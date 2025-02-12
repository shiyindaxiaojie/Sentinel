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
package com.alibaba.csp.sentinel.dashboard.rule.memory;

import com.alibaba.csp.sentinel.dashboard.client.SentinelApiClient;
import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.discovery.AppManagement;

import java.util.List;

/**
 * @author <a href="mailto:shiyindaxiaojie@gmail.com">gyl</a>
 * @since 1.8.2
 */
public class FlowRuleMemoryProvider extends MemoryProviderTemplate<FlowRuleEntity> {

	private final SentinelApiClient sentinelApiClient;

	public FlowRuleMemoryProvider(AppManagement appManagement, SentinelApiClient sentinelApiClient) {
		super(appManagement);
		this.sentinelApiClient = sentinelApiClient;
	}

	@Override
	public List<FlowRuleEntity> getRules(String app, String ip, int port) throws Exception {
		return sentinelApiClient.fetchFlowRuleOfMachine(app, ip, port);
	}
}
