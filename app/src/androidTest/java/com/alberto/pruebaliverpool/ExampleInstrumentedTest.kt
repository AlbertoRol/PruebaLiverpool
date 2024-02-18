package com.alberto.pruebaliverpool

import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import androidx.navigation.testing.TestNavHostController
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.alberto.pruebaliverpool.presentation.view.MainActivity
import com.alberto.pruebaliverpool.presentation.view.navigation.AppNavigation
import com.alberto.pruebaliverpool.presentation.view.order.OrderProductActivity
import com.alberto.pruebaliverpool.presentation.view.product.ProductActivity
import com.alberto.pruebaliverpool.presentation.view.product.SearchView
import com.alberto.pruebaliverpool.presentation.viewmodel.ProductViewModel
import com.alberto.pruebaliverpool.presentation.theme.PruebaLiverpoolTheme

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule  = createAndroidComposeRule<MainActivity>()
    private lateinit var navController: TestNavHostController

    @Test
    fun useAppContext() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.alberto.pruebaliverpool", appContext.packageName)
    }

    @Test
    fun greeting_composable_component_test(){
        composeTestRule.activity.setContent {
            PruebaLiverpoolTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        AppNavigation()
                    }
                }
            }
        }
    }

    @Test
    fun searchViewTest(){
        composeTestRule.activity.setContent { SearchView(
            navController = navController
        )}
    }
    
    @Test
    fun productViewTest(){
        composeTestRule.activity.setContent {
            val testmodel = composeTestRule.activity.viewModels<ProductViewModel>().value
            ProductActivity(navController = navController, productViewModel = testmodel)
        }
    }

    @Test
    fun orderViewTest(){
        composeTestRule.activity.setContent {
            val testmodel = composeTestRule.activity.viewModels<ProductViewModel>().value
            OrderProductActivity(navController = navController, productViewModel = testmodel, "xbox")
        }
    }

}