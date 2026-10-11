package com.example.r2mbrands.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.r2mbrands.data.Inquiry
import com.example.r2mbrands.data.R2MRepository
import com.example.r2mbrands.ui.components.EyebrowBadge
import com.example.r2mbrands.ui.components.NeuCard
import com.example.r2mbrands.ui.components.SectionHeader
import com.example.r2mbrands.ui.theme.R2MCyan
import com.example.r2mbrands.ui.theme.R2MInk
import com.example.r2mbrands.ui.theme.R2MInkMuted
import com.example.r2mbrands.ui.theme.R2MSurface
import com.example.r2mbrands.ui.theme.R2MTeal
import com.example.r2mbrands.ui.theme.R2MTealSoft
import com.example.r2mbrands.ui.theme.R2MWhite
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val submittedInquiries by R2MRepository.submittedInquiries.collectAsState()

    var fullName by remember { mutableStateOf("") }
    var company by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var selectedService by remember { mutableStateOf("Full Route-to-Market") }
    var serviceDropdownExpanded by remember { mutableStateOf(false) }
    var message by remember { mutableStateOf("") }

    var isSubmitting by remember { mutableStateOf(false) }
    var isSubmittedSuccess by remember { mutableStateOf(false) }
    var formError by remember { mutableStateOf<String?>(null) }

    val serviceOptions = listOf(
        "Instore Promotions",
        "Merchandising",
        "Foot Soldiers",
        "Wholesale Distribution",
        "Retail Distribution",
        "Full Route-to-Market"
    )

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(R2MSurface)
            .testTag("contact_screen"),
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
                eyebrow = "Contact Operations",
                title = "Let's map your route to market",
                description = "Tell us about your brand and targets. We'll show you exactly how we reach the Kenyan shelves that matter."
            )
        }

        // Direct Channels
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                // Phone
                ContactChannelCard(
                    icon = Icons.Default.Call,
                    label = "Call Us",
                    value = R2MRepository.contactPhone,
                    onClick = {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse(R2MRepository.contactPhoneUri))
                        context.startActivity(intent)
                    },
                    testTag = "contact_channel_phone"
                )

                // Email
                ContactChannelCard(
                    icon = Icons.Default.Email,
                    label = "Email Operations",
                    value = R2MRepository.contactEmail,
                    onClick = {
                        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${R2MRepository.contactEmail}"))
                        context.startActivity(intent)
                    },
                    testTag = "contact_channel_email"
                )

                // Head Office
                ContactChannelCard(
                    icon = Icons.Default.LocationOn,
                    label = "Head Office",
                    value = R2MRepository.contactLocation,
                    onClick = {},
                    testTag = "contact_channel_location"
                )
            }
        }

        // Form Section
        item {
            NeuCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("contact_form_card"),
                cornerRadius = 28.dp,
                elevation = 6.dp
            ) {
                Column(modifier = Modifier.padding(22.dp)) {
                    Text(
                        text = "Send Trade Inquiry",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Black,
                        color = R2MInk
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Guaranteed response within 1 business day.",
                        fontSize = 12.sp,
                        color = R2MInkMuted
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    if (isSubmittedSuccess) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(56.dp)
                                    .clip(CircleShape)
                                    .background(R2MTeal),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Check,
                                    contentDescription = "Success",
                                    tint = R2MWhite,
                                    modifier = Modifier.size(32.dp)
                                )
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            Text(
                                text = "Message Received!",
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Black,
                                color = R2MInk
                            )

                            Spacer(modifier = Modifier.height(6.dp))

                            Text(
                                text = "Thank you. Our route team has logged your inquiry and will reach out with territory projections.",
                                fontSize = 13.sp,
                                color = R2MInkMuted,
                                lineHeight = 19.sp,
                                modifier = Modifier.padding(horizontal = 16.dp),
                                textAlign = androidx.compose.ui.text.style.TextAlign.Center
                            )

                            Spacer(modifier = Modifier.height(16.dp))

                            Button(
                                onClick = {
                                    isSubmittedSuccess = false
                                    fullName = ""
                                    company = ""
                                    email = ""
                                    phone = ""
                                    message = ""
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = R2MTeal)
                            ) {
                                Text("Submit Another Inquiry")
                            }
                        }
                    } else {
                        // Form fields
                        OutlinedTextField(
                            value = fullName,
                            onValueChange = { fullName = it },
                            label = { Text("Full Name *") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("contact_input_name"),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = R2MTeal,
                                unfocusedBorderColor = Color(0xFFCBD5E1)
                            )
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = company,
                            onValueChange = { company = it },
                            label = { Text("Company / Brand *") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("contact_input_company"),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = R2MTeal,
                                unfocusedBorderColor = Color(0xFFCBD5E1)
                            )
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = email,
                            onValueChange = { email = it },
                            label = { Text("Email *") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("contact_input_email"),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = R2MTeal,
                                unfocusedBorderColor = Color(0xFFCBD5E1)
                            )
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = phone,
                            onValueChange = { phone = it },
                            label = { Text("Phone Number") },
                            placeholder = { Text("+254 7...") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("contact_input_phone"),
                            singleLine = true,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = R2MTeal,
                                unfocusedBorderColor = Color(0xFFCBD5E1)
                            )
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        ExposedDropdownMenuBox(
                            expanded = serviceDropdownExpanded,
                            onExpandedChange = { serviceDropdownExpanded = !serviceDropdownExpanded }
                        ) {
                            OutlinedTextField(
                                value = selectedService,
                                onValueChange = {},
                                readOnly = true,
                                label = { Text("Service of Interest") },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = serviceDropdownExpanded) },
                                modifier = Modifier
                                    .menuAnchor()
                                    .fillMaxWidth()
                                    .testTag("contact_select_service"),
                                colors = OutlinedTextFieldDefaults.colors(
                                    focusedBorderColor = R2MTeal,
                                    unfocusedBorderColor = Color(0xFFCBD5E1)
                                )
                            )

                            ExposedDropdownMenu(
                                expanded = serviceDropdownExpanded,
                                onDismissRequest = { serviceDropdownExpanded = false }
                            ) {
                                serviceOptions.forEach { opt ->
                                    DropdownMenuItem(
                                        text = { Text(opt) },
                                        onClick = {
                                            selectedService = opt
                                            serviceDropdownExpanded = false
                                        }
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(10.dp))

                        OutlinedTextField(
                            value = message,
                            onValueChange = { message = it },
                            label = { Text("Tell us about your brand & targets *") },
                            placeholder = { Text("SKU categories, counties you want to cover, current volume...") },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("contact_input_message"),
                            minLines = 4,
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = R2MTeal,
                                unfocusedBorderColor = Color(0xFFCBD5E1)
                            )
                        )

                        if (formError != null) {
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = formError ?: "",
                                color = Color(0xFFDC2626),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        Button(
                            onClick = {
                                if (fullName.isBlank() || company.isBlank() || email.isBlank() || message.isBlank()) {
                                    formError = "Please fill in all required fields (Name, Company, Email, Message)."
                                    return@Button
                                }
                                formError = null
                                isSubmitting = true
                                coroutineScope.launch {
                                    delay(700)
                                    R2MRepository.submitInquiry(
                                        name = fullName,
                                        company = company,
                                        email = email,
                                        phone = phone.ifBlank { "+254" },
                                        service = selectedService,
                                        message = message
                                    )
                                    isSubmitting = false
                                    isSubmittedSuccess = true
                                }
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .testTag("contact_submit_button"),
                            enabled = !isSubmitting,
                            colors = ButtonDefaults.buttonColors(
                                containerColor = R2MTeal,
                                contentColor = R2MWhite
                            ),
                            shape = RoundedCornerShape(14.dp)
                        ) {
                            if (isSubmitting) {
                                CircularProgressIndicator(
                                    color = R2MWhite,
                                    modifier = Modifier.size(16.dp),
                                    strokeWidth = 2.dp
                                )
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Submitting...")
                            } else {
                                Text("Send Trade Message", fontWeight = FontWeight.ExtraBold)
                            }
                        }
                    }
                }
            }
        }

        // Recent Inquiries Log (Audit Trail)
        item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Tracked Inquiries (${submittedInquiries.size})",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = R2MInk
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        items(submittedInquiries) { inq ->
            SubmittedInquiryItemCard(inquiry = inq)
        }
    }
}

