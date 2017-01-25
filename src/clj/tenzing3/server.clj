(ns tenzing3.server
  (:require [clojure.pprint :as pp :refer [pprint]]
            [clojure.string :as string]))

(defn sleep
  "sleeps for the given number of seconds (may be fractional)"
  [s]
  (Thread/sleep (* 1000 s)))

(defn foo []
  (println "foo"))
