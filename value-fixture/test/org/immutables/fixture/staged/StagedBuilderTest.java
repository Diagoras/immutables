package org.immutables.fixture.staged;

import org.junit.Test;

public class StagedBuilderTest {

  @SuppressWarnings("CheckReturnValue")
  @Test
  public void canBuildWithDeepImmutablesDetection() {
    ImmutableStagedDeep staged =
      ImmutableStagedDeep.builder()
                         .a("Test")
                         .b(ImmutableStringWrapper.of("Another test"), 42)
                         .build();

    StringWrapper stringWrapper = staged.a();

    ImmutableStagedDeep.builder()
                       .a(stringWrapper)
                       .b(stringWrapper, -42)
                       .c("So many tests")
                       .build();
  }
}
