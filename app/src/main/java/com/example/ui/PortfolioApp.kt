package com.example.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.FolderSpecial
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Laptop
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PortfolioRepository
import com.example.data.ProjectItem
import com.example.ui.components.AboutSection
import com.example.ui.components.AchievementsSection
import com.example.ui.components.ContactSection
import com.example.ui.components.EducationSection
import com.example.ui.components.HeroSection
import com.example.ui.components.ProjectDetailDialog
import com.example.ui.components.ProjectsSection
import com.example.ui.components.SkillsSection
import com.example.ui.components.WebPortfolioScreen
import kotlinx.coroutines.launch

enum class PortfolioTab(val label: String, val icon: ImageVector) {
    HOME("Home", Icons.Default.Person),
    ABOUT("About", Icons.Default.Info),
    SKILLS("Skills", Icons.Default.Laptop),
    PROJECTS("Projects", Icons.Default.FolderSpecial),
    JOURNEY("Journey", Icons.Default.School),
    AWARDS("Awards", Icons.Default.EmojiEvents),
    CONTACT("Contact", Icons.Default.Email),
    WEB("Web Page", Icons.Default.Language)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioApp(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    var currentTab by remember { mutableStateOf(PortfolioTab.HOME) }
    var selectedProjectForDialog by remember { mutableStateOf<ProjectItem?>(null) }
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val clipboardManager = LocalClipboardManager.current

    val copyEmailToClipboard: () -> Unit = {
        clipboardManager.setText(AnnotatedString(PortfolioRepository.EMAIL))
        coroutineScope.launch {
            snackbarHostState.showSnackbar("Email copied to clipboard: ${PortfolioRepository.EMAIL}")
        }
    }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val isExpanded = maxWidth >= 720.dp

        if (isExpanded) {
            // Wide Screen / Tablet Layout with Navigation Rail
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
            ) {
                NavigationRail(
                    modifier = Modifier.fillMaxHeight(),
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.onSurface,
                    header = {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(top = 16.dp, bottom = 12.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(CircleShape)
                                    .background(MaterialTheme.colorScheme.primaryContainer),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "UA",
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                ) {
                    PortfolioTab.entries.forEach { tab ->
                        NavigationRailItem(
                            selected = currentTab == tab,
                            onClick = { currentTab = tab },
                            icon = {
                                Icon(
                                    imageVector = tab.icon,
                                    contentDescription = tab.label
                                )
                            },
                            label = { Text(tab.label, style = MaterialTheme.typography.labelSmall) },
                            colors = NavigationRailItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                indicatorColor = MaterialTheme.colorScheme.primaryContainer
                            ),
                            modifier = Modifier.testTag("nav_rail_${tab.name.lowercase()}")
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    IconButton(
                        onClick = onToggleTheme,
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                            .testTag("theme_toggle_button_rail")
                    ) {
                        Icon(
                            imageVector = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                            contentDescription = "Toggle Theme",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                // Main Content Area for Expanded Screen
                Scaffold(
                    snackbarHost = { SnackbarHost(snackbarHostState) },
                    containerColor = MaterialTheme.colorScheme.background,
                    topBar = {
                        TopAppBar(
                            title = {
                                Column {
                                    Text(
                                        text = PortfolioRepository.FORMATTED_NAME,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = PortfolioRepository.ROLE_TITLE,
                                        style = MaterialTheme.typography.bodySmall,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            },
                            actions = {
                                IconButton(
                                    onClick = {
                                        currentTab = if (currentTab == PortfolioTab.WEB) PortfolioTab.HOME else PortfolioTab.WEB
                                    },
                                    modifier = Modifier.testTag("toggle_web_view_rail")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Language,
                                        contentDescription = "Web Page View",
                                        tint = if (currentTab == PortfolioTab.WEB) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.surface
                            )
                        )
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        if (currentTab == PortfolioTab.WEB) {
                            WebPortfolioScreen(modifier = Modifier.fillMaxSize())
                        } else {
                            PortfolioContent(
                                currentTab = currentTab,
                                onNavigateToTab = { currentTab = it },
                                onSelectProject = { selectedProjectForDialog = it },
                                onCopyEmail = copyEmailToClipboard,
                                modifier = Modifier
                                    .widthIn(max = 900.dp)
                                    .padding(horizontal = 24.dp, vertical = 16.dp)
                            )
                        }
                    }
                }
            }
        } else {
            // Mobile Compact Screen Layout with Bottom Navigation Bar & Top AppBar
            Scaffold(
                snackbarHost = { SnackbarHost(snackbarHostState) },
                containerColor = MaterialTheme.colorScheme.background,
                topBar = {
                    TopAppBar(
                        title = {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = Modifier
                                        .size(32.dp)
                                        .clip(CircleShape)
                                        .background(MaterialTheme.colorScheme.primaryContainer),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "UA",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 12.sp,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                                Spacer(modifier = Modifier.width(10.dp))
                                Column {
                                    Text(
                                        text = PortfolioRepository.FORMATTED_NAME,
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "BS Software Eng. • COMSATS",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }
                        },
                        actions = {
                            IconButton(
                                onClick = {
                                    currentTab = if (currentTab == PortfolioTab.WEB) PortfolioTab.HOME else PortfolioTab.WEB
                                },
                                modifier = Modifier.testTag("toggle_web_view_button")
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Language,
                                    contentDescription = "Web Page View",
                                    tint = if (currentTab == PortfolioTab.WEB) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                            IconButton(
                                onClick = onToggleTheme,
                                modifier = Modifier.testTag("theme_toggle_button")
                            ) {
                                Icon(
                                    imageVector = if (isDarkTheme) Icons.Default.LightMode else Icons.Default.DarkMode,
                                    contentDescription = "Toggle Theme",
                                    tint = MaterialTheme.colorScheme.onSurfaceVariant
                                )
                            }
                        },
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = MaterialTheme.colorScheme.surface
                        )
                    )
                },
                bottomBar = {
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.testTag("bottom_navigation_bar")
                    ) {
                        // Show main mobile tabs: Home, Skills, Projects, Journey, Contact, Web Page
                        val mobileTabs = listOf(
                            PortfolioTab.HOME,
                            PortfolioTab.SKILLS,
                            PortfolioTab.PROJECTS,
                            PortfolioTab.JOURNEY,
                            PortfolioTab.CONTACT,
                            PortfolioTab.WEB
                        )

                        mobileTabs.forEach { tab ->
                            NavigationBarItem(
                                selected = currentTab == tab || (currentTab == PortfolioTab.ABOUT && tab == PortfolioTab.HOME) || (currentTab == PortfolioTab.AWARDS && tab == PortfolioTab.JOURNEY),
                                onClick = { currentTab = tab },
                                icon = {
                                    Icon(
                                        imageVector = tab.icon,
                                        contentDescription = tab.label
                                    )
                                },
                                label = { Text(tab.label, style = MaterialTheme.typography.labelSmall) },
                                colors = NavigationBarItemDefaults.colors(
                                    selectedIconColor = MaterialTheme.colorScheme.primary,
                                    selectedTextColor = MaterialTheme.colorScheme.primary,
                                    indicatorColor = MaterialTheme.colorScheme.primaryContainer
                                ),
                                modifier = Modifier.testTag("nav_item_${tab.name.lowercase()}")
                            )
                        }
                    }
                }
            ) { innerPadding ->
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                ) {
                    // Quick Scrollable Section Header Tabs
                    ScrollableTabRow(
                        selectedTabIndex = PortfolioTab.entries.indexOf(currentTab),
                        containerColor = MaterialTheme.colorScheme.surface,
                        contentColor = MaterialTheme.colorScheme.primary,
                        edgePadding = 16.dp,
                        divider = {},
                        indicator = { tabPositions ->
                            TabRowDefaults.SecondaryIndicator(
                                Modifier.tabIndicatorOffset(tabPositions[PortfolioTab.entries.indexOf(currentTab)]),
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    ) {
                        PortfolioTab.entries.forEach { tab ->
                            Tab(
                                selected = currentTab == tab,
                                onClick = { currentTab = tab },
                                text = {
                                    Text(
                                        text = tab.label,
                                        fontWeight = if (currentTab == tab) FontWeight.Bold else FontWeight.Normal,
                                        fontSize = 13.sp
                                    )
                                },
                                modifier = Modifier.testTag("tab_strip_${tab.name.lowercase()}")
                            )
                        }
                    }

                    if (currentTab == PortfolioTab.WEB) {
                        WebPortfolioScreen(modifier = Modifier.fillMaxSize())
                    } else {
                        PortfolioContent(
                            currentTab = currentTab,
                            onNavigateToTab = { currentTab = it },
                            onSelectProject = { selectedProjectForDialog = it },
                            onCopyEmail = copyEmailToClipboard,
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(horizontal = 16.dp, vertical = 12.dp)
                        )
                    }
                }
            }
        }

        // Project Detail Dialog Modal
        selectedProjectForDialog?.let { project ->
            ProjectDetailDialog(
                project = project,
                onDismiss = { selectedProjectForDialog = null }
            )
        }
    }
}

@Composable
fun PortfolioContent(
    currentTab: PortfolioTab,
    onNavigateToTab: (PortfolioTab) -> Unit,
    onSelectProject: (ProjectItem) -> Unit,
    onCopyEmail: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        when (currentTab) {
            PortfolioTab.HOME -> {
                HeroSection(
                    onNavigateToProjects = { onNavigateToTab(PortfolioTab.PROJECTS) },
                    onNavigateToContact = { onNavigateToTab(PortfolioTab.CONTACT) },
                    onCopyEmail = onCopyEmail
                )

                Spacer(modifier = Modifier.height(16.dp))

                AboutSection()

                Spacer(modifier = Modifier.height(16.dp))

                SkillsSection()

                Spacer(modifier = Modifier.height(16.dp))

                ProjectsSection(onSelectProject = onSelectProject)

                Spacer(modifier = Modifier.height(16.dp))

                EducationSection()

                Spacer(modifier = Modifier.height(16.dp))

                AchievementsSection()

                Spacer(modifier = Modifier.height(16.dp))

                ContactSection(onCopyEmail = onCopyEmail)
            }
            PortfolioTab.ABOUT -> {
                HeroSection(
                    onNavigateToProjects = { onNavigateToTab(PortfolioTab.PROJECTS) },
                    onNavigateToContact = { onNavigateToTab(PortfolioTab.CONTACT) },
                    onCopyEmail = onCopyEmail
                )
                Spacer(modifier = Modifier.height(16.dp))
                AboutSection()
            }
            PortfolioTab.SKILLS -> {
                SkillsSection()
            }
            PortfolioTab.PROJECTS -> {
                ProjectsSection(onSelectProject = onSelectProject)
            }
            PortfolioTab.JOURNEY -> {
                EducationSection()
                Spacer(modifier = Modifier.height(16.dp))
                AchievementsSection()
            }
            PortfolioTab.AWARDS -> {
                AchievementsSection()
            }
            PortfolioTab.CONTACT -> {
                ContactSection(onCopyEmail = onCopyEmail)
            }
            PortfolioTab.WEB -> {
                WebPortfolioScreen()
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        // Professional Footer
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "${PortfolioRepository.FULL_NAME} • Portfolio",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "${PortfolioRepository.DEGREE_SHORT} • ${PortfolioRepository.LOCATION}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}
