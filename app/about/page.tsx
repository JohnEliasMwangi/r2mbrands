import type { Metadata } from 'next'
import Image from 'next/image'
import { Target, Handshake, TrendingUp, ShieldCheck } from 'lucide-react'
import { Container, SectionHead } from '@/components/primitives'
import { PageHero } from '@/components/page-hero'
import { StatPills } from '@/components/stat-pills'
import { CtaBand } from '@/components/cta-band'
import { Reveal } from '@/components/ui/reveal'

export const metadata: Metadata = {
  title: 'Who We Are',
  description:
    'R2M Brands Ltd is a Kenyan route-to-market and sales execution company connecting manufacturers to retailers across 47 counties.',
}

const values = [
  {
    icon: Target,
    title: 'Accountability',
    body: 'We own the number. Every visit, delivery, and activation is tracked and reported.',
  },
  {
    icon: Handshake,
    title: 'Partnership',
    body: 'We act as an extension of your sales team, not a faceless vendor.',
  },
  {
    icon: TrendingUp,
    title: 'Growth',
    body: 'We are measured by your sell-out, not our activity. Volume is the scoreboard.',
  },
  {
    icon: ShieldCheck,
    title: 'Integrity',
    body: 'Real data from the field. No inflated coverage, no phantom outlets.',
  },
]

export default function AboutPage() {
  return (
    <>
      <PageHero
        eyebrow="Who We Are"
        title={<>The team between your brand and the shopper</>}
        description="R2M Brands Ltd is a sales and marketing execution company built for the realities of the Kenyan market — where trust, presence, and consistency win the shelf."
      />

      <section className="py-10">
        <Container className="grid items-center gap-10 lg:grid-cols-2">
          <Reveal className="neon-wrap">
            <div className="overflow-hidden bg-card p-2.5">
              <div className="relative aspect-16/11 overflow-hidden rounded-3xl">
                <Image
                  src="/images/wholesale-warehouse.webp"
                  alt="R2M distribution warehouse operations"
                  fill
                  sizes="(max-width: 1024px) 90vw, 560px"
                  className="object-cover"
                />
              </div>
            </div>
          </Reveal>
          <div>
            <SectionHead
              className="mx-0 mb-6 max-w-none text-left"
              eyebrow="Our Story"
              title="From the factory floor to the last duka"
            />
            <div className="space-y-4 text-pretty text-ink-2">
              <p>
                Manufacturers make great products. The hard part is getting them into tens of
                thousands of outlets, keeping them on shelf, and making sure shoppers choose them.
                That gap is where brands lose the most volume — and it is exactly where R2M lives.
              </p>
              <p>
                We combine boots-on-the-ground field teams with disciplined route planning and
                real-time reporting. The result is a route-to-market engine that turns national
                ambition into outlet-level execution, one visit at a time.
              </p>
              <p>
                Today we activate outlets in all 47 counties, feeding the wholesalers and
                retailers who ultimately serve every Kenyan household.
              </p>
            </div>
          </div>
        </Container>
      </section>

      <section className="py-12">
        <Container>
          <StatPills />
        </Container>
      </section>

      <section className="py-16">
        <Container>
          <SectionHead
            eyebrow="What We Believe"
            title="The values that keep us on the road"
          />
          <div className="grid gap-6 sm:grid-cols-2 lg:grid-cols-4">
            {values.map((value, i) => (
              <Reveal key={value.title} delay={i * 80} className="neu rounded-3xl p-6">
                <div className="neu-inset grid h-12 w-12 place-items-center rounded-2xl text-teal">
                  <value.icon size={22} />
                </div>
                <h3 className="font-display mt-4 text-lg font-black">{value.title}</h3>
                <p className="mt-2 text-sm text-pretty text-ink-2">{value.body}</p>
              </Reveal>
            ))}
          </div>
        </Container>
      </section>

      <CtaBand title="Let's put your brand on every shelf" />
    </>
  )
}
