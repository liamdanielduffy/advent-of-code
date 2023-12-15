(ns advent-of-code.day-2
  (:require [clojure.string :as s]
            [advent-of-code.utils :as utils]))

(def num-cubes-regex #"\d{1,2} (blue|red|green)")

(def game-id-regex #"(?<=Game )\d+")

(def max-cubes-by-color { "red" 12 "blue" 14 "green" 13})

;;cube-samples are all tuples of [color, num-marbles] listed in a game

(defn get-cube-samples [input-line] (->> input-line
                                         (re-seq num-cubes-regex)
                                         (map first)
                                         (map #(s/split % #" "))
                                         (map #(vector
                                                 (last %)
                                                 (Integer/parseInt (first %))))))

(defn get-game-id [input-line] (->> input-line
                                    (re-seq game-id-regex)
                                    (first)
                                    (Integer/parseInt)))


(defn is-possible-game [cube-samples]
  (->> cube-samples
       (every? (fn [[cube-color num-cubes]]
                 (let [max-cubes (get max-cubes-by-color cube-color)]
                   (<= num-cubes max-cubes))))))

(defn remove-impossible-games [input-lines]
  (filter #(is-possible-game (get-cube-samples %)) input-lines))

(defn accumulate-max-cubes [max-cubes [color number]]
  (assoc max-cubes color (max (get max-cubes color 0) number)))

(defn get-max-cubes-of-each-color [cube-samples]
  (reduce accumulate-max-cubes {} cube-samples))

(defn multiply-max-cubes [max-cubes]
  (* (get max-cubes "red") (get max-cubes "blue") (get max-cubes "green")))
