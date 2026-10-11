package com.example.r2mbrands.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Handshake
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.TrackChanges
import androidx.compose.material.icons.filled.TrendingUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.r2mbrands.data.R2MRepository
import com.example.r2mbrands.data.ValuePill
import com.example.r2mbrands.ui.components.CtaBandCard
import com.example.r2mbrands.ui.components.EyebrowBadge
import com.example.r2mbrands.ui.components.NeuCard
import com.example.r2mbrands.ui.components.NeuInsetBox
import com.example.r2mbrands.ui.components.SectionHeader
import com.example.r2mbrands.ui.components.StatPillsRow
import com.example.r2mbrands.ui.theme.R2MCyan
import com.example.r2mbrands.ui.theme.R2MInk
import com.example.r2mbrands.ui.theme.R2MInkMuted
import com.example.r2mbrands.ui.theme.R2MSurface
import com.example.r2mbrands.ui.theme.R2MTeal
import com.example.r2mbrands.ui.theme.R2MTealSoft

@Composable
fun AboutScreen(
    onNavigateToContact: () -> Unit,
    modifier: Modifier = Modifier
) {
    val values = R2MRepository.values

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(R2MSurface)
            .testTag("about_screen"),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 90.dp
        ),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item {
            SectionHeader(
                eyebrow = "Who We Are",
                title = "The team between your brand and the shopper",
                description = "R2M Brands Ltd is built for the realities of the Kenyan market — where trust, presence, and consistency win the shelf."
            )
        }

        // Our Story Card
        item {
            NeuCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("about_story_card"),
                cornerRadius = 24.dp,
                elevation = 6.dp
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    EyebrowBadge(text = "Our Story")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "From the factory floor to the last duka",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        color = R2MInk
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Manufacturers make great products. The hard part is getting them into tens of thousands of outlets, keeping them on shelf, and making sure shoppers choose them. That gap is where brands lose the most volume — and it is exactly where R2M lives.",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 20.sp,
                        color = R2MInkMuted
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "We combine boots-on-the-ground field teams with disciplined route planning and real-time reporting. The result is a route-to-market engine that turns national ambition into outlet-level execution, one visit at a time.",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 20.sp,
                        color = R2MInkMuted
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    NeuInsetBox(
                        modifier = Modifier.fillMaxWidth(),
                        cornerRadius = 14.dp,
                        backgroundColor = Color(0xFFE8EEF3)
                    ) {
                        Text(
                            text = "Today we activate outlets across all 47 Kenyan counties, feeding wholesalers and neighborhood retailers who serve every household.",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = R2MTeal,
                            lineHeight = 18.sp,
                            modifier = Modifier.padding(14.dp)
                        )
                    }
                }
            }
        }

        // Stats
        item {
            StatPillsRow()
        }

        // Values
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    eyebrow = "What We Believe",
                    title = "The values that keep us on the road",
                    description = "Operating principles governing our field teams every single day."
                )

                Spacer(modifier = Modifier.height(14.dp))

                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    values.forEach { value ->
                        ValueItemCard(value = value)
                    }
                }
            }
        }

        item {
            CtaBandCard(
                onNavigateToContact = onNavigateToContact,
                title = "Let's put your brand on every shelf",
                subtitle = "Work with an execution team that treats your sell-out like our own scoreboard."
            )
        }
    }
}

@Composable
fun ValueItemCard(
    value: ValuePill,
    modifier: Modifier = Modifier
) {
    val icon = when (value.iconName) {
        "target" -> Icons.Default.TrackChanges
        "handshake" -> Icons.Default.Handshake
        "trending_up" -> Icons.Default.TrendingUp
        else -> Icons.Default.Shield
    }

    NeuCard(
        modifier = modifier
            .fillMaxWidth()
            .testTag("value_card_${value.title.lowercase()}"),
        cornerRadius = 20.dp,
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(44.dp)
                    .clip(RoundedCornerShape(14.dp))
                    .background(R2MTealSoft),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = value.title,
                    tint = R2MTeal,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = value.title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Black,
                    color = R2MInk
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = value.body,
                    fontSize = 12.sp,
                    color = R2MInkMuted,
                    lineHeight = 18.sp
                )
            }
        }
    }
}
