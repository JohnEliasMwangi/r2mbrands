import { Counter } from '@/components/ui/counter'
import { Reveal } from '@/components/ui/reveal'
import { stats } from '@/lib/site'
import { cn } from '@/lib/utils'

export function StatPills({ className }: { className?: string }) {
  return (
    <div className={cn('grid grid-cols-2 gap-4 sm:grid-cols-4', className)}>
      {stats.map((stat, i) => (
        <Reveal
          key={stat.label}
          delay={i * 90}
          className="neu rounded-2xl px-4 py-6 text-center"
        >
          <div className="font-display text-3xl font-black text-gradient sm:text-4xl">
            <Counter target={stat.target} suffix={stat.suffix} />
          </div>
          <div className="mt-1 text-xs font-bold tracking-wide text-ink-2 uppercase">
            {stat.label}
          </div>
        </Reveal>
      ))}
    </div>
  )
}
