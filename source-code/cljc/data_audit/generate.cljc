
(ns data-audit.generate
    (:require [fruits.loop.api   :refer [reduce-range]]
              [fruits.math.api   :as math]
              [fruits.random.api :as random]
              [data-audit.config :as config]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn generate-password
  ; @description
  ; Returns a randomly generated password containing at least one uppercase letter, lowercase letter, special character, and decimal digit.
  ;
  ; @param (integer)(opt) length
  ; Default: 8
  ; Min: 4
  ;
  ; @usage
  ; (generate-password 4)
  ; =>
  ; "Yi4_"
  ;
  ; @usage
  ; (generate-password 8)
  ; =>
  ; "AQga12*?"
  ;
  ; @return (string)
  ([]
   (generate-password 8))

  ([length]
   (let [length (max 4 length)]
        (letfn [(f0 [set length] (reduce-range (fn [%1 _] (str %1 (rand-nth set))) nil length))
                (f1 [pos]        (if (<= pos (rem length 4)) 1 0))]
               (let [lowercase-set "abcdefghijklmnopqrstuvxyz"
                     uppercase-set "ABCDEFGHIJKLMNOPQRSTUVXYZ"
                     numeric-set   "0123456789"]
                    (str (f0 uppercase-set                      (+ (math/floor (/ length 4)) (f1 1)))
                         (f0 lowercase-set                      (+ (math/floor (/ length 4)) (f1 2)))
                         (f0 numeric-set                        (+ (math/floor (/ length 4)) (f1 3)))
                         (f0 config/PASSWORD-SPECIAL-CHARACTERS (+ (math/floor (/ length 4)) (f1 4)))))))))

(defn generate-pin-code
  ; @description
  ; Returns a randomly generated PIN code.
  ;
  ; @param (integer)(opt) length
  ; Default: 4
  ;
  ; @usage
  ; (generate-pin-code)
  ; =>
  ; "1234"
  ;
  ; @usage
  ; (generate-pin-code 6)
  ; =>
  ; "123456"
  ;
  ; @return (string)
  ([]
   (generate-pin-code 4))

  ([length]
   (-> length random/generate-integer str)))

(defn generate-security-code
  ; @description
  ; Returns a randomly generated security code.
  ;
  ; @param (integer)(opt) length
  ; Default: 6
  ;
  ; @usage
  ; (generate-security-code)
  ; =>
  ; "123456"
  ;
  ; @usage
  ; (generate-security-code 8)
  ; =>
  ; "12345678"
  ;
  ; @return (string)
  ([]
   (generate-security-code 6))

  ([length]
   (-> length random/generate-integer str)))
