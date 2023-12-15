(ns advent-of-code.core
  (:require [advent-of-code.day-1 :as d1]
            [advent-of-code.day-2 :as d2]
            [advent-of-code.utils :as utils]
            [advent-of-code.inputs :as inputs]))

;; DAY 1

(def day1-part1-answer (->> inputs/day1
                            (utils/split-on-newlines)
                            (map d1/get-calibration-value-pt1)
                            (apply +)))

(def day1-part2-answer (->> inputs/day1
                            (utils/split-on-newlines)
                            (map d1/get-calibration-value-pt2)
                            (apply +)))

;; DAY 2

(def day2-part1-answer (->> inputs/day2
                            (utils/split-on-newlines)
                            (d2/remove-impossible-games)
                            (map d2/get-game-id)
                            (apply +)))

(def day2-part2-answer (->> inputs/day2
                            (utils/split-on-newlines)
                            (map d2/get-cube-samples)
                            (map d2/get-max-cubes-of-each-color)
                            (map d2/multiply-max-cubes)
                            (apply +)))