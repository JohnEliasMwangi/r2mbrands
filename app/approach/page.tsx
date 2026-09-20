import type { Metadata } from 'next'
import { Container, SectionHead } from '@/components/primitives'
import { PageHero } from '@/components/page-hero'
import { WorkflowChain } from '@/components/workflow-chain'
import { CtaBand } from '@/components/cta-band'
import { Reveal } from '@/components/ui/reveal'

export const metadata: Metadata = {
  title: 'Our Approach',
  description:
    'Predict, Execute, Win — the closed-loop route-to-market methodology R2M Brands uses to compound coverage across Kenya.',
}

const phases = [
  {
    tag: 'Predict',
    title: 'Plan the coverage before the trucks roll',
    body: 'We segment the universe of outlets, size the opportunity per route, and set outlet-level targets. Forecasting is grounded in real trade data, not guesswork.',
  },
  {
    tag: 'Execute',
    title: 'Put disciplined feet on every street',
    body: 'Field teams work optimised journey plans, merchandise to planogram, run activations, and capture every visit in real time. Nothing depends on memory.',
  },
  {
    tag: 'Win',
    title: 'Turn sell-out data into the next forecast',
    body: 'Sell-out and compliance data flows back into planning, so each cycle is smarter than the last. Coverage compounds instead of leaking.',
  },
]

export default function ApproachPage() {
  return (
    <>
      <PageHero
        eyebrow="Our Approach"
        title={
          <>
            Predict. Execute. <span className="text-gradient">Win.</span>
          </>
        }
        description="A closed loop that connects planning to the field and back again. It is how we keep coverage honest and growth repeatable."
      />

      <section className="py-10">
        <Container>
          <div className="grid gap-6 md:grid-cols-3">
            {phases.map((phase, i) => (
              <Reveal key={phase.tag} delay={i * 90} className="neu relative rounded-3xl p-7">
                <span className="font-display text-6xl font-black text-black/5">
                  0{i + 1}
                </span>
                <span className="neu-inset mt-2 inline-flex rounded-full px-3 py-1 text-xs font-extrabold tracking-wide text-teal uppercase">
                  {phase.tag}
                </span>
                <h3 className="font-display mt-3 text-xl font-black text-balance">{phase.title}</h3>
                <p className="mt-2 text-pretty text-ink-2">{phase.body}</p>
              </Reveal>
            ))}
          </div>
        </Container>
      </section>

      <section className="py-16">
        <Container>
          <SectionHead
            eyebrow="The Workflow"
            title="Six steps, one accountable loop"
            description="From route design to reporting, each step hands clean data to the next."
          />
          <WorkflowChain />
        </Container>
      </section>

      <CtaBand title="See the loop run on your brand" />
    </>
  )
}
