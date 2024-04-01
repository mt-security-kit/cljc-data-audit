
(ns data-audit.patterns
    (:require [fruits.string.api :as string]
              [fruits.normalize.api :as normalize]
              [data-audit.config :as config]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn credit-card-number-pattern
  ; @important
  ; This function is incomplete and may not behave as expected.
  ;
  ; @description
  ; - Returns a regex pattern that matches valid credit card numbers.
  ; - A credit card number is considered valid if ...
  ;
  ; @usage
  ; (credit-card-number-pattern)
  ; =>
  ; #""
  ;
  ; @return (regex pattern)
  [])

(defn local-bank-account-number-pattern
  ; @description
  ; - Returns a regex pattern that matches valid local bank account numbers.
  ; - A local bank account number is considered valid if ...
  ;   ... its length is within a certain domain (9-18 digits),
  ;   ... it contains only decimal digits.
  ;
  ; @usage
  ; (local-bank-account-number-pattern)
  ; =>
  ; #"^[0-9]{9,18}$"
  ;
  ; @return (regex pattern)
  []
  #"^[0-9]{9,18}$")

(defn international-bank-account-number-pattern
  ; @important
  ; This function is incomplete and may not behave as expected.
  ;
  ; @description
  ; - Returns a regex pattern that matches valid international bank account numbers.
  ; - A international bank account number is considered valid if ...
  ;
  ; @usage
  ; (international-bank-account-number-pattern)
  ; =>
  ; #""
  ;
  ; @return (regex pattern)
  [])

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn email-address-pattern
  ; @links
  ; General Email Regex (RFC 5322 Official Standard)
  ; https://www.regextester.com/115911
  ;
  ; @description
  ; Returns a regex pattern that matches valid email addresses.
  ;
  ; @usage
  ; (email-address-pattern)
  ;
  ; @return (regex pattern)
  []
  #"^(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])$")

(defn phone-number-pattern
  ; @description
  ; - Returns a regex pattern that matches valid phone numbers.
  ; - A phone number is considered valid if ...
  ;   ... its length is within a certain domain,
  ;   ... its first character is a '+'.
  ;   ... it contains only decimal digits from the second character.
  ;
  ; @param (map)(opt) options
  ; {:max (integer)(opt)
  ;   Default: 20
  ;  :min (integer)(opt)
  ;   Default: 4}
  ;
  ; @usage
  ; (phone-number-pattern)
  ; =>
  ; #"^\+[0-9]{6,24}$"
  ;
  ; @return (regex pattern)
  ([]
   (phone-number-pattern {}))

  ([{:keys [max min] :or {max 20 min 4}}]
   (re-pattern (str "^\\+[0-9]{"min","max"}$"))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn latin-name-pattern
  ; @description
  ; - Returns a regex pattern that matches valid latin names.
  ; - A latin name is considered valid if ...
  ;   ... its length is within a certain domain,
  ;   ... it contains at least one latin letter or latin accented letter,
  ;   ... it contains only latin letters, latin accented letters, decimal digits, horizontal whitespaces and allowed special characters.
  ;
  ; @param (map)(opt) options
  ; {:max (integer)(opt)
  ;   Default: 32
  ;  :min (integer)(opt)
  ;   Default: 2
  ;  :specials (string)(opt)
  ;   Allowed special characters.
  ;   Default: "_-'."}
  ;
  ; @usage
  ; (latin-name-pattern)
  ; =>
  ; #"^(?=.*[a-zA-Zà-ýÀ-Ý])[a-zA-Zà-ýÀ-Ý0-9\h\_\-\'\.]{2,32}$"
  ;
  ; @return (regex pattern)
  ([]
   (latin-name-pattern {}))

  ([{:keys [max min specials] :or {max 32 min 2 specials config/LATIN-NAME-SPECIAL-CHARACTERS}}]
   (let [specials (string/escape-characters specials)]
        (re-pattern (str "^(?=.*[a-zA-Zà-ýÀ-Ý])[a-zA-Zà-ýÀ-Ý0-9\\h"specials"]{"min","max"}$")))))

(defn username-pattern
  ; @description
  ; - Returns a regex pattern that matches valid usernames.
  ; - A username is considered valid if ...
  ;   ... its length is within a certain domain,
  ;   ... it contains at least one latin letter,
  ;   ... it contains only latin letters, decimal digits, and allowed special characters.
  ;
  ; @param (map)(opt) options
  ; {:max (integer)(opt)
  ;   Default: 24
  ;  :min (integer)(opt)
  ;   Default: 4
  ;  :specials (string)(opt)
  ;   Allowed special characters.
  ;   Default: "_-."}
  ;
  ; @usage
  ; (username-pattern)
  ; =>
  ; #"^(?=.*[a-zA-Z])[a-zA-Z0-9\_\-\.]{4,24}$"
  ;
  ; @return (regex pattern)
  ([]
   (username-pattern {}))

  ([{:keys [max min specials] :or {max 24 min 4 specials config/USERNAME-SPECIAL-CHARACTERS}}]
   (let [specials (string/escape-characters specials)]
        (re-pattern (str "^(?=.*[a-zA-Z])[a-zA-Z0-9"specials"]{"min","max"}$")))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn password-pattern
  ; @description
  ; - Returns a regex pattern that matches valid passwords.
  ; - A password is considered valid if ...
  ;   ... its length is within a certain domain,
  ;   ... it contains at least one lowercase latin letter,
  ;   ... it contains at least one uppercase latin letter,
  ;   ... it contains at least one decimal digit,
  ;   ... it contains at least one special character,
  ;   ... it contains only latin letters, latin accented letters, decimal digits, and allowed special characters.
  ;
  ; @param (map)(opt) options
  ; {:max (integer)(opt)
  ;   Default: 32
  ;  :min (integer)(opt)
  ;   Default: 8
  ;  :specials (string)(opt)
  ;   Allowed special characters.
  ;   Default: "*@#!?=%,.:;-_+<>{}[]()'|/£€$~&§ß"}
  ;
  ; @usage
  ; (password-pattern)
  ; =>
  ; #"^(?=.*[a-ÿ])(?=.*[A-Z])(?=.*[0-9])(?=.*[\*\@\\#\!\?\=\%\,\.\:\;\-\_\+\<\>\{\}\[\]\(\)\'\|\/\£\€\$\~\&\§\ß])[a-ÿA-Ÿ0-9\*\@\\#\!\?\=\%\,\.\:\;\-\_\+\<\>\{\}\[\]\(\)\'\|\/\£\€\$\~\&\§\ß]{8,32}$"
  ;
  ; @return (regex pattern)
  ([]
   (password-pattern {}))

  ([{:keys [max min specials] :or {max 32 min 8 specials config/PASSWORD-SPECIAL-CHARACTERS}}]
   (let [specials (string/escape-characters specials)]
        (re-pattern (str "^(?=.*[a-ÿ])(?=.*[A-Ÿ])(?=.*[0-9])(?=.*["specials"])[a-ÿA-Ÿ0-9"specials"]{"min","max"}$")))))

(defn pin-code-pattern
  ; @description
  ; - Returns a regex pattern that matches valid PIN codes.
  ; - A PIN code is considered valid if ...
  ;   ... its length is within a certain domain,
  ;   ... it contains only decimal digits.
  ;
  ; @param (map)(opt) options
  ; {:max (integer)(opt)
  ;   Default: 8
  ;  :min (integer)(opt)
  ;   Default: 4}
  ;
  ; @usage
  ; (pin-code-pattern)
  ; =>
  ; #"^[0-9]{4,8}$"
  ;
  ; @return (regex pattern)
  ([]
   (pin-code-pattern {}))

  ([{:keys [max min] :or {max 8 min 4}}]
   (re-pattern (str "^[0-9]{"min","max"}$"))))

(defn security-code-pattern
  ; @description
  ; - Returns a regex pattern that matches valid security codes.
  ; - A security code is considered valid if ...
  ;   ... it has a certain length,
  ;   ... it contains only decimal digits.
  ;
  ; @param (map)(opt) options
  ; {:max (integer)(opt)
  ;   Default: 6
  ;  :min (integer)(opt)
  ;   Default: 6}
  ;
  ; @usage
  ; (security-code-pattern)
  ; =>
  ; #"^[0-9]{6,6}$"
  ;
  ; @return (regex pattern)
  ([]
   (security-code-pattern {}))

  ([{:keys [max min] :or {max 6 min 6}}]
   (re-pattern (str "^[0-9]{"min","max"}$"))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn ip-address-pattern
  ; @description
  ; Returns a regex pattern that matches valid IP addresses.
  ;
  ; @usage
  ; (ip-address-pattern)
  ; =>
  ; #"^([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3})$"
  ;
  ; @return (regex pattern)
  []
  #"^([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3})$")

(defn user-agent-pattern
  ; @description
  ; Returns a regex pattern that matches valid user agent strings.
  ; - A user agent string is considered valid if ...
  ;   ... it contains any of the given allowed agents.
  ;
  ; @param (map)(opt) options
  ; {:allowed-agents (strings in vector)(opt)
  ;   Default: ["Mozilla" "Chrome" "Safari"]}
  ;
  ; @usage
  ; (user-agent-pattern)
  ; =>
  ; #"Mozilla|Chrome|Safari"
  ;
  ; @return (regex pattern)
  ([]
   (user-agent-pattern {}))

  ([{:keys [allowed-agents] :or {allowed-agents ["Mozilla" "Chrome" "Safari"]}}]
   (-> allowed-agents (string/join "|")
                      (re-pattern))))
