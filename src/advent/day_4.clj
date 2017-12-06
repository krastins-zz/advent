(ns advent.day-4
  (:require [clojure.string :refer [split split-lines]]))

(defn contains-no-duplicates? [l]
  (= (distinct l) l))

(defn contains-no-anagrams? [l]
  (let [l (map sort l)]
    (= (distinct l) l)))

(defn str->2d-array [s]
  (map #(split % #"\s") (split-lines s)))

(defn count-valid-pasphrases [pred l]
  (count (filter pred (str->2d-array l))))


