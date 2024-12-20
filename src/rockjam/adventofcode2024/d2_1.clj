(ns rockjam.adventofcode2024.d2-1
  (:require [clojure.string :as str]))

;(def data (slurp "./inputs/d2-sample"))
(def data (slurp "./inputs/d2"))

(def input
  (map #(map Integer/parseInt (str/split % #" "))
       (str/split-lines data)))

(defn is-decreasing [report]
  (reduce
    (fn [acc [f s]] (and acc (> f s)))
    true
    (partition 2 1 report)))

(defn is-increasing [report]
  (reduce
    (fn [acc [f s]] (and acc (> s f)))
    true
    (partition 2 1 report)))

(defn is-small-diff [report]
  (reduce
    (fn [acc [f s]] (let [diff (abs (- f s))] (and acc (and (>= diff 1) (<= diff 3)))))
    true
    (partition 2 1 report)))

(defn is-safe [report]
  (and (or (is-decreasing report) (is-increasing report)) (is-small-diff report)))

(comment
  (def reports
    '((7 6 4 2 1)
      (1 2 7 8 9)
      (9 7 6 2 1)
      (1 3 2 4 5)
      (8 6 4 4 1)
      (1 3 6 7 9)))

  (map #(vector (is-decreasing %) %) reports)
  (map #(vector (is-increasing %) %) reports)
  (map #(vector (is-small-diff %) %) reports)
  (map #(vector (is-safe %) %) reports)

  ())

(count (filter is-safe input))

299
