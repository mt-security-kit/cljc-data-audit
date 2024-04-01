
(ns data-audit.api
    (:require [data-audit.valid    :as valid]
              [data-audit.generate :as generate]
              [data-audit.patterns :as patterns]
              [data-audit.contain :as contain]
              [data-audit.modify :as modify]
              [data-audit.length :as length]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @redirect (data-audit.contain/*)
(def contains-any-horizontal-whitespace?         contain/contains-any-horizontal-whitespace?)
(def not-contains-any-horizontal-whitespace?     contain/not-contains-any-horizontal-whitespace?)
(def contains-only-horizontal-whitespaces?       contain/contains-only-horizontal-whitespaces?)
(def contains-any-vertical-whitespace?           contain/contains-any-vertical-whitespace?)
(def not-contains-any-vertical-whitespace?       contain/not-contains-any-vertical-whitespace?)
(def contains-only-vertical-whitespaces?         contain/contains-only-vertical-whitespaces?)
(def contains-any-whitespace?                    contain/contains-any-whitespace?)
(def not-contains-any-whitespace?                contain/not-contains-any-whitespace?)
(def contains-only-whitespaces?                  contain/contains-only-whitespaces?)
(def contains-any-digit?                         contain/contains-any-digit?)
(def not-contains-any-digit?                     contain/not-contains-any-digit?)
(def contains-only-digits?                       contain/contains-only-digits?)
(def contains-any-latin-letter?                  contain/contains-any-latin-letter?)
(def not-contains-any-latin-letter?              contain/not-contains-any-latin-letter?)
(def contains-only-latin-letters?                contain/contains-only-latin-letters?)
(def contains-any-latin-lowercase-letter?        contain/contains-any-latin-lowercase-letter?)
(def not-contains-any-latin-lowercase-letter?    contain/not-contains-any-latin-lowercase-letter?)
(def contains-only-latin-lowercase-letters?      contain/contains-only-latin-lowercase-letters?)
(def contains-any-latin-uppercase-letter?        contain/contains-any-latin-uppercase-letter?)
(def not-contains-any-latin-uppercase-letter?    contain/not-contains-any-latin-uppercase-letter?)
(def contains-only-latin-uppercase-letters?      contain/contains-only-latin-uppercase-letters?)
(def contains-any-latin-accented-letter?         contain/contains-any-latin-accented-letter?)
(def not-contains-any-latin-accented-letter?     contain/not-contains-any-latin-accented-letter?)
(def contains-only-latin-accented-letters?       contain/contains-only-latin-accented-letters?)
(def contains-any-latin-non-accented-letter?     contain/contains-any-latin-non-accented-letter?)
(def not-contains-any-latin-non-accented-letter? contain/not-contains-any-latin-non-accented-letter?)
(def contains-only-latin-non-accented-letters?   contain/contains-only-latin-non-accented-letters?)
(def contains-any-special-character?             contain/contains-any-special-character?)
(def not-contains-any-special-character?         contain/not-contains-any-special-character?)
(def contains-only-special-characters?           contain/contains-only-special-characters?)

; @redirect (data-audit.length/*)
(def length-under?   length/length-under?)
(def length-over?    length/length-over?)
(def length-between? length/length-between?)
(def length-matches? length/length-matches?)
(def length-some?    length/length-some?)

; @redirect (data-audit.modify/*)
(def format-number modify/format-number)

; @redirect (data-audit.generate/*)
(def generate-password      generate/generate-password)
(def generate-pin-code      generate/generate-pin-code)
(def generate-security-code generate/generate-security-code)

; @redirect (data-audit.patterns/*)
(def email-address-pattern patterns/email-address-pattern)
(def phone-number-pattern  patterns/phone-number-pattern)
(def latin-name-pattern    patterns/latin-name-pattern)
(def username-pattern      patterns/username-pattern)
(def password-pattern      patterns/password-pattern)
(def pin-code-pattern      patterns/pin-code-pattern)
(def security-code-pattern patterns/security-code-pattern)
(def ip-address-pattern    patterns/ip-address-pattern)
(def user-agent-pattern    patterns/user-agent-pattern)

; @redirect (data-audit.valid/*)
(def email-address-valid? valid/email-address-valid?)
(def phone-number-valid?  valid/phone-number-valid?)
(def latin-name-valid?    valid/latin-name-valid?)
(def username-valid?      valid/username-valid?)
(def password-valid?      valid/password-valid?)
(def pin-code-valid?      valid/pin-code-valid?)
(def security-code-valid? valid/security-code-valid?)
(def ip-address-valid?    valid/ip-address-valid?)
(def user-agent-valid?    valid/user-agent-valid?)
