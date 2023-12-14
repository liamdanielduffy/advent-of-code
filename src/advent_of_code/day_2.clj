(ns advent-of-code.day-2
  (:require [clojure.string :as s]
            [advent-of-code.utils :as utils]))

(def num-cubes-regex #"\d{1,2} (blue|red|green)")


;;cube-samples are all tuples of [color, num-marbles] listed in a game
(defn get-cube-samples [input-line] (->> input-line
                                         (re-seq num-cubes-regex)
                                         (map first)
                                         (map #(s/split % #" "))
                                         (map #(vector
                                                 (last %)
                                                 (Integer/parseInt (first %))))))

(defn get-game-id [input-line] (->> input-line
                                    (re-seq #"(?<=Game )\d+")
                                    (first)
                                    (Integer/parseInt)))


(defn is-possible-game [cube-samples max-cubes-by-color]
  (->> cube-samples
       (every? (fn [[cube-color num-cubes]]
                 (let [max-cubes (get max-cubes-by-color cube-color)]
                   (< num-cubes max-cubes))))))

(defn remove-impossible-games [max-cubes-by-color input-lines]
  (filter #(is-possible-game (get-cube-samples %) max-cubes-by-color) input-lines))
