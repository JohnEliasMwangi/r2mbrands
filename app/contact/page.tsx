import type { Metadata } from 'next'
import { Phone, Mail, MapPin } from 'lucide-react'
import { Container, Eyebrow } from '@/components/primitives'
import { ContactForm } from '@/components/contact-form'
import { Reveal } from '@/components/ui/reveal'
import { contactInfo } from '@/lib/site'

export const metadata: Metadata = {
  title: 'Contact',
  description:
    'Talk to R2M Brands about instore promotions, merchandising, and wholesale & retail distribution across Kenya.',
}

const channels = [
  { icon: Phone, label: 'Call us', value: contactInfo.phone, href: contactInfo.phoneHref },
  { icon: Mail, label: 'Email', value: contactInfo.email, href: `mailto:${contactInfo.email}` },
  { icon: MapPin, label: 'Head office', value: contactInfo.location, href: undefined },
]

export default function ContactPage() {
  return (
    <section className="pt-[calc(var(--nav-h)+3rem)] pb-16">
      <Container className="grid gap-12 lg:grid-cols-[0.9fr_1.1fr]">
        <div>
          <Eyebrow>Contact</Eyebrow>
          <h1 className="font-display text-4xl leading-[1.05] font-black tracking-tight text-balance sm:text-5xl">
            Let&apos;s map your route to market
          </h1>
          <p className="mt-5 max-w-md text-lg text-pretty text-ink-2">
            Tell us about your brand and targets. We&apos;ll show you exactly how we reach the
            shelves that matter.
          </p>

          <div className="mt-9 space-y-4">
            {channels.map((channel, i) => (
              <Reveal key={channel.label} delay={i * 80} className="neu flex items-center gap-4 rounded-2xl p-4">
                <span className="neu-inset grid h-11 w-11 shrink-0 place-items-center rounded-xl text-teal">
                  <channel.icon size={19} />
                </span>
                <div>
                  <div className="text-xs font-extrabold tracking-wide text-ink-2 uppercase">
                    {channel.label}
                  </div>
                  {channel.href ? (
                    <a href={channel.href} className="font-bold text-ink transition-colors hover:text-teal">
                      {channel.value}
                    </a>
                  ) : (
                    <div className="font-bold text-ink">{channel.value}</div>
                  )}
                </div>
              </Reveal>
            ))}
          </div>
        </div>

        <ContactForm />
      </Container>
    </section>
  )
}
