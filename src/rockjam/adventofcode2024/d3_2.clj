(ns rockjam.adventofcode2024.d3-2
  (:require [clojure.string :as str]))

;(def data (slurp "./inputs/d3-sample"))

; to make the pattern simpler - remove newlines from the input,
; and append do() and don't() to start and end of the line
(def data (str "do()" (str/replace (slurp "./inputs/d3") "\n" "") "don't()"))

(def enabled-parts
  (map
    #(nth % 0)
    (re-seq #"do\(\)(.*?)don't\(\)" data)))


(defn execute-part [data]
  (map
    (fn [[_ a b]] (* (Integer/parseInt a) (Integer/parseInt b)))
    (re-seq #"mul\((\d*),(\d*)\)" data)))


(->> enabled-parts
     (map execute-part)
     (flatten)
     (reduce +))

82868252
