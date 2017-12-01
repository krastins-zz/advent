(ns advent.t-day-1
  (:require [clojure.test :refer :all]
            [advent.day-1 :refer [sum-consecutive-dupes sum-dupes-halfway-around]]))

(deftest test-day-1-solution
  (is (= (sum-consecutive-dupes "1122") 3))
  (is (= (sum-consecutive-dupes "1111") 4))
  (is (= (sum-consecutive-dupes "1234") 0))
  (is (= (sum-consecutive-dupes "91212129") 9)))

(deftest test-day-1-advanced-solution
  (is (= (sum-dupes-halfway-around "1212") 6))
  (is (= (sum-dupes-halfway-around "1221") 0))
  (is (= (sum-dupes-halfway-around "123425") 4))
  (is (= (sum-dupes-halfway-around "123123") 12))
  (is (= (sum-dupes-halfway-around "12131415") 4)))
