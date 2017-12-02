(ns advent.t-day-2
  (:require [clojure.test :refer :all]
            [advent.day-2 :refer [checksum
                                  difference-of-extremes
                                  even-division]]))

(deftest test-day-2-solution
  (is (= (checksum difference-of-extremes "5 1 9 5\n7 5 3\n2 4 6 8") 18)))

(deftest test-day-2-advanced-solution
  (is (= (checksum even-division "5 9 2 8\n9 4 7 3\n3 8 6 5") 9)))
