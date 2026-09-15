package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.PortfolioRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("Umm-e-Aimen Portfolio", appName)
  }

  @Test
  fun `verify portfolio repository content`() {
    assertEquals("UMM-E-AIMEN", PortfolioRepository.FULL_NAME)
    assertEquals("Lahore, Pakistan", PortfolioRepository.LOCATION)
    assertEquals("ummeaimen368@gmail.com", PortfolioRepository.EMAIL)
    assertEquals(7, PortfolioRepository.PROJECTS.size)
    assertEquals(6, PortfolioRepository.SKILLS.size)
    assertEquals(2, PortfolioRepository.EDUCATION.size)
    assertEquals(2, PortfolioRepository.ACHIEVEMENTS.size)
    assertEquals(5, PortfolioRepository.COMPETENCIES.size)
  }
}
