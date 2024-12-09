(ns rockjam.adventofcode2024.d1-1
  (:require [clojure.string :as str]))

;(def data (slurp "./inputs/d1-sample"))
(def data (slurp "./inputs/d1"))

(defn split-whitespace [s] (str/split s #"   "))

(def lists (reduce (fn [[left right] el]
                     (let [[f s] (split-whitespace el)] [(conj left (Integer/parseInt f)) (conj right (Integer/parseInt s))]))
                   [[] []]
                   (str/split-lines data)))

(->> lists
     (map sort)
     (apply map vector)
     (map (fn [[a b]] (abs (- a b))))
     (reduce +))

1341714
