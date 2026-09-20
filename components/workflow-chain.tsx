import Image from 'next/image'
import { workflow } from '@/lib/site'
import { Reveal } from '@/components/ui/reveal'

export function WorkflowChain() {
  return (
    <ol className="grid gap-5 sm:grid-cols-2 lg:grid-cols-3">
      {workflow.map((step, i) => (
        <Reveal
          key={step.title}
          as="li"
          delay={i * 80}
          className="neu group relative overflow-hidden rounded-3xl p-2.5"
        >
          <div className="relative h-40 overflow-hidden rounded-2xl">
            <Image
              src={step.image}
              alt=""
              fill
              sizes="(max-width: 640px) 100vw, 380px"
              className="object-cover transition-transform duration-500 group-hover:scale-105"
            />
            <span className="absolute top-3 left-3 grid h-9 w-9 place-items-center rounded-full bg-gradient-to-br from-teal to-teal-2 text-sm font-black text-white shadow-lg">
              {i + 1}
            </span>
          </div>
          <div className="px-3 pt-4 pb-3">
            <h3 className="font-display text-lg font-black">{step.title}</h3>
            <p className="mt-1 text-sm text-ink-2">{step.blurb}</p>
          </div>
        </Reveal>
      ))}
    </ol>
  )
}
