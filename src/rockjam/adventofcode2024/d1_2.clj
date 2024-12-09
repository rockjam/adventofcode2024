(ns rockjam.adventofcode2024.d1-2
  (:require [clojure.string :as str]))

;(def data (slurp "./inputs/d1-sample"))
(def data (slurp "./inputs/d1"))

(defn split-whitespace [s] (str/split s #"   "))

(def lists (reduce (fn [[left right] el]
                     (let [[f s] (split-whitespace el)] [(conj left (Integer/parseInt f)) (conj right (Integer/parseInt s))]))
                   [[] []]
                   (str/split-lines data)))

(def frequencies (update-vals (group-by identity (second lists)) count))

(reduce +
        (map (fn [el] (* el (get frequencies el 0)))
             (first lists)))

27384707
