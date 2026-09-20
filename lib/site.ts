export const navLinks = [
  { href: '/', label: 'Home' },
  { href: '/about', label: 'Who We Are' },
  { href: '/services', label: 'What We Do' },
  { href: '/approach', label: 'Workflow' },
  { href: '/industries', label: 'Industries' },
  { href: '/insights', label: 'Insights' },
] as const

export const contactInfo = {
  phone: '+254 704 051 777',
  phoneHref: 'tel:+254704051777',
  email: 'info@r2mbrands.com',
  location: 'Nairobi, Kenya',
}

export const services = [
  {
    id: 'instore',
    kicker: 'Instore Promotions',
    title: 'Sampling That Converts',
    blurb: 'Trained brand ambassadors, tasting tables, and conversion tracked per hour.',
    image: '/images/instore-promo.webp',
  },
  {
    id: 'merch',
    kicker: 'Merchandising',
    title: 'Shelf Dominance',
    blurb: 'Planogram compliance, facing discipline, and POSM on every visit.',
    image: '/images/merchandising.webp',
  },
  {
    id: 'foot',
    kicker: 'Foot Soldiers',
    title: '500+ Reps Daily',
    blurb: 'General-trade coverage, duka to duka, across every route.',
    image: '/images/foot-soldiers.webp',
  },
  {
    id: 'wholesale',
    kicker: 'Wholesale',
    title: 'Bulk to Hubs, 98% OTIF',
    blurb: 'Feeding the wholesalers who feed the dukas, on time and in full.',
    image: '/images/wholesale-warehouse.webp',
  },
  {
    id: 'retail',
    kicker: 'Retail',
    title: 'Last-Mile Delivery',
    blurb: 'Vans and boda fleets with photo proof of delivery.',
    image: '/images/lastmile-delivery.webp',
  },
  {
    id: 'link',
    kicker: 'Supply Chain',
    title: 'Manufacturer to Consumer',
    blurb: 'Demand forecasting tied directly to real sell-out data.',
    image: '/images/factory-manufacturing.webp',
  },
] as const

export const stats = [
  { target: 35000, suffix: '+', label: 'Active Outlets' },
  { target: 47, suffix: '', label: 'Counties' },
  { target: 98, suffix: '%', label: 'Delivery Success' },
  { target: 500, suffix: '+', label: 'Foot Soldiers' },
] as const

export const industries = [
  {
    emoji: '🥤',
    title: 'Food & Beverage',
    blurb: 'High-velocity SKUs where out-of-stock means a lost sale. We keep shelves full and facings clean.',
  },
  {
    emoji: '🧴',
    title: 'Personal Care',
    blurb: 'Impulse and habit categories that reward premium visibility and consistent sampling.',
  },
  {
    emoji: '🧽',
    title: 'Home Care',
    blurb: 'Bulky, price-sensitive lines where distribution efficiency protects your margin.',
  },
  {
    emoji: '🍺',
    title: 'Beverages & Spirits',
    blurb: 'Compliance-heavy trade that demands trained reps and airtight route discipline.',
  },
  {
    emoji: '📱',
    title: 'Telecom & Airtime',
    blurb: 'Ultra-wide distribution where presence in every duka is the whole game.',
  },
  {
    emoji: '🌾',
    title: 'Agri-Inputs',
    blurb: 'Seasonal demand and rural reach that our county-level coverage is built for.',
  },
] as const

export const workflow = [
  { image: '/images/factory-manufacturing.webp', title: 'Predict', blurb: 'Forecast demand by outlet' },
  { image: '/images/wholesale-warehouse.webp', title: 'Plan Route', blurb: 'Warehouse allocation' },
  { image: '/images/foot-soldiers.webp', title: 'Execute Visit', blurb: '35+ visits per day' },
  { image: '/images/merchandising.webp', title: 'Merch & Promo', blurb: 'Shelf compliance + sampling' },
  { image: '/images/lastmile-delivery.webp', title: 'Deliver', blurb: 'Last-mile proof of delivery' },
  { image: '/images/instore-promo.webp', title: 'Win & Reorder', blurb: 'Sell-out drives the next order' },
] as const
