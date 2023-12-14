(ns advent-of-code.core
  (:require [advent-of-code.day-1 :as d1]
            [advent-of-code.puzzle-inputs :as inputs]))

(def day1-part1-answer (->> inputs/day1
                            (d1/split-on-newlines)
                            (map d1/get-calibration-value-pt1)
                            (apply +)))

(def day1-part2-answer (->> inputs/day1
                            (d1/split-on-newlines)
                            (map d1/get-calibration-value-pt2)
                            (apply +)))