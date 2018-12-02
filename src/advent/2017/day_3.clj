(ns advent.2017.day-3
  (:require [clojure.math.numeric-tower :as math]))

(defn nearest-odd-square-root [n]
  (let [root (int (math/ceil (math/sqrt n)))]
    (if (even? root)
      (+ root 1)
      root)))

(defn manhattan-distance [n]
  (let [root (nearest-odd-square-root n)
        p (- root 1)
        i (math/floor (/ root 2))
        d (- (math/expt root 2) n)]
    (- p (math/abs (- (mod (- d i) p) i)))))
