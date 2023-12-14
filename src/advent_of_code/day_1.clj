(ns advent-of-code.day-1
  (:require [advent-of-code.puzzle-inputs :as inputs]
            [clojure.string :as s]))

(def pt1-strings-to-numbers
  {"1" 1
   "2" 2
   "3" 3
   "4" 4
   "5" 5
   "6" 6
   "7" 7
   "8" 8
   "9" 9})

(def pt2-strings-to-numbers
  {"one" 1
   "1" 1
   "two" 2
   "2" 2
   "three" 3
   "3" 3
   "four" 4
   "4" 4
   "five" 5
   "5" 5
   "six" 6
   "6" 6
   "seven" 7
   "7" 7
   "eight" 8
   "8" 8
   "nine" 9
   "9" 9})

;; get a vector of the input lines

(defn split-on-newlines [s] (clojure.string/split s #"\n"))

;; get substrings from each index in the string - 0,1,2,3...

(defn substrings-after-indices [s indices]
  (map #(subs s %) indices))

(defn character-indices [s]
  (range 0 (count s)))

(defn substrings-from-start [s]
  (substrings-after-indices s (character-indices s)))

;; for each substring, figure out what number, if any, starts the string
;; customize how numbers can be found by passing a strings-to-numbers array

(defn get-number-starting-string [strings-to-numbers s]
  (some (fn [[key value]]
          (if (s/starts-with? s key)
            value))
        strings-to-numbers))

(defn get-numbers-starting-strings [strings-to-numbers strings]
  (map #(get-number-starting-string strings-to-numbers %) strings))

;; get rid of nils, representing substrings with no numbers

(defn remove-nils [numbers]
  (filter identity numbers))

;; get the first and last number, concatenate them to make the calibration value

(defn convert-to-calibration-value [ints]
  (let [string-ints (map #(str %) ints)
        calibration-string (str (first string-ints) (last string-ints))]
    (Integer/parseInt calibration-string)))

;; get calibration value for a string, given a map of number-representations-in-strings to numbers

(defn get-calibration-value [strings-to-numbers s]
  (->> s
       (substrings-from-start)
       (get-numbers-starting-strings strings-to-numbers)
       (remove-nils)
       (convert-to-calibration-value)))

;; shorthand for using the pt1 map from number-representations to numbers

(defn get-calibration-value-pt1 [s]
  (get-calibration-value pt1-strings-to-numbers s))

;; shorthand for using the pt2 map from number-representations to numbers

(defn get-calibration-value-pt2 [s]
  (get-calibration-value pt2-strings-to-numbers s))