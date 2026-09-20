import Link from 'next/link'
import { ArrowRight } from 'lucide-react'
import { Container, SectionHead } from '@/components/primitives'
import { HomeHero } from '@/components/home/home-hero'
import { StatPills } from '@/components/stat-pills'
import { ServiceCard } from '@/components/service-card'
import { WorkflowChain } from '@/components/workflow-chain'
import { CtaBand } from '@/components/cta-band'
import { Reveal } from '@/components/ui/reveal'
import { services } from '@/lib/site'

const industries = [
  'Food & Beverage',
  'Personal Care',
  'Home Care',
  'Alcoholic Beverages',
  'Telecom & Airtime',
  'Agri-Inputs',
]

export default function HomePage() {
  return (
    <>
      <HomeHero />

      <section className="py-10">
        <Container>
          <StatPills />
        </Container>
      </section>

      <section className="py-16">
        <Container>
          <SectionHead
            eyebrow="What We Do"
            title="One partner for the whole last mile"
            description="From the moment stock leaves the factory to the moment a shopper picks it off the shelf, we own the execution."
          />
          <div className="grid gap-6 md:grid-cols-2 lg:grid-cols-3">
            {services.map((service, i) => (
              <ServiceCard key={service.id} {...service} delay={i * 70} />
            ))}
          </div>
        </Container>
      </section>

      <section className="py-16">
        <Container>
          <SectionHead
            eyebrow="How We Work"
            title="Predict. Execute. Win."
            description="A closed loop where real sell-out data feeds the next forecast — so coverage compounds instead of leaking."
          />
          <WorkflowChain />
          <div className="mt-9 text-center">
            <Link
              href="/approach"
              className="inline-flex items-center gap-2 text-sm font-extrabold text-teal transition-colors hover:text-teal-2"
            >
              Explore the full workflow
              <ArrowRight size={16} />
            </Link>
          </div>
        </Container>
      </section>

      <section className="py-16">
        <Container>
          <div className="neu grid items-center gap-8 rounded-[30px] p-8 md:grid-cols-2 md:p-12">
            <div>
              <SectionHead
                className="mx-0 mb-0 max-w-none text-left"
                eyebrow="Industries"
                title="Built for fast-moving categories"
                description="We speak the language of trade, from mama mbogas to modern retail chains."
              />
            </div>
            <div className="flex flex-wrap gap-3">
              {industries.map((industry, i) => (
                <Reveal
                  key={industry}
                  delay={i * 60}
                  className="neu-sm rounded-full px-5 py-3 text-sm font-bold text-ink"
                >
                  {industry}
                </Reveal>
              ))}
            </div>
          </div>
        </Container>
      </section>

      <CtaBand />
    </>
  )
}
