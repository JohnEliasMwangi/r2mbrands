'use client'

import { useEffect, useState } from 'react'
import Link from 'next/link'
import Image from 'next/image'
import { usePathname } from 'next/navigation'
import { Menu, X } from 'lucide-react'
import { navLinks } from '@/lib/site'
import { cn } from '@/lib/utils'

export function SiteHeader() {
  const pathname = usePathname()
  const [scrolled, setScrolled] = useState(false)
  const [open, setOpen] = useState(false)

  useEffect(() => {
    const onScroll = () => setScrolled(window.scrollY > 12)
    onScroll()
    window.addEventListener('scroll', onScroll, { passive: true })
    return () => window.removeEventListener('scroll', onScroll)
  }, [])

  useEffect(() => {
    setOpen(false)
  }, [pathname])

  useEffect(() => {
    document.body.style.overflow = open ? 'hidden' : ''
    return () => {
      document.body.style.overflow = ''
    }
  }, [open])

  const isActive = (href: string) =>
    href === '/' ? pathname === '/' : pathname.startsWith(href)

  return (
    <header
      className={cn(
        'fixed inset-x-0 top-0 z-100 flex h-[var(--nav-h)] items-center px-6 transition-all duration-300',
        scrolled &&
          'bg-surface/85 shadow-[0_1px_0_var(--border),0_12px_30px_rgba(18,32,38,0.06)] backdrop-blur-xl backdrop-saturate-150',
      )}
    >
      <div className="mx-auto flex w-full max-w-[1240px] items-center justify-between gap-6">
        <Link href="/" className="flex items-center" aria-label="R2M Brands home">
          <Image
            src="/brand/logo-primary.png"
            alt="R2M Brands Ltd"
            width={160}
            height={44}
            priority
            className="h-11 w-auto object-contain"
          />
        </Link>

        <nav className="hidden items-center gap-1 lg:flex" aria-label="Primary">
          {navLinks.map((link) => (
            <Link
              key={link.href}
              href={link.href}
              className={cn(
                'rounded-[10px] px-3.5 py-2.5 text-sm font-bold text-ink-2 transition-all hover:text-ink',
                isActive(link.href) && 'neu-inset text-ink',
              )}
            >
              {link.label}
            </Link>
          ))}
          <Link
            href="/contact"
            className="ml-2 inline-flex items-center justify-center rounded-xl bg-gradient-to-br from-teal to-teal-2 px-5 py-2.5 text-sm font-extrabold text-white shadow-[0_10px_24px_rgba(13,148,136,0.25)] transition-transform hover:-translate-y-0.5"
          >
            Let&apos;s Talk
          </Link>
        </nav>

        <button
          type="button"
          onClick={() => setOpen((v) => !v)}
          aria-label={open ? 'Close menu' : 'Open menu'}
          aria-expanded={open}
          className="neu-sm grid h-11 w-11 place-items-center rounded-xl text-ink lg:hidden"
        >
          {open ? <X size={20} /> : <Menu size={20} />}
        </button>
      </div>

      {/* Mobile menu */}
      <div
        className={cn(
          'fixed inset-x-0 top-[var(--nav-h)] bottom-0 z-90 flex flex-col gap-1.5 bg-surface/97 p-6 backdrop-blur-xl transition-transform duration-300 lg:hidden',
          open ? 'translate-y-0' : 'pointer-events-none -translate-y-[105%]',
        )}
      >
        {navLinks.map((link) => (
          <Link
            key={link.href}
            href={link.href}
            className={cn(
              'rounded-2xl px-4.5 py-4 text-lg font-extrabold transition-all',
              isActive(link.href) ? 'neu-inset text-ink' : 'text-ink hover:neu-inset',
            )}
          >
            {link.label}
          </Link>
        ))}
        <Link
          href="/contact"
          className="mt-2 rounded-2xl bg-gradient-to-br from-teal to-teal-2 px-4.5 py-4 text-lg font-extrabold text-white"
        >
          Let&apos;s Talk
        </Link>
      </div>
    </header>
  )
}
