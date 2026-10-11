package com.example.r2mbrands.data

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object R2MRepository {

    val contactPhone = "+254 704 051 777"
    val contactPhoneUri = "tel:+254704051777"
    val contactEmail = "info@r2mbrands.com"
    val contactLocation = "Nairobi, Kenya"

    val stats = listOf(
        StatItem(target = 35000, suffix = "+", label = "Active Outlets"),
        StatItem(target = 47, suffix = "", label = "Counties Covered"),
        StatItem(target = 98, suffix = "%", label = "Delivery Success"),
        StatItem(target = 500, suffix = "+", label = "Foot Soldiers")
    )

    val values = listOf(
        ValuePill(
            title = "Accountability",
            body = "We own the number. Every visit, delivery, and activation is tracked and reported.",
            iconName = "target"
        ),
        ValuePill(
            title = "Partnership",
            body = "We act as an extension of your sales team, not a faceless vendor.",
            iconName = "handshake"
        ),
        ValuePill(
            title = "Growth",
            body = "We are measured by your sell-out, not our activity. Volume is the scoreboard.",
            iconName = "trending_up"
        ),
        ValuePill(
            title = "Integrity",
            body = "Real data from the field. No inflated coverage, no phantom outlets.",
            iconName = "shield_check"
        )
    )

    val services = listOf(
        ServiceItem(
            id = "instore",
            kicker = "Instore Promotions",
            title = "Sampling That Converts",
            blurb = "Trained brand ambassadors, tasting tables, and conversion tracked per hour.",
            deliverables = listOf(
                "Trained and audited brand ambassadors",
                "High-footfall hypermarket & supermarket activations",
                "Hourly sampling-to-purchase conversion tracking",
                "Branded display booths and POS collateral setups"
            ),
            iconName = "campaign"
        ),
        ServiceItem(
            id = "merch",
            kicker = "Merchandising",
            title = "Shelf Dominance",
            blurb = "Planogram compliance, facing discipline, and POSM on every visit.",
            deliverables = listOf(
                "Planogram compliance & share-of-shelf maximization",
                "Eyes-to-thighs prime facing maintenance",
                "POSM (Point of Sale Material) deployment & audit",
                "Expiry date rotation and damage mitigation"
            ),
            iconName = "layers"
        ),
        ServiceItem(
            id = "foot",
            kicker = "Foot Soldiers",
            title = "500+ Reps Daily",
            blurb = "General-trade coverage, duka to duka, across every route.",
            deliverables = listOf(
                "Disciplined beat/journey planning (35+ dukas/day)",
                "Pre-sales and spot cash order generation",
                "Geolocation-tagged digital visit verification",
                "Real-time stock level and competitor price capture"
            ),
            iconName = "directions_walk"
        ),
        ServiceItem(
            id = "wholesale",
            kicker = "Wholesale Distribution",
            title = "Bulk to Hubs, 98% OTIF",
            blurb = "Feeding the wholesalers who feed the dukas, on time and in full.",
            deliverables = listOf(
                "Primary and secondary wholesale fulfillment",
                "98% On-Time In-Full (OTIF) dispatch rate",
                "Central depot to regional hub consolidation",
                "Trade scheme enforcement and wholesale incentives"
            ),
            iconName = "warehouse"
        ),
        ServiceItem(
            id = "retail",
            kicker = "Retail Distribution",
            title = "Last-Mile Delivery",
            blurb = "Vans and boda fleets with photo proof of delivery.",
            deliverables = listOf(
                "Dedicated motorized van & motorcycle fleet",
                "Next-day fulfillment to neighborhood dukas",
                "Digital proof-of-delivery with photographic sign-off",
                "Returns reconciliation and cash collection integrity"
            ),
            iconName = "local_shipping"
        ),
        ServiceItem(
            id = "link",
            kicker = "Supply Chain Integration",
            title = "Manufacturer to Consumer",
            blurb = "Demand forecasting tied directly to real sell-out data.",
            deliverables = listOf(
                "Closed-loop replenishment planning",
                "Regional buffer stock allocation by county",
                "ERP integration and real-time dashboarding",
                "National coverage footprint across all 47 Kenyan counties"
            ),
            iconName = "hub"
        )
    )

    val deliverablesChecklist = listOf(
        "Dedicated field teams and experienced team leaders",
        "Route planning and GPS-guided journey optimisation",
        "Real-time visit and verified sell-out reporting",
        "Planogram compliance and share-of-shelf audits",
        "Competitor price and trade promotion monitoring",
        "Stock, credit, and returns reconciliation"
    )

    val approachPhases = listOf(
        WorkflowStep(
            stepNumber = 1,
            tag = "Predict",
            title = "Plan the coverage before the trucks roll",
            blurb = "We segment the universe of outlets, size the opportunity per route, and set outlet-level targets. Forecasting is grounded in real trade data, not guesswork.",
            keyMetric = "100% Census-Driven Targets",
            detailedAction = "Data teams ingest county demographics, duka density, and trade channel data to map optimal journey paths before dispatch."
        ),
        WorkflowStep(
            stepNumber = 2,
            tag = "Execute",
            title = "Put disciplined feet on every street",
            blurb = "Field teams work optimised journey plans, merchandise to planogram, run activations, and capture every visit in real time. Nothing depends on memory.",
            keyMetric = "35+ Outlets / Rep / Day",
            detailedAction = "Field reps follow scheduled beat plans on mobile tablets, taking geo-tagged photos of shelves, pricing, and orders."
        ),
        WorkflowStep(
            stepNumber = 3,
            tag = "Win",
            title = "Turn sell-out data into the next forecast",
            blurb = "Sell-out and compliance data flows back into planning, so each cycle is smarter than the last. Coverage compounds instead of leaking.",
            keyMetric = "+28% Reorder Compound Rate",
            detailedAction = "Automated analytics aggregate field telemetry to recalibrate delivery volume, ensuring zero out-of-stock occurrences."
        )
    )

    val workflowSteps = listOf(
        WorkflowStep(
            stepNumber = 1,
            tag = "Design",
            title = "Route & Universe Mapping",
            blurb = "Identify viable dukas, kiosks, and wholesalers in target territories.",
            keyMetric = "All 47 Counties",
            detailedAction = "Every route is mapped and zoned to prevent overlaps and maximise trade efficiency."
        ),
        WorkflowStep(
            stepNumber = 2,
            tag = "Planning",
            title = "Journey Optimization",
            blurb = "Assign daily journey schedules and stock targets per rep.",
            keyMetric = "Zero Idle Time",
            detailedAction = "Optimized routing cuts travel time so reps spend 80%+ of their day in front of retailers."
        ),
        WorkflowStep(
            stepNumber = 3,
            tag = "Fieldwork",
            title = "Boots on Ground Execution",
            blurb = "Duka visits, relationship building, spot orders, and POS placement.",
            keyMetric = "500+ Daily Reps",
            detailedAction = "R2M foot soldiers maintain high trust and personal relationships with shopkeepers."
        ),
        WorkflowStep(
            stepNumber = 4,
            tag = "Shelf Care",
            title = "Merchandising & Sampling",
            blurb = "Planogram compliance, facing visibility, and live activations.",
            keyMetric = "Prime Shelf Share",
            detailedAction = "Ensure shoppers see, taste, and choose your brand when they stand before the counter."
        ),
        WorkflowStep(
            stepNumber = 5,
            tag = "Logistics",
            title = "OTIF Last-Mile Delivery",
            blurb = "Fulfill orders rapidly with digital photo proof of delivery.",
            keyMetric = "98% OTIF",
            detailedAction = "Fast delivery protects retailer goodwill and keeps cash flowing smoothly."
        ),
        WorkflowStep(
            stepNumber = 6,
            tag = "Intelligence",
            title = "Sell-Out Feedback Loop",
            blurb = "Real-time field telemetry recalibrates the next production batch.",
            keyMetric = "Live Telemetry",
            detailedAction = "Manufacturers gain complete visibility down to individual retailer reorder rates."
        )
    )

    val industries = listOf(
        IndustryItem(
            emoji = "🥤",
            title = "Food & Beverage",
            blurb = "High-velocity SKUs where out-of-stock means a lost sale. We keep shelves full and facings clean.",
            category = "FMCG",
            coverageHighlights = "General trade, kiosks, modern supermarkets, school kiosks",
            averageTurnaround = "Daily / 48hr replenishment"
        ),
        IndustryItem(
            emoji = "🧴",
            title = "Personal Care",
            blurb = "Impulse and habit categories that reward premium visibility and consistent sampling.",
            category = "FMCG",
            coverageHighlights = "Cosmetics shops, pharmacies, modern retail chains, salons",
            averageTurnaround = "Weekly journey cycle"
        ),
        IndustryItem(
            emoji = "🧽",
            title = "Home Care",
            blurb = "Bulky, price-sensitive lines where distribution efficiency protects your margin.",
            category = "FMCG",
            coverageHighlights = "Wholesale depots, mid-tier supermarkets, estate mini-marts",
            averageTurnaround = "Semi-weekly bulk dispatch"
        ),
        IndustryItem(
            emoji = "🍺",
            title = "Beverages & Spirits",
            blurb = "Compliance-heavy trade that demands trained reps and airtight route discipline.",
            category = "Beverages",
            coverageHighlights = "Bars, lounges, wines & spirits retailers, distributors",
            averageTurnaround = "Scheduled route drops"
        ),
        IndustryItem(
            emoji = "📱",
            title = "Telecom & Airtime",
            blurb = "Ultra-wide distribution where presence in every single duka is the whole game.",
            category = "Services",
            coverageHighlights = "M-Pesa agents, street vendors, transport hub stalls",
            averageTurnaround = "Daily float & SIM availability"
        ),
        IndustryItem(
            emoji = "🌾",
            title = "Agri-Inputs",
            blurb = "Seasonal demand and rural reach that our county-level coverage is custom-built for.",
            category = "Agriculture",
            coverageHighlights = "Agrovets, farming co-operatives, rural market days",
            averageTurnaround = "Seasonal surge allocation"
        )
    )

    val insights = listOf(
        InsightArticle(
            id = "leakage",
            tag = "Route-to-Market",
            title = "Why coverage leaks — and how to plug it",
            excerpt = "Most brands lose volume not at the factory but in the last mile. Here is where the leaks hide and how disciplined routing seals them.",
            fullContent = """
                Manufacturers in East Africa invest heavily in plant capacity, formulation, packaging, and above-the-line marketing. Yet when quarterly volume figures arrive, sell-out consistently falls short of projections.
                
                The culprit is almost never production — it is route leakage. Leakage occurs when:
                1. Phantom Outlets: Reps report visiting 40 outlets, but 12 are either closed or non-existent.
                2. Stockouts between cycles: A fast-selling SKU empties on Tuesday, but the next truck isn't scheduled until the following Monday.
                3. Facing erosion: Competitors offer cash discounts to push your product behind newer arrivals on the shelf.
                
                R2M Brands plugs these leaks through GPS-verified visit verification, strict 35+ duka daily cadence, and instant restock alerts. When every visit is transparent, volume doesn't leak — it compounds.
            """.trimIndent(),
            readTime = "5 min read",
            author = "Operations Lead, R2M Brands",
            date = "March 2026"
        ),
        InsightArticle(
            id = "shelf-share",
            tag = "Merchandising",
            title = "The share-of-shelf math that decides your quarter",
            excerpt = "Facings are not vanity. We break down the mathematical relationship between share-of-shelf, availability, and sell-out in general trade.",
            fullContent = """
                In Kenyan trade, the average shopper spends less than 4 seconds making a category decision in front of a duka counter.
                
                If your brand commands 3 facings out of 10, statistical choice probability is 30%. If merchandising discipline increases that to 6 facings, sales jump by over 110% due to eye-level dominance.
                
                Our field audit team tracks:
                - Eyes-to-thighs placement ratio
                - POSM sticker and hanging card visibility
                - Competitor promotional bundles
                
                Regular auditing turns shelf space from a passive holding spot into an active sales driver.
            """.trimIndent(),
            readTime = "4 min read",
            author = "Head of Trade Marketing",
            date = "February 2026"
        ),
        InsightArticle(
            id = "national-otif",
            tag = "Distribution",
            title = "Reaching all 47 counties without breaking OTIF",
            excerpt = "National reach and reliable delivery usually trade off. Here is the operating model that lets you have both.",
            fullContent = """
                Expanding beyond Nairobi and Mombasa to places like Lodwar, Garissa, Kisii, and Bungoma often results in fractured logistics, damaged cartons, and frustrated stockists.
                
                The traditional model relies on third-party long-haul couriers who lack cold-chain or shelf-handling care.
                
                R2M's Hub-and-Spoke model changes this:
                - 6 Regional consolidation depots
                - Daily local hub stock balancing
                - Dedicated two-wheeler and van fleets for final 5km delivery
                
                This architecture guarantees 98% On-Time In-Full (OTIF) delivery, whether your retailer is on Kimathi Street in Nairobi or in rural Kitui.
            """.trimIndent(),
            readTime = "6 min read",
            author = "Logistics Director",
            date = "January 2026"
        ),
        InsightArticle(
            id = "sampling-conversion",
            tag = "Activation",
            title = "Sampling that actually converts to reorders",
            excerpt = "Instore promotions only pay off when trial turns into habit. We share the field metrics that separate noise from growth.",
            fullContent = """
                Handing out free cups or sample sachets in a supermarket is easy; turning those trials into registered recurring purchases is where most campaigns fail.
                
                At R2M Brands, our brand ambassadors are trained not just to smile and sample, but to guide the shopper directly to the shelf for an immediate basket conversion.
                
                Key activation benchmarks:
                - Minimum 45 consumer interactions per active ambassador hour
                - Target 35% immediate on-the-spot cart conversion
                - Store inventory replenishment synchronized directly with activation weekends
                
                When sampling is integrated with route stock availability, volume spikes become permanent market share.
            """.trimIndent(),
            readTime = "3 min read",
            author = "Activations Manager",
            date = "January 2026"
        )
    )

    private val _submittedInquiries = MutableStateFlow<List<Inquiry>>(
        listOf(
            Inquiry(
                id = 1L,
                fullName = "Grace Wanjiku",
                company = "Savannah Organics Ltd",
                email = "gwanjiku@savannah.co.ke",
                phone = "+254 722 345 678",
                service = "Full Route-to-Market",
                message = "Looking to distribute premium natural juices across Nairobi and Kiambu retail chains.",
                timestamp = "Recent"
            )
        )
    )
    val submittedInquiries: StateFlow<List<Inquiry>> = _submittedInquiries.asStateFlow()

    fun submitInquiry(
        name: String,
        company: String,
        email: String,
        phone: String,
        service: String,
        message: String
    ): Boolean {
        val dateFormat = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
        val newInquiry = Inquiry(
            fullName = name,
            company = company,
            email = email,
            phone = phone,
            service = service,
            message = message,
            timestamp = dateFormat.format(Date())
        )
        _submittedInquiries.value = listOf(newInquiry) + _submittedInquiries.value
        return true
    }
}
