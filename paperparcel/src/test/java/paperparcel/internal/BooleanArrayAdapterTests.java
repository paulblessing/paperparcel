package paperparcel.internal;

import paperparcel.TypeAdapter;
import paperparcel.utils.TestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static com.google.common.truth.Truth.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = Config.NONE)
public class BooleanArrayAdapterTests {
  @Test public void booleanArraysAreCorrectlyParcelled() {
    TypeAdapter<boolean[]> adapter = StaticAdapters.BOOLEAN_ARRAY_ADAPTER;
    boolean[] expected = new boolean[] { true, false };
    boolean[] result = TestUtils.writeThenRead(adapter, expected);
    assertThat(result).isEqualTo(expected);
  }
}
