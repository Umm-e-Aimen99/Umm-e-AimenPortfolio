package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PortfolioRepository
import com.example.ui.theme.AccentCyan
import com.example.ui.theme.AccentMint
import com.example.ui.theme.AccentPurple

data class JourneyItem(
    val dateLabel: String,
    val title: String,
    val subtitle: String,
    val description: String,
    val isHighlighted: Boolean = false
)

@Composable
fun EducationSection(
    modifier: Modifier = Modifier
) {
    val journeyItems = listOf(
        JourneyItem(
            dateLabel = "2025 — 2029",
            title = "BS Software Engineering",
            subtitle = "COMSATS University Islamabad — Lahore Campus",
            description = "Currently building foundations in software engineering, programming, databases, networks and AI.",
            isHighlighted = true
        ),
        JourneyItem(
            dateLabel = "CURRENT",
            title = "MERN Stack Web Development",
            subtitle = "Hunarmand Punjab IT Program",
            description = "Course recently started, alongside independent web and backend learning.",
            isHighlighted = false
        ),
        JourneyItem(
            dateLabel = "NEXT MILESTONE",
            title = "Software Engineering Internship",
            subtitle = "Target: practical industry experience",
            description = "Preparing through projects, DSA, web development and backend fundamentals.",
            isHighlighted = false
        ),
        JourneyItem(
            dateLabel = "2022 — 2024",
            title = "HSSC (ICS-Physics)",
            subtitle = "Unique College for Girls 109-A",
            description = "Completed Intermediate in Computer Science with Physics, securing an 80% academic score.",
            isHighlighted = false
        )
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("education_section"),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            // Eyebrow
            Text(
                text = "04 / JOURNEY",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Bold,
                letterSpacing = 1.5.sp,
                color = AccentCyan
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Headline with gradient accent
            val gradientBrush = Brush.horizontalGradient(
                listOf(AccentPurple, AccentCyan)
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Where I'm ",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "headed.",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        brush = gradientBrush
                    ),
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = "A student journey focused on turning fundamentals into practical engineering skills.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Timeline Items
            Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
                journeyItems.forEach { item ->
                    TimelineItemCard(item = item)
                }
            }
        }
    }
}

@Composable
fun TimelineItemCard(item: JourneyItem) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.4f),
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            if (item.isHighlighted) AccentPurple.copy(alpha = 0.4f) else MaterialTheme.colorScheme.outline
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.Top
        ) {
            // Timeline indicator marker
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(top = 4.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(if (item.isHighlighted) AccentPurple else AccentCyan)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = item.dateLabel,
                    style = MaterialTheme.typography.labelSmall,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.2.sp,
                    color = AccentCyan
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = item.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Text(
                    text = item.subtitle,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Medium,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 18.sp
                )
            }
        }
    }
}
