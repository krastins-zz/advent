(ns advent.2017.day-2
  (:require [clojure.string :refer [split split-lines]]
            [clojure.math.combinatorics :refer [combinations]]))

(defn str->2d-array [s]
  (map #(split % #"\s") (split-lines s)))

(defn parse-ints [v]
  (map #(Integer/parseInt %) v))

(defn difference-of-extremes [v]
  (- (apply max v) (apply min v)))

(defn divisible? [[dividend divisor]]
  (= (mod dividend divisor) 0))

(defn even-division [v] ((comp (partial apply /)
                               first
                               (partial filter divisible?)
                               (map (partial sort >))
                               #(combinations % 2)) v))

(defn checksum [intermediate-fn s]
  (->> s
       str->2d-array
       (map (comp intermediate-fn parse-ints))
       (apply +)))
