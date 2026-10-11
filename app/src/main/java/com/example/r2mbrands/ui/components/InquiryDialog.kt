package com.example.r2mbrands.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.r2mbrands.data.R2MRepository
import com.example.r2mbrands.ui.theme.R2MInk
import com.example.r2mbrands.ui.theme.R2MInkMuted
import com.example.r2mbrands.ui.theme.R2MTeal
import com.example.r2mbrands.ui.theme.R2MWhite
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun InquiryDialog(
    initialService: String = "Full Route-to-Market",
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    var fullName by remember { mutableStateOf("") }
    var company by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var isSubmitting by remember { mutableStateOf(false) }
    var isSuccess by remember { mutableStateOf(false) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    val coroutineScope = rememberCoroutineScope()

    AlertDialog(
        onDismissRequest = onDismiss,
        modifier = modifier.testTag("inquiry_dialog"),
        shape = RoundedCornerShape(28.dp),
        containerColor = Color(0xFFF1F5F8),
        title = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = if (isSuccess) "Proposal Requested" else "Request Service Proposal",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Black,
                        color = R2MInk
                    )
                    Text(
                        text = initialService,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = R2MTeal
                    )
                }
                IconButton(onClick = onDismiss) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = R2MInkMuted
                    )
                }
            }
        },
        text = {
            if (isSuccess) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Success",
                        tint = R2MTeal,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        text = "Thank you, $fullName!",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = R2MInk
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = "Our Nairobi operations desk will contact $email within 1 business day with custom route projections for $company.",
                        fontSize = 13.sp,
                        color = R2MInkMuted,
                        lineHeight = 18.sp
                    )
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    OutlinedTextField(
                        value = fullName,
                        onValueChange = { fullName = it },
                        label = { Text("Full Name *") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("inquiry_input_name"),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = R2MTeal,
                            unfocusedBorderColor = Color(0xFFCBD5E1)
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = company,
                        onValueChange = { company = it },
                        label = { Text("Company / Brand Name *") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("inquiry_input_company"),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = R2MTeal,
                            unfocusedBorderColor = Color(0xFFCBD5E1)
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Work Email *") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("inquiry_input_email"),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = R2MTeal,
                            unfocusedBorderColor = Color(0xFFCBD5E1)
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = phone,
                        onValueChange = { phone = it },
                        label = { Text("Phone Number") },
                        placeholder = { Text("+254 7...") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("inquiry_input_phone"),
                        singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = R2MTeal,
                            unfocusedBorderColor = Color(0xFFCBD5E1)
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    OutlinedTextField(
                        value = message,
                        onValueChange = { message = it },
                        label = { Text("Target Counties / Details") },
                        placeholder = { Text("e.g. 5,000 kiosks across Nairobi & Nakuru") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .testTag("inquiry_input_message"),
                        minLines = 3,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = R2MTeal,
                            unfocusedBorderColor = Color(0xFFCBD5E1)
                        )
                    )

                    if (errorMessage != null) {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = errorMessage ?: "",
                            color = Color(0xFFDC2626),
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        },
        confirmButton = {
            if (isSuccess) {
                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(containerColor = R2MTeal)
                ) {
                    Text("Done")
                }
            } else {
                Button(
                    onClick = {
                        if (fullName.isBlank() || company.isBlank() || email.isBlank()) {
                            errorMessage = "Please enter your name, company, and email."
                            return@Button
                        }
                        errorMessage = null
                        isSubmitting = true
                        coroutineScope.launch {
                            delay(600)
                            R2MRepository.submitInquiry(
                                name = fullName,
                                company = company,
                                email = email,
                                phone = phone.ifBlank { "+254" },
                                service = initialService,
                                message = message.ifBlank { "General route inquiry for $company" }
                            )
                            isSubmitting = false
                            isSuccess = true
                        }
                    },
                    modifier = Modifier.testTag("inquiry_submit_button"),
                    enabled = !isSubmitting,
                    colors = ButtonDefaults.buttonColors(containerColor = R2MTeal)
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
                        Text("Submit Request")
                    }
                }
            }
        },
        dismissButton = {
            if (!isSuccess) {
                TextButton(onClick = onDismiss) {
                    Text("Cancel", color = R2MInkMuted)
                }
            }
        }
    )
}
