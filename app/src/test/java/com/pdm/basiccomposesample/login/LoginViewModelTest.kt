package com.pdm.basiccomposesample.login

import androidx.lifecycle.SavedStateHandle
import app.cash.turbine.test
import com.google.common.truth.Truth
import com.pdm.basiccomposesample.util.SampleLoginDispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class LoginViewModelTest {

    private lateinit var loginViewModel: LoginViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        loginViewModel = LoginViewModel(
            dispatchers = SampleLoginDispatchers.createTestDispatchers(UnconfinedTestDispatcher()),
            stateHandle = SavedStateHandle()
        )
    }

    @Test
    fun `test authentication state change` () = runTest {
        with(loginViewModel) {
            userNameChanged("Madonna")
            passwordChanged("home")
            passwordVisibility(true)
            state.test {
                val stateChange = awaitItem()
                Truth.assertThat(stateChange).isEqualTo(
                    AuthenticationState(
                        userName = "Madonna",
                        password = "home",
                        togglePasswordVisibility = true
                    )
                )
            }
        }
    }
}