@Composable
fun ContactChannelCard(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    value: String,
    onClick: () -> Unit,
    testTag: String,
    modifier: Modifier = Modifier
) {
    NeuCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .testTag(testTag),
        cornerRadius = 18.dp,
        elevation = 3.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(42.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(R2MTealSoft),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = label,
                    tint = R2MTeal,
                    modifier = Modifier.size(22.dp)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column {
                Text(
                    text = label.uppercase(),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = R2MInkMuted,
                    letterSpacing = 0.8.sp
                )
                Text(
                    text = value,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = R2MInk
                )
            }
        }
    }
}

@Composable
fun SubmittedInquiryItemCard(
    inquiry: Inquiry,
    modifier: Modifier = Modifier
) {
    NeuCard(
        modifier = modifier
            .fillMaxWidth()
            .testTag("inquiry_item_${inquiry.id}"),
        cornerRadius = 16.dp,
        elevation = 2.dp
    ) {
        Column(modifier = Modifier.padding(14.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = inquiry.company,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = R2MInk
                )
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(R2MTealSoft)
                        .padding(horizontal = 6.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = "Received",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = R2MTeal
                    )
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "${inquiry.service} • ${inquiry.fullName}",
                fontSize = 12.sp,
                color = R2MInkMuted
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = inquiry.message,
                fontSize = 12.sp,
                color = R2MInk,
                maxLines = 2
            )
        }
    }
}
