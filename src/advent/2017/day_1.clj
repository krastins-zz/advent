(ns advent.2017.day-1)

(defn str->digits [s]
  (map #(Character/getNumericValue %) s))

(defn sum-consecutive-dupes [s]
  (->> (str s (first s))
       (map #(Character/getNumericValue %))
       (partition 2 1)
       (filter #(apply = %))
       (map first)
       (apply +)))

(defn interleave-halves [seq]
  (apply interleave (partition (/ (count seq) 2) seq)))

(defn sum-dupes-halfway-around [s]
    (->> s
         str->digits
         interleave-halves
         (partition 2)
         (filter #(apply = %))
         (map first)
         (apply +)
         (* 2)))
