package scalajsplugintest

import org.junit.Test
import org.junit.Assert.assertNull

class NullTestJs {
  @Test
  def nilTest = {
    assertNull(Null.nil)
  }
}
