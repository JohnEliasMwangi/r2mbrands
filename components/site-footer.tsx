import Link from 'next/link'
import Image from 'next/image'
import { contactInfo } from '@/lib/site'

const columns = [
  {
    heading: 'Services',
    links: [
      { label: 'Instore Promotions', href: '/services#instore' },
      { label: 'Merchandising', href: '/services#merch' },
      { label: 'Foot Soldiers', href: '/services#foot' },
      { label: 'Wholesale', href: '/services#wholesale' },
      { label: 'Retail', href: '/services#retail' },
    ],
  },
  {
    heading: 'Workflow',
    links: [
      { label: 'How We Work', href: '/approach' },
      { label: 'About', href: '/about' },
      { label: 'Industries', href: '/industries' },
    ],
  },
  {
    heading: 'Company',
    links: [
      { label: 'Who We Are', href: '/about' },
      { label: 'Insights', href: '/insights' },
      { label: 'Contact', href: '/contact' },
    ],
  },
]

export function SiteFooter() {
  return (
    <footer className="mt-16 bg-[#0f1f1d] text-[#c8d9d6]">
      <div className="mx-auto max-w-[1240px] px-6">
        <div className="grid gap-8 py-14 md:grid-cols-2 lg:grid-cols-[1.6fr_repeat(4,0.9fr)]">
          <div>
            <div className="mb-3.5 flex items-center gap-3">
              <div className="grid h-13 w-13 place-items-center rounded-2xl bg-[#173330] p-2">
                <Image
                  src="/brand/logo-icon.png"
                  alt=""
                  width={44}
                  height={44}
                  className="h-full w-full object-contain"
                />
              </div>
              <div>
                <span className="text-lg font-black text-white">
                  R2M <span className="text-[#2dd4bf]">Brands Ltd</span>
                </span>
                <span className="block text-xs font-semibold text-[#8fa8a3]">
                  Connecting Brands to the Market
                </span>
              </div>
            </div>
            <p className="max-w-sm text-sm leading-relaxed text-[#8fa8a3]">
              Sales &amp; marketing execution: instore promotions, merchandising, foot
              soldiers, and wholesale &amp; retail distribution across 47 counties.
            </p>
          </div>

          {columns.map((col) => (
            <div key={col.heading}>
              <h4 className="mb-3.5 text-sm font-bold text-white">{col.heading}</h4>
              <ul className="space-y-2.5">
                {col.links.map((link) => (
                  <li key={link.label}>
                    <Link
                      href={link.href}
                      className="text-sm text-[#8fa8a3] transition-colors hover:text-white"
                    >
                      {link.label}
                    </Link>
                  </li>
                ))}
              </ul>
            </div>
          ))}

          <div>
            <h4 className="mb-3.5 text-sm font-bold text-white">Contact</h4>
            <ul className="space-y-2.5 text-sm text-[#8fa8a3]">
              <li>
                <a href={contactInfo.phoneHref} className="transition-colors hover:text-white">
                  {contactInfo.phone}
                </a>
              </li>
              <li>
                <a href={`mailto:${contactInfo.email}`} className="transition-colors hover:text-white">
                  {contactInfo.email}
                </a>
              </li>
              <li>{contactInfo.location}</li>
            </ul>
          </div>
        </div>

        <div className="flex flex-wrap justify-between gap-2.5 border-t border-white/10 py-5 text-xs text-[#6d8a85]">
          <span>&copy; {new Date().getFullYear()} R2M Brands Limited.</span>
          <span className="font-semibold tracking-wide">Predict. Execute. Win.</span>
        </div>
      </div>
    </footer>
  )
}
