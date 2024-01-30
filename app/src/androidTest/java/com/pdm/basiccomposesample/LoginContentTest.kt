package com.pdm.basiccomposesample

import androidx.activity.compose.setContent
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.pdm.basiccomposesample.login.AuthenticationState
import com.pdm.basiccomposesample.login.LoginContent
import com.pdm.basiccomposesample.ui.theme.BasicComposeSampleTheme
import com.pdm.basiccomposesample.util.TestTags
import org.junit.Rule
import org.junit.Test

class LoginContentTest {

    @get:Rule
    val composableRuleTest = createAndroidComposeRule<MainActivity>()

    private fun initCompose() {
        composableRuleTest.activity.setContent {
            BasicComposeSampleTheme {
                LoginContent(
                    uiState = AuthenticationState.EMPTY_STATE,
                    onUsernameUpdated = {},
                    onPasswordUpdated = {},
                    onLogin = { /*TODO*/ },
                    passwordToggleVisibility = { }
                ) {

                }
            }
        }
    }

    @Test
    fun assertSignInButtonIsDisplayed() {
        initCompose()
        composableRuleTest.onNodeWithTag(TestTags.LoginContent.SIGN_IN_BUTTON, true).assertIsDisplayed()
    }

    @Test
    fun assertInputFieldIsDisplayed() {
        initCompose()
        composableRuleTest.onNodeWithTag(TestTags.LoginContent.USERNAME_FIELD, true).assertIsDisplayed()
    }
}