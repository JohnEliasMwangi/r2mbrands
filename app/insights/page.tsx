import type { Metadata } from 'next'
import Image from 'next/image'
import Link from 'next/link'
import { ArrowRight } from 'lucide-react'
import { Container } from '@/components/primitives'
import { PageHero } from '@/components/page-hero'
import { CtaBand } from '@/components/cta-band'
import { Reveal } from '@/components/ui/reveal'

export const metadata: Metadata = {
  title: 'Insights',
  description:
    'Field-tested perspectives on route-to-market, distribution, and retail execution across Kenya from the R2M Brands team.',
}

const posts = [
  {
    tag: 'Route-to-Market',
    title: 'Why coverage leaks — and how to plug it',
    excerpt:
      'Most brands lose volume not at the factory but in the last mile. Here is where the leaks hide and how disciplined routing seals them.',
    image: '/images/foot-soldiers.webp',
    read: '5 min read',
  },
  {
    tag: 'Merchandising',
    title: 'The share-of-shelf math that decides your quarter',
    excerpt:
      'Facings are not vanity. We break down the relationship between share-of-shelf, availability, and sell-out in general trade.',
    image: '/images/merchandising.webp',
    read: '4 min read',
  },
  {
    tag: 'Distribution',
    title: 'Reaching all 47 counties without breaking OTIF',
    excerpt:
      'National reach and reliable delivery usually trade off. Here is the operating model that lets you have both.',
    image: '/images/wholesale-warehouse.webp',
    read: '6 min read',
  },
  {
    tag: 'Activation',
    title: 'Sampling that actually converts to reorders',
    excerpt:
      'Instore promotions only pay off when the trial turns into a habit. We share the metrics that separate noise from growth.',
    image: '/images/instore-promo.webp',
    read: '3 min read',
  },
]

export default function InsightsPage() {
  const [featured, ...rest] = posts

  return (
    <>
      <PageHero
        eyebrow="Insights"
        title={<>Notes from the field</>}
        description="Practical perspectives on execution, distribution, and winning the shelf in fast-moving Kenyan trade."
      />

      <section className="py-10">
        <Container>
          <Reveal className="neu group grid overflow-hidden rounded-[30px] lg:grid-cols-2">
            <div className="relative min-h-64 overflow-hidden">
              <Image
                src={featured.image}
                alt={featured.title}
                fill
                sizes="(max-width: 1024px) 100vw, 600px"
                className="object-cover transition-transform duration-500 group-hover:scale-105"
              />
            </div>
            <div className="flex flex-col justify-center p-8 md:p-12">
              <span className="neu-inset inline-flex w-fit rounded-full px-3 py-1 text-xs font-extrabold tracking-wide text-teal uppercase">
                {featured.tag}
              </span>
              <h2 className="font-display mt-4 text-2xl font-black text-balance sm:text-3xl">
                {featured.title}
              </h2>
              <p className="mt-3 text-pretty text-ink-2">{featured.excerpt}</p>
              <div className="mt-6 flex items-center gap-4 text-sm font-bold text-ink-2">
                <span>{featured.read}</span>
                <span className="inline-flex items-center gap-2 text-teal">
                  Read article <ArrowRight size={15} />
                </span>
              </div>
            </div>
          </Reveal>
        </Container>
      </section>

      <section className="pb-16">
        <Container>
          <div className="grid gap-6 md:grid-cols-3">
            {rest.map((post, i) => (
              <Reveal
                key={post.title}
                as="article"
                delay={i * 80}
                className="neu group flex flex-col overflow-hidden rounded-3xl"
              >
                <div className="relative h-44 overflow-hidden">
                  <Image
                    src={post.image}
                    alt={post.title}
                    fill
                    sizes="(max-width: 768px) 100vw, 360px"
                    className="object-cover transition-transform duration-500 group-hover:scale-105"
                  />
                </div>
                <div className="flex flex-1 flex-col p-6">
                  <span className="text-xs font-extrabold tracking-wide text-teal uppercase">
                    {post.tag}
                  </span>
                  <h3 className="font-display mt-2 text-lg font-black text-balance">{post.title}</h3>
                  <p className="mt-2 flex-1 text-sm text-pretty text-ink-2">{post.excerpt}</p>
                  <span className="mt-4 text-sm font-bold text-ink-2">{post.read}</span>
                </div>
              </Reveal>
            ))}
          </div>
          <p className="mt-10 text-center text-sm text-ink-2">
            Want a topic covered?{' '}
            <Link href="/contact" className="font-extrabold text-teal hover:text-teal-2">
              Ask our team
            </Link>
            .
          </p>
        </Container>
      </section>

      <CtaBand title="Turn these ideas into shelf wins" />
    </>
  )
}
