import { Analytics } from '@vercel/analytics/next'
import type { Metadata, Viewport } from 'next'
import { Manrope, Space_Grotesk } from 'next/font/google'
import { SiteHeader } from '@/components/site-header'
import { SiteFooter } from '@/components/site-footer'
import { BackToTop } from '@/components/back-to-top'
import './globals.css'

const manrope = Manrope({
  subsets: ['latin'],
  variable: '--font-manrope',
  display: 'swap',
})

const spaceGrotesk = Space_Grotesk({
  subsets: ['latin'],
  variable: '--font-display',
  display: 'swap',
})

const siteUrl = 'https://r2mbrands.com'

export const metadata: Metadata = {
  metadataBase: new URL(siteUrl),
  title: {
    default: 'R2M Brands Ltd | Sales, Merchandising & Route-to-Market Execution',
    template: '%s | R2M Brands Ltd',
  },
  description:
    'R2M Brands Ltd connects manufacturers to every shelf. Instore promotions, merchandising, foot soldiers, and wholesale & retail distribution across 47 counties in Kenya.',
  keywords: [
    'R2M Brands',
    'route to market Kenya',
    'FMCG distribution',
    'instore promotions',
    'merchandising',
    'foot soldiers',
    'wholesale distribution',
    'Nairobi',
  ],
  generator: 'v0.app',
  openGraph: {
    type: 'website',
    url: siteUrl,
    title: 'R2M Brands Ltd | Connecting Brands to the Market',
    description:
      'The last-mile engine for FMCG brands: instore promotions, merchandising, foot soldiers, and wholesale & retail distribution across 47 counties.',
    siteName: 'R2M Brands Ltd',
  },
  twitter: {
    card: 'summary_large_image',
    title: 'R2M Brands Ltd | Connecting Brands to the Market',
    description:
      'The last-mile engine for FMCG brands across 47 counties in Kenya.',
  },
  icons: {
    icon: [
      { url: '/favicon.ico', sizes: 'any' },
      { url: '/favicon-32x32.png', type: 'image/png', sizes: '32x32' },
      { url: '/favicon-192x192.png', type: 'image/png', sizes: '192x192' },
    ],
  },
}

export const viewport: Viewport = {
  colorScheme: 'light',
  themeColor: '#0d9488',
}

export default function RootLayout({
  children,
}: Readonly<{
  children: React.ReactNode
}>) {
  return (
    <html lang="en" className={`${manrope.variable} ${spaceGrotesk.variable}`}>
      <body className="font-sans antialiased">
        <SiteHeader />
        <main>{children}</main>
        <SiteFooter />
        <BackToTop />
        {process.env.NODE_ENV === 'production' && <Analytics />}
      </body>
    </html>
  )
}
