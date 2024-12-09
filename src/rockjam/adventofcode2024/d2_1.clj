(ns rockjam.adventofcode2024.d2-1
  (:require [clojure.string :as str]))

(def data (slurp "./inputs/d2-sample"))
;(def data (slurp "./inputs/d2"))

(def input
  (map #(map Integer/parseInt (str/split % #" "))
       (str/split-lines data)))

(defn is-safe [line] (map (fn [[a b]] (and (> a b) (or (>= 1 (abs (- a b))) (<= 3 (abs (- a b)))))) (partition 2 1 line)))

(is-safe [7 6 4 2 1])
(is-safe [1 3 2 4 5])

