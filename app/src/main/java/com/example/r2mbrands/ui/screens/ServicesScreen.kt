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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Campaign
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.DirectionsWalk
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.LocalShipping
import androidx.compose.material.icons.filled.Warehouse
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
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
import com.example.r2mbrands.data.R2MRepository
import com.example.r2mbrands.data.ServiceItem
import com.example.r2mbrands.ui.components.CtaBandCard
import com.example.r2mbrands.ui.components.EyebrowBadge
import com.example.r2mbrands.ui.components.InquiryDialog
import com.example.r2mbrands.ui.components.NeuCard
import com.example.r2mbrands.ui.components.SectionHeader
import com.example.r2mbrands.ui.theme.R2MCyan
import com.example.r2mbrands.ui.theme.R2MInk
import com.example.r2mbrands.ui.theme.R2MInkMuted
import com.example.r2mbrands.ui.theme.R2MSurface
import com.example.r2mbrands.ui.theme.R2MTeal
import com.example.r2mbrands.ui.theme.R2MTealSoft
import com.example.r2mbrands.ui.theme.R2MWhite

@Composable
fun ServicesScreen(
    onNavigateToContact: () -> Unit,
    modifier: Modifier = Modifier
) {
    var showInquiryDialog by remember { mutableStateOf(false) }
    var selectedServiceForDialog by remember { mutableStateOf("Instore Promotions") }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(R2MSurface)
            .testTag("services_screen"),
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
                eyebrow = "Our Services",
                title = "Everything the last mile demands",
                description = "Pick one capability or the full stack. Either way, you get one accountable partner and verified line of sight into Kenyan trade."
            )
        }

        // Services List
        items(R2MRepository.services) { service ->
            ServiceDetailCard(
                service = service,
                onRequestQuote = {
                    selectedServiceForDialog = service.kicker
                    showInquiryDialog = true
                }
            )
        }

        // Deliverables Checklist
        item {
            NeuCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("services_deliverables_card"),
                cornerRadius = 24.dp
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    EyebrowBadge(text = "What's Included")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Execution You Can Actually See",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = R2MInk
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Every R2M engagement ships with the operational backbone that keeps coverage honest and verifiable.",
                        fontSize = 13.sp,
                        color = R2MInkMuted
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    R2MRepository.deliverablesChecklist.forEach { deliverable ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 6.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                imageVector = Icons.Default.CheckCircle,
                                contentDescription = null,
                                tint = R2MTeal,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(modifier = Modifier.width(10.dp))
                            Text(
                                text = deliverable,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.SemiBold,
                                color = R2MInk
                            )
                        }
                    }
                }
            }
        }

        item {
            CtaBandCard(
                onNavigateToContact = onNavigateToContact,
                title = "Which shelves do you want to own?",
                subtitle = "Let's configure the right service mix for your brand's growth phase."
            )
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
fun ServiceDetailCard(
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
            .testTag("service_card_${service.id}"),
        cornerRadius = 24.dp,
        elevation = 6.dp
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
                    Icon(
                        imageVector = icon,
                        contentDescription = service.title,
                        tint = R2MTeal,
                        modifier = Modifier.size(26.dp)
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))

                Column {
                    Text(
                        text = service.kicker.uppercase(),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = R2MTeal,
                        letterSpacing = 0.8.sp
                    )
                    Text(
                        text = service.title,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        color = R2MInk
                    )
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = service.blurb,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                lineHeight = 19.sp,
                color = R2MInkMuted
            )

            if (service.deliverables.isNotEmpty()) {
                Spacer(modifier = Modifier.height(14.dp))
                Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                    service.deliverables.forEach { item ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Box(
                                modifier = Modifier
                                    .size(6.dp)
                                    .clip(CircleShape)
                                    .background(R2MTeal)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = item,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium,
                                color = R2MInk
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onRequestQuote,
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("service_request_${service.id}"),
                colors = ButtonDefaults.buttonColors(
                    containerColor = R2MTeal,
                    contentColor = R2MWhite
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(
                    text = "Request ${service.kicker} Proposal",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
