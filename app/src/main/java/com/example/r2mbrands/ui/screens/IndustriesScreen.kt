package com.example.r2mbrands.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.r2mbrands.data.IndustryItem
import com.example.r2mbrands.data.R2MRepository
import com.example.r2mbrands.ui.components.CtaBandCard
import com.example.r2mbrands.ui.components.NeuCard
import com.example.r2mbrands.ui.components.NeuInsetBox
import com.example.r2mbrands.ui.components.SectionHeader
import com.example.r2mbrands.ui.theme.R2MCyan
import com.example.r2mbrands.ui.theme.R2MInk
import com.example.r2mbrands.ui.theme.R2MInkMuted
import com.example.r2mbrands.ui.theme.R2MSurface
import com.example.r2mbrands.ui.theme.R2MTeal
import com.example.r2mbrands.ui.theme.R2MTealSoft
import com.example.r2mbrands.ui.theme.R2MWhite

@Composable
fun IndustriesScreen(
    onNavigateToContact: () -> Unit,
    modifier: Modifier = Modifier
) {
    val allIndustries = R2MRepository.industries
    val categories = listOf("All", "FMCG", "Beverages", "Services", "Agriculture")
    var selectedCategory by remember { mutableStateOf("All") }

    val filteredIndustries = remember(selectedCategory) {
        if (selectedCategory == "All") allIndustries
        else allIndustries.filter { it.category == selectedCategory }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(R2MSurface)
            .testTag("industries_screen"),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 90.dp
        ),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        item {
            SectionHeader(
                eyebrow = "Category Focus",
                title = "Categories that live and die on the shelf",
                description = "Fast-moving goods reward presence and punish gaps. We tailor route models to the specific purchasing rhythm of each sector."
            )
        }

        // Category filter tabs
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(categories) { cat ->
                    val isSelected = cat == selectedCategory
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(14.dp))
                            .background(if (isSelected) R2MTeal else Color(0xFFE2E8F0))
                            .clickable { selectedCategory = cat }
                            .padding(horizontal = 14.dp, vertical = 8.dp)
                            .testTag("industry_filter_$cat"),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = cat,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isSelected) R2MWhite else R2MInk
                        )
                    }
                }
            }
        }

        items(filteredIndustries) { industry ->
            IndustryDetailCard(industry = industry)
        }

        item {
            CtaBandCard(
                onNavigateToContact = onNavigateToContact,
                title = "Don't see your category?",
                subtitle = "We adapt fast. Let's design a custom route mapping session for your SKU profile."
            )
        }
    }
}

@Composable
fun IndustryDetailCard(
    industry: IndustryItem,
    modifier: Modifier = Modifier
) {
    NeuCard(
        modifier = modifier
            .fillMaxWidth()
            .testTag("industry_card_${industry.title.lowercase().replace(" ", "_")}"),
        cornerRadius = 24.dp,
        elevation = 5.dp
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(R2MTealSoft),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = industry.emoji,
                        fontSize = 24.sp
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column {
                    Text(
                        text = industry.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        color = R2MInk
                    )
                    Text(
                        text = industry.category.uppercase(),
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = R2MTeal,
                        letterSpacing = 0.8.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = industry.blurb,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 19.sp,
                color = R2MInkMuted
            )

            Spacer(modifier = Modifier.height(14.dp))

            NeuInsetBox(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color(0xFFE8EEF3),
                cornerRadius = 14.dp
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = "CHANNEL REACH",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = R2MTeal,
                                letterSpacing = 0.5.sp
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = industry.coverageHighlights,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Medium,
                                color = R2MInk
                            )
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(horizontalAlignment = Alignment.End) {
                            Text(
                                text = "CYCLE",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = R2MTeal,
                                letterSpacing = 0.5.sp
                            )
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = industry.averageTurnaround,
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = R2MInk
                            )
                        }
                    }
                }
            }
        }
    }
}
