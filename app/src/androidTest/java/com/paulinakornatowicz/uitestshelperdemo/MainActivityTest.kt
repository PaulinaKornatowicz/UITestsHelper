package com.paulinakornatowicz.uitestshelperdemo

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.paulinakornatowicz.uitestshelper.matchers.visibility.assertViewDisplayed
import com.paulinakornatowicz.uitestshelper.matchers.visibility.assertViewDoesNotExist
import com.paulinakornatowicz.uitestshelper.matchers.visibility.assertViewNotDisplayed
import com.paulinakornatowicz.uitestshelper.rules.DisableAnimationsRule
import com.paulinakornatowicz.uitestshelper.rules.IdlingResourcesRule
import com.paulinakornatowicz.uitestshelper.rules.MockWebServerRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestName
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val name = TestName()

    @Rule
    @JvmField
    val disableAnimationsRule = DisableAnimationsRule()

    @Rule
    @JvmField
    val idleResourcesRule = IdlingResourcesRule {
        "MainActivityTest"
    }

    @Rule
    @JvmField
    val mockWebServerRule = MockWebServerRule({
        name.methodName
    })

    private lateinit var accountViewScenario: ActivityScenario<MainActivity>


    @Before
    fun beforeSetup() {
        accountViewScenario = ActivityScenario.launch(Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java))
    }


    @Test
    fun mainActivityTest() {
        assertViewDisplayed(R.id.helloWorldText)
        assertViewNotDisplayed(R.id.invisibleHelloWorldText)
        assertViewNotDisplayed(R.id.goneHelloWorldText)
        assertViewDoesNotExist(R.id.dummyTextView)
    }
}