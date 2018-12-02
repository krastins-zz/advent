(ns advent.2018.day-1
  (:require [clojure.string :as s]))

(defn solution-1 [input-string]
  (->> (s/split-lines input-string)
       (map #(Integer/parseInt %))
       (apply +)))

(defn find-first-reoccuring [frequencies]
  (reduce
    (fn [{:keys [frequencies previous-frequency]} number]
      (let [frequency (+ number previous-frequency)]
        (if (some? (get frequencies frequency))
          (reduced frequency)
          {:frequencies (conj frequencies frequency)
           :previous-frequency frequency})))
    {:frequencies #{0}
     :previous-frequency 0}
    frequencies))

(defn solution-2 [input-string]
  (->> (s/split-lines input-string)
       (map #(Integer/parseInt %))
       cycle
       find-first-reoccuring))
