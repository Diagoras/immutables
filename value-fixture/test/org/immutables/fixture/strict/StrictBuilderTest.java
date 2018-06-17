/*
   Copyright 2015 Immutables Authors and Contributors

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.immutables.fixture.strict;

import com.google.common.base.Optional;
import org.junit.Test;

public class StrictBuilderTest {
  @SuppressWarnings("CheckReturnValue")
  @Test(expected = IllegalStateException.class)
  public void noReassignment() {
    ImmutableAar.builder()
        .integer(1)
        .integer(2)
        .bl(true)
        .build();
  }

  @SuppressWarnings("CheckReturnValue")
  @Test(expected = IllegalStateException.class)
  public void noReassignmentOptional() {
    ImmutableBar.builder()
        .opt(1)
        .opt(Optional.absent())
        .build();
  }

  @SuppressWarnings("CheckReturnValue")
  @Test
  public void canBuildWithDeepImmutablesDetection() {
    ImmutableStrictDeep staged =
      ImmutableStrictDeep.builder()
                         .a("Test")
                         .b(ImmutableStringWrapper.of("Another test"), 42)
                         .build();

    StringWrapper stringWrapper = staged.a();

    ImmutableStrictDeep.builder()
                       .a(stringWrapper)
                       .b(stringWrapper, -42)
                       .c("So many tests")
                       .build();
  }
}
