import type { ReactNode } from 'react'
import { cn } from '@/lib/utils'

export function Container({
  children,
  className,
}: {
  children: ReactNode
  className?: string
}) {
  return (
    <div className={cn('mx-auto w-full max-w-[1240px] px-5 sm:px-6 lg:px-8', className)}>
      {children}
    </div>
  )
}

export function Eyebrow({ children }: { children: ReactNode }) {
  return (
    <span className="neu-inset mb-4 inline-flex items-center gap-2 rounded-full px-4 py-2 text-xs font-extrabold tracking-wide text-teal uppercase">
      <span className="animate-pulse-dot h-1.5 w-1.5 rounded-full bg-teal" aria-hidden />
      {children}
    </span>
  )
}

export function SectionHead({
  eyebrow,
  title,
  description,
  className,
}: {
  eyebrow?: string
  title: ReactNode
  description?: ReactNode
  className?: string
}) {
  return (
    <div className={cn('mx-auto mb-8 max-w-3xl text-center sm:mb-11', className)}>
      {eyebrow ? <Eyebrow>{eyebrow}</Eyebrow> : null}
      <h2 className="font-display text-3xl leading-tight font-black tracking-tight text-balance sm:text-4xl md:text-[2.6rem]">
        {title}
      </h2>
      {description ? (
        <p className="mx-auto mt-3 max-w-[58ch] text-pretty text-ink-2">{description}</p>
      ) : null}
    </div>
  )
}
