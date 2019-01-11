/**
 * Copyright (c) 2012-2019 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.corundumstudio.socketio.store;

import io.netty.util.internal.PlatformDependent;

import java.util.Map;

public class MemoryStore implements Store {

    private final Map<String, Object> store = PlatformDependent.newConcurrentHashMap();

    @Override
    public void set(String key, Object value) {
        store.put(key, value);
    }

    @Override
    public <T> T get(String key) {
        return (T) store.get(key);
    }

    @Override
    public boolean has(String key) {
        return store.containsKey(key);
    }

    @Override
    public void del(String key) {
        store.remove(key);
    }

}
