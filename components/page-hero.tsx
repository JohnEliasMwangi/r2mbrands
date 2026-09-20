import type { ReactNode } from 'react'
import { Container, Eyebrow } from '@/components/primitives'

export function PageHero({
  eyebrow,
  title,
  description,
  children,
}: {
  eyebrow: string
  title: ReactNode
  description?: ReactNode
  children?: ReactNode
}) {
  return (
    <section className="relative pt-[calc(var(--nav-h)+3.5rem)] pb-10">
      <Container>
        <div className="max-w-3xl">
          <Eyebrow>{eyebrow}</Eyebrow>
          <h1 className="font-display text-4xl leading-[1.05] font-black tracking-tight text-balance sm:text-5xl md:text-[3.4rem]">
            {title}
          </h1>
          {description ? (
            <p className="mt-5 max-w-2xl text-lg text-pretty text-ink-2">{description}</p>
          ) : null}
          {children}
        </div>
      </Container>
    </section>
  )
}
