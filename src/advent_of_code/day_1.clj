(ns advent-of-code.day-1
  (:require [advent-of-code.puzzle-inputs :as inputs]))

(defn split-on-newlines [s] (clojure.string/split s #"\n"))

(defn remove-non-digits [s] (clojure.string/replace s #"[^\d]" ""))

(defn get-calibration-value [s]
  (Integer/parseInt (str (first s) (last s))))

(defn sum-calibration-values [s]
  (->> s
       (split-on-newlines)
       (map remove-non-digits)
       (map get-calibration-value)
       (apply +)))