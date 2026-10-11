package com.example.r2mbrands.data

data class ServiceItem(
    val id: String,
    val kicker: String,
    val title: String,
    val blurb: String,
    val deliverables: List<String> = emptyList(),
    val iconName: String = "store"
)

data class StatItem(
    val target: Int,
    val suffix: String,
    val label: String
)

data class IndustryItem(
    val emoji: String,
    val title: String,
    val blurb: String,
    val category: String,
    val coverageHighlights: String,
    val averageTurnaround: String
)

data class WorkflowStep(
    val stepNumber: Int,
    val tag: String,
    val title: String,
    val blurb: String,
    val keyMetric: String,
    val detailedAction: String
)

data class ValuePill(
    val title: String,
    val body: String,
    val iconName: String
)

data class InsightArticle(
    val id: String,
    val tag: String,
    val title: String,
    val excerpt: String,
    val fullContent: String,
    val readTime: String,
    val author: String = "R2M Field Intelligence",
    val date: String = "Trade Report 2026"
)

data class Inquiry(
    val id: Long = System.currentTimeMillis(),
    val fullName: String,
    val company: String,
    val email: String,
    val phone: String,
    val service: String,
    val message: String,
    val timestamp: String
)
