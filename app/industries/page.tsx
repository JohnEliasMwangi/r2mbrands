import type { Metadata } from 'next'
import { Container } from '@/components/primitives'
import { PageHero } from '@/components/page-hero'
import { CtaBand } from '@/components/cta-band'
import { Reveal } from '@/components/ui/reveal'
import { industries } from '@/lib/site'

export const metadata: Metadata = {
  title: 'Industries',
  description:
    'R2M Brands serves fast-moving consumer goods categories across Kenya — food & beverage, personal care, home care, beverages, telecom, and agri-inputs.',
}

export default function IndustriesPage() {
  return (
    <>
      <PageHero
        eyebrow="Industries"
        title={<>Categories that live and die on the shelf</>}
        description="Fast-moving goods reward presence and punish gaps. We tailor coverage models to the rhythm of each category."
      />

      <section className="py-10">
        <Container>
          <div className="grid gap-6 sm:grid-cols-2 lg:grid-cols-3">
            {industries.map((industry, i) => (
              <Reveal
                key={industry.title}
                as="article"
                delay={i * 70}
                className="neu group rounded-3xl p-7"
              >
                <div className="neu-inset grid h-12 w-12 place-items-center rounded-2xl text-2xl">
                  <span aria-hidden>{industry.emoji}</span>
                </div>
                <h3 className="font-display mt-4 text-xl font-black">{industry.title}</h3>
                <p className="mt-2 text-pretty text-ink-2">{industry.blurb}</p>
              </Reveal>
            ))}
          </div>
        </Container>
      </section>

      <CtaBand title="Don't see your category? We adapt fast." />
    </>
  )
}
