'use client'

import { useEffect, useState } from 'react'
import { ArrowUp } from 'lucide-react'
import { cn } from '@/lib/utils'

export function BackToTop() {
  const [show, setShow] = useState(false)

  useEffect(() => {
    const onScroll = () => setShow(window.scrollY > 600)
    window.addEventListener('scroll', onScroll, { passive: true })
    return () => window.removeEventListener('scroll', onScroll)
  }, [])

  return (
    <button
      type="button"
      aria-label="Back to top"
      onClick={() => window.scrollTo({ top: 0, behavior: 'smooth' })}
      className={cn(
        'neu-sm fixed right-5 bottom-5 z-80 grid h-12 w-12 place-items-center rounded-xl text-teal transition-all duration-300',
        show ? 'translate-y-0 opacity-100' : 'pointer-events-none translate-y-2.5 opacity-0',
      )}
    >
      <ArrowUp size={20} />
    </button>
  )
}
