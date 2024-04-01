
(ns data-audit.config)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; @description
; Allowed special characters in latin names.
;
; @usage
; LATIN-NAME-SPECIAL-CHARACTERS
; =>
; "_-'."
;
; @constant (string)
(def LATIN-NAME-SPECIAL-CHARACTERS "_-'.")

; @description
; Allowed special characters in passwords.
;
; @usage
; PASSWORD-SPECIAL-CHARACTERS
; =>
; "_-."
;
; @constant (string)
(def PASSWORD-SPECIAL-CHARACTERS "*@#!?=%,.:;-_+<>{}[]()'|/£€$~&§ß")

; @description
; Allowed special characters in usernames.
;
; @usage
; USERNAME-SPECIAL-CHARACTERS
; =>
; "_-."
;
; @constant (string)
(def USERNAME-SPECIAL-CHARACTERS "_-.")
