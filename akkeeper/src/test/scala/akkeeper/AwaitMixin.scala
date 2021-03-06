/*
 * Copyright 2017 Iaroslav Zeigerman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package akkeeper

import scala.concurrent.{Await, Awaitable}
import scala.concurrent.duration._

trait AwaitMixin {

  protected implicit val awaitTimeout = 6 seconds

  protected def await[T](awaitable: Awaitable[T])
                        (implicit duration: Duration): T = {
    Await.result(awaitable, duration)
  }
}
