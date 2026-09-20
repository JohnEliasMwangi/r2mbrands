import type { Metadata } from 'next'
import { Container, SectionHead } from '@/components/primitives'
import { PageHero } from '@/components/page-hero'
import { ServiceCard } from '@/components/service-card'
import { CtaBand } from '@/components/cta-band'
import { Reveal } from '@/components/ui/reveal'
import { services } from '@/lib/site'

export const metadata: Metadata = {
  title: 'Services',
  description:
    'Instore promotions, merchandising, foot soldiers, and wholesale & retail distribution — full-service route-to-market execution from R2M Brands.',
}

const deliverables = [
  'Dedicated field teams and team leaders',
  'Route planning and journey optimisation',
  'Real-time visit and sell-out reporting',
  'Planogram compliance and share-of-shelf audits',
  'Price and promotion monitoring',
  'Stock and returns reconciliation',
]

export default function ServicesPage() {
  return (
    <>
      <PageHero
        eyebrow="Services"
        title={<>Everything the last mile demands</>}
        description="Pick one capability or the full stack. Either way, you get one accountable partner and one clear line of sight into the field."
      />

      <section className="py-10">
        <Container>
          <div className="grid gap-6 md:grid-cols-2">
            {services.map((service, i) => (
              <ServiceCard key={service.id} {...service} delay={i * 70} />
            ))}
          </div>
        </Container>
      </section>

      <section className="py-16">
        <Container>
          <div className="neu grid gap-8 rounded-[30px] p-8 md:grid-cols-2 md:p-12">
            <div>
              <SectionHead
                className="mx-0 mb-0 max-w-none text-left"
                eyebrow="What's Included"
                title="Execution you can actually see"
                description="Every engagement ships with the operational backbone that keeps coverage honest."
              />
            </div>
            <ul className="grid gap-3 sm:grid-cols-2 md:grid-cols-1">
              {deliverables.map((item, i) => (
                <Reveal
                  as="li"
                  key={item}
                  delay={i * 60}
                  className="neu-sm flex items-start gap-3 rounded-2xl px-4 py-3 text-sm font-semibold text-ink"
                >
                  <span className="mt-1.5 h-2 w-2 shrink-0 rounded-full bg-gradient-to-br from-teal to-teal-2" aria-hidden />
                  {item}
                </Reveal>
              ))}
            </ul>
          </div>
        </Container>
      </section>

      <CtaBand title="Which shelves do you want to own?" />
    </>
  )
}
