/*-
 * #%L
 * Bobcat
 * %%
 * Copyright (C) 2016 Cognifide Ltd.
 * %%
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
 * #L%
 */
package com.cognifide.qa.bb.junit.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Internal thread factory class for creating threads that execute tests.
 */
final class NamedThreadFactory implements ThreadFactory {

  private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);

  private final AtomicInteger threadNumber = new AtomicInteger(1);

  private final ThreadGroup group;

  /**
   * Constructs the factory. Creates new thread group.
   *
   * @param poolName Name of the thread pool.
   */
  NamedThreadFactory(String poolName) {
    group = new ThreadGroup(poolName + "-" + POOL_NUMBER.getAndIncrement());
  }

  /**
   * @return New thread instance, added to the thread group associated with this factory, with autogenerated
   * name.
   */
  @Override
  public Thread newThread(Runnable r) {
    return new Thread(group, r, group.getName() + "-thread-" + threadNumber.getAndIncrement(), 0);
  }
}
