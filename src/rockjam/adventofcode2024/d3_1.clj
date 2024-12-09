(ns rockjam.adventofcode2024.d3-1)

;(def data (slurp "./inputs/d3-sample"))
(def data (slurp "./inputs/d3"))

(def pattern #"mul\((\d*),(\d*)\)")

(reduce +
        (map
          (fn [[_ a b]] (* (Integer/parseInt a) (Integer/parseInt b)))
          (re-seq pattern data)))

170778545
