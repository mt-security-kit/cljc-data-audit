
(ns data-audit.modify
    (:require [fruits.format.api :as format]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn format-number
  ; @description
  ;
  ; @param (*) n
  ; @param (string) format
  ;
  ; @usage
  ; (format-number "123456789" "000-000-000")
  ; =>
  ; "123-456-789"
  ;
  ; @return (string)
  [n format]
  (format/format-number n format {:cut? true}))

(defn trim-ends
  [n])

(defn remove-blanks
  [n])

(defn keep-latin-characters
  [n])

(defn keep-numeric-digits
  [n])
