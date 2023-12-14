(ns advent-of-code.day-2
  (:require [clojure.string :as s]
            [advent-of-code.utils :as utils]))

(def num-cubes-regex #"\d{1,2} (blue|red|green)")

(defn get-color-num-tuples [input-line] (->> input-line
                                             (re-seq num-cubes-regex)
                                             (map first)
                                             (map #(s/split % #" "))
                                             (map #(vector
                                                     (last %)
                                                     (Integer/parseInt (first %))))))