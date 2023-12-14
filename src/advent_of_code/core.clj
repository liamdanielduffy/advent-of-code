(ns advent-of-code.core
  (:require [advent-of-code.day-1 :as day1]
            [advent-of-code.puzzle-inputs :as inputs]))

(def day1-part1-answer (day1/sum-calibration-values inputs/day1))
