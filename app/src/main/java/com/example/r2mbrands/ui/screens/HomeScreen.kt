package com.example.r2mbrands.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Warehouse
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.r2mbrands.data.R2MRepository
import com.example.r2mbrands.data.ServiceItem
import com.example.r2mbrands.ui.components.CtaBandCard
import com.example.r2mbrands.ui.components.EyebrowBadge
import com.example.r2mbrands.ui.components.InquiryDialog
import com.example.r2mbrands.ui.components.NeuCard
import com.example.r2mbrands.ui.components.SectionHeader
import com.example.r2mbrands.ui.components.StatPillsRow
import com.example.r2mbrands.ui.components.WorkflowChainView
import com.example.r2mbrands.ui.theme.R2MCyan
import com.example.r2mbrands.ui.theme.R2MInk
import com.example.r2mbrands.ui.theme.R2MInkMuted
import com.example.r2mbrands.ui.theme.R2MSurface
import com.example.r2mbrands.ui.theme.R2MTeal
import com.example.r2mbrands.ui.theme.R2MTealSoft
import com.example.r2mbrands.ui.theme.R2MWhite

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
    onNavigateToServices: () -> Unit,
    onNavigateToApproach: () -> Unit,
    onNavigateToIndustries: () -> Unit,
    onNavigateToContact: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showInquiryDialog by remember { mutableStateOf(false) }
    var selectedServiceForDialog by remember { mutableStateOf("Full Route-to-Market") }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(R2MSurface)
            .testTag("home_screen"),
        contentPadding = androidx.compose.foundation.layout.PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 90.dp
        ),
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        // Hero Section
        item {
            NeuCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("home_hero_card"),
                cornerRadius = 28.dp,
                elevation = 6.dp
            ) {
                Column(
                    modifier = Modifier.padding(22.dp)
                ) {
                    EyebrowBadge(text = "The Route-to-Market Engine")

                    Spacer(modifier = Modifier.height(14.dp))

                    Text(
                        text = "Connecting Brands to Every Shelf",
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Black,
                        lineHeight = 34.sp,
                        color = R2MInk
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "R2M Brands Ltd powers sales, merchandising, instore activations, and wholesale-retail distribution across all 47 Kenyan counties.",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        lineHeight = 21.sp,
                        color = R2MInkMuted
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Button(
                            onClick = {
                                selectedServiceForDialog = "Full Route-to-Market"
                                showInquiryDialog = true
                            },
                            modifier = Modifier
                                .weight(1f)
                                .testTag("home_hero_quote_button"),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = R2MTeal,
                                contentColor = R2MWhite
                            ),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Text(
                                text = "Get Proposal",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        OutlinedButton(
                            onClick = onNavigateToApproach,
                            modifier = Modifier
                                .weight(1f)
                                .testTag("home_hero_approach_button"),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            Text(
                                text = "How It Works",
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Bold,
                                color = R2MInk
                            )
                        }
                    }
                }
            }
        }

        // Live Stats Grid
        item {
            StatPillsRow()
        }

        // What We Do (Services Snapshot)
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    eyebrow = "What We Do",
                    title = "One partner for the whole last mile",
                    description = "From factory floor to the last duka in Kenya, we own the ground execution."
                )

                Spacer(modifier = Modifier.height(14.dp))

                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    R2MRepository.services.take(4).forEach { service ->
                        HomeServiceItemCard(
                            service = service,
                            onRequestQuote = {
                                selectedServiceForDialog = service.kicker
                                showInquiryDialog = true
                            }
                        )
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = onNavigateToServices,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("home_view_all_services_button"),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFE2E8F0),
                        contentColor = R2MInk
                    ),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "Explore All 6 Services & Deliverables",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }

        // How We Work (Workflow Chain)
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                SectionHeader(
                    eyebrow = "The Operating Loop",
                    title = "Predict. Execute. Win.",
                    description = "A closed data loop where real sell-out numbers feed the next forecast."
                )

                Spacer(modifier = Modifier.height(14.dp))

                WorkflowChainView()

                Spacer(modifier = Modifier.height(12.dp))

                OutlinedButton(
                    onClick = onNavigateToApproach,
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("home_view_approach_button"),
                    shape = RoundedCornerShape(14.dp)
                ) {
                    Text(
                        text = "View Detailed Methodology",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = R2MTeal
                    )
                }
            }
        }

        // Industries Snapshot
        item {
            NeuCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("home_industries_card"),
                cornerRadius = 24.dp
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    EyebrowBadge(text = "Industries")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Fast-Moving Categories",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = R2MInk
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "We speak the language of Kenyan trade, from rural agrovets to tier-1 hypermarkets.",
                        fontSize = 13.sp,
                        color = R2MInkMuted
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        R2MRepository.industries.forEach { ind ->
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(12.dp))
                                    .background(Color(0xFFE2E8F0))
                                    .clickable { onNavigateToIndustries() }
                                    .padding(horizontal = 12.dp, vertical = 8.dp)
                            ) {
                                Text(
                                    text = "${ind.emoji} ${ind.title}",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = R2MInk
                                )
                            }
                        }
                    }
                }
            }
        }

        // CTA Band
        item {
            CtaBandCard(onNavigateToContact = onNavigateToContact)
        }
    }

    if (showInquiryDialog) {
        InquiryDialog(
            initialService = selectedServiceForDialog,
            onDismiss = { showInquiryDialog = false }
        )
    }
}

@Composable
fun HomeServiceItemCard(
    service: ServiceItem,
    onRequestQuote: () -> Unit,
    modifier: Modifier = Modifier
) {
    val icon = when (service.iconName) {
        "campaign" -> Icons.Default.Campaign
        "layers" -> Icons.Default.Layers
        "directions_walk" -> Icons.Default.DirectionsWalk
        "warehouse" -> Icons.Default.Warehouse
        "local_shipping" -> Icons.Default.LocalShipping
        else -> Icons.Default.Hub
    }

    NeuCard(
        modifier = modifier
            .fillMaxWidth()
            .testTag("home_service_card_${service.id}"),
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
                    contentDescription = service.title,
                    tint = R2MTeal,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = service.kicker.uppercase(),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = R2MTeal,
                    letterSpacing = 0.8.sp
                )
                Text(
                    text = service.title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = R2MInk
                )
                Text(
                    text = service.blurb,
                    fontSize = 12.sp,
                    color = R2MInkMuted,
                    maxLines = 2
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color(0xFFE2E8F0))
                    .clickable(onClick = onRequestQuote)
                    .padding(8.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Request Proposal",
                    tint = R2MTeal,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}
