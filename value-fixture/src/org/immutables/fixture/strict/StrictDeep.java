package org.immutables.fixture.strict;

import java.util.Optional;

import org.immutables.value.Value;

@Value.Immutable
public interface StrictDeep {

  StringWrapper a();

  WrapperIntTuple b();

  Optional<StringWrapper> c();
}

@Value.Immutable(builder = false)
@Value.Style(allParameters = true, deepImmutablesDetection = true)
interface WrapperIntTuple {

  StringWrapper first();

  int second();
}

@Value.Immutable(builder = false)
@Value.Style(allParameters = true)
interface StringWrapper {

  String wrapped();
}

