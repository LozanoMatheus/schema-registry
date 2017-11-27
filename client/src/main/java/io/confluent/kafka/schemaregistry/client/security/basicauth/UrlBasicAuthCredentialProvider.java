/*
 * Copyright 2017 Confluent Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.confluent.kafka.schemaregistry.client.security.basicauth;

import java.net.URL;
import java.util.Map;

public class UrlBasicAuthCredentialProvider implements BasicAuthCredentialProvider {

  protected static final String SCHEMA_REGISTRY_USER_INFO = "schema.registry.url.user.info";

  private String userInfo;

  @Override
  public void configure(Map<String, ?> configs) {
    userInfo = (String) configs.get(SCHEMA_REGISTRY_USER_INFO);
  }

  @Override
  public String getUserInfo(URL url) {
    if (userInfo != null && !userInfo.isEmpty()) {
      return userInfo;
    } else {
      return url.getUserInfo();
    }
  }
}