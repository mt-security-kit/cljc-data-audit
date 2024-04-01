
(ns data-audit.valid
    (:require [data-audit.patterns :as patterns]
              [fruits.regex.api    :as regex]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn credit-card-number-valid?
  ; @important
  ; This function is incomplete and may not behave as expected.
  ;
  ; @description
  ; - Returns TRUE if the given value is a valid credit card number.
  ; - A credit card number is considered valid if ...
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (credit-card-number-valid? "...")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n])

(defn local-bank-account-number-valid?
  ; @description
  ; - Returns TRUE if the given value is a valid local bank account number.
  ; - A local bank account number is considered valid if ...
  ;   ... its length is within a certain domain (9-18 digits),
  ;   ... it contains only decimal decimal digits.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (local-bank-account-number-valid? "123456789")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (regex/re-match? (-> n str)
                   (patterns/local-bank-account-number-pattern)))

(defn international-bank-account-number-valid?
  ; @important
  ; This function is incomplete and may not behave as expected.
  ;
  ; @description
  ; - Returns TRUE if the given value is a valid international bank account number.
  ; - A international bank account number is considered valid if ...
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (international-bank-account-number-valid? "...")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n])

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn email-address-valid?
  ; @links
  ; General Email Regex (RFC 5322 Official Standard)
  ; https://www.regextester.com/115911
  ;
  ; @description
  ; Returns TRUE if the given value is a valid email address.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (email-address-valid? "user@provider.com")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (regex/re-match? (-> n str)
                   (patterns/email-address-pattern)))

(defn phone-number-valid?
  ; @description
  ; - Returns TRUE if the given value is a valid phone number.
  ; - A phone number is considered valid if ...
  ;   ... its length is within a certain domain,
  ;   ... its first character is a '+'.
  ;   ... it contains only decimal digits from the second character.
  ;
  ; @param (*) n
  ; @param (map)(opt) options
  ; {:max (integer)(opt)
  ;   Default: 20
  ;  :min (integer)(opt)
  ;   Default: 4}
  ;
  ; @usage
  ; (phone-number-valid? "+123456789")
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([n]
   (phone-number-valid? n {}))

  ([n options]
   (regex/re-match? (-> n str)
                    (-> options patterns/phone-number-pattern))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn latin-name-valid?
  ; @description
  ; - Returns TRUE if the given value is a valid latin name.
  ; - A latin name is considered valid if ...
  ;   ... its length is within a certain domain,
  ;   ... it contains at least one latin letter or latin accented letter,
  ;   ... it contains only latin letters, latin accented letters, decimal digits, horizontal whitespaces and allowed special characters.
  ;
  ; @param (*) n
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
  ; (latin-name-valid? "John O'Reilly")
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([n]
   (latin-name-valid? n {}))

  ([n options]
   (regex/re-match? (-> n str)
                    (-> options patterns/latin-name-pattern))))

(defn username-valid?
  ; @description
  ; - Returns TRUE if the given value is a valid username.
  ; - A username is considered valid if ...
  ;   ... its length is within a certain domain,
  ;   ... it contains at least one latin letter,
  ;   ... it contains only latin letters, decimal digits, and allowed special characters.
  ;
  ; @param (*) n
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
  ; (username-valid? "My-user69")
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([n]
   (username-valid? n {}))

  ([n options]
   (regex/re-match? (-> n str)
                    (-> options patterns/username-pattern))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn password-valid?
  ; @description
  ; - Returns TRUE if the given value is a valid password.
  ; - A password is considered valid if ...
  ;   ... its length is within a certain domain,
  ;   ... it contains at least one lowercase latin letter,
  ;   ... it contains at least one uppercase latin letter,
  ;   ... it contains at least one decimal digit,
  ;   ... it contains at least one special character,
  ;   ... it contains only latin letters, latin accented letters, decimal digits, and allowed special characters.
  ;
  ; @param (*) n
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
  ; (password-valid? "Password1234")
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([n]
   (password-valid? n {}))

  ([n options]
   (regex/re-match? (-> n str)
                    (-> options patterns/password-pattern))))

(defn pin-code-valid?
  ; @description
  ; - Returns TRUE if the given value is a valid PIN code.
  ; - A PIN code is considered valid if ...
  ;   ... its length is within a certain domain,
  ;   ... it contains only decimal digits.
  ;
  ; @param (*) n
  ; @param (map)(opt) options
  ; {:max (integer)(opt)
  ;   Default: 8
  ;  :min (integer)(opt)
  ;   Default: 4}
  ;
  ; @usage
  ; (pin-code-valid? "1234")
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([n]
   (pin-code-valid? n {}))

  ([n options]
   (regex/re-match? (-> n str)
                    (-> options patterns/pin-code-pattern))))

(defn security-code-valid?
  ; @description
  ; - Returns TRUE if the given value is a valid security code.
  ; - A security code is considered valid if ...
  ;   ... it has a certain length,
  ;   ... it contains only decimal digits.
  ;
  ; @param (*) n
  ; @param (map)(opt) options
  ; {:max (integer)(opt)
  ;   Default: 6
  ;  :min (integer)(opt)
  ;   Default: 6}
  ;
  ; @usage
  ; (security-code-valid? "123456")
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([n]
   (security-code-valid? n {}))

  ([n options]
   (regex/re-match? (-> n str)
                    (-> options patterns/security-code-pattern))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn ip-address-valid?
  ; @description
  ; Returns TRUE if the given value is a valid IP address.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (ip-address-valid? "0.0.0.0")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (regex/re-match? (-> n str)
                   (patterns/ip-address-pattern)))

(defn user-agent-valid?
  ; @description
  ; - Returns TRUE if the given value is a valid user-agent string.
  ; - A user agent string is considered valid if ...
  ;   ... it contains any of the given allowed agents.
  ;
  ; @param (*) n
  ; @param (map)(opt) options
  ; {:allowed-agents (strings in vector)(opt)
  ;   Default: ["Mozilla" "Chrome" "Safari"]}
  ;
  ; @usage
  ; (user-agent-valid? "Mozilla/5.0 (Linux; Android 10; SM-G960U) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.101 Mobile Safari/537.36")
  ; =>
  ; true
  ;
  ; @return (boolean)
  ([n]
   (user-agent-valid? n {}))

  ([n options]
   (regex/re-match? (-> n str)
                    (-> options patterns/user-agent-pattern))))
