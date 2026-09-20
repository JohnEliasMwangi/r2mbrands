import Image from 'next/image'
import { Reveal } from '@/components/ui/reveal'

interface ServiceCardProps {
  id?: string
  kicker: string
  title: string
  blurb: string
  image: string
  delay?: number
}

export function ServiceCard({ id, kicker, title, blurb, image, delay = 0 }: ServiceCardProps) {
  return (
    <Reveal
      as="article"
      delay={delay}
      className="neu group scroll-mt-28 overflow-hidden rounded-3xl"
      id={id}
    >
      <div className="relative h-52 overflow-hidden">
        <Image
          src={image}
          alt={title}
          fill
          sizes="(max-width: 768px) 100vw, 400px"
          className="object-cover transition-transform duration-500 group-hover:scale-105"
        />
        <div className="absolute inset-0 bg-gradient-to-t from-[#0f1f1d]/70 via-transparent to-transparent" />
        <span className="absolute bottom-3 left-4 rounded-full bg-white/90 px-3 py-1 text-xs font-extrabold tracking-wide text-teal uppercase backdrop-blur">
          {kicker}
        </span>
      </div>
      <div className="p-6">
        <h3 className="font-display text-xl font-black">{title}</h3>
        <p className="mt-2 text-pretty text-ink-2">{blurb}</p>
      </div>
    </Reveal>
  )
}
