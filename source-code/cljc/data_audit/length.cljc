
(ns data-audit.length
    (:require [fruits.string.api :as string]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn length-under?
  ; @description
  ; Returns TRUE if the length of the given value is not greater than the given length.
  ;
  ; @param (*) n
  ; @param (integer) length
  ;
  ; @usage
  ; (length-under? "My value" 16)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n length]
  (-> n (string/length-max? length)))

(defn length-over?
  ; @description
  ; Returns TRUE if the length of the given value is not smaller than the given length.
  ;
  ; @param (*) n
  ; @param (integer) length
  ;
  ; @usage
  ; (length-over? "My value" 4)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n length]
  (-> n (string/length-min? length)))

(defn length-between?
  ; @description
  ; Returns TRUE if the length of the given value falls between the given minumum and maximum lengths.
  ;
  ; @param (*) n
  ; @param (integer) min
  ; @param (integer) max
  ;
  ; @usage
  ; (length-between? "My value" 4 16)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n min max]
  (-> n (string/length-between? min max)))

(defn length-matches?
  ; @description
  ; Returns TRUE if the length of the given value matches the given length.
  ;
  ; @param (*) n
  ; @param (integer) length
  ;
  ; @usage
  ; (length-between? "My value" 8)
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n length]
  (-> n (string/length? length)))

(defn length-some?
  ; @description
  ; Returns TRUE if the length of the given value is not 0.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (length-some? "My value")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (-> n (string/length-min? 1)))
