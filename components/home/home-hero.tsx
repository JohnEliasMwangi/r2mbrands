import Link from 'next/link'
import Image from 'next/image'
import { ArrowRight, MapPin } from 'lucide-react'
import { Container } from '@/components/primitives'
import { Reveal } from '@/components/ui/reveal'

export function HomeHero() {
  return (
    <section className="relative overflow-hidden pt-[calc(var(--nav-h)+2.5rem)] pb-14">
      <Container className="grid items-center gap-12 lg:grid-cols-[1.05fr_0.95fr]">
        <div>
          <Reveal>
            <span className="neu-inset mb-5 inline-flex items-center gap-2 rounded-full px-4 py-2 text-xs font-extrabold tracking-wide text-teal uppercase">
              <span className="animate-pulse-dot h-1.5 w-1.5 rounded-full bg-teal" aria-hidden />
              Route-to-Market Execution
            </span>
          </Reveal>
          <Reveal delay={80}>
            <h1 className="font-display text-4xl leading-[1.02] font-black tracking-tight text-balance sm:text-5xl md:text-[3.75rem]">
              We connect brands to <span className="text-gradient">every shelf</span> in Kenya.
            </h1>
          </Reveal>
          <Reveal delay={160}>
            <p className="mt-5 max-w-xl text-lg text-pretty text-ink-2">
              R2M Brands is the last-mile engine for FMCG. Instore promotions, merchandising,
              foot soldiers, and wholesale &amp; retail distribution — one accountable partner
              from the factory to the consumer.
            </p>
          </Reveal>
          <Reveal delay={240}>
            <div className="mt-8 flex flex-wrap items-center gap-3.5">
              <Link
                href="/contact"
                className="inline-flex items-center gap-2 rounded-xl bg-gradient-to-br from-teal to-teal-2 px-6 py-3.5 text-sm font-extrabold text-white shadow-[0_14px_30px_rgba(13,148,136,0.28)] transition-transform hover:-translate-y-0.5"
              >
                Build My Route to Market
                <ArrowRight size={16} />
              </Link>
              <Link
                href="/services"
                className="neu-sm inline-flex items-center gap-2 rounded-xl px-6 py-3.5 text-sm font-extrabold text-ink transition-transform hover:-translate-y-0.5"
              >
                See What We Do
              </Link>
            </div>
          </Reveal>
          <Reveal delay={320}>
            <p className="mt-6 inline-flex items-center gap-2 text-sm font-semibold text-ink-2">
              <MapPin size={15} className="text-teal" />
              Coverage across all 47 counties &mdash; Predict. Execute. Win.
            </p>
          </Reveal>
        </div>

        <Reveal delay={200} className="relative">
          <div className="neon-wrap mx-auto max-w-md">
            <div className="overflow-hidden bg-card p-2.5">
              <div className="relative aspect-4/5 overflow-hidden rounded-3xl">
                <Image
                  src="/images/foot-soldiers.webp"
                  alt="R2M foot soldiers activating outlets in the field"
                  fill
                  priority
                  sizes="(max-width: 1024px) 90vw, 440px"
                  className="object-cover"
                />
                <div className="absolute inset-0 bg-gradient-to-t from-[#0f1f1d]/55 via-transparent to-transparent" />
              </div>
            </div>
          </div>
          <div className="neu absolute -bottom-5 -left-2 hidden rounded-2xl px-5 py-3.5 sm:block">
            <div className="font-display text-2xl font-black text-gradient">98% OTIF</div>
            <div className="text-xs font-bold tracking-wide text-ink-2 uppercase">On time, in full</div>
          </div>
        </Reveal>
      </Container>
    </section>
  )
}
