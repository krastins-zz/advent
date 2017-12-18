(ns advent.day-6)

(defn spread-largest [vec]
  (let [size (count vec)
        largest (apply max vec)
        pos (.indexOf vec largest)]
    (loop [counter largest
           vec (assoc-in vec [pos] 0)
           pos (mod (inc pos) size)]
      (if (> counter 0)
        (recur (dec counter)
               (update vec pos inc)
               (mod (inc pos) size))
        vec))))

(defn spread-until-seen [vec]
  (loop [vec vec
         past-configs []
         counter 0]
    (if (some (partial = vec) past-configs)
        counter
        (recur (spread-largest vec)
               (conj past-configs vec)
               (inc counter)))))

(defn spread-until-seen [vec]
  (loop [vec vec
         past-configs []
         counter 0]
    (if (some (partial = vec) past-configs)
      {:steps counter
       :period (- counter (.indexOf past-configs vec))}
      (recur (spread-largest vec)
             (conj past-configs vec)
             (inc counter)))))
