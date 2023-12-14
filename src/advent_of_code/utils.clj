(ns advent-of-code.utils)

;; get a vector of the input lines

(defn split-on-newlines [s] (clojure.string/split s #"\n"))