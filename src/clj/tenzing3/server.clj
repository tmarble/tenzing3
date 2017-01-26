(ns tenzing3.server
  "Example Clojure server application (which doesn't serve anything yet)."
  (:require [clojure.string :as string]))

(def bar
  "Example CLJ var"
  {:a 123})

(defn foo
  "Example function"
  [& args]
  (println "foo with args:" args))
