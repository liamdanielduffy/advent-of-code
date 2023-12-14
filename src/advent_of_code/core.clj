(ns advent-of-code.core
  (:require [advent-of-code.day-1 :as d1]
            [advent-of-code.day-2 :as d2]
            [advent-of-code.utils :as utils]
            [advent-of-code.inputs :as inputs]))

(def day1-part1-answer (->> inputs/day1
                            (utils/split-on-newlines)
                            (map d1/get-calibration-value-pt1)
                            (apply +)))

(def day1-part2-answer (->> inputs/day1
                            (utils/split-on-newlines)
                            (map d1/get-calibration-value-pt2)
                            (apply +)))

;; work in progress!
(def day2-answer (->> inputs/day2
                      (utils/split-on-newlines)
                      (map d2/get-color-num-tuples)))