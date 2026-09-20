'use client'

import { useState, type FormEvent } from 'react'
import { Check, Loader2 } from 'lucide-react'

const services = [
  'Instore Promotions',
  'Merchandising',
  'Foot Soldiers',
  'Wholesale Distribution',
  'Retail Distribution',
  'Full Route-to-Market',
]

export function ContactForm() {
  const [status, setStatus] = useState<'idle' | 'submitting' | 'done'>('idle')

  function handleSubmit(event: FormEvent<HTMLFormElement>) {
    event.preventDefault()
    setStatus('submitting')
    setTimeout(() => setStatus('done'), 900)
  }

  if (status === 'done') {
    return (
      <div className="neu flex flex-col items-center rounded-3xl p-10 text-center">
        <div className="grid h-14 w-14 place-items-center rounded-full bg-gradient-to-br from-teal to-teal-2 text-white">
          <Check size={26} />
        </div>
        <h3 className="font-display mt-5 text-2xl font-black">Message received</h3>
        <p className="mt-2 max-w-sm text-pretty text-ink-2">
          Thank you. Our team will be in touch within one business day to map out your route to
          market.
        </p>
      </div>
    )
  }

  return (
    <form onSubmit={handleSubmit} className="neu rounded-3xl p-7 sm:p-8">
      <div className="grid gap-5 sm:grid-cols-2">
        <Field label="Full name" htmlFor="name">
          <input id="name" name="name" required className="field-input" autoComplete="name" />
        </Field>
        <Field label="Company" htmlFor="company">
          <input id="company" name="company" required className="field-input" autoComplete="organization" />
        </Field>
        <Field label="Email" htmlFor="email">
          <input id="email" name="email" type="email" required className="field-input" autoComplete="email" />
        </Field>
        <Field label="Phone" htmlFor="phone">
          <input id="phone" name="phone" type="tel" className="field-input" autoComplete="tel" />
        </Field>
      </div>

      <div className="mt-5">
        <Field label="Service of interest" htmlFor="service">
          <select id="service" name="service" className="field-input" defaultValue="">
            <option value="" disabled>
              Select a service
            </option>
            {services.map((service) => (
              <option key={service} value={service}>
                {service}
              </option>
            ))}
          </select>
        </Field>
      </div>

      <div className="mt-5">
        <Field label="Tell us about your brand" htmlFor="message">
          <textarea
            id="message"
            name="message"
            rows={4}
            required
            className="field-input resize-none"
            placeholder="Categories, counties you want to cover, and your current volume."
          />
        </Field>
      </div>

      <button
        type="submit"
        disabled={status === 'submitting'}
        className="mt-6 inline-flex w-full items-center justify-center gap-2 rounded-xl bg-gradient-to-br from-teal to-teal-2 px-6 py-3.5 text-sm font-extrabold text-white shadow-[0_14px_30px_rgba(13,148,136,0.28)] transition-transform hover:-translate-y-0.5 disabled:opacity-70"
      >
        {status === 'submitting' ? (
          <>
            <Loader2 size={16} className="animate-spin" />
            Sending…
          </>
        ) : (
          'Send Message'
        )}
      </button>
    </form>
  )
}

function Field({
  label,
  htmlFor,
  children,
}: {
  label: string
  htmlFor: string
  children: React.ReactNode
}) {
  return (
    <label htmlFor={htmlFor} className="block">
      <span className="mb-2 block text-xs font-extrabold tracking-wide text-ink-2 uppercase">
        {label}
      </span>
      {children}
    </label>
  )
}
