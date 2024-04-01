
(ns data-audit.contain)

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn contains-any-horizontal-whitespace?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any horizontal whitespace character.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-any-horizontal-whitespace? "abc ")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"\h" n))))

(defn not-contains-any-horizontal-whitespace?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... does not contain any horizontal whitespace character.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (not-contains-any-horizontal-whitespace? "abc")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (nil? (re-find #"\h" n))))

(defn contains-only-horizontal-whitespaces?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any horizontal whitespace character,
  ; ... contains only horizontal whitespace characters.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-only-horizontal-whitespaces? "   ")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"^\h+$" n))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn contains-any-vertical-whitespace?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any vertical whitespace character.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-any-vertical-whitespace? "abc\n")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"\v" n))))

(defn not-contains-any-vertical-whitespace?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... does not contain any vertical whitespace character.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (not-contains-any-vertical-whitespace? "abc")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (nil? (re-find #"\v" n))))

(defn contains-only-vertical-whitespaces?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any vertical whitespace character,
  ; ... contains only vertical whitespace characters.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-only-vertical-whitespaces? "\n\n\n")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"^\v+$" n))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn contains-any-whitespace?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any horizontal and/or vertical whitespace character.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-any-whitespace? "abc\n")
  ; =>
  ; true
  ;
  ; @usage
  ; (contains-any-whitespace? "abc ")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"\s" n))))

(defn not-contains-any-whitespace?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... does not contain any whitespace character.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (not-contains-any-whitespace? "abc")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (nil? (re-find #"\s" n))))

(defn contains-only-whitespaces?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any whitespace character,
  ; ... contains only whitespace characters.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-only-whitespaces? " \n ")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"^\s+$" n))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn contains-any-digit?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any decimal digit.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-any-digit? "abc123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"[0-9]" n))))

(defn not-contains-any-digit?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... does not contain any decimal digit.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (not-contains-any-digit? "abc")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (nil? (re-find #"[0-9]" n))))

(defn contains-only-digits?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any decimal digit,
  ; ... contains only decimal digits.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-only-digits? "123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"^[0-9]+$" n))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn contains-any-latin-letter?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any latin letter or latin accented letter.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-any-latin-letter? "abc123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"[a-zA-Zà-ýÀ-Ý]" n))))

(defn not-contains-any-latin-letter?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... does not contain any latin letter or latin accented letter.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (not-contains-any-latin-letter? "123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (nil? (re-find #"[a-zA-Zà-ýÀ-Ý]" n))))

(defn contains-only-latin-letters?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any latin letter or latin accented letter,
  ; ... contains only latin letters and/or latin accented letters.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-only-latin-letters? "abc")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"^[a-zA-Zà-ýÀ-Ý]+$" n))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn contains-any-latin-lowercase-letter?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any latin lowercase letter or latin lowercase accented letter.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-any-latin-lowercase-letter? "abc123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"[a-zà-ý]" n))))

(defn not-contains-any-latin-lowercase-letter?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... does not contain any latin lowercase letter or latin lowercase accented letter.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (not-contains-any-latin-lowercase-letter? "ABC123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (nil? (re-find #"[a-zà-ý]" n))))

(defn contains-only-latin-lowercase-letters?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any latin lowercase letter or latin lowercase accented letter,
  ; ... contains only latin lowercase letters and/or latin lowercase accented letters.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-latin-lowercase-letters? "abc")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"^[a-zà-ý]+$" n))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn contains-any-latin-uppercase-letter?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any latin uppercase letter or latin uppercase accented letter.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-any-latin-uppercase-letter? "ABC123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"[A-ZÀ-Ý]" n))))

(defn not-contains-any-latin-uppercase-letter?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... does not contain any latin uppercase letter or latin uppercase accented letter.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (not-contains-any-latin-uppercase-letter? "abc123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (nil? (re-find #"[A-ZÀ-Ý]" n))))

(defn contains-only-latin-uppercase-letters?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any latin uppercase letter or latin uppercase accented letter,
  ; ... contains only latin uppercase letters and/or latin uppercase accented letters.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-only-latin-uppercase-letters? "ABC")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"^[A-ZÀ-Ý]+$" n))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn contains-any-latin-accented-letter?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any latin accented letter.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-any-latin-accented-letter? "ábc123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"[à-ýÀ-Ý]" n))))

(defn not-contains-any-latin-accented-letter?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... does not contain any latin accented letter.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (not-contains-any-latin-accented-letter? "abc123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (nil? (re-find #"[à-ýÀ-Ý]" n))))

(defn contains-only-latin-accented-letters?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any latin accented letter,
  ; ... contains only latin accented letters.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-only-latin-accented-letters? "áéí")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"^[à-ýÀ-Ý]+$" n))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn contains-any-latin-non-accented-letter?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any latin non-accented letter.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-any-latin-non-accented-letter? "abc123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"[a-zA-Z]" n))))

(defn not-contains-any-latin-non-accented-letter?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... does not contain any latin non-accented letter.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (not-contains-any-latin-non-accented-letter? "áéí123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (nil? (re-find #"[a-zA-Z]" n))))

(defn contains-only-latin-non-accented-letters?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any latin non-accented letter,
  ; ... contains only latin non-accented letters.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-only-latin-non-accented-letters? "abc")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"^[a-zA-Z]+$" n))))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

(defn contains-any-special-character?
  ; @description
  ; Returns TRUE if the given value
  ; ... contains any character that is not a whitespace, a numeric digit or a latin letter.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-any-special-character? "abc?!#")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"[^\s0-9a-zA-Zà-ýÀ-Ý]" n))))

(defn not-contains-any-special-character?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... does not contain any character that is not a whitespace, a numeric digit or a latin letter.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (not-contains-any-special-character? "abc123")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (nil? (re-find #"[^\s0-9a-zA-Zà-ýÀ-Ý]" n))))

(defn contains-only-special-characters?
  ; @description
  ; Returns TRUE if the given value ...
  ; ... contains any character that is not a whitespace, a numeric digit or a latin letter,
  ; ... contains only characters that are not whitespaces, numeric digits or latin letters.
  ;
  ; @param (*) n
  ;
  ; @usage
  ; (contains-only-special-characters? "?!#")
  ; =>
  ; true
  ;
  ; @return (boolean)
  [n]
  (let [n (str n)]
       (some? (re-find #"^[^\s0-9a-zA-Zà-ýÀ-Ý]+$" n))))
