import Link from 'next/link'
import { ArrowRight } from 'lucide-react'
import { Container } from '@/components/primitives'
import { Reveal } from '@/components/ui/reveal'
import { contactInfo } from '@/lib/site'

export function CtaBand({
  title = 'Ready to reach every shelf?',
  subtitle = 'Tell us your brand, your targets, and the counties you want to own. We build the route-to-market engine that gets you there.',
}: {
  title?: string
  subtitle?: string
}) {
  return (
    <section className="py-20">
      <Container>
        <Reveal className="relative overflow-hidden rounded-[30px] bg-gradient-to-br from-[#0f1f1d] via-[#123b36] to-[#0d5b53] px-6 py-16 text-center text-white sm:px-14">
          <div
            className="pointer-events-none absolute -top-24 -right-24 h-72 w-72 rounded-full bg-teal-2/25 blur-3xl"
            aria-hidden
          />
          <div
            className="pointer-events-none absolute -bottom-24 -left-24 h-72 w-72 rounded-full bg-teal/25 blur-3xl"
            aria-hidden
          />
          <div className="relative">
            <h2 className="font-display mx-auto max-w-2xl text-3xl font-black text-balance sm:text-4xl">
              {title}
            </h2>
            <p className="mx-auto mt-4 max-w-xl text-pretty text-white/70">{subtitle}</p>
            <div className="mt-8 flex flex-wrap justify-center gap-3.5">
              <Link
                href="/contact"
                className="inline-flex items-center gap-2 rounded-xl bg-white px-6 py-3.5 text-sm font-extrabold text-[#0f1f1d] transition-transform hover:-translate-y-0.5"
              >
                Start a Conversation
                <ArrowRight size={16} />
              </Link>
              <a
                href={contactInfo.phoneHref}
                className="inline-flex items-center gap-2 rounded-xl border border-white/25 px-6 py-3.5 text-sm font-extrabold text-white transition-colors hover:bg-white/10"
              >
                {contactInfo.phone}
              </a>
            </div>
          </div>
        </Reveal>
      </Container>
    </section>
  )
}
