package com.example.r2mbrands

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material.icons.filled.Route
import androidx.compose.material.icons.filled.ShoppingBag
import androidx.compose.material.icons.outlined.Business
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Route
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.r2mbrands.ui.components.R2MTopBar
import com.example.r2mbrands.ui.screens.AboutScreen
import com.example.r2mbrands.ui.screens.ApproachScreen
import com.example.r2mbrands.ui.screens.ContactScreen
import com.example.r2mbrands.ui.screens.HomeScreen
import com.example.r2mbrands.ui.screens.IndustriesScreen
import com.example.r2mbrands.ui.screens.InsightsScreen
import com.example.r2mbrands.ui.screens.ServicesScreen
import com.example.r2mbrands.ui.theme.R2MBrandsTheme
import com.example.r2mbrands.ui.theme.R2MInk
import com.example.r2mbrands.ui.theme.R2MInkMuted
import com.example.r2mbrands.ui.theme.R2MSurface
import com.example.r2mbrands.ui.theme.R2MTeal
import com.example.r2mbrands.ui.theme.R2MTealSoft

enum class Screen(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector
) {
    HOME("Home", Icons.Filled.Home, Icons.Outlined.Home),
    SERVICES("Services", Icons.Filled.ShoppingBag, Icons.Outlined.ShoppingBag),
    APPROACH("Workflow", Icons.Filled.Route, Icons.Outlined.Route),
    INDUSTRIES("Industries", Icons.Filled.Business, Icons.Outlined.Business),
    INSIGHTS("Insights", Icons.Filled.Description, Icons.Outlined.Description),
    CONTACT("Contact", Icons.Filled.Mail, Icons.Outlined.Mail),
    ABOUT("About", Icons.Filled.Home, Icons.Outlined.Home)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            R2MBrandsTheme {
                R2MAppRoot()
            }
        }
    }
}

@Composable
fun R2MAppRoot() {
    var currentScreen by remember { mutableStateOf(Screen.HOME) }
    var navigationHistory by remember { mutableStateOf(listOf(Screen.HOME)) }

    fun navigateTo(screen: Screen) {
        if (currentScreen != screen) {
            navigationHistory = navigationHistory + screen
            currentScreen = screen
        }
    }

    BackHandler(enabled = navigationHistory.size > 1) {
        val previousHistory = navigationHistory.dropLast(1)
        navigationHistory = previousHistory
        currentScreen = previousHistory.lastOrNull() ?: Screen.HOME
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val isTablet = maxWidth >= 600.dp

        if (isTablet) {
            // Tablet layout with NavigationRail
            Row(modifier = Modifier.fillMaxSize()) {
                NavigationRail(
                    containerColor = R2MSurface,
                    modifier = Modifier.fillMaxHeight(),
                    header = {
                        Text(
                            text = "R2M",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Black,
                            color = R2MTeal,
                            modifier = Modifier.padding(vertical = 12.dp)
                        )
                    }
                ) {
                    Screen.values().filter { it != Screen.ABOUT }.forEach { screen ->
                        val isSelected = currentScreen == screen
                        NavigationRailItem(
                            selected = isSelected,
                            onClick = { navigateTo(screen) },
                            icon = {
                                Icon(
                                    imageVector = if (isSelected) screen.selectedIcon else screen.unselectedIcon,
                                    contentDescription = screen.title
                                )
                            },
                            label = { Text(screen.title, fontSize = 11.sp) },
                            colors = NavigationRailItemDefaults.colors(
                                selectedIconColor = R2MTeal,
                                selectedTextColor = R2MTeal,
                                unselectedIconColor = R2MInkMuted,
                                unselectedTextColor = R2MInkMuted,
                                indicatorColor = R2MTealSoft
                            ),
                            modifier = Modifier.testTag("nav_rail_${screen.name.lowercase()}")
                        )
                    }
                }

                Scaffold(
                    topBar = {
                        R2MTopBar(onAboutClick = { navigateTo(Screen.ABOUT) })
                    },
                    contentWindowInsets = WindowInsets(0, 0, 0, 0)
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        ScreenContent(
                            currentScreen = currentScreen,
                            onNavigateToServices = { navigateTo(Screen.SERVICES) },
                            onNavigateToApproach = { navigateTo(Screen.APPROACH) },
                            onNavigateToIndustries = { navigateTo(Screen.INDUSTRIES) },
                            onNavigateToContact = { navigateTo(Screen.CONTACT) }
                        )
                    }
                }
            }
        } else {
            // Handheld layout with Bottom NavigationBar
            Scaffold(
                topBar = {
                    R2MTopBar(onAboutClick = { navigateTo(Screen.ABOUT) })
                },
                bottomBar = {
                    NavigationBar(
                        containerColor = Color(0xFFF1F5F8),
                        tonalElevation = 8.dp
                    ) {
                        Screen.values().filter { it != Screen.ABOUT }.forEach { screen ->
                            val isSelected = currentScreen == screen
                            NavigationBarItem(
                                selected = isSelected,
                                onClick = { navigateTo(screen) },
                                icon = {
                                    Icon(
                                        imageVector = if (isSelected) screen.selectedIcon else screen.unselectedIcon,
                                        contentDescription = screen.title,
                                        modifier = Modifier.size(20.dp)
                                    )
                                },
                                label = {
                                    Text(
                                        text = screen.title,
                                        fontSize = 10.sp,
                                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = R2MTeal,
                                    selectedTextColor = R2MTeal,
                                    unselectedIconColor = R2MInkMuted,
                                    unselectedTextColor = R2MInkMuted,
                                    indicatorColor = R2MTealSoft
                                ),
                                modifier = Modifier.testTag("nav_item_${screen.name.lowercase()}")
                            )
                        }
                    }
                },
                contentWindowInsets = WindowInsets(0, 0, 0, 0)
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    ScreenContent(
                        currentScreen = currentScreen,
                        onNavigateToServices = { navigateTo(Screen.SERVICES) },
                        onNavigateToApproach = { navigateTo(Screen.APPROACH) },
                        onNavigateToIndustries = { navigateTo(Screen.INDUSTRIES) },
                        onNavigateToContact = { navigateTo(Screen.CONTACT) }
                    )
                }
            }
        }
    }
}

@Composable
fun ScreenContent(
    currentScreen: Screen,
    onNavigateToServices: () -> Unit,
    onNavigateToApproach: () -> Unit,
    onNavigateToIndustries: () -> Unit,
    onNavigateToContact: () -> Unit
) {
    when (currentScreen) {
        Screen.HOME -> HomeScreen(
            onNavigateToServices = onNavigateToServices,
            onNavigateToApproach = onNavigateToApproach,
            onNavigateToIndustries = onNavigateToIndustries,
            onNavigateToContact = onNavigateToContact
        )
        Screen.SERVICES -> ServicesScreen(
            onNavigateToContact = onNavigateToContact
        )
        Screen.APPROACH -> ApproachScreen(
            onNavigateToContact = onNavigateToContact
        )
        Screen.INDUSTRIES -> IndustriesScreen(
            onNavigateToContact = onNavigateToContact
        )
        Screen.INSIGHTS -> InsightsScreen(
            onNavigateToContact = onNavigateToContact
        )
        Screen.CONTACT -> ContactScreen()
        Screen.ABOUT -> AboutScreen(
            onNavigateToContact = onNavigateToContact
        )
    }
}
