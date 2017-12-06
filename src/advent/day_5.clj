(ns advent.day-5)


(defn jump [v n]
  (assoc-in v [n] (inc (nth v n))))

(defn increment-offset [col current pos]
                  (assoc-in col [pos] (if (>= current 3)
                                        (dec (nth col pos))
                                        (inc (nth col pos)))))

(defn solve [col]
  (let [size (count col)]
    (loop [pos 0
          col col
          count 0]
     (if (or (< pos 0) (>= pos size))
       count
       (recur (+ pos (nth col pos))
              (jump col pos)
              (inc count))))))

(defn solve-advanced [col]
  (let [size (count col)]
    (loop [pos 0
           col col
           count 0]
      (if (or (< pos 0) (>= pos size))
        count
        (recur (+ pos (nth col pos))
               (increment-offset col (nth col pos) pos)
               (inc count))))))
