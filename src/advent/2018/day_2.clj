(ns advent.2018.day-2
  (:require [clojure.data :refer [diff]]
            [clojure.math.combinatorics :refer [combinations]]))

(defn inc-frequency-count [frequencies frequency old-count]
  (if (some? (#(some #{frequency} (vals frequencies))))
    (inc old-count)
    old-count))

(defn count-twice-and-thrice [intermediate]
  (reduce
    (fn [{:keys [twice thrice]} frequencies]
      {:twice (inc-frequency-count frequencies twice 2)
       :thrice (inc-frequency-count frequencies thrice 3)})
    {:twice 0
     :thrice 0}
    intermediate))

(defn solution-1 [input-string]
  (->> (clojure.string/split-lines input-string)
       (map (comp frequencies vec))
       count-twice-and-thrice
       vals
       (apply *)))

(defn remainder-when-diff-by-one [[a b]]
  (let [[only-in-a only-in-b in-both] (diff a b)
        non-nil-in-a (filter some? only-in-a)
        non-nil-in-b (filter some? only-in-b)
        char-a (first non-nil-in-a)
        char-b (first non-nil-in-b)]
    (when (and (= 1 (count non-nil-in-a) (count non-nil-in-b))
               (= (.indexOf only-in-a char-a) (.indexOf only-in-b char-b)))
      (apply str in-both))))

(defn solution-2 [input-string]
  (->> (clojure.string/split-lines input-string)
       (map vec)
       (#(combinations % 2))
       (some remainder-when-diff-by-one)))
