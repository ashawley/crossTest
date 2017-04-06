package scalajsplugintest

import org.junit.Test
import org.junit.Assert.assertNull

class NullTest {
  @Test
  def nilTest = {
    assertNull(Null.nil)
  }
}